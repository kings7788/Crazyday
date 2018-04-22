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
import org.springframework.transaction.annotation.Transactional;

@Repository
@Scope("prototype")
public class VideoManageDAOImpl implements VideoManageDAO {

	@Autowired
	private SessionFactory sessionfactory;

	@Transactional
	@Override
	public Serializable insertVideo(VideoBean vb) throws SQLException {

		Session session = sessionfactory.getCurrentSession();
		Serializable key = session.save(vb);
		return key;

	}

	@Transactional
	@Override
	public VideoBean updateVideo(VideoBean vb) throws SQLException {

		Session session = sessionfactory.getCurrentSession();
		session.saveOrUpdate(vb);
		return vb;
	}

	@Transactional
	@Override
	public VideoBean deleteVideo(Integer videoSeqNo) throws SQLException {

		VideoBean oldvb = selectOneVideo(videoSeqNo);
		oldvb.setVideoStatus("0");
		updateVideo(oldvb);
		return oldvb;

	}

	@Transactional
	@Override
	public VideoBean selectOneVideo(Integer VideoSeqNo) throws SQLException {
		Session session = sessionfactory.getCurrentSession();
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

	@Transactional
	@Override
	public List<VideoBean> selectAllVideo(VideoBean vb) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public List<VideoBean> getUserVideos(String account) {

		Session session = sessionfactory.getCurrentSession();
		List<VideoBean> videoBeanList;
		videoBeanList = session
				.createQuery("FROM VideoBean where account = :account and videoStatus = '1'", VideoBean.class)
				.setParameter("account", account).list();

		return videoBeanList;
	}

}
