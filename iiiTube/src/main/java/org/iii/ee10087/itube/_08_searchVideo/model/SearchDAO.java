package org.iii.ee10087.itube._08_searchVideo.model;

import java.sql.SQLException;
import java.util.List;

import org.iii.ee10087.itube._05_videoManage.model.VideoBean;

public interface SearchDAO {
	List<VideoBean> queryAllVideosByUploader(String videoUploaderAccountqueryWordslike) throws SQLException;
	
	List<VideoBean> queryAllVideosByTitle(String videoTitlequeryWordslike, String videoUploaderAccountqueryWordslike) throws SQLException;
	
	List<VideoBean> queryAllVideosByDescription(String videoDescriptionqueryWordslike, String videoUploaderAccountqueryWordslike, String videoTitlequeryWordslike) throws SQLException;
	
	List<VideoBean> queryAllVideosByVideoType(String videoTypequeryWordslike, String videoUploaderAccountqueryWordslike, String videoTitlequeryWordslike, String videoDescriptionqueryWordslike) throws SQLException;
	
	List<VideoBean> queryAllVideosByVideoUploadDate(String videoUploadDatequeryWordslike, String videoUploaderAccountqueryWordslike, String videoTitlequeryWordslike, String videoDescriptionqueryWordslike, String videoTypequeryWordslike) throws SQLException;
}
