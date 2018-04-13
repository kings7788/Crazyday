package org.iii.ee10087.itube._05_videoManage.model;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public interface VideoDAO {
	int saveVideo(VideoBean vb) throws SQLException;
	
	void setPageNo(int pageNo);
	
	void setQueryAccount(String  queryAccount);
	
	void setRecordsPerPage(int recordsPerPage);
	
	List<VideoBean> getPageVideos(String account) throws SQLException;
	
	int getTotalPages() throws SQLException;
	
	long getRecordCounts() throws SQLException;
	
	VideoBean queryVideo(Long seqNo)throws SQLException;
	
	int updateVideo(VideoBean vb);
	
	public int updateVideo(VideoBean vb, long sizeInBytes);
	
	public int deleteVideo(Long seqNo);
	
	int backupVideo(VideoBean vb) throws SQLException;
	
	public boolean videoExists(String videoFile) throws SQLException;
	
	public void setSeqNo(Long seqNo);
	
	public VideoBean getVideo() throws SQLException;

	LinkedList<HashMap<String, String>> queryInsertVideo() throws SQLException;
	
}
