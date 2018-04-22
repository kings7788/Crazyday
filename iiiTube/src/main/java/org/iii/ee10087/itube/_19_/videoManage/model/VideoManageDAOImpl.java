package org.iii.ee10087.itube._19_.videoManage.model;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope("prototype")
public class VideoManageDAOImpl implements VideoManageDAO {

	private String userAccount;
	@Autowired
	private SessionFactory sessionfactory;

	public Session openSession() {
		return sessionfactory.openSession();

	}

	public Session getSession() {
		try {
			return sessionfactory.getCurrentSession();
		} catch (HibernateException e) {
			return sessionfactory.openSession();
		}

	}

	@Override
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;

	}

	@Override
	public Serializable insertVideo(VideoBean vb) throws SQLException {

		Session session = getSession();
		Serializable key;
		try {

			key = session.save(vb);
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
		return key;

	}

	@Override
	public VideoBean updateVideo(VideoBean vb) throws SQLException {

		Session session = getSession();
		Transaction trx = null;
		try {
			trx = session.beginTransaction();
			session.saveOrUpdate(vb);
			trx.commit();
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
		return vb;
	}

	@Override
	public VideoBean deleteVideo(Integer videoSeqNo) throws SQLException {

		VideoBean oldvb = selectOneVideo(videoSeqNo);
		oldvb.setVideoStatus("0");
		updateVideo(oldvb);
		return oldvb;

	}

	@Override
	public VideoBean selectOneVideo(Integer VideoSeqNo) throws SQLException {
		Session session = getSession();
		VideoBean vb;
		try {
			vb = session.get(VideoBean.class, VideoSeqNo);
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
		return vb;

	}

	@Override
	public List<VideoBean> selectAllVideo(VideoBean vb) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VideoBean> getUserVideos() {

		Session session = getSession();
		List<VideoBean> videoBeanSet;
		try {
//			System.out.println(userAccount + " aaaaaa");
			videoBeanSet = session.createQuery("FROM VideoBean where userAccount = :userAccount and videoStatus = '1'",VideoBean.class).setParameter("userAccount", userAccount).list();
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
		return videoBeanSet;
	}

}
