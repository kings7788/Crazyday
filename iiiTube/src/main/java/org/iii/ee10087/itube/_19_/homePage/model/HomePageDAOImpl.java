package org.iii.ee10087.itube._19_.homePage.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.iii.ee10087.itube._19_.VideoType.model.VideoTypeBean;
import org.iii.ee10087.itube._19_.videoManage.model.VideoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Scope("prototype")
public class HomePageDAOImpl implements HomePageDAO {
	@Autowired
	private SessionFactory sessionfactory;
	private String videoType;

	public void setVideoType(String videoType) {
		this.videoType = videoType;
	}

	@Transactional
	@Override
	public List<VideoBean> getHotVideo() {
		Session session = sessionfactory.getCurrentSession();
		List<VideoBean> vblist = session
				.createQuery("FROM VideoBean where videoStatus ='1' ORDER BY videoViews desc", VideoBean.class).list();

		return vblist;

	}

	@Transactional
	@Override
	public List<VideoBean> getNewVideo() {
		Session session = sessionfactory.getCurrentSession();
		List<VideoBean> vblist = session
				.createQuery("FROM VideoBean where videoStatus ='1' ORDER BY videoUploadDate desc", VideoBean.class)
				.list();

		return vblist;
	}

	@Transactional
	@Override
	public List<List<VideoBean>> getSortedVideo() {
		// List<VideoBean> vblist = this.getSession()
		// .createQuery(
		// "FROM VideoBean where videoType = :videoType and videoStatus ='1' ORDER BY
		// videoViews desc",
		// VideoBean.class)
		// .setParameter("videoType", videoType).list();
		Session session = sessionfactory.getCurrentSession();
		List<List<VideoBean>> list = new ArrayList<List<VideoBean>>();
		try {
			List<VideoTypeBean> vtblist = session.createQuery("FROM VideoTypeBean", VideoTypeBean.class).list();
			for (VideoTypeBean vtb : vtblist) {
				String videoTypeTmp = vtb.getVideoType();
				Session sessiontmp = sessionfactory.openSession();
				List<VideoBean> videoBeanList = sessiontmp
						.createQuery("FROM VideoBean where videoType = :videoType and videoStatus = '1'",
								VideoBean.class)
						.setParameter("videoType", videoTypeTmp).list();
				list.add(videoBeanList);
				if (sessiontmp != null) {
					sessiontmp.close();

				}
			}
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

}
