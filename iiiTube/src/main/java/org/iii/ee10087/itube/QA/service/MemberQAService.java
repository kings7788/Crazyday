package org.iii.ee10087.itube.QA.service;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.iii.ee10087.itube.HibernateSessionFactory.HibernateUtil;
import org.iii.ee10087.itube.QA.bean.MemberQABean;
import org.iii.ee10087.itube.QA.dao.MemberQADAO;
import org.iii.ee10087.itube.QA.dao.MemeberQAHibernate;


public class MemberQAService {
	private MemberQADAO memberDao;
	public MemberQAService() {
		memberDao = new MemeberQAHibernate(HibernateUtil.getSessionFactory());
	}
	
	public MemberQABean insert(MemberQABean bean) throws SQLException {
		MemberQABean result =null;
		if(bean!=null) {
			result = memberDao.insert(bean);
		return result;
		}
		return null;
	}
	public List<MemberQABean> getALL() throws SQLException {
		List<MemberQABean> resultlist = null;
		resultlist = memberDao.getALL();
	
		return resultlist;
	}
	public MemberQABean select(MemberQABean bean) throws SQLException {
		MemberQABean result =null;
		result = memberDao.findbyPrimaryKey(bean);
		if(result!=null) {
		return result;
		}
		return null;
	}
	
}
