package org.iii.ee10087.itube.manage.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.Session;
import org.iii.ee10087.itube.HibernateSessionFactory.HibernateUtil;

@Entity
@Table(name = "manager")
public class ManageBean {
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private String manageId; // 管理員帳號
	private String managePwd; // 密碼
	private String manageName; // 名稱
	@Transient
	private Integer manageNum; // 管理員編號

//	public static void main(String[] args) {
//		try {
//			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
//			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//			// insert
//			ManageBean bean = new ManageBean();
//			bean.setManageId("100");
//			bean.setManageName("micsoft");
//			session.save(bean);
//			// 新增 刪除 修改 查詢 資料庫資料的程式碼
//			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
//			HibernateUtil.getSessionFactory().getCurrentSession().close();
//		} finally {
//			// factory.close();
//			HibernateUtil.closeSessionFactory();
//		}
//	}

	public Integer getManageNum() {
		return manageNum;
	}

	public void setManageNum(Integer manageNum) {
		this.manageNum = manageNum;
	}

	public String getManageId() {
		return manageId;
	}

	public void setManageId(String manageId) {
		this.manageId = manageId;
	}

	public String getManagePwd() {
		return managePwd;
	}

	public void setManagePwd(String managePwd) {
		this.managePwd = managePwd;
	}

	public String getManageName() {
		return manageName;
	}

	public void setManageName(String manageName) {
		this.manageName = manageName;
	}

	public ManageBean(Integer manageNum, String manageId, String managePwd, String manageName) {
		super();
		this.manageNum = manageNum;
		this.manageId = manageId;
		this.managePwd = managePwd;
		this.manageName = manageName;
	}

	public ManageBean() {
		super();
	}

	@Override
	public String toString() {
		return "ManageBean [manageNum=" + manageNum + ", manageId=" + manageId + ", managePwd=" + managePwd
				+ ", manageName=" + manageName + "]";
	}

}