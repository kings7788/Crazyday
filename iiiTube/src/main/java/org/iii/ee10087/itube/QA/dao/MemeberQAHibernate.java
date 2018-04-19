package org.iii.ee10087.itube.QA.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.iii.ee10087.itube.QA.bean.MemberQABean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class MemeberQAHibernate implements MemberQADAO {
	@Autowired	
	SessionFactory factory;
//	private SessionFactory Sessionfactory;
//	public MemeberQAHibernate(SessionFactory Sessionfactory) {
//		this.Sessionfactory = Sessionfactory;
//	}
//	public Session getSession() {
//		return  Sessionfactory.getCurrentSession();
//
//	}
	@Override
	public MemberQABean insert(MemberQABean mem) throws SQLException {
		Session session = factory.getCurrentSession();
		MemberQABean temp = session.get(MemberQABean.class, mem.getMemberQuesNum());
//		MemberQABean temp =getSession().get(MemberQABean.class, mem.getMemberQuesNum());
		if(temp==null) {
		session.save(mem);
		return mem;
		}
		return null;
	}

	@Override
	public MemberQABean update(MemberQABean mem) throws SQLException {
		Session session = factory.getCurrentSession();
		MemberQABean bean = session.get(MemberQABean.class, mem.getMemberQuesNum());
		if(bean!=null) {	
			bean.setMemName(mem.getMemName());
			bean.setMemTel(mem.getMemTel());
			bean.setMemMail(mem.getMemMail());
			bean.setMemAsk(mem.getMemAsk());
			bean.setMemQuesTime(mem.getMemQuesTime());
			return bean;
		}
		return null;
	}

	@Override
	public MemberQABean delete(MemberQABean mem) throws SQLException {
		Session session = factory.getCurrentSession();
		MemberQABean bean = session.get(MemberQABean.class, mem.getMemberQuesNum());
		if(bean!=null) {
			session.delete(bean);
			return bean;
		}
		return null;
	}

	@Override
	public MemberQABean findbyPrimaryKey(MemberQABean mem) throws SQLException {
		Session session = factory.getCurrentSession();
		return session.get(MemberQABean.class,  mem.getMemberQuesNum());
	}

	@Override
	public List<MemberQABean> getALL() throws SQLException {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("from MemberQABean ");
		return (List<MemberQABean>) query.list();
	}

}
