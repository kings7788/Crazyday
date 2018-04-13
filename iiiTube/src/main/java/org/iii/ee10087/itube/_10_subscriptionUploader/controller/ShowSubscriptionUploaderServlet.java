package org.iii.ee10087.itube._10_subscriptionUploader.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iii.ee10087.itube._02_register.model.MemberBean;
import org.iii.ee10087.itube._10_subscriptionUploader.model.ShowSubscriptionUploaderBean;
import org.iii.ee10087.itube._10_subscriptionUploader.model.SubscriptionUploaderDAO;
import org.iii.ee10087.itube._10_subscriptionUploader.model.SubscriptionUploaderDAOImpl;


@WebServlet("/_10_subscriptionUploader/ShowSubscriptionUploader.do")
public class ShowSubscriptionUploaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		MemberBean mb = (MemberBean) session.getAttribute("LoginOK");
		SubscriptionUploaderDAO sudao = new SubscriptionUploaderDAOImpl();
		List<ShowSubscriptionUploaderBean> ssub = null;
		try {
			ssub = sudao.querySubscriptionUploaderByAccount(mb.getAccount());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		session.setAttribute("subscriptionUploader", ssub);
		response.sendRedirect("subscriptionUploader.jsp");
		return;
	}

}
