package org.iii.ee10087.itube._16_.Manager.service;

import java.sql.SQLException;

import org.iii.ee10087.itube.HibernateSessionFactory.HibernateUtil;
import org.iii.ee10087.itube._16_.Manager.bean.*;
import org.iii.ee10087.itube._16_.Manager.dao.*;
import org.iii.ee10087.itube.manage.dao.*;
import org.iii.ee10087.itube.memberRegister.dao.MemberDAO;
import org.iii.ee10087.itube.memberRegister.dao.MemberDAOHibernate;

public class ManageLoginService {
	public ManageBean checkIDPassword(String account, String password) throws Exception {
		// 將 MemberDAO new為物件，放入變數dao內
		ManageDao dao = new ManageHibernateDao(HibernateUtil.getSessionFactory());
		// 透過變數dao，呼叫它的select()方法，要傳入參數 id。將傳回值放入變數
        // MemberBean mb 內。
		
		ManageBean mem = new ManageBean();
		
		
		ManageBean mb = dao.findbyPrimaryKey(account);
        // 如果mb不等於 null 而且參數 password等於mb內的password) {
        if ( mb != null && password.equals(mb.getManagePwd())) {
//        	 傳回 mb物件，同時結束本方法
        	 return mb;
        }
        // 傳回null物件
		return null;
	}
}

