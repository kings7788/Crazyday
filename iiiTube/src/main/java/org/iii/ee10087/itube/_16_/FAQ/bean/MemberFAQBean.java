package org.iii.ee10087.itube._16_.FAQ.bean;

import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import org.iii.ee10087.itube._16_.FAQ.dao.*;

@Entity
@Table(name = "MemberQues")
public class MemberFAQBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer memberQuesSeqNo;
	private String account;
	private String memTopic;
	private String memTitle;
	private String memAsk;
	private java.util.Date memQuesTime;
	private String memFileName;
	private Blob memQuespic;

	public MemberFAQBean() {

	}

	@Override
	public String toString() {
		return "MemberQABean [memberQuesSeqNo=" + memberQuesSeqNo + ", account=" + account + ", memTopic=" + memTopic
				+ ", memTitle=" + memTitle + ", memAsk=" + memAsk + ", memQuesTime=" + memQuesTime + ", memFileName="
				+ memFileName + ", memQuespic=" + memQuespic + "]";
	}

	public MemberFAQBean(Integer memberQuesSeqNo, String account, String memTopic, String memTitle, String memAsk,
			java.util.Date memQuesTime, String memFileName, Blob memQuespic) {
		super();
		this.memberQuesSeqNo = memberQuesSeqNo;
		this.account = account;
		this.memTopic = memTopic;
		this.memTitle = memTitle;
		this.memAsk = memAsk;
		this.memQuesTime = memQuesTime;
		this.memFileName = memFileName;
		this.memQuespic = memQuespic;
	}

	public Integer getMemberQuesSeqNo() {
		return memberQuesSeqNo;
	}

	public void setMemberQuesSeqNo(Integer memberQuesSeqNo) {
		this.memberQuesSeqNo = memberQuesSeqNo;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getMemTopic() {
		return memTopic;
	}

	public void setMemTopic(String memTopic) {
		this.memTopic = memTopic;
	}

	public String getMemTitle() {
		return memTitle;
	}

	public void setMemTitle(String memTitle) {
		this.memTitle = memTitle;
	}

	public String getMemAsk() {
		return memAsk;
	}

	public void setMemAsk(String memAsk) {
		this.memAsk = memAsk;
	}

	public java.util.Date getMemQuesTime() {
		return memQuesTime;
	}

	public void setMemQuesTime(java.util.Date memQuesTime) {
		this.memQuesTime = memQuesTime;
	}

	public String getMemFileName() {
		return memFileName;
	}

	public void setMemFileName(String memFileName) {
		this.memFileName = memFileName;
	}

	public Blob getMemQuespic() {
		return memQuespic;
	}

	public void setMemQuespic(Blob memQuespic) {
		this.memQuespic = memQuespic;
	}

	public static void main(String[] args) throws SQLException {
		//// StandardServiceRegistry serviceRegistry = new
		//// StandardServiceRegistryBuilder().configure().build();
		//// SessionFactory factory = new
		//// MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		//// Session session = factory.getCurrentSession();
		//// Transaction trx = session.beginTransaction();
		// try {
		// HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
		// Session session =
		//// HibernateUtil.getSessionFactory().getCurrentSession();

		// MemeberQAHibernate dao = new
		// MemeberQAHibernate(HibernateUtil.getSessionFactory());
		// MemberQABean mem = new MemberQABean(100, "fuckyou7710", "55@22",
		// "三重金城武", "sss", 777558, "在座的各位都是垃圾", "sss", "sss", new
		// java.sql.Date(0), );
		////// insert test
		//// mem.setMemberQuesNum(100);
		//// mem.setMemId("fuckyou7710");
		//// mem.setMemMail("55@22");
		//// mem.setMemName("三重金城武");
		//// mem.setMemTel(777558);
		//// mem.setMemAsk("在座的各位都是垃圾");
		//// mem.setMemQuesTime(new java.sql.Date(0));
		//// dao.insert(mem);
		//
		//// update test
		// MemberQABean mem = new MemberQABean();
		// mem.setMemberQuesNum(1); //update 一定要給正確的identity
		// mem.setMemId("fuckyou7789");
		// mem.setMemMail("55@226");
		// mem.setMemName("三重金城武6");
		// mem.setMemTel(7775586);
		// mem.setMemAsk("在座的各位都是垃圾77777");
		// mem.setMemQuesTime(new java.sql.Date(0));
		// dao.update(mem);
		//// session.getSession().get(MemberQABean, "fuckyoumom7788");
		//
		//// delete test
		//// mem.setMemberQuesNum(2);
		//// dao.delete(mem);
		//
		//// select test
		//// mem.setMemberQuesNum(2);
		//// MemberQABean bean = dao.findbyPrimaryKey(mem);
		//// System.out.println("bean="+bean);
		//
		//// select All test
		//// List<MemberQABean> beans = dao.getALL();
		//// System.out.println("beans="+beans);
		//
		//
		//// trx.commit();
		//// session.close();
		// HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		// HibernateUtil.getSessionFactory().getCurrentSession().close();
		// } finally {
		// HibernateUtil.closeSessionFactory();
		//// factory.close();
		// }
	}

}