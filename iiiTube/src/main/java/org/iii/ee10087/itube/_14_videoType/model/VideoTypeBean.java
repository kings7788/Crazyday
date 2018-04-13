package org.iii.ee10087.itube._14_videoType.model;

import java.io.Serializable;

public class VideoTypeBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long seqNo;
	private String videoType;
	private Long score;
	public VideoTypeBean(){
		
	}
	public VideoTypeBean(Long seqNo, String videoType, Long score) {
		super();
		this.seqNo = seqNo;
		this.videoType = videoType;
		this.score = score;
	}
	public Long getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(Long seqNo) {
		this.seqNo = seqNo;
	}
	public String getVideoType() {
		return videoType;
	}
	public void setVideoType(String videoType) {
		this.videoType = videoType;
	}
	public Long getScore() {
		return score;
	}
	public void setScore(Long score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "VideoTypeBean [seqNo=" + seqNo + ", videoType=" + videoType + ", score=" + score + "]";
	}
	
	
	
}
