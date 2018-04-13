package org.iii.ee10087.itube._03_login.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iii.ee10087.itube._02_register.model.MemberBean;

@WebFilter(
		urlPatterns = {"/*"},
		initParams = {
				@WebInitParam(name = "mustLogin1" , value = "/_05_videoManage/*"),
				@WebInitParam(name = "mustLogin2" , value = "/_15_memberManage/*"),
				@WebInitParam(name = "mustLogin3" , value = "/_07_watchHistory/*"),
				@WebInitParam(name = "mustLogin4" , value = "/_09_likeUnlikeVideo/*"),
				@WebInitParam(name = "mustLogin5" , value = "/_10_subscriptionUploader/*")
		})
public class LoginCheckingFilter implements Filter {
	Collection<String> url = new ArrayList<String>();
	String servletPath;
	String contextPath;
	String requestURI;

	public void init(FilterConfig fConfig) throws ServletException {
		Enumeration<String> e = fConfig.getInitParameterNames();
		while(e.hasMoreElements()){
			String path = e.nextElement();
			url.add(fConfig.getInitParameter(path));
		}
	}
	
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		boolean isRequestSessionIdValid = false;
		if(request instanceof HttpServletRequest &&
				response instanceof HttpServletResponse
				){
			HttpServletRequest req = (HttpServletRequest)request;
			HttpServletResponse resp = (HttpServletResponse)response;
			servletPath = req.getServletPath();
			contextPath = req.getContextPath();
			requestURI = req.getRequestURI();
			isRequestSessionIdValid = req.isRequestedSessionIdValid();
			
			if(mustLogin()){
				if(checkLogin(req)){
					chain.doFilter(request, response);
				}else {
					HttpSession session = req.getSession();
					session.setAttribute("requestURI", requestURI);
					if(! isRequestSessionIdValid){
						session.setAttribute("timeOut", "使用逾時，請重新登入");
					}
					resp.sendRedirect(contextPath + "/_03_login/login.jsp");
					return;
				}
			}
			else{
				chain.doFilter(request, response);
			}
		}else {
			throw new ServletException("Request/Response 型態錯誤(極不可能發生");
		}
		
	}
	
	private boolean checkLogin(HttpServletRequest req){
		HttpSession session = req.getSession();
		MemberBean loginToken = (MemberBean)session.getAttribute("LoginOK");
		if(loginToken == null){
			return false;
		}else {
			return true;
		}
	}
	
	private boolean mustLogin(){
		boolean login = false;
		for(String sURL : url){
			if(sURL.endsWith("*")){
				sURL = sURL.substring(0, sURL.length() - 1);
				if(servletPath.startsWith(sURL)){
					login = true;
					break;
				}
			}else {
				if(servletPath.equals(sURL)){
					login = true;
					break;
				}
			}
		}
		return login;
	}
	
	
	public void destroy() {
		
	}

}
