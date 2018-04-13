package org.iii.ee10087.itube._03_login.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iii.ee10087.itube._01_global.util.GlobalService;

/**
 * Servlet Filter implementation class FindUserPassword
 */
@WebFilter("/_02_login/login.jsp")
public class FindUserPassword implements Filter {
	
	String requestURI;
    public FindUserPassword() {
    	
    }


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if(request instanceof HttpServletRequest && response instanceof HttpServletResponse){
			HttpServletRequest req  = (HttpServletRequest)request;
			HttpServletResponse resp  = (HttpServletResponse)response;
			HttpSession session = req.getSession();
			
			String cookieName = "";
			String account = "";
			String password = "";
			String rememberMe = "false";
			
			Cookie[] cookies = req.getCookies();
			if(cookies != null){
				for(int i = 0; i < cookies.length; i ++){
					cookieName = cookies[i].getName();
					if(cookieName.equals("account")){
						account = cookies[i].getValue();
						
					}else if(cookieName.equals("password")){
						String tmp = cookies[i].getValue();
						if(tmp != null){
							password = GlobalService.decryptString(GlobalService.KEY, tmp);
						}
					}else if(cookieName.equals("rm")){
						rememberMe = cookies[i].getValue();
					}
				}
			}else{
				
			}
			
			session.setAttribute("rememberMe", rememberMe);
			session.setAttribute("password", password);
			session.setAttribute("account", account);
		}
		
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
    @Override
	public void destroy() {
	}
}
