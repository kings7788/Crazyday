package org.iii.ee10087.itube._03_login.model;

import org.iii.ee10087.itube._02_register.model.MemberBean;

public interface LoginService {
	public MemberBean checkIDPassword(String account , String Password);
}
