package org.iii.ee10087.itube._19_.homePage.model;

import java.util.List;

import org.iii.ee10087.itube._19_.videoManage.model.VideoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HomePageServiceImpl implements HomePageService {
	@Autowired
	private HomePageDAO homePageDAO;
	@Transactional
	@Override
	public List<VideoBean> getHotVideo() {
		return homePageDAO.getHotVideo();
	}
	@Transactional
	@Override
	public List<VideoBean> getNewVideo() {
		return homePageDAO.getNewVideo();
	}
	@Transactional
	@Override
	public List<List<VideoBean>> getSortedVideo() {
		// TODO Auto-generated method stub
		return null;
	}

}
