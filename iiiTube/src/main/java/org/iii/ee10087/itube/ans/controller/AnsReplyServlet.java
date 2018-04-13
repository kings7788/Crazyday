package org.iii.ee10087.itube.ans.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iii.ee10087.itube.HibernateSessionFactory.HibernateUtil;
import org.iii.ee10087.itube.ans.bean.AnsBean;
import org.iii.ee10087.itube.ans.dao.AnsDao;
import org.iii.ee10087.itube.ans.dao.AnsHibernateDao;

@WebServlet("/ans.do")
public class AnsReplyServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("otason");
		request.setCharacterEncoding("UTF-8");
		
		String ans = request.getParameter("report");
		System.out.println(ans);
//		String managenum = request.getParameter("report");
//		String memask = request.getParameter("report");
//		String memtitle = request.getParameter("report");
		AnsDao dao = new AnsHibernateDao(HibernateUtil.getSessionFactory());
		
		java.sql.Date responseDay = new java.sql.Date(System.currentTimeMillis());
		AnsBean bean = new AnsBean();
		bean.setMemberQuesNum(5010);
		bean.setManageNum(0);
		bean.setMemTitle("");
		bean.setMemAsk("");
		bean.setManageResponse(ans);
		bean.setResponseDay(responseDay);
		try {
			dao.insert(bean);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}		
	}
	
}
