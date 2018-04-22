package org.iii.ee10087.itube._19_.VideoType.model;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Scope("prototype")
public class VideoTypeDAOImpl implements VideoTypeDAO {
	@Autowired
	private SessionFactory sessionfactory;

	@Transactional
	@Override
	public List<String> getAllVideoType() {
		Session session = sessionfactory.getCurrentSession();
		List<String> listvt;
		listvt = session.createQuery("Select videoType FROM VideoTypeBean").getResultList();
		return listvt;
	}

}
