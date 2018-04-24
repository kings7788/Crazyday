package org.iii.ee10087.itube._16_.Manager.controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iii.ee10087.itube.HibernateSessionFactory.HibernateUtil;
import org.iii.ee10087.itube._16_.Manager.bean.*;
import org.iii.ee10087.itube._16_.Manager.dao.*;

import org.iii.ee10087.itube.memberRegister.bean.MemberBean;
import org.iii.ee10087.itube.memberRegister.dao.MemberDAO;
import org.iii.ee10087.itube.memberRegister.dao.MemberDAOHibernate;
@WebServlet("/manager/man.controller")
public class ManageBeanRegisterServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Map<String, String> errorMessage = new HashMap<>();
		request.setAttribute("ErrorMsg", errorMessage);
		
		request.setCharacterEncoding("UTF-8");
		String account = request.getParameter("mAcc");
		if(account == null || account.trim().length()==0){
			errorMessage.put("account", "帳號欄必須輸入");
		}
		
		String password = request.getParameter("mPwd");
		if(password == null || password.trim().length()==0){
			errorMessage.put("password", "密碼欄必須輸入");
		}
		
		String name = request.getParameter("mName");
		if(name == null || name.trim().length()==0){
			errorMessage.put("name", "姓名欄必須輸入");
		}
		
//		String email = request.getParameter("mEmail");
//		if(email == null || email.trim().length()==0){
//			errorMessage.put("email", "電子信箱必須輸入");
//		}
		
//		String address = request.getParameter("mAddr");
//		if(address == null || address.trim().length()==0){
//			errorMessage.put("address", "地址必須輸入");
//		}

//		Blob blob = null;
//		java.sql.Date registerdate = new java.sql.Date(System.currentTimeMillis());
//		java.sql.Date lastlogin = new java.sql.Date(System.currentTimeMillis());
		
		if(!errorMessage.isEmpty()){				//錯誤Map內有錯誤訊息，退回註冊頁面並顯示錯誤訊息
			RequestDispatcher rd = request.getRequestDispatcher("/manager/Register.jsp");
			rd.forward(request, response);
			return;
		}
		ManageBean mb = new ManageBean(new Integer(0), account, password, name);

		try{
			ManageDao mfio = new ManageHibernateDao(HibernateUtil.getSessionFactory());
			mfio.insert(mb);
			session.setAttribute("ManageBean", mb);
			
			 response.sendRedirect(response.encodeRedirectURL("HelloManager.jsp"));
				return;
			} catch (SQLException e) {
				if (e.getMessage().indexOf("重複的索引鍵") != -1 || 
					e.getMessage().indexOf("Duplicate entry") != -1) {
					errorMessage.put("acc","帳號重複，請重新輸入帳號");
				} else {
					errorMessage.put("exception","資料庫存取錯誤:" + e.getMessage());
				}
				RequestDispatcher rd = request
					.getRequestDispatcher("/manager/Register.jsp");
				rd.forward(request, response);
				return;
			} 
		
	}
	
}
