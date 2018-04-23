package org.iii.ee10087.itube._19_.videoManage.model;

import java.io.File;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class VideoManageServiceImpl implements VideoManageService {

	@Autowired
	private VideoManageDAO videoManageDAO;

	@Override
	public void saveVideoImageToFile(String videoImageFileFolderPath, String videoImageFilePath,
			MultipartFile videoImage) throws SQLException {
		// 如果圖片資料夾不存在就創建資料夾
		File imageFolder = new File(videoImageFileFolderPath);
		if (!imageFolder.exists()) {
			imageFolder.mkdirs();
		}
		// 將圖片寫入資料夾
		File imagefile = new File(videoImageFilePath);
		try {
			videoImage.transferTo(imagefile);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("檔案上傳發生意外");
		}

	}

	@Override
	public void saveVideoToFile(String videoFileFolderPath, String videoFilePath, MultipartFile videoFile)
			throws SQLException {
		// 如果影片資料夾不存在就創建資料夾
		File videoFolder = new File(videoFileFolderPath);
		if (!videoFolder.exists()) {
			videoFolder.mkdirs();
		}
		// 將影片寫入資料夾
		File videofile = new File(videoFilePath);
		try {
			videoFile.transferTo(videofile);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("檔案上傳發生意外");
		}
	}

	@Transactional
	@Override
	public VideoBean insertVideo(VideoBean vb, String extImage, String extVideo, MultipartFile videoImage,
			MultipartFile videoFile) throws SQLException {
		vb.setVideoImageFilePath("");
		vb.setVideoFilePath("");
		vb.setVideoLikes(0);
		vb.setVideoUnlikes(0);
		vb.setVideoStatus("1");
		Timestamp now = new java.sql.Timestamp(System.currentTimeMillis());
		vb.setVideoUploadDate(now);
		vb.setVideoUplodaerListType("");
		vb.setVideoViews(0);
		int key = (int) videoManageDAO.insertVideo(vb);

		// 影片封面圖片資料夾路徑
		String videoImageFileFolderPath = "C:/resources/images/video/" + vb.getAccount();
		// 影片資料夾路徑
		String videoFileFolderPath = "C:/resources/videos/video/" + vb.getAccount();
		// 影片封面圖片檔案路徑
		String videoImageFilePath = "C:/resources/images/video/" + vb.getAccount() + "/" + vb.getAccount() + "_" + key
				+ extImage;
		// 影片檔案路徑
		String videoFilePath = "C:/resources/videos/video/" + vb.getAccount() + "/" + vb.getAccount() + "_" + key
				+ extVideo;

		vb.setVideoImageFilePath(videoImageFilePath);
		vb.setVideoFilePath(videoFilePath);
		vb.setVideoSeqNo(key);
		videoManageDAO.updateVideo(vb);
		saveVideoImageToFile(videoImageFileFolderPath, videoImageFilePath, videoImage);
		saveVideoToFile(videoFileFolderPath, videoFilePath, videoFile);
		return vb;

	}

	@Transactional
	@Override
	public List<VideoBean> getUserVideos(String account) {
		return videoManageDAO.getUserVideos(account);
	}

}
