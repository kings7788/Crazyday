package org.iii.ee10087.itube._04_logout.model;

import javax.servlet.http.HttpSession;

public class LogoutBean {
	HttpSession session;
	
	public HttpSession getSession(){
		return session;
	}
	
	public void setSession(HttpSession session){
		this.session = session;
	}
	
	public Integer getLogout(){
		session.invalidate();
		return 0;
	}
}
