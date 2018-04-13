package org.iii.ee10087.itube._16_videoWatchLater.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class VideoWatchLaterBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long seqNo;
	private String userAccount;
	private Long videoSeqNo;
	private String status;
	private Timestamp watchLaterVideoDate;
	private Long score;
	public VideoWatchLaterBean() {
		
	}
	public VideoWatchLaterBean(Long seqNo, String userAccount, Long videoSeqNo, String status,
			Timestamp watchLaterVideoDate, Long score) {
		super();
		this.seqNo = seqNo;
		this.userAccount = userAccount;
		this.videoSeqNo = videoSeqNo;
		this.status = status;
		this.watchLaterVideoDate = watchLaterVideoDate;
		this.score = score;
	}
	public Long getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(Long seqNo) {
		this.seqNo = seqNo;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public Long getVideoSeqNo() {
		return videoSeqNo;
	}
	public void setVideoSeqNo(Long videoSeqNo) {
		this.videoSeqNo = videoSeqNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Timestamp getWatchLaterVideoDate() {
		return watchLaterVideoDate;
	}
	public void setWatchLaterVideoDate(Timestamp watchLaterVideoDate) {
		this.watchLaterVideoDate = watchLaterVideoDate;
	}
	public Long getScore() {
		return score;
	}
	public void setScore(Long score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "VideoWatchLaterBean [seqNo=" + seqNo + ", userAccount=" + userAccount + ", videoSeqNo=" + videoSeqNo
				+ ", status=" + status + ", watchLaterVideoDate=" + watchLaterVideoDate + ", score=" + score + "]";
	}

	
	
	
}	
