package org.iii.ee10087.itube.ans.bean;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="service_ans")
public class AnsBean {
	@Id
	private int memberQuesNum; // 客戶問題編號
	private int manageNum ;     // 管理員的編號		
	private String memTitle;    //客戶問題主旨
	private String memAsk;          //客戶問題的內容 
	private java.sql.Date memQuesTime;  //問題時間  
//	private memQuespic varbinary(max);       //圖片截圖  
	private String manageResponse;	 //管理員的回應
	private java.sql.Date responseDay;	         //管理員回應的時間
	public int getMemberQuesNum() {
		return memberQuesNum;
	}
	public void setMemberQuesNum(int memberQuesNum) {
		this.memberQuesNum = memberQuesNum;
	}
	public int getManageNum() {
		return manageNum;
	}
	public void setManageNum(int manageNum) {
		this.manageNum = manageNum;
	}
	public String getMemTitle() {
		return memTitle;
	}
	public void setMemTitle(String memTitle) {
		this.memTitle = memTitle;
	}
	public String getMemAsk() {
		return memAsk;
	}
	public void setMemAsk(String memAsk) {
		this.memAsk = memAsk;
	}
	public java.sql.Date getMemQuesTime() {
		return memQuesTime;
	}
	public void setMemQuesTime(java.sql.Date memQuesTime) {
		this.memQuesTime = memQuesTime;
	}
	public String getManageResponse() {
		return manageResponse;
	}
	public void setManageResponse(String manageResponse) {
		this.manageResponse = manageResponse;
	}
	public java.sql.Date getResponseDay() {
		return responseDay;
	}
	public void setResponseDay(java.sql.Date responseDay) {
		this.responseDay = responseDay;
	}
	public AnsBean() {
		super();
	}
	public AnsBean(int memberQuesNum, int manageNum, String memTitle, String memAsk, Date memQuesTime,
			String manageResponse, Date responseDay) {
		super();
		this.memberQuesNum = memberQuesNum;
		this.manageNum = manageNum;
		this.memTitle = memTitle;
		this.memAsk = memAsk;
		this.memQuesTime = memQuesTime;
		this.manageResponse = manageResponse;
		this.responseDay = responseDay;
	}
	@Override
	public String toString() {
		return "AnsBean [memberQuesNum=" + memberQuesNum + ", manageNum=" + manageNum + ", memTitle=" + memTitle
				+ ", memAsk=" + memAsk + ", memQuesTime=" + memQuesTime + ", manageResponse=" + manageResponse
				+ ", responseDay=" + responseDay + "]";
	}
	
	
}
