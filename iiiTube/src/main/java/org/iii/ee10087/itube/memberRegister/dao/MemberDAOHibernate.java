package org.iii.ee10087.itube.memberRegister.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.iii.ee10087.itube.memberRegister.bean.MemberBean;

public class MemberDAOHibernate implements MemberDAO {

	private SessionFactory sessionFactory;
	public MemberDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public MemberBean select(String account) {
		return this.getSession().get(MemberBean.class, account);
		
	}

	@Override
	public List<MemberBean> select() {
			Query query = this.getSession().createQuery("from MEMBER");
			return (List<MemberBean>) query.list();

	}

	@Override
	public MemberBean insert(MemberBean bean) throws SQLException {
		MemberBean temp = this.getSession().get(MemberBean.class,bean.getAccount());
		if(temp==null) {
			this.getSession().save(bean);
			return bean;
		}
		
		return null;
	}

	@Override
	public void delete(String account){
		
		
		MemberBean bean = this.getSession().get(MemberBean.class, account);
		if(bean!=null) {
			this.getSession().delete(bean);
		}
	return;
	}

	@Override
	public MemberBean update(MemberBean bean) throws SQLException {
		return null;
	}
	

}
