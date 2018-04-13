package org.iii.ee10087.itube._09_likeUnlikeVideo.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class LikeVideoOrderedBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long likeVideoSeqNo;
	private String userAccount;
	private String likeStatus;
	private Timestamp likeUnLikeVideoDate;
	private Integer likeScore;
	private Long videoSeqNo;
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

	public LikeVideoOrderedBean(Long likeVideoSeqNo, String userAccount, String likeStatus,
			Timestamp likeUnLikeVideoDate, Integer likeScore, Long videoSeqNo, String videoTitle,
			String videoUploaderAccount, String videoFile, String videoDescription, String videoType,
			String videoUploaderType, Timestamp videoUploadDate, Long videoLikes, Long videoUnlikes, Long videoViews,
			String videoStatus) {
		super();
		this.likeVideoSeqNo = likeVideoSeqNo;
		this.userAccount = userAccount;
		this.likeStatus = likeStatus;
		this.likeUnLikeVideoDate = likeUnLikeVideoDate;
		this.likeScore = likeScore;
		this.videoSeqNo = videoSeqNo;
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
	}

	public LikeVideoOrderedBean() {

	}

	public Long getLikeVideoSeqNo() {
		return likeVideoSeqNo;
	}

	public void setLikeVideoSeqNo(Long likeVideoSeqNo) {
		this.likeVideoSeqNo = likeVideoSeqNo;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getLikeStatus() {
		return likeStatus;
	}

	public void setLikeStatus(String likeStatus) {
		this.likeStatus = likeStatus;
	}

	public Timestamp getLikeUnLikeVideoDate() {
		return likeUnLikeVideoDate;
	}

	public void setLikeUnLikeVideoDate(Timestamp likeUnLikeVideoDate) {
		this.likeUnLikeVideoDate = likeUnLikeVideoDate;
	}

	public Integer getLikeScore() {
		return likeScore;
	}

	public void setLikeScore(Integer likeScore) {
		this.likeScore = likeScore;
	}

	public Long getVideoSeqNo() {
		return videoSeqNo;
	}

	public void setVideoSeqNo(Long videoSeqNo) {
		this.videoSeqNo = videoSeqNo;
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

	@Override
	public String toString() {
		return "LikeVideoOrderedBean [likeVideoSeqNo=" + likeVideoSeqNo + ", userAccount=" + userAccount
				+ ", likeStatus=" + likeStatus + ", likeUnLikeVideoDate=" + likeUnLikeVideoDate + ", likeScore="
				+ likeScore + ", videoSeqNo=" + videoSeqNo + ", videoTitle=" + videoTitle + ", videoUploaderAccount="
				+ videoUploaderAccount + ", videoFile=" + videoFile + ", videoDescription=" + videoDescription
				+ ", videoType=" + videoType + ", videoUploaderType=" + videoUploaderType + ", videoUploadDate="
				+ videoUploadDate + ", videoLikes=" + videoLikes + ", videoUnlikes=" + videoUnlikes + ", videoViews="
				+ videoViews + ", videoStatus=" + videoStatus + "]";
	}

}
