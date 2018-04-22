package org.iii.ee10087.itube._19_.videoManage.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Video")
public class VideoBean{
//	@OneToMany(
//		mappedBy="videoSeqNo"
//	)
//	private Set<CommentVideoBean> commentVideoBeanSet;
//	
//	
//	public Set<CommentVideoBean> getCommentVideoBeanSet() {
//		return commentVideoBeanSet;
//	}
//	public void setCommentVideoBeanSet(Set<CommentVideoBean> commentVideoBeanSet) {
//		this.commentVideoBeanSet = commentVideoBeanSet;
//	}
	
//	@ManyToOne
//	@JoinColumn(
//		name="videoType",
//		referencedColumnName="videoType",
//		insertable = false,
//		updatable = false
//	)
//	private VideoTypeBean videoTypeBean;
//	
//	
//	public VideoTypeBean getVideoTypeBean() {
//		return videoTypeBean;
//	}
//	public void setVideoTypeBean(VideoTypeBean videoTypeBean) {
//		this.videoTypeBean = videoTypeBean;
//	}
//	@ManyToOne
//	@JoinColumn(
//		name="userAccount",
//		referencedColumnName="userAccount",
//		insertable=false,
//		updatable=false
//	)
//	private MemberBean memberBean;
//	
//	
//	
//	public MemberBean getMemberBean() {
//		return memberBean;
//	}
//	public void setMemberBean(MemberBean memberBean) {
//		this.memberBean = memberBean;
//	}
//	@ManyToMany
//	@JoinTable(
//		name="WatchLaterVideos",
//		joinColumns=@JoinColumn(name="videoSeqNo"),
//		inverseJoinColumns=@JoinColumn(name="userAccount")
//	)
//	private Set<MemberBean> MemeberBeanWatchLaterSet;
//	
//	public Set<MemberBean> getMemeberBeanWatchLaterSet() {
//		return MemeberBeanWatchLaterSet;
//	}
//	public void setMemeberBeanWatchLaterSet(Set<MemberBean> memeberBeanWatchLaterSet) {
//		MemeberBeanWatchLaterSet = memeberBeanWatchLaterSet;
//	}
//	@ManyToMany
//	@JoinTable(
//		name="WatchHistory",
//		joinColumns=@JoinColumn(name="videoSeqNo"),
//		inverseJoinColumns=@JoinColumn(name="userAccount")
//	)
//	private Set<MemberBean> MemeberBeanWatchHistorySet;
//	
//	public Set<MemberBean> getMemeberBeanWatchHistorySet() {
//		return MemeberBeanWatchHistorySet;
//	}
//	public void setMemeberBeanWatchHistorySet(Set<MemberBean> memeberBeanWatchHistorySet) {
//		MemeberBeanWatchHistorySet = memeberBeanWatchHistorySet;
//	}
//	@ManyToMany
//	@JoinTable(
//		name="LikeUnlikeVideos",
//		joinColumns=@JoinColumn(name="videoSeqNo"),
//		inverseJoinColumns=@JoinColumn(name="userAccount")
//	)
//	private Set<MemberBean> MemeberBeanLikeSet;
//	
//	public Set<MemberBean> getMemeberBeanLikeSet() {
//		return MemeberBeanLikeSet;
//	}
//	public void setMemeberBeanLikeSet(Set<MemberBean> memeberBeanLikeSet) {
//		MemeberBeanLikeSet = memeberBeanLikeSet;
//	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer videoSeqNo;
	private String videoTitle;
	private String userAccount;
	private String videoDescription;
	private String videoType;
	private String videoUplodaerListType;
	private Timestamp videoUploadDate;
	private Integer videoLikes;
	private Integer videoUnlikes;
	private Integer videoViews;
	private String videoStatus;
	private String videoFilePath;
	private String VideoFileName;
	private String videoImageFilePath;
	private String videoImageFileName;
	public VideoBean() {
	}
	public VideoBean(Integer videoSeqNo, String videoTitle, String userAccount, String videoDescription,
			String videoType, String videoUplodaerListType, Timestamp videoUploadDate, Integer videoLikes,
			Integer videoUnlikes, Integer videoViews, String videoStatus, String videoFilePath, String videoFileName,
			String videoImageFilePath, String videoImageFileName) {
		super();
		this.videoSeqNo = videoSeqNo;
		this.videoTitle = videoTitle;
		this.userAccount = userAccount;
		this.videoDescription = videoDescription;
		this.videoType = videoType;
		this.videoUplodaerListType = videoUplodaerListType;
		this.videoUploadDate = videoUploadDate;
		this.videoLikes = videoLikes;
		this.videoUnlikes = videoUnlikes;
		this.videoViews = videoViews;
		this.videoStatus = videoStatus;
		this.videoFilePath = videoFilePath;
		VideoFileName = videoFileName;
		this.videoImageFilePath = videoImageFilePath;
		this.videoImageFileName = videoImageFileName;
	}
	public Integer getVideoSeqNo() {
		return videoSeqNo;
	}
	public void setVideoSeqNo(Integer videoSeqNo) {
		this.videoSeqNo = videoSeqNo;
	}
	public String getVideoTitle() {
		return videoTitle;
	}
	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
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
	public String getVideoUplodaerListType() {
		return videoUplodaerListType;
	}
	public void setVideoUplodaerListType(String videoUplodaerListType) {
		this.videoUplodaerListType = videoUplodaerListType;
	}
	public Timestamp getVideoUploadDate() {
		return videoUploadDate;
	}
	public void setVideoUploadDate(Timestamp videoUploadDate) {
		this.videoUploadDate = videoUploadDate;
	}
	public Integer getVideoLikes() {
		return videoLikes;
	}
	public void setVideoLikes(Integer videoLikes) {
		this.videoLikes = videoLikes;
	}
	public Integer getVideoUnlikes() {
		return videoUnlikes;
	}
	public void setVideoUnlikes(Integer videoUnlikes) {
		this.videoUnlikes = videoUnlikes;
	}
	public Integer getVideoViews() {
		return videoViews;
	}
	public void setVideoViews(Integer videoViews) {
		this.videoViews = videoViews;
	}
	public String getVideoStatus() {
		return videoStatus;
	}
	public void setVideoStatus(String videoStatus) {
		this.videoStatus = videoStatus;
	}
	public String getVideoFilePath() {
		return videoFilePath;
	}
	public void setVideoFilePath(String videoFilePath) {
		this.videoFilePath = videoFilePath;
	}
	public String getVideoFileName() {
		return VideoFileName;
	}
	public void setVideoFileName(String videoFileName) {
		VideoFileName = videoFileName;
	}
	public String getVideoImageFilePath() {
		return videoImageFilePath;
	}
	public void setVideoImageFilePath(String videoImageFilePath) {
		this.videoImageFilePath = videoImageFilePath;
	}
	public String getVideoImageFileName() {
		return videoImageFileName;
	}
	public void setVideoImageFileName(String videoImageFileName) {
		this.videoImageFileName = videoImageFileName;
	}
	@Override
	public String toString() {
		return "VideoBean [videoSeqNo=" + videoSeqNo + ", videoTitle=" + videoTitle + ", userAccount=" + userAccount
				+ ", videoDescription=" + videoDescription + ", videoType=" + videoType + ", videoUplodaerListType="
				+ videoUplodaerListType + ", videoUploadDate=" + videoUploadDate + ", videoLikes=" + videoLikes
				+ ", videoUnlikes=" + videoUnlikes + ", videoViews=" + videoViews + ", videoStatus=" + videoStatus
				+ ", videoFilePath=" + videoFilePath + ", VideoFileName=" + VideoFileName + ", videoImageFilePath="
				+ videoImageFilePath + ", videoImageFileName=" + videoImageFileName + "]";
	}
	
	
	
	
}
