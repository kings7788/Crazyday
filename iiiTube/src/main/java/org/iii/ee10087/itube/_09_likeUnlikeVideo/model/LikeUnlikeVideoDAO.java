package org.iii.ee10087.itube._09_likeUnlikeVideo.model;

import java.sql.SQLException;
import java.util.List;

public interface LikeUnlikeVideoDAO {
	LikeUnlikeVideoBean queryLikeUnlikeVideo(Long videoSeqNo, String userAccount) throws SQLException;
	
	int insertLikeUnlikeVideo(LikeUnlikeVideoBean luvb) throws SQLException;
	
	int updateLikeUnlikeVideo(LikeUnlikeVideoBean luvb);
	
	
	public List<LikeVideoOrderedBean> queryLikeVideos(String userAccount) throws SQLException;
}
