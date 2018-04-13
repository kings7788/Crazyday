package org.iii.ee10087.itube._10_subscriptionUploader.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iii.ee10087.itube._02_register.model.MemberBean;
import org.iii.ee10087.itube._02_register.model.MemberDAO;
import org.iii.ee10087.itube._02_register.model.MemberDAOIMP;
import org.iii.ee10087.itube._05_videoManage.model.VideoDAOImpl;
import org.iii.ee10087.itube._10_subscriptionUploader.model.SubscriptionUploaderBean;
import org.iii.ee10087.itube._10_subscriptionUploader.model.SubscriptionUploaderDAO;
import org.iii.ee10087.itube._10_subscriptionUploader.model.SubscriptionUploaderDAOImpl;
import org.json.simple.JSONValue;

/**
 * Servlet implementation class SubscriptionUploaderServlet
 */
@WebServlet("/_10_subscriptionUploader/subscriptionUploader.do")
public class SubscriptionUploaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String videoUploaderAccount = request.getParameter("uploaderaccount");
		String userAccount = request.getParameter("userAccount");
		
		
		MemberBean mb = new MemberBean();
		MemberDAO mdao = new MemberDAOIMP();
		mb = mdao.queryMember(videoUploaderAccount);
		SubscriptionUploaderBean subbean = new SubscriptionUploaderBean();
		SubscriptionUploaderDAO subdao = new SubscriptionUploaderDAOImpl();
		
		java.sql.Timestamp now = new java.sql.Timestamp(System.currentTimeMillis());
		try {
			subbean = subdao.querySubscriptionUploader(videoUploaderAccount, userAccount);
			if(subbean == null){
				SubscriptionUploaderBean subbean1 = new SubscriptionUploaderBean(0L , userAccount, videoUploaderAccount, "subscription", now , 0L);
				subdao.insertSubscriptionUploader(subbean1);
				
				mb.setSubscription((mb.getSubscription() + 1L));
				mdao.updateMember(mb);
			}else if(subbean.getStatus().equals("subscription")){
				subbean.setStatus("notsubscription");
				subbean.setSubscriptionUploaderDate(now);
				if(subbean.getScore() > 0L){
					subbean.setScore(subbean.getScore()-1L);
				}
				subdao.updateSubscriptionUploader(subbean);
				
				if(mb.getSubscription() > 0L){
					mb.setSubscription(mb.getSubscription() - 1L);
				}
				
				mdao.updateMember(mb);
				
			}else if(subbean.getStatus().equals("notsubscription")){
				subbean.setScore(subbean.getScore()+1L);
				subbean.setStatus("subscription");
				subbean.setSubscriptionUploaderDate(now);
				subdao.updateSubscriptionUploader(subbean);
				
				mb.setSubscription(mb.getSubscription() + 1L);
				mdao.updateMember(mb);
				
				
			}
			subbean = subdao.querySubscriptionUploader(videoUploaderAccount, userAccount);
			LinkedList<HashMap<String, String>> l1 = new LinkedList<HashMap<String, String>>();
			HashMap<String, String> m1 = new HashMap<String, String>();
			m1.put("seqNo", String.valueOf(subbean.getSeqNo()));
			m1.put("userAccount", subbean.getUserAccount());
			m1.put("uploaderAccount", subbean.getUploaderAccount());
			m1.put("status", subbean.getStatus());
			m1.put("subscriptionUploaderDate", String.valueOf(subbean.getSubscriptionUploaderDate()));
			m1.put("score", String.valueOf(subbean.getScore()));

			l1.add(m1);
			String jsonString = JSONValue.toJSONString(m1);
			response.setHeader("content-type", "text/plain;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.println(jsonString);
			return;
			
			
			
//			response.sendRedirect("../index.jsp");
//			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

}
