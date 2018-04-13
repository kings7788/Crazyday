package org.iii.ee10087.itube._16_videoWatchLater.model;

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
import org.iii.ee10087.itube._05_videoManage.model.VideoBean;
import org.iii.ee10087.itube._09_likeUnlikeVideo.model.LikeUnlikeVideoBean;

public class VideoWatchLaterDAOImpl implements VideoWatchLaterDAO {
	private static final long serialVersionUID = 1L;

	DataSource ds = null;

	public VideoWatchLaterDAOImpl() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(GlobalService.JNDI_DB_NAME);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public List<VideoWatchLaterBean> queryAllVideoWatchLater(String userAccount) throws SQLException {
		List<VideoWatchLaterBean> list = new ArrayList<VideoWatchLaterBean>();
		String sql = "select * from videoWatchLater where userAccount = ?";

		try (Connection connection = ds.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setString(1, userAccount);
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					VideoWatchLaterBean vwlb = new VideoWatchLaterBean();

					vwlb.setSeqNo(rs.getLong("seqNo"));
					vwlb.setUserAccount(rs.getString("userAccount"));
					vwlb.setVideoSeqNo(rs.getLong("videoSeqNo"));
					vwlb.setStatus(rs.getString("status"));
					vwlb.setWatchLaterVideoDate(rs.getTimestamp("watchLaterVideoDate"));
					vwlb.setScore(rs.getLong("score"));

					list.add(vwlb);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	@Override
	public int insertVideoWatchLater(VideoWatchLaterBean vwlb) throws SQLException {
		int n = 0;
		String sql = "insert into videoWatchLater(userAccount, videoSeqNo, "
				+ "status, watchLaterVideoDate, score)"
				+ "values(?,?,?,?,?)";
		try(Connection connection = ds.getConnection();
				PreparedStatement  pStmst = connection.prepareStatement(sql);
				){
			pStmst.setString(1,vwlb.getUserAccount());
			pStmst.setLong(2,vwlb.getVideoSeqNo());
			pStmst.setString(3,vwlb.getStatus());
			pStmst.setTimestamp(4,vwlb.getWatchLaterVideoDate());
			pStmst.setLong(5,vwlb.getScore());
			n = pStmst.executeUpdate();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		return n;
	}

	@Override
	public VideoWatchLaterBean queryVideoWatchLater(Long videoSeqNo, String userAccount) throws SQLException {
		VideoWatchLaterBean vwlb = null;
		String sql = "select * from videoWatchLater where videoSeqNo = ? and userAccount = ?";
		try (Connection connection = ds.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setLong(1, videoSeqNo);
			ps.setString(2, userAccount);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					vwlb = new VideoWatchLaterBean();
					vwlb.setSeqNo(rs.getLong("seqNo"));
					vwlb.setUserAccount(rs.getString("userAccount"));
					vwlb.setVideoSeqNo(rs.getLong("videoSeqNo"));
					vwlb.setStatus(rs.getString("status"));
					vwlb.setWatchLaterVideoDate(rs.getTimestamp("watchLaterVideoDate"));
					vwlb.setScore(rs.getLong("score"));
					
					
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			return vwlb;
		}
	}

	@Override
	public int updateVideoWatchLater(VideoWatchLaterBean vwlb) throws SQLException {
		int n = 0;
		String sql = "update videoWatchLater set userAccount = ?"
				+ ", videoSeqNo = ?, status = ?, watchLaterVideoDate = ?"
				+ ", score = ? where seqNo = ?";
		try(Connection connection = ds.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
				){
			ps.clearParameters();
			ps.setString(1 ,vwlb.getUserAccount());
			ps.setLong(2,vwlb.getVideoSeqNo());
			ps.setString(3 ,vwlb.getStatus());
			ps.setTimestamp(4 ,vwlb.getWatchLaterVideoDate());
			ps.setLong(5 ,vwlb.getScore());
			ps.setLong(6 ,vwlb.getSeqNo());
			n = ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return n;
	}

}
