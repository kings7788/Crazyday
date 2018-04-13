package org.iii.ee10087.itube._11_comments.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.iii.ee10087.itube._01_global.util.GlobalService;

public class ReplyCommentsDAOImpl implements Serializable, ReplyCommentsDAO {

	private static final long serialVersionUID = 1L;
	DataSource ds = null;

	public ReplyCommentsDAOImpl() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(GlobalService.JNDI_DB_NAME);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public int saveReplyComments(ReplyCommentsBean rcb) throws SQLException {
		int n = 0;
		String sql = "insert into replyComments(replyCommentsUserAccount,"
				+ "commentSeqNo,replyComments,replyCommentsDate,replyCommentLike,"
				+ "replyCommentUnLike) values(?,?,?,?,?,?)";
		try (Connection connection = ds.getConnection(); PreparedStatement pStmst = connection.prepareStatement(sql);) {

			pStmst.setString(1, rcb.getReplyCommentsUserAccount());
			pStmst.setLong(2, rcb.getCommentSeqNo());
			pStmst.setString(3, rcb.getReplyComments());
			java.sql.Timestamp now = new java.sql.Timestamp(System.currentTimeMillis());
			pStmst.setTimestamp(4, now);
			pStmst.setLong(5, rcb.getReplyCommentLike());
			pStmst.setLong(6, rcb.getReplyCommentUnLike());

			n = pStmst.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return n;
	}

	@Override
	public ReplyCommentsBean getLastReplyComments(ReplyCommentsBean rcb) throws SQLException {
		String sql = "  select top(1) replyCommentsDate,seqNo,"
				+ "replyCommentsUserAccount,commentSeqNo,replyComments,replyCommentLike,"
				+ "replyCommentUnLike from replyComments where "
				+ "replyCommentsUserAccount = ? and commentSeqNo = ? "
				+ "order by replyCommentsDate";
		try (Connection connection = ds.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setString(1, rcb.getReplyCommentsUserAccount());
			ps.setLong(2, rcb.getCommentSeqNo());
			try (ResultSet rs = ps.executeQuery();) {
		

				if (rs.next()) {
					
					rcb = new ReplyCommentsBean();
					rcb.setSeqNo(rs.getLong("seqNo"));
					rcb.setReplyCommentsUserAccount(rs.getString("replyCommentsUserAccount"));
					rcb.setCommentSeqNo(rs.getLong("commentSeqNo"));
					rcb.setReplyComments(rs.getString("replyComments"));
					rcb.setReplyCommentsDate(rs.getTimestamp("replyCommentsDate"));
					rcb.setReplyCommentLike(rs.getLong("replyCommentLike"));
					rcb.setReplyCommentUnLike(rs.getLong("replyCommentUnLike"));
					

				
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return rcb;
	}

	@Override
	public LinkedList<HashMap<String, String>> getAllReplyComments(Long commentSeqNo) throws SQLException {
		LinkedList<HashMap<String,String>> lhReplycomments = new LinkedList<HashMap<String,String>>();
		String sql = "select * from replyComments where commentSeqNo=? order by replyCommentsDate desc";
		try (Connection connection = ds.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {
			
			ps.setLong(1, commentSeqNo);
			try (ResultSet rs = ps.executeQuery();) {
				
				while (rs.next()) {
					HashMap<String,String>  m1 = new HashMap<String,String>();       
					 m1.put("seqNo",rs.getString("seqNo"));   
					 m1.put("replyCommentsUserAccount", rs.getString("replyCommentsUserAccount")); 
					 m1.put("commentSeqNo",rs.getString("commentSeqNo")); 
					 m1.put("replyComments", rs.getString("replyComments"));
					 m1.put("replyCommentsDate", rs.getString("replyCommentsDate"));
					 m1.put("replyCommentLike", rs.getString("replyCommentLike"));
					 m1.put("replyCommentUnLike", rs.getString("replyCommentUnLike"));
					 lhReplycomments.add(m1);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lhReplycomments;
	}
}
