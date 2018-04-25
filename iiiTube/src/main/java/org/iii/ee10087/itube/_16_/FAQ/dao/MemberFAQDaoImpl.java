package org.iii.ee10087.itube._16_.FAQ.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.iii.ee10087.itube._16_.FAQ.bean.*;
import org.iii.ee10087.itube._16_.FAQ.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class MemberFAQDaoImpl implements MemberFAQDao {
	@Autowired	
	SessionFactory factory;
	@Override
	public MemberFAQBean insert(MemberFAQBean mem) throws SQLException {
		Session session = factory.getCurrentSession();
		MemberFAQBean temp = session.get(MemberFAQBean.class, mem.getMemberQuesSeqNo());		
		if(temp==null) {
		session.save(mem);
		return mem;
		}
		return null;
	}

	@Override
	public MemberFAQBean update(MemberFAQBean mem) throws SQLException {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(mem);
		return mem;
	}

	@Override
	public MemberFAQBean delete(MemberFAQBean mem) throws SQLException {
		Session session = factory.getCurrentSession();
		MemberFAQBean temp = session.get(MemberFAQBean.class, mem.getMemberQuesSeqNo());
		if(temp!=null) {
			session.delete(temp);
			return temp;
		}
		return null;
	}

	@Override
	public MemberFAQBean findbyPrimaryKey(MemberFAQBean mem) throws SQLException {
		Session session = factory.getCurrentSession();
		return session.get(MemberFAQBean.class,  mem.getMemberQuesSeqNo());
	}
	
	@Override
	public List<MemberFAQBean> getALL() throws SQLException {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("from MemberQABean ");
		return (List<MemberFAQBean>) query.list();
	}

}
