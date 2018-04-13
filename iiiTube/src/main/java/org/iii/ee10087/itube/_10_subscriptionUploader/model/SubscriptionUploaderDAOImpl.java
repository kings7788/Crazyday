package org.iii.ee10087.itube._10_subscriptionUploader.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.iii.ee10087.itube._01_global.util.GlobalService;
import org.iii.ee10087.itube._16_videoWatchLater.model.VideoWatchLaterBean;

public class SubscriptionUploaderDAOImpl implements SubscriptionUploaderDAO {
	
	private static final long serialVersionUID = 1L;

	DataSource ds = null;

	public SubscriptionUploaderDAOImpl() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(GlobalService.JNDI_DB_NAME);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	

	@Override
	public List<SubscriptionUploaderBean> queryAllSubscriptionUploader(String userAccount) throws SQLException {
		List<SubscriptionUploaderBean> list = new ArrayList<SubscriptionUploaderBean>();
		String sql = "select * from subscriptionUploader where userAccount = ?";

		try (Connection connection = ds.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setString(1, userAccount);
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					SubscriptionUploaderBean sub = new SubscriptionUploaderBean();

					sub.setSeqNo(rs.getLong("seqNo"));
					sub.setUserAccount(rs.getString("userAccount"));
					sub.setUploaderAccount(rs.getString("uploaderAccount"));
					sub.setStatus(rs.getString("status"));
					sub.setSubscriptionUploaderDate(rs.getTimestamp("subscriptionUploaderDate"));
					sub.setScore(rs.getLong("score"));

					list.add(sub);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	@Override
	public int insertSubscriptionUploader(SubscriptionUploaderBean sub) throws SQLException {
		int n = 0;
		String sql = "insert into subscriptionUploader(userAccount, uploaderAccount, "
				+ "status, subscriptionUploaderDate, score)"
				+ "values(?,?,?,?,?)";
		try(Connection connection = ds.getConnection();
				PreparedStatement  pStmst = connection.prepareStatement(sql);
				){
			pStmst.setString(1,sub.getUserAccount());
			pStmst.setString(2,sub.getUploaderAccount());
			pStmst.setString(3,sub.getStatus());
			pStmst.setTimestamp(4,sub.getSubscriptionUploaderDate());
			pStmst.setLong(5,sub.getScore());
			n = pStmst.executeUpdate();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		return n;
	}

	@Override
	public SubscriptionUploaderBean querySubscriptionUploader(String videoUploaderAccount, String userAccount)
			throws SQLException {
		SubscriptionUploaderBean sub = null;
		String sql = "select * from subscriptionUploader where uploaderAccount = ? and userAccount = ?";
		try (Connection connection = ds.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setString(1, videoUploaderAccount);
			ps.setString(2, userAccount);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					sub = new SubscriptionUploaderBean();
					sub.setSeqNo(rs.getLong("seqNo"));
					sub.setUserAccount(rs.getString("userAccount"));
					sub.setUploaderAccount(rs.getString("uploaderAccount"));
					sub.setStatus(rs.getString("status"));
					sub.setSubscriptionUploaderDate(rs.getTimestamp("subscriptionUploaderDate"));
					sub.setScore(rs.getLong("score"));
					
					
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			return sub;
		}
	}

	@Override
	public int updateSubscriptionUploader(SubscriptionUploaderBean sub) throws SQLException {
		int n = 0;
		String sql = "update subscriptionUploader set userAccount = ?"
				+ ", uploaderAccount = ?, status = ?, subscriptionUploaderDate = ?"
				+ ", score = ? where seqNo = ?";
		try(Connection connection = ds.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
				){
			ps.clearParameters();
			ps.setString(1 ,sub.getUserAccount());
			ps.setString(2,sub.getUploaderAccount());
			ps.setString(3 ,sub.getStatus());
			ps.setTimestamp(4 ,sub.getSubscriptionUploaderDate());
			ps.setLong(5 ,sub.getScore());
			ps.setLong(6 ,sub.getSeqNo());
			n = ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return n;
	}
	
	
	@Override
	public List<ShowSubscriptionUploaderBean> querySubscriptionUploaderByAccount(String userAccount) throws SQLException {
		List<ShowSubscriptionUploaderBean> list = new ArrayList<ShowSubscriptionUploaderBean>();
		String sql = " select end_sub.seqNo subUpSeqNo, end_sub.userAccount, end_sub.status subUpStatus, end_sub.subscriptionUploaderDate, end_sub.score subUpScore "+
					" ,upmem.seqNo uploaderSeqNo, upmem.account uploaderAccount, upmem.nickname uploaderNickname, upmem.firstname uploaderFirstname "+
					" ,upmem.lastname uploaderLastname, upmem.cellphone uploaderCellphone, upmem.address uploaderAddress, upmem.email uploaderEmail "+
					" ,upmem.birthday uploaderBirthday, upmem.gender uploaderGender, upmem.registerTime uploaderRegisterTime, upmem.memberImage uploaderMemberImage "+
					" ,upmem.fileName uploaderFileName, upmem.subscription uploaderSubscription from member upmem join ( select * from subscriptionUploader "+
					" where userAccount = ? and status = 'subscription') end_sub on upmem.account = end_sub.uploaderAccount order by end_sub.subscriptionUploaderDate desc ";

		try (Connection connection = ds.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setString(1, userAccount);
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					ShowSubscriptionUploaderBean ssub = new ShowSubscriptionUploaderBean();

					ssub.setSubUpSeqNo(rs.getLong("subUpSeqNo"));
					ssub.setUserAccount(rs.getString("userAccount"));
					ssub.setSubUpStatus(rs.getString("subUpStatus"));
					ssub.setSubscriptionUploaderDate(rs.getTimestamp("subscriptionUploaderDate"));
					ssub.setSubUpScore(rs.getString("subUpScore"));
					ssub.setUploaderSeqNo(rs.getLong("uploaderSeqNo"));
					ssub.setUploaderAccount(rs.getString("uploaderAccount"));
					ssub.setUploaderNickname(rs.getString("uploaderNickname"));
					ssub.setUploaderFirstname(rs.getString("uploaderFirstname"));
					ssub.setUploaderLastname(rs.getString("uploaderLastname"));
					ssub.setUploaderCellphone(rs.getString("uploaderCellphone"));
					ssub.setUploaderAddress(rs.getString("uploaderAddress"));
					ssub.setUploaderEmail(rs.getString("uploaderEmail"));
					ssub.setUploaderBirthday(rs.getTimestamp("uploaderBirthday"));
					ssub.setUploaderGender(rs.getString("uploaderGender"));
					ssub.setUploaderRegisterTime(rs.getTimestamp("uploaderRegisterTime"));
					ssub.setUploaderMemberImage(rs.getString("uploaderMemberImage"));
					ssub.setUploaderFileName(rs.getString("uploaderFileName"));
					ssub.setUploaderSubscription(rs.getLong("uploaderSubscription"));
					list.add(ssub);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

}
