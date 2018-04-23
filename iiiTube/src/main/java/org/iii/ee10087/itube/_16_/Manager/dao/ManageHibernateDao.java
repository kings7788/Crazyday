package org.iii.ee10087.itube._16_.Manager.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.iii.ee10087.itube.HibernateSessionFactory.HibernateUtil;
import org.iii.ee10087.itube._16_.FAQ.bean.*;
import org.iii.ee10087.itube._16_.Manager.bean.*;
import org.iii.ee10087.itube._16_.Manager.dao.*;


public class ManageHibernateDao implements ManageDao {

	private SessionFactory Sessionfactory;

	public ManageHibernateDao(SessionFactory Sessionfactory) {
		this.Sessionfactory = Sessionfactory;
	}

	public Session getSession() {
		return Sessionfactory.getCurrentSession();

	}

//	public static void main(String[] args) throws SQLException {
//		try {
//			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
//			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//			// insert
//			ManageHibernateDao dao = new ManageHibernateDao(HibernateUtil.getSessionFactory());
//			ManageBean bean = new ManageBean();
//			
//			
//			//select
//			ManageBean beanss = session.get(ManageBean.class, "100");
//			System.out.println("select=" + beanss);
//			System.out.println("select=" + beanss.getManageNum());
//			
//			bean.setManageNum(100);
//			bean.setManageId("300");
//			bean.setManageName("mikk");
//			bean.setManagePwd("123");
//			dao.insert(bean);
//			
//			System.out.println("id-300"+dao.findbyPrimaryKey("300"));
//			// 新增 刪除 修改 查詢 資料庫資料的程式碼
//			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
//			HibernateUtil.getSessionFactory().getCurrentSession().close();
//		} finally {
//			// factory.close();
//			HibernateUtil.closeSessionFactory();
//		}
//}

	@Override
	public ManageBean insert(ManageBean manbean) throws SQLException {
		ManageBean temp = (ManageBean) this.getSession().get(ManageBean.class, manbean.getManageId());
		if (temp == null) {
			this.getSession().save(manbean);
			return manbean;
		}
		return null;

	}

	@Override
	public ManageBean update(ManageBean manbean) throws SQLException {
		ManageBean bean = this.getSession().get(ManageBean.class, manbean.getManageId());
		if (bean != null) {
			bean.setManageNum(manbean.getManageNum());
			bean.setManageId(manbean.getManageId());
			bean.setManageName(manbean.getManageName());
			bean.setManagePwd(manbean.getManagePwd());

			return bean;
		}
		return null;
	}

	@Override
	public ManageBean delete(ManageBean manbean) throws SQLException {
		ManageBean bean = this.getSession().get(ManageBean.class, manbean.getManageId());
		if (bean != null) {
			this.getSession().delete(bean);
			return bean;
		}
		return null;
	}

	@Override
	public ManageBean findbyPrimaryKey(String account) throws SQLException {
		return this.getSession().get(ManageBean.class, account);
	}

	@Override
	public List<ManageBean> getALL() throws SQLException {
		Query query = this.getSession().createQuery("from ManageBean ");
		return (List<ManageBean>) query.list();
	}

}
