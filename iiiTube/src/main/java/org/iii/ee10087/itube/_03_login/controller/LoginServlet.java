package org.iii.ee10087.itube._03_login.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iii.ee10087.itube._01_global.util.GlobalService;
import org.iii.ee10087.itube._02_register.model.MemberBean;
import org.iii.ee10087.itube._03_login.model.LoginService;
import org.iii.ee10087.itube._03_login.model.LoginServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/_03_login/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		Map<String,String> errorMsgMap = new HashMap<String,String>();
		request.setAttribute("ErrorMsgKey", errorMsgMap);
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String rm = request.getParameter("rememberMe");
		String requestURI = (String)request.getParameter("requestURI");
		
		if(account == null || account.trim().length() == 0){
			errorMsgMap.put("AccountEmptyError", "帳號欄必須輸入");
		}
		if(password == null || password.trim().length() == 0){
			errorMsgMap.put("PasswordEmptyError", "密碼欄必須輸入");
		}
		Cookie cookieAccount = null;
		Cookie cookiePassword = null;
		Cookie cookieRememberMe = null;
		
		if(rm != null){
			cookieAccount = new Cookie("account" , account);
			cookieAccount.setMaxAge(30*60*60);
			cookieAccount.setPath(request.getContextPath());
			
			String encodePassword = GlobalService.encryptString(password);
			cookiePassword = new Cookie("password" , encodePassword);
			cookiePassword.setMaxAge(30*60*60);
			cookiePassword.setPath(request.getContextPath());
			
			cookieRememberMe = new Cookie("rm" , "true");
			cookieRememberMe.setMaxAge(30*60*60);
			cookieRememberMe.setPath(request.getContextPath());
		}else{
			cookieAccount = new Cookie("account" , account);
			cookieAccount.setMaxAge(0);
			cookieAccount.setPath(request.getContextPath());
			
			String encodePassword = GlobalService.encryptString(password);
			cookiePassword = new Cookie("password" , encodePassword);
			cookiePassword.setMaxAge(0);
			cookiePassword.setPath(request.getContextPath());
			
			cookieRememberMe = new Cookie("rm" , "false");
			cookieRememberMe.setMaxAge(30*60*60);
			cookieRememberMe.setPath(request.getContextPath()); 
		}
		response.addCookie(cookieAccount);
		response.addCookie(cookiePassword);
		response.addCookie(cookieRememberMe);
		
		if(!errorMsgMap.isEmpty()){
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			return;
		}
		
		LoginService loginService = new LoginServiceImpl();
		password = GlobalService.getMD5Endocing(GlobalService.encryptString(password));
		MemberBean mb = null;
		try{
			mb = loginService.checkIDPassword(account , password);
			if(mb != null){
				session.setAttribute("LoginOK", mb);
			}else {
				errorMsgMap.put("LoginError", "該帳號不存在或密碼錯誤");
				
			}
		}catch(RuntimeException ex){
			errorMsgMap.put("LoginError", ex.getMessage());
		}
		
		if(errorMsgMap.isEmpty()){
			if(requestURI != null){
				requestURI = (requestURI.length() == 0 ? request.getContextPath() : requestURI);
				response.sendRedirect(response.encodeRedirectURL(requestURI));
				return;
			}else { 
				response.sendRedirect(response.encodeRedirectURL(request.getContextPath()));
				return;
			}
		}else{ 
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			return;
		}
		
	}

}
