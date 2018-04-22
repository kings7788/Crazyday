package org.iii.ee10087.itube._19_.videoManage.model;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface VideoManageService {
	public void saveVideoImageToFile(String videoImageFileFolderPath, String videoImageFilePath,MultipartFile videoImage) throws SQLException;

	public void saveVideoToFile(String videoFileFolderPath, String videoFilePath,MultipartFile videoFile) throws SQLException;

	public VideoBean insertVideo(VideoBean vb, String extImage, String extVideo, MultipartFile videoImage,
			MultipartFile videoFile) throws SQLException;
	public List<VideoBean> getUserVideos(String account);
}
