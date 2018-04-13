package org.iii.ee10087.itube._09_likeUnlikeVideo.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class LikeUnlikeVideoBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long seqNo;
	private String userAccount;
	private Long videoSeqNo;
	private String status;
	private Timestamp likeUnLikeVideoDate;
	private Integer score;
	
	public LikeUnlikeVideoBean(){
		
	}

	public LikeUnlikeVideoBean(Long seqNo, String userAccount, Long videoSeqNo, String status,
			Timestamp likeUnLikeVideoDate, Integer score) {
		super();
		this.seqNo = seqNo;
		this.userAccount = userAccount;
		this.videoSeqNo = videoSeqNo;
		this.status = status;
		this.likeUnLikeVideoDate = likeUnLikeVideoDate;
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

	public Timestamp getLikeUnLikeVideoDate() {
		return likeUnLikeVideoDate;
	}

	public void setLikeUnLikeVideoDate(Timestamp likeUnLikeVideoDate) {
		this.likeUnLikeVideoDate = likeUnLikeVideoDate;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "LikeUnlikeVideoBean [seqNo=" + seqNo + ", userAccount=" + userAccount + ", videoSeqNo=" + videoSeqNo
				+ ", status=" + status + ", likeUnLikeVideoDate=" + likeUnLikeVideoDate + ", score=" + score + "]";
	}
	
	
	
	
	
	
}
