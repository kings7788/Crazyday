package org.iii.ee10087.itube._09_likeUnlikeVideo.model;

import java.io.Serializable;
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
import org.iii.ee10087.itube._07_watchHistory.model.WatchHistoryBean;

public class LikeUnlikeVideoDAOImpl implements LikeUnlikeVideoDAO, Serializable {

	private static final long serialVersionUID = 1L;

	DataSource ds = null;

	public LikeUnlikeVideoDAOImpl(){
		try{
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup(GlobalService.JNDI_DB_NAME);
		}catch(Exception e){
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public LikeUnlikeVideoBean queryLikeUnlikeVideo(Long videoSeqNo, String userAccount) throws SQLException {
		LikeUnlikeVideoBean luvb = null;
		String sql = "select * from videoLikeUnlike where videoSeqNo = ? and userAccount = ?";
		try (Connection connection = ds.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setLong(1, videoSeqNo);
			ps.setString(2, userAccount);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					luvb = new LikeUnlikeVideoBean();
					luvb.setSeqNo(rs.getLong("seqNo"));
					luvb.setUserAccount(rs.getString("userAccount"));
					luvb.setVideoSeqNo(rs.getLong("videoSeqNo"));
					luvb.setStatus(rs.getString("status"));
					luvb.setLikeUnLikeVideoDate(rs.getTimestamp("likeUnLikeVideoDate"));
					luvb.setScore(rs.getInt("score"));
					
					
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			return luvb;
		}
	}

	@Override
	public int insertLikeUnlikeVideo(LikeUnlikeVideoBean luvb) throws SQLException {
		int n = 0;
		String sql = "insert into videoLikeUnlike(userAccount, videoSeqNo, "
				+ "status, likeUnLikeVideoDate,score)"
				+ "values(?,?,?,?,?)";
		try(Connection connection = ds.getConnection();
				PreparedStatement  pStmst = connection.prepareStatement(sql);
				){
			pStmst.setString(1,luvb.getUserAccount());
			pStmst.setLong(2,luvb.getVideoSeqNo());
			pStmst.setString(3,luvb.getStatus());
			pStmst.setTimestamp(4,luvb.getLikeUnLikeVideoDate());
			pStmst.setInt(5,luvb.getScore());
			n = pStmst.executeUpdate();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		return n;
	}

	@Override
	public int updateLikeUnlikeVideo(LikeUnlikeVideoBean luvb) {
		int n = 0;
		String sql = "update videoLikeUnlike set userAccount = ?"
				+ ", videoSeqNo = ?, status = ?, likeUnLikeVideoDate = ?"
				+ ", score = ? where seqNo = ?";
		try(Connection connection = ds.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
				){
			ps.clearParameters();
			ps.setString(1 ,luvb.getUserAccount());
			ps.setLong(2,luvb.getVideoSeqNo());
			ps.setString(3 ,luvb.getStatus());
			ps.setTimestamp(4 ,luvb.getLikeUnLikeVideoDate());
			ps.setInt(5 ,luvb.getScore());
			ps.setLong(6 ,luvb.getSeqNo());
			n = ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return n;
	}
	
	@Override
	public List<LikeVideoOrderedBean> queryLikeVideos(String userAccount) throws SQLException {
		List<LikeVideoOrderedBean> list = new ArrayList<LikeVideoOrderedBean>();
		String sql = "select end_likev.seqNo likeVideoSeqNo "+
      " ,end_likev.userAccount, end_likev.status likeStatus, end_likev.likeUnLikeVideoDate, end_likev.score likeScore "+
	  " ,vs.SeqNo videoSeqNo, vs.videoTitle, vs.videoUploaderAccount, vs.videoFile, vs.videoDescription, vs.videoType "+
      " ,vs.videoUploaderType, vs.videoUploadDate, vs.videoLikes, vs.videoUnlikes, vs.videoViews, vs.videoStatus "+
	  " from videos vs join (select * from videoLikeUnlike where userAccount = ? and status = 'like') end_likev on vs.seqNo "+
	  " = end_likev.videoSeqNo order by likeUnLikeVideoDate desc";

		try (Connection connection = ds.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setString(1, userAccount);
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					LikeVideoOrderedBean lvob = new LikeVideoOrderedBean();

					lvob.setLikeVideoSeqNo(rs.getLong("likeVideoSeqNo"));
					lvob.setUserAccount(rs.getString("userAccount"));
					lvob.setLikeStatus(rs.getString("likeStatus"));
					lvob.setLikeUnLikeVideoDate(rs.getTimestamp("likeUnLikeVideoDate"));
					lvob.setLikeScore(rs.getInt("likeScore"));
					lvob.setVideoSeqNo(rs.getLong("videoSeqNo"));
					lvob.setVideoTitle(rs.getString("videoTitle"));
					lvob.setVideoUploaderAccount(rs.getString("videoUploaderAccount"));
					lvob.setVideoFile(rs.getString("videoFile"));
					lvob.setVideoDescription(rs.getString("videoDescription"));
					lvob.setVideoType(rs.getString("videoType"));
					lvob.setVideoUploaderType(rs.getString("videoUploaderType"));
					lvob.setVideoUploadDate(rs.getTimestamp("videoUploadDate"));
					lvob.setVideoLikes(rs.getLong("videoLikes"));
					lvob.setVideoUnlikes(rs.getLong("videoUnlikes"));
					lvob.setVideoViews(rs.getLong("videoViews"));
					lvob.setVideoStatus(rs.getString("videoStatus"));
					list.add(lvob);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	
	
}
