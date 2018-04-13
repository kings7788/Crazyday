package org.iii.ee10087.itube.QA.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.iii.ee10087.itube.QA.bean.MemberQABean;

public class MemeberQAHibernate implements MemberQADAO {

	private SessionFactory Sessionfactory;
	public MemeberQAHibernate(SessionFactory Sessionfactory) {
		this.Sessionfactory = Sessionfactory;
	}
	public Session getSession() {
		return  Sessionfactory.getCurrentSession();

	}
	@Override
	public MemberQABean insert(MemberQABean mem) throws SQLException {
		MemberQABean temp = (MemberQABean)this.getSession().get(MemberQABean.class, mem.getMemberQuesNum());
		if(temp==null) {
		this.getSession().save(mem);
		return mem;
		}
		return null;
	}

	@Override
	public MemberQABean update(MemberQABean mem) throws SQLException {
		MemberQABean bean = this.getSession().get(MemberQABean.class, mem.getMemberQuesNum());
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
		MemberQABean bean = this.getSession().get(MemberQABean.class, mem.getMemberQuesNum());
		if(bean!=null) {
			this.getSession().delete(bean);
			return bean;
		}
		return null;
	}

	@Override
	public MemberQABean findbyPrimaryKey(MemberQABean mem) throws SQLException {
		return this.getSession().get(MemberQABean.class,  mem.getMemberQuesNum());
	}

	@Override
	public List<MemberQABean> getALL() throws SQLException {
		Query query = this.getSession().createQuery("from MemberQABean ");
		return (List<MemberQABean>) query.list();
	}

}
