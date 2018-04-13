package org.iii.ee10087.itube._10_subscriptionUploader.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class ShowSubscriptionUploaderBean  implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long  subUpSeqNo;
	private String  userAccount;
	private String subUpStatus;
	private Timestamp subscriptionUploaderDate;
	private String  subUpScore;
	private Long uploaderSeqNo;
	private String  uploaderAccount;
	private String  uploaderNickname;
	private String  uploaderFirstname;
	private String  uploaderLastname;
	private String  uploaderCellphone;
	private String uploaderAddress;
	private String  uploaderEmail;
	private Timestamp uploaderBirthday;
	private String  uploaderGender;
	private Timestamp  uploaderRegisterTime;
	private String  uploaderMemberImage;
	private String  uploaderFileName;
	private Long   uploaderSubscription;
	
	public ShowSubscriptionUploaderBean(Long subUpSeqNo, String userAccount, String subUpStatus,
			Timestamp subscriptionUploaderDate, String subUpScore, Long uploaderSeqNo, String uploaderAccount,
			String uploaderNickname, String uploaderFirstname, String uploaderLastname, String uploaderCellphone,
			String uploaderAddress, String uploaderEmail, Timestamp uploaderBirthday, String uploaderGender,
			Timestamp uploaderRegisterTime, String uploaderMemberImage, String uploaderFileName,
			Long uploaderSubscription) {
		super();
		this.subUpSeqNo = subUpSeqNo;
		this.userAccount = userAccount;
		this.subUpStatus = subUpStatus;
		this.subscriptionUploaderDate = subscriptionUploaderDate;
		this.subUpScore = subUpScore;
		this.uploaderSeqNo = uploaderSeqNo;
		this.uploaderAccount = uploaderAccount;
		this.uploaderNickname = uploaderNickname;
		this.uploaderFirstname = uploaderFirstname;
		this.uploaderLastname = uploaderLastname;
		this.uploaderCellphone = uploaderCellphone;
		this.uploaderAddress = uploaderAddress;
		this.uploaderEmail = uploaderEmail;
		this.uploaderBirthday = uploaderBirthday;
		this.uploaderGender = uploaderGender;
		this.uploaderRegisterTime = uploaderRegisterTime;
		this.uploaderMemberImage = uploaderMemberImage;
		this.uploaderFileName = uploaderFileName;
		this.uploaderSubscription = uploaderSubscription;
	}
	
	public ShowSubscriptionUploaderBean() {
		
	}
	
	public Long getSubUpSeqNo() {
		return subUpSeqNo;
	}
	public void setSubUpSeqNo(Long subUpSeqNo) {
		this.subUpSeqNo = subUpSeqNo;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getSubUpStatus() {
		return subUpStatus;
	}
	public void setSubUpStatus(String subUpStatus) {
		this.subUpStatus = subUpStatus;
	}
	public Timestamp getSubscriptionUploaderDate() {
		return subscriptionUploaderDate;
	}
	public void setSubscriptionUploaderDate(Timestamp subscriptionUploaderDate) {
		this.subscriptionUploaderDate = subscriptionUploaderDate;
	}
	public String getSubUpScore() {
		return subUpScore;
	}
	public void setSubUpScore(String subUpScore) {
		this.subUpScore = subUpScore;
	}
	public Long getUploaderSeqNo() {
		return uploaderSeqNo;
	}
	public void setUploaderSeqNo(Long uploaderSeqNo) {
		this.uploaderSeqNo = uploaderSeqNo;
	}
	public String getUploaderAccount() {
		return uploaderAccount;
	}
	public void setUploaderAccount(String uploaderAccount) {
		this.uploaderAccount = uploaderAccount;
	}
	public String getUploaderNickname() {
		return uploaderNickname;
	}
	public void setUploaderNickname(String uploaderNickname) {
		this.uploaderNickname = uploaderNickname;
	}
	public String getUploaderFirstname() {
		return uploaderFirstname;
	}
	public void setUploaderFirstname(String uploaderFirstname) {
		this.uploaderFirstname = uploaderFirstname;
	}
	public String getUploaderLastname() {
		return uploaderLastname;
	}
	public void setUploaderLastname(String uploaderLastname) {
		this.uploaderLastname = uploaderLastname;
	}
	public String getUploaderCellphone() {
		return uploaderCellphone;
	}
	public void setUploaderCellphone(String uploaderCellphone) {
		this.uploaderCellphone = uploaderCellphone;
	}
	public String getUploaderAddress() {
		return uploaderAddress;
	}
	public void setUploaderAddress(String uploaderAddress) {
		this.uploaderAddress = uploaderAddress;
	}
	public String getUploaderEmail() {
		return uploaderEmail;
	}
	public void setUploaderEmail(String uploaderEmail) {
		this.uploaderEmail = uploaderEmail;
	}
	public Timestamp getUploaderBirthday() {
		return uploaderBirthday;
	}
	public void setUploaderBirthday(Timestamp uploaderBirthday) {
		this.uploaderBirthday = uploaderBirthday;
	}
	public String getUploaderGender() {
		return uploaderGender;
	}
	public void setUploaderGender(String uploaderGender) {
		this.uploaderGender = uploaderGender;
	}
	public Timestamp getUploaderRegisterTime() {
		return uploaderRegisterTime;
	}
	public void setUploaderRegisterTime(Timestamp uploaderRegisterTime) {
		this.uploaderRegisterTime = uploaderRegisterTime;
	}
	public String getUploaderMemberImage() {
		return uploaderMemberImage;
	}
	public void setUploaderMemberImage(String uploaderMemberImage) {
		this.uploaderMemberImage = uploaderMemberImage;
	}
	public String getUploaderFileName() {
		return uploaderFileName;
	}
	public void setUploaderFileName(String uploaderFileName) {
		this.uploaderFileName = uploaderFileName;
	}
	public Long getUploaderSubscription() {
		return uploaderSubscription;
	}
	public void setUploaderSubscription(Long uploaderSubscription) {
		this.uploaderSubscription = uploaderSubscription;
	}
	@Override
	public String toString() {
		return "ShowSubscriptionUploaderBean [subUpSeqNo=" + subUpSeqNo + ", userAccount=" + userAccount
				+ ", subUpStatus=" + subUpStatus + ", subscriptionUploaderDate=" + subscriptionUploaderDate
				+ ", subUpScore=" + subUpScore + ", uploaderSeqNo=" + uploaderSeqNo + ", uploaderAccount="
				+ uploaderAccount + ", uploaderNickname=" + uploaderNickname + ", uploaderFirstname="
				+ uploaderFirstname + ", uploaderLastname=" + uploaderLastname + ", uploaderCellphone="
				+ uploaderCellphone + ", uploaderAddress=" + uploaderAddress + ", uploaderEmail=" + uploaderEmail
				+ ", uploaderBirthday=" + uploaderBirthday + ", uploaderGender=" + uploaderGender
				+ ", uploaderRegisterTime=" + uploaderRegisterTime + ", uploaderMemberImage=" + uploaderMemberImage
				+ ", uploaderFileName=" + uploaderFileName + ", uploaderSubscription=" + uploaderSubscription + "]";
	}
	
	
}
