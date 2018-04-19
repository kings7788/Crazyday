package org.iii.ee10087.itube.QA.service;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.iii.ee10087.itube.HibernateSessionFactory.HibernateUtil;
import org.iii.ee10087.itube.QA.bean.MemberQABean;
import org.iii.ee10087.itube.QA.dao.MemberQADAO;
import org.iii.ee10087.itube.QA.dao.MemeberQAHibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberQAService {
	@Autowired
	private MemeberQAHibernate dao;
	
	@Transactional
	public MemberQABean insert(MemberQABean bean) throws SQLException {
		MemberQABean result =null;
		if(bean!=null) {
			result = dao.insert(bean);
		return result;
		}
		return null;
	}
	@Transactional
	public List<MemberQABean> getALL() throws SQLException {
		List<MemberQABean> resultlist = null;
		resultlist = dao.getALL();
	
		return resultlist;
	}
	@Transactional
	public MemberQABean select(MemberQABean bean) throws SQLException {
		MemberQABean result =null;
		result = dao.findbyPrimaryKey(bean);
		if(result!=null) {
		return result;
		}
		return null;
	}
	
}
