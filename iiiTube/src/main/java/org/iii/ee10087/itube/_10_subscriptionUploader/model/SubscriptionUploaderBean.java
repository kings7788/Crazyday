package org.iii.ee10087.itube._10_subscriptionUploader.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class SubscriptionUploaderBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long seqNo;
	private String userAccount;
	private String uploaderAccount;
	private String status;
	private Timestamp subscriptionUploaderDate;
	private Long score;
	
	
	
	public SubscriptionUploaderBean() {
	}



	public SubscriptionUploaderBean(Long seqNo, String userAccount, String uploaderAccount, String status,
			Timestamp subscriptionUploaderDate, Long score) {
		super();
		this.seqNo = seqNo;
		this.userAccount = userAccount;
		this.uploaderAccount = uploaderAccount;
		this.status = status;
		this.subscriptionUploaderDate = subscriptionUploaderDate;
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



	public String getUploaderAccount() {
		return uploaderAccount;
	}



	public void setUploaderAccount(String uploaderAccount) {
		this.uploaderAccount = uploaderAccount;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public Timestamp getSubscriptionUploaderDate() {
		return subscriptionUploaderDate;
	}



	public void setSubscriptionUploaderDate(Timestamp subscriptionUploaderDate) {
		this.subscriptionUploaderDate = subscriptionUploaderDate;
	}



	public Long getScore() {
		return score;
	}



	public void setScore(Long score) {
		this.score = score;
	}



	@Override
	public String toString() {
		return "SubscriptionUploaderBean [seqNo=" + seqNo + ", userAccount=" + userAccount + ", uploaderAccount="
				+ uploaderAccount + ", status=" + status + ", subscriptionUploaderDate=" + subscriptionUploaderDate
				+ ", score=" + score + "]";
	}



	
	
	
	
}
