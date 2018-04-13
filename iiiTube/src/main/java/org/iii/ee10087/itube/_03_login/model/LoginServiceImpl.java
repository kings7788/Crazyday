package org.iii.ee10087.itube._03_login.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.iii.ee10087.itube._01_global.util.GlobalService;
import org.iii.ee10087.itube._02_register.model.MemberBean;

public class LoginServiceImpl implements LoginService{
	private DataSource ds = null;
	
	public LoginServiceImpl(){
		try{
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup(GlobalService.JNDI_DB_NAME);
		}catch(Exception e){
			throw new RuntimeException(e.getMessage());
		}
	}
	
	@Override
	public MemberBean checkIDPassword(String account, String password) {
		MemberBean mb = null;
		String sql = "select * from member where account = ? and password = ?";
		try(Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				){
			ps.setString(1, account);
			ps.setString(2, password);
			try(ResultSet rs = ps.executeQuery()){
				if(rs.next()){
					mb = new MemberBean();
					mb.setSeqNo(rs.getInt("seqNo"));
					mb.setAccount(rs.getString("account"));
					mb.setPassword(rs.getString("password"));
					mb.setNickname(rs.getString("nickname"));
					mb.setFirstname(rs.getString("firstname"));
					mb.setLastname(rs.getString("lastname"));
					mb.setCellphone(rs.getString("cellphone"));
					mb.setAddress(rs.getString("address"));
					mb.setEmail(rs.getString("email"));
					mb.setBirthday(rs.getTimestamp("birthday"));
					mb.setGender(rs.getString("gender"));
					mb.setRegisterTime(rs.getTimestamp("registerTime"));
					mb.setMemberImage(rs.getBlob("memberImage"));
					mb.setFileName(rs.getString("fileName"));
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("發生例外: " + e.getMessage());
		}
		return mb;
	}
	
}
