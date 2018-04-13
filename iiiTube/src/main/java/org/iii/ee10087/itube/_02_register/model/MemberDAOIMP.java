package org.iii.ee10087.itube._02_register.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.iii.ee10087.itube._01_global.util.GlobalService;

public class MemberDAOIMP implements MemberDAO {

	private DataSource ds = null;

	public MemberDAOIMP() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(GlobalService.JNDI_DB_NAME);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public int saveMember(MemberBean mb) {
		String sql = "insert into member(account, password, nickname, "
				+ "firstname, lastname, cellphone, address, email, "
				+ "birthday, gender, registerTime, memberImage, fileName, subscription) " + "values(?,?,?,?,?,?,?,?,?,?,?,?,? ,?)";
		int n = 0;
		try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, mb.getAccount());
			String EncrypedString = GlobalService.encryptString(mb.getPassword());
			String tmp = GlobalService.getMD5Endocing(EncrypedString);
			ps.setString(2, tmp);
			ps.setString(3, mb.getNickname());
			ps.setString(4, mb.getFirstname());
			ps.setString(5, mb.getLastname());
			ps.setString(6, mb.getCellphone());
			ps.setString(7, mb.getAddress());
			ps.setString(8, mb.getEmail());
			ps.setTimestamp(9, mb.getBirthday());
			ps.setString(10, mb.getGender());

			java.sql.Timestamp now = new java.sql.Timestamp(System.currentTimeMillis());

			ps.setTimestamp(11, now);
			ps.setBlob(12, mb.getMemberImage());
			ps.setString(13, mb.getFileName());
			ps.setLong(14, mb.getSubscription());
			n = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public boolean accountExists(String account) {
		boolean exist = false;
		String sql = "select * from member where account = ?";
		try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, account);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					exist = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
		return exist;
	}

	@Override
	public MemberBean queryMember(String account) {
		MemberBean mb = null;
		String sql = "select * from member where account = ?";
		try(Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)
				){
			ps.setString(1, account);
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
					mb.setSubscription(rs.getLong("subscription"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mb;
	}

	@Override
	public int updateMember(MemberBean mb) {
		String sql = "update member set nickname = ?, firstname = ?, lastname = ?, cellphone = ?,"
				+ " address = ?, email = ?, birthday = ?, gender = ?, memberImage = ?, fileName = ?, subscription = ?"
				+ " where account = ? ";
		int n = 0;
		try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			
			ps.setString(1, mb.getNickname());
			ps.setString(2, mb.getFirstname());
			ps.setString(3, mb.getLastname());
			ps.setString(4, mb.getCellphone());
			ps.setString(5, mb.getAddress());
			ps.setString(6, mb.getEmail());
			ps.setTimestamp(7, mb.getBirthday());
			ps.setString(8, mb.getGender());
			ps.setBlob(9, mb.getMemberImage());
			ps.setString(10, mb.getFileName());
			ps.setLong(11, mb.getSubscription());
			ps.setString(12, mb.getAccount());
			
			n = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	}
	
	

}
