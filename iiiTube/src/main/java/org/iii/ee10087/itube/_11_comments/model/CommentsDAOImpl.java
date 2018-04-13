package org.iii.ee10087.itube._11_comments.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.iii.ee10087.itube._01_global.util.GlobalService;
import org.iii.ee10087.itube._05_videoManage.model.VideoBean;

public class CommentsDAOImpl implements Serializable, CommentsDAO {

	private static final long serialVersionUID = 1L;

	DataSource ds = null;

	public CommentsDAOImpl() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(GlobalService.JNDI_DB_NAME);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public int saveComments(CommentsBean cb) throws SQLException {
		int n = 0;
		String sql = "insert into comments" + "(userAccount,videoSeqNo,comments,"
				+ "commentDate,commentLike,commentUnLike)" + " values(?,?,?,?,?,?)";
		try (Connection connection = ds.getConnection(); PreparedStatement pStmst = connection.prepareStatement(sql);) {

			pStmst.setString(1, cb.getUserAccount());
			pStmst.setLong(2, cb.getVideoSeqNo());
			pStmst.setString(3, cb.getComments());
			java.sql.Timestamp now = new java.sql.Timestamp(System.currentTimeMillis());
			pStmst.setTimestamp(4, now);
			pStmst.setLong(5, cb.getCommentLike());
			pStmst.setLong(6, cb.getCommentUnLike());

			n = pStmst.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return n;
	}

	@Override
	public CommentsBean getLastComments(CommentsBean cb) throws SQLException {
		
		String sql = "select top(1) commentDate, seqNo , "
				+ "userAccount,videoSeqNo,comments,"
				+ "commentLike,commentUnLike from comments where userAccount = ? and videoSeqNo = ? order by commentDate desc";
		try (Connection connection = ds.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setString(1, cb.getUserAccount());
			ps.setLong(2, cb.getVideoSeqNo());
			try (ResultSet rs = ps.executeQuery();) {
		

				if (rs.next()) {
					
					cb = new CommentsBean();
					cb.setSeqNo(rs.getLong("seqNo"));
					cb.setUserAccount(rs.getString("userAccount"));
					cb.setVideoSeqNo(rs.getLong("videoSeqNo"));
					cb.setComments(rs.getString("comments"));
					cb.setCommentDate(rs.getTimestamp("commentDate"));
					cb.setCommentLike(rs.getLong("commentLike"));
					cb.setCommentUnLike(rs.getLong("commentUnLike"));
					

				
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return cb;
	}

	@Override
	public LinkedList<HashMap<String,String>> getAllComments(Long videoSeqNo) throws SQLException {
		LinkedList<HashMap<String,String>> lhcomments = new LinkedList<HashMap<String,String>>();
		String sql = "select * from comments where videoSeqNo = ? order by commentDate desc";
		
		try (Connection connection = ds.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setLong(1, videoSeqNo);
			
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					HashMap<String,String>  m1 = new HashMap<String,String>();       
					 m1.put("seqNo",rs.getString("seqNo"));   
					 m1.put("userAccount", rs.getString("userAccount")); 
					 m1.put("videoSeqNo",rs.getString("videoSeqNo")); 
					 m1.put("comments", rs.getString("comments"));
					 m1.put("commentDate", rs.getString("commentDate"));
					 m1.put("commentLike", rs.getString("commentLike"));
					 m1.put("commentUnLike", rs.getString("commentUnLike"));
					
					 lhcomments.add(m1);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lhcomments;
	}
	
	
	
	
}
