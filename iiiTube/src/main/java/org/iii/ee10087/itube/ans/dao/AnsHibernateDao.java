package org.iii.ee10087.itube.ans.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.iii.ee10087.itube.HibernateSessionFactory.HibernateUtil;
import org.iii.ee10087.itube.ans.bean.AnsBean;
import org.iii.ee10087.itube.manage.bean.ManageBean;


public class AnsHibernateDao implements AnsDao {

	private SessionFactory Sessionfactory;

	public AnsHibernateDao(SessionFactory Sessionfactory) {
		this.Sessionfactory = Sessionfactory;
	}

	public Session getSession() {
		return Sessionfactory.getCurrentSession();

	}
//	public static void main(String[] args) throws SQLException {
//	try {
//		HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		// insert
//		AnsHibernateDao dao = new AnsHibernateDao(HibernateUtil.getSessionFactory());
//		AnsBean bean = new AnsBean();
//		
//		
////		//select
////		ManageBean beanss = session.get(ManageBean.class, "100");
////		System.out.println("select=" + beanss);
////		System.out.println("select=" + beanss.getManageNum());
//		
//		bean.setManageNum(100);
//		bean.setManageResponse("映射'成功");
//		bean.setMemAsk("之前的問題");
//		bean.setMemberQuesNum(65500);
//		bean.setMemTitle("HELLO WORLD");
//		bean.setMemQuesTime(new java.sql.Date(0));
//		dao.insert(bean);
//		
////		System.out.println("id-300"+dao.findbyPrimaryKey("300"));
//		// 新增 刪除 修改 查詢 資料庫資料的程式碼
//		HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
//		HibernateUtil.getSessionFactory().getCurrentSession().close();
//	} finally {
//		// factory.close();
//		HibernateUtil.closeSessionFactory();
//	}
//}
	@Override
	public AnsBean insert(AnsBean bean) throws SQLException {
		AnsBean temp = (AnsBean) this.getSession().get(AnsBean.class, bean.getMemberQuesNum());
		if (temp == null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public AnsBean findbyPrimaryKey(AnsBean mem) throws SQLException {
		return this.getSession().get(AnsBean.class, mem.getMemberQuesNum());
	}

	@Override
	public List<AnsBean> getALL() throws SQLException {
		Query query = this.getSession().createQuery("from AnsBean");
		return (List<AnsBean>) query.list();
	}

}
