package org.iii.ee10087.itube._19_.homePage.model;

import java.sql.SQLException;
import java.util.List;

import org.iii.ee10087.itube._19_.videoManage.model.VideoBean;

public interface HomePageDAO {
	List<VideoBean> getHotVideo();

	List<VideoBean> getNewVideo();

	List<List<VideoBean>> getSortedVideo();
}
