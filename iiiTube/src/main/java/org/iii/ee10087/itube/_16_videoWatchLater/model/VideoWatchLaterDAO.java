package org.iii.ee10087.itube._16_videoWatchLater.model;

import java.sql.SQLException;
import java.util.List;

import org.iii.ee10087.itube._09_likeUnlikeVideo.model.LikeUnlikeVideoBean;

public interface VideoWatchLaterDAO {
	List<VideoWatchLaterBean> queryAllVideoWatchLater(String userAccount) throws SQLException;

	int insertVideoWatchLater(VideoWatchLaterBean vwlb) throws SQLException;
	
	VideoWatchLaterBean queryVideoWatchLater(Long videoSeqNo, String userAccount) throws SQLException;
	
	int updateVideoWatchLater(VideoWatchLaterBean vwlb) throws SQLException;
}
