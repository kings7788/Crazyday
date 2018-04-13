package org.iii.ee10087.itube._07_watchHistory.model;

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

public class WatchHistoryDAOImpl implements WatchHistoryDAO {
	private static final long serialVersionUID = 1L;

	DataSource ds = null;

	public WatchHistoryDAOImpl() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(GlobalService.JNDI_DB_NAME);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public List<WatchHistoryBean> queryWatchHistory(String userAccount) throws SQLException {
		List<WatchHistoryBean> list = new ArrayList<WatchHistoryBean>();
		String sql = "select * from watchHistory where userAccount = ?";

		try (Connection connection = ds.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setString(1, userAccount);
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					WatchHistoryBean whb = new WatchHistoryBean();

					whb.setSeqNo(rs.getLong("seqNo"));
					whb.setUserAccount(rs.getString("userAccount"));
					whb.setVideoSeqNo(rs.getLong("videoSeqNo"));
					whb.setWatchVideoDate(rs.getTimestamp("watchVideoDate"));
					whb.setScore(rs.getLong("score"));

					list.add(whb);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	
	@Override
	public List<WatchHistoryLastDateBean> queryWatchHistoryLastDate(String userAccount) throws SQLException {
		List<WatchHistoryLastDateBean> list = new ArrayList<WatchHistoryLastDateBean>();
		String sql = "Select vs.seqNo videoSeqNo ,vs.videoTitle ,vs.videoUploaderAccount " 
					+" , vs.videoFile, vs.videoDescription,vs.videoType ,vs.videoUploaderType "
					+" ,vs.videoUploadDate,vs.videoLikes,vs.videoUnlikes,vs.videoViews "
					+" ,vs.videoStatus ,end_wh.watchVideoDate, end_wh.score watchHistoryScore, "
					+ " end_wh.seqNo watchHistorySeqNo , end_wh.userAccount "
					+ " From videos vs Inner Join (Select seqNo,userAccount,watchVideoDate,score,videoSeqNo From ( "
					+ " Select  seqNo,userAccount,watchVideoDate,score,videoSeqNo, "
					+ " ROW_NUMBER() Over (Partition By videoSeqNo Order By watchVideoDate Desc) As Sort "
					+ "From watchHistory where userAccount = ?) TMP_wh "
					+ " Where  TMP_wh.Sort=1 ) end_wh "
					+ " On vs.seqNo =end_wh.videoSeqNo ";

		try (Connection connection = ds.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setString(1, userAccount);
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					WatchHistoryLastDateBean whldb = new WatchHistoryLastDateBean();

					whldb.setVideoSeqNo(rs.getLong("videoSeqNo"));
					whldb.setVideoTitle(rs.getString("videoTitle"));
					whldb.setVideoUploaderAccount(rs.getString("videoUploaderAccount"));
					whldb.setVideoFile(rs.getString("videoFile"));
					whldb.setVideoDescription(rs.getString("videoDescription"));
					whldb.setVideoType(rs.getString("videoType"));
					whldb.setVideoUploaderType(rs.getString("videoUploaderType"));
					whldb.setVideoUploadDate(rs.getTimestamp("videoUploadDate"));
					whldb.setVideoLikes(rs.getLong("videoLikes"));
					whldb.setVideoUnlikes(rs.getLong("videoUnlikes"));
					whldb.setVideoViews(rs.getLong("videoViews"));
					whldb.setVideoStatus(rs.getString("videoStatus"));
					whldb.setWatchVideoDate(rs.getTimestamp("watchVideoDate"));
					whldb.setWatchHistoryScore(rs.getLong("watchHistoryScore"));
					whldb.setWatchHistorySeqNo(rs.getLong("watchHistorySeqNo"));
					whldb.setUserAccount(rs.getString("userAccount"));
					list.add(whldb);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	@Override
	public int insertWatchHistory(WatchHistoryBean whb) throws SQLException {
		int n = 0;
		String sql = "insert into watchHistory(userAccount, videoSeqNo, "
				+ "watchVideoDate ,score)"
				+ "values(?,?,?,?)";
		try(Connection connection = ds.getConnection();
				PreparedStatement  pStmst = connection.prepareStatement(sql);
				){
			pStmst.setString(1,whb.getUserAccount());
			pStmst.setLong(2,whb.getVideoSeqNo());
			pStmst.setTimestamp(3,whb.getWatchVideoDate());
			pStmst.setLong(4,whb.getScore());
			n = pStmst.executeUpdate();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		return n;
	}

	

}
