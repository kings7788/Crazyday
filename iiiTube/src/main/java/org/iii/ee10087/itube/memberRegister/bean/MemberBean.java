package org.iii.ee10087.itube.memberRegister.bean;

import java.io.*;
import java.sql.*;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;



@Entity
@Table(name = "MEMBER")
public class MemberBean implements Serializable {

//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private String account; // 帳號
	private String password; // 密碼
	private String name; // 姓名
	private String email; // 電子信箱
	private String address; // 地址
	private java.sql.Date registerdate; // 會員註冊日期
	private Blob photo; // 照片
	private java.sql.Date lastlogin; // 最近登入日期
	@Transient
	private Integer idnumber; //流水編號
	
	public MemberBean(Integer idnumber, String account, String password, String name, String email, String address,
			java.sql.Date registerdate, Blob photo, java.sql.Date lastlogin) {
		this.idnumber = idnumber;
		this.account = account;
		this.password = password;
		this.name = name;
		this.email = email;
		this.address = address;
		this.registerdate = registerdate;
		this.photo = photo;
		this.lastlogin = lastlogin;
	}

	
	
	public MemberBean() {
	}



	public Integer getIdnumber() {
		return idnumber;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public java.sql.Date getRegisterdate() {
		return registerdate;
	}

	public void setRegisterdate(java.sql.Date registerdate) {
		this.registerdate = registerdate;
	}

	public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}

	public java.sql.Date getLastlogin() {
		return lastlogin;
	}

	public void setLastlogin(java.sql.Date lastlogin) {
		this.lastlogin = lastlogin;
	}

}