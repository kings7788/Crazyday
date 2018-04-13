package org.iii.ee10087.itube._05_videoManage.model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Timestamp;

public class VideoBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long seqNo;
	private String videoTitle;
	private String videoUploaderAccount;
	private String videoFile;
	private String videoDescription;
	private String videoType;
	private String videoUploaderType;
	private Timestamp videoUploadDate;
	private Long videoLikes;
	private Long videoUnlikes;
	private Long videoViews;
	private String videoStatus;
	private Blob videoImage;
	private String videoImageFileName;

	
	public VideoBean(){
		
	}


	public VideoBean(Long seqNo, String videoTitle, String videoUploaderAccount, String videoFile,
			String videoDescription, String videoType, String videoUploaderType, Timestamp videoUploadDate,
			Long videoLikes, Long videoUnlikes, Long videoViews, String videoStatus, Blob videoImage,
			String videoImageFileName) {
		super();
		this.seqNo = seqNo;
		this.videoTitle = videoTitle;
		this.videoUploaderAccount = videoUploaderAccount;
		this.videoFile = videoFile;
		this.videoDescription = videoDescription;
		this.videoType = videoType;
		this.videoUploaderType = videoUploaderType;
		this.videoUploadDate = videoUploadDate;
		this.videoLikes = videoLikes;
		this.videoUnlikes = videoUnlikes;
		this.videoViews = videoViews;
		this.videoStatus = videoStatus;
		this.videoImage = videoImage;
		this.videoImageFileName = videoImageFileName;
	}


	public Long getSeqNo() {
		return seqNo;
	}


	public void setSeqNo(Long seqNo) {
		this.seqNo = seqNo;
	}


	public String getVideoTitle() {
		return videoTitle;
	}


	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}


	public String getVideoUploaderAccount() {
		return videoUploaderAccount;
	}


	public void setVideoUploaderAccount(String videoUploaderAccount) {
		this.videoUploaderAccount = videoUploaderAccount;
	}


	public String getVideoFile() {
		return videoFile;
	}


	public void setVideoFile(String videoFile) {
		this.videoFile = videoFile;
	}


	public String getVideoDescription() {
		return videoDescription;
	}


	public void setVideoDescription(String videoDescription) {
		this.videoDescription = videoDescription;
	}


	public String getVideoType() {
		return videoType;
	}


	public void setVideoType(String videoType) {
		this.videoType = videoType;
	}


	public String getVideoUploaderType() {
		return videoUploaderType;
	}


	public void setVideoUploaderType(String videoUploaderType) {
		this.videoUploaderType = videoUploaderType;
	}


	public Timestamp getVideoUploadDate() {
		return videoUploadDate;
	}


	public void setVideoUploadDate(Timestamp videoUploadDate) {
		this.videoUploadDate = videoUploadDate;
	}


	public Long getVideoLikes() {
		return videoLikes;
	}


	public void setVideoLikes(Long videoLikes) {
		this.videoLikes = videoLikes;
	}


	public Long getVideoUnlikes() {
		return videoUnlikes;
	}


	public void setVideoUnlikes(Long videoUnlikes) {
		this.videoUnlikes = videoUnlikes;
	}


	public Long getVideoViews() {
		return videoViews;
	}


	public void setVideoViews(Long videoViews) {
		this.videoViews = videoViews;
	}


	public String getVideoStatus() {
		return videoStatus;
	}


	public void setVideoStatus(String videoStatus) {
		this.videoStatus = videoStatus;
	}


	public Blob getVideoImage() {
		return videoImage;
	}


	public void setVideoImage(Blob videoImage) {
		this.videoImage = videoImage;
	}


	public String getVideoImageFileName() {
		return videoImageFileName;
	}


	public void setVideoImageFileName(String videoImageFileName) {
		this.videoImageFileName = videoImageFileName;
	}


	@Override
	public String toString() {
		return "VideoBean [seqNo=" + seqNo + ", videoTitle=" + videoTitle + ", videoUploaderAccount="
				+ videoUploaderAccount + ", videoFile=" + videoFile + ", videoDescription=" + videoDescription
				+ ", videoType=" + videoType + ", videoUploaderType=" + videoUploaderType + ", videoUploadDate="
				+ videoUploadDate + ", videoLikes=" + videoLikes + ", videoUnlikes=" + videoUnlikes + ", videoViews="
				+ videoViews + ", videoStatus=" + videoStatus + ", videoImage=" + videoImage + ", videoImageFileName="
				+ videoImageFileName + "]";
	}


	

	

	
	
	
	
	
}
