package org.iii.ee10087.itube._19_.videoManage.model;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface VideoManageDAO {
	public Serializable insertVideo(VideoBean vb) throws SQLException;

	public VideoBean updateVideo(VideoBean vb) throws SQLException;

	public VideoBean deleteVideo(Integer videoSeqNo) throws SQLException;

	public VideoBean selectOneVideo(Integer VideoSeqNo) throws SQLException;

	public List<VideoBean> selectAllVideo(VideoBean vb) throws SQLException;

	public List<VideoBean> getUserVideos();

	public void setUserAccount(String userAccount);
}
