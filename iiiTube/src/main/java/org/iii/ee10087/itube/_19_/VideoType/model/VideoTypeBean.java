package org.iii.ee10087.itube._19_.VideoType.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VideoType")
public class VideoTypeBean {
	
//	@OneToMany(
//		mappedBy = "videoType"
//	)
//	
//	private Set<VideoBean> videoBeanSet; 
//
//	public Set<VideoBean> getVideoBeanSet() {
//		return videoBeanSet;
//	}
//	public void setVideoBeanSet(Set<VideoBean> videoBeanSet) {
//		this.videoBeanSet = videoBeanSet;
//	}
	private Integer sortedVideosSeqNo;
	@Id
	private String videoType;
	private Integer sortedVideosScore;
	private String sortedVideosStatus;

	public VideoTypeBean() {
	}
	public VideoTypeBean(Integer sortedVideosSeqNo, String videoType,
			Integer sortedVideosScore, String sortedVideosStatus) {
		super();
		
		this.sortedVideosSeqNo = sortedVideosSeqNo;
		this.videoType = videoType;
		this.sortedVideosScore = sortedVideosScore;
		this.sortedVideosStatus = sortedVideosStatus;
	}
	public Integer getSortedVideosSeqNo() {
		return sortedVideosSeqNo;
	}
	public void setSortedVideosSeqNo(Integer sortedVideosSeqNo) {
		this.sortedVideosSeqNo = sortedVideosSeqNo;
	}
	public String getVideoType() {
		return videoType;
	}
	public void setVideoType(String videoType) {
		this.videoType = videoType;
	}
	public Integer getSortedVideosScore() {
		return sortedVideosScore;
	}
	public void setSortedVideosScore(Integer sortedVideosScore) {
		this.sortedVideosScore = sortedVideosScore;
	}
	public String getSortedVideosStatus() {
		return sortedVideosStatus;
	}
	public void setSortedVideosStatus(String sortedVideosStatus) {
		this.sortedVideosStatus = sortedVideosStatus;
	}
	@Override
	public String toString() {
		return "VideoTypeBean [sortedVideosSeqNo=" + sortedVideosSeqNo
				+ ", videoType=" + videoType + ", sortedVideosScore=" + sortedVideosScore + ", sortedVideosStatus="
				+ sortedVideosStatus + "]";
	}
	
	
	
	
	
}
