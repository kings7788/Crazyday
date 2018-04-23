package org.iii.ee10087.itube._16_.contactlist.Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iii.ee10087.itube._16_.FAQ.bean.*;
import org.iii.ee10087.itube._16_.FAQ.service.*;
@WebServlet("/contactlistdetail.do")
public class ContactListDetail extends HttpServlet {
	MemberQAService selectdetail = new MemberQAService();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	this.doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//取得問題編號  用SERVICE方法讀出  完整的問題回應給後台回應問題頁面
		//需讀出資料庫圖檔
		
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String a = request.getParameter("quesnum");
		
		int quesnum = Integer.parseInt(a);
		
		MemberFAQBean bean= new MemberFAQBean();
		bean.setMemberQuesNum(quesnum);
		
		try {
			MemberFAQBean beandetail = selectdetail.select(bean);
			if(beandetail!=null) {
//				request.setAttribute("HaveBean", beandetail);
				session.setAttribute("HaveBean", beandetail);
				response.sendRedirect(request.getContextPath()+"/manager/ServiceReport.jsp");
				return;
//				RequestDispatcher rd = request.getRequestDispatcher("/manager/ServiceReport.jsp");
//				rd.forward(request, response);
//				return;
								}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	
	}

}
