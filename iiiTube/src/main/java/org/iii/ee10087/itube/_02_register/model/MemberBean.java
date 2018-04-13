package org.iii.ee10087.itube._02_register.model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Timestamp;

public class MemberBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer seqNo;
	private String account;
	private String password;
	private String nickname;
	private String firstname;
	private String lastname;
	private String cellphone;
	private String address;
	private String email;
	private Timestamp birthday;
	private String gender;
	private Timestamp registerTime;
	private Blob memberImage;
	private String fileName;
	private Long subscription;
	
	public MemberBean(){
	
	}

	public MemberBean(Integer seqNo, String account, String password, String nickname, String firstname,
			String lastname, String cellphone, String address, String email, Timestamp birthday, String gender,
			Timestamp registerTime, Blob memberImage, String fileName, Long subscription) {
		super();
		this.seqNo = seqNo;
		this.account = account;
		this.password = password;
		this.nickname = nickname;
		this.firstname = firstname;
		this.lastname = lastname;
		this.cellphone = cellphone;
		this.address = address;
		this.email = email;
		this.birthday = birthday;
		this.gender = gender;
		this.registerTime = registerTime;
		this.memberImage = memberImage;
		this.fileName = fileName;
		this.subscription = subscription;
	}

	public Integer getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getBirthday() {
		return birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Timestamp getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}

	public Blob getMemberImage() {
		return memberImage;
	}

	public void setMemberImage(Blob memberImage) {
		this.memberImage = memberImage;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Long getSubscription() {
		return subscription;
	}

	public void setSubscription(Long subscription) {
		this.subscription = subscription;
	}

	@Override
	public String toString() {
		return "MemberBean [seqNo=" + seqNo + ", account=" + account + ", password=" + password + ", nickname="
				+ nickname + ", firstname=" + firstname + ", lastname=" + lastname + ", cellphone=" + cellphone
				+ ", address=" + address + ", email=" + email + ", birthday=" + birthday + ", gender=" + gender
				+ ", registerTime=" + registerTime + ", memberImage=" + memberImage + ", fileName=" + fileName
				+ ", subscription=" + subscription + "]";
	}
	
	
	
	
}
