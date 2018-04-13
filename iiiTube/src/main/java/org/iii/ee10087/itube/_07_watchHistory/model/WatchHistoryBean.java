package org.iii.ee10087.itube._07_watchHistory.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class WatchHistoryBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private Long seqNo;
	private String userAccount;
	private Long videoSeqNo;
	private Timestamp watchVideoDate;
	private Long score;
	
	public WatchHistoryBean(){
		
	}
	
	
	
	public WatchHistoryBean(Long seqNo, String userAccount, Long videoSeqNo, Timestamp watchVideoDate, Long score) {
		super();
		this.seqNo = seqNo;
		this.userAccount = userAccount;
		this.videoSeqNo = videoSeqNo;
		this.watchVideoDate = watchVideoDate;
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
	public Timestamp getWatchVideoDate() {
		return watchVideoDate;
	}
	public void setWatchVideoDate(Timestamp watchVideoDate) {
		this.watchVideoDate = watchVideoDate;
	}
	public Long getScore() {
		return score;
	}
	public void setScore(Long score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "WatchHistoryBean [seqNo=" + seqNo + ", userAccount=" + userAccount + ", videoSeqNo=" + videoSeqNo
				+ ", watchVideoDate=" + watchVideoDate + ", score=" + score + "]";
	}
	
	
}
