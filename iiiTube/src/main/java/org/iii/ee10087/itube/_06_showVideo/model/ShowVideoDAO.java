package org.iii.ee10087.itube._06_showVideo.model;

import java.sql.SQLException;
import java.util.List;

import org.iii.ee10087.itube._05_videoManage.model.VideoBean;

public interface ShowVideoDAO {
	List<VideoBean> getHotVideo()throws SQLException;
	
	List<VideoBean> getNewVideo()throws SQLException;
	
	List<VideoBean> getSortedVideo() throws SQLException;
}
