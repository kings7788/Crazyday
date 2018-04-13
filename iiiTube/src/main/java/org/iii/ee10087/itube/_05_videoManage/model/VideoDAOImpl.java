package org.iii.ee10087.itube._05_videoManage.model;

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

public class VideoDAOImpl implements Serializable, VideoDAO {
	private static final long serialVersionUID = 1L;
	private Long seqNo = 0L;
	private int pageNo = 0;
	private String queryAccount = "";
	private int recordsPerPage = GlobalService.RECORDS_PER_PAGE;
	private int totalPages = -1;

	DataSource ds = null;

	public VideoDAOImpl() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(GlobalService.JNDI_DB_NAME);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public int saveVideo(VideoBean vb) throws SQLException {
		int n = 0;
		String sql = "insert into videos(videoTitle, videoUploaderAccount, "
				+ "videoFile, videoDescription, videoType, videoUploaderType, "
				+ "videoUploadDate, videoLikes, videoUnlikes, videoViews, videoStatus, videoImage, videoImageFileName)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try (Connection connection = ds.getConnection(); PreparedStatement pStmst = connection.prepareStatement(sql);) {
			pStmst.setString(1, vb.getVideoTitle());
			pStmst.setString(2, vb.getVideoUploaderAccount());
			pStmst.setString(3, vb.getVideoFile());
			pStmst.setString(4, vb.getVideoDescription());
			pStmst.setString(5, vb.getVideoType());
			pStmst.setString(6, vb.getVideoUploaderType());
			java.sql.Timestamp now = new java.sql.Timestamp(System.currentTimeMillis());
			pStmst.setTimestamp(7, now);
			pStmst.setLong(8, vb.getVideoLikes());
			pStmst.setLong(9, vb.getVideoUnlikes());
			pStmst.setLong(10, vb.getVideoViews());
			pStmst.setString(11, vb.getVideoStatus());
			pStmst.setBlob(12, vb.getVideoImage());
			pStmst.setString(13, vb.getVideoImageFileName());
			n = pStmst.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return n;
	}

	@Override
	public void setQueryAccount(String queryAccount) {
		this.queryAccount = queryAccount;

	}

	@Override
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;

	}

	@Override
	public void setSeqNo(Long seqNo) {
		this.seqNo = seqNo;
	}

	@Override
	public VideoBean getVideo() throws SQLException {
		VideoBean bean = queryVideo(this.seqNo);
		return bean;
	}

	@Override
	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	@Override
	public List<VideoBean> getPageVideos(String account) throws SQLException {
		List<VideoBean> list = new ArrayList<VideoBean>();
		String sql = "select * from (SELECT  ROW_NUMBER() OVER (ORDER BY videoUploadDate desc)"
				+ "AS RowNum, seqNo, videoTitle, videoUploaderAccount, videoFile, videoDescription, videoType, "
				+ "videoUploaderType, videoUploadDate, videoLikes, videoUnlikes, videoViews, videoStatus FROM  videos WHERE videoUploaderAccount=?)"
				+ "AS NewTable WHERE RowNum >= ? AND RowNum <= ? AND videoStatus='1' AND videoUploaderAccount=? order by videoUploadDate desc";

		int startRecordNo = (pageNo - 1) * recordsPerPage + 1;
		int endRecordNo = (pageNo) * recordsPerPage;
		try (Connection connection = ds.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setString(1, account);
			ps.setInt(2, startRecordNo);
			ps.setInt(3, endRecordNo);
			ps.setString(4, account);
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					VideoBean vb = new VideoBean();

					vb.setSeqNo(rs.getLong("seqNo"));
					vb.setVideoTitle(rs.getString("videoTitle"));
					vb.setVideoUploaderAccount(rs.getString("videoUploaderAccount"));
					vb.setVideoFile(rs.getString("videoFile"));
					vb.setVideoDescription(rs.getString("videoDescription"));
					vb.setVideoType(rs.getString("videoType"));
					vb.setVideoUploaderType(rs.getString("videoUploaderType"));
					vb.setVideoUploadDate(rs.getTimestamp("videoUploadDate"));
					vb.setVideoLikes(rs.getLong("videoLikes"));
					vb.setVideoUnlikes(rs.getLong("videoUnlikes"));
					vb.setVideoViews(rs.getLong("videoViews"));
					vb.setVideoStatus(rs.getString("videoStatus"));

					list.add(vb);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	@Override
	public int getTotalPages() throws SQLException {
		totalPages = (int) (Math.ceil(getRecordCounts() / (double) recordsPerPage));
		return totalPages;
	}

	@Override
	public long getRecordCounts() throws SQLException {
		long count = 0;
		String sql = "select count(*) from videos where videoStatus = '1' and videoUploaderAccount = ? ";
		try (Connection connection = ds.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, queryAccount);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					count = rs.getLong(1);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return count;
	}

	@Override
	public VideoBean queryVideo(Long seqNo) throws SQLException {
		VideoBean vb = null;
		String sql = "select * from videos where seqNo = ? and videoStatus = '1'";
		try (Connection connection = ds.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setLong(1, seqNo);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					vb = new VideoBean();
					vb.setSeqNo(rs.getLong("seqNo"));
					vb.setVideoTitle(rs.getString("videoTitle"));
					vb.setVideoUploaderAccount(rs.getString("videoUploaderAccount"));
					vb.setVideoFile(rs.getString("videoFile"));
					vb.setVideoDescription(rs.getString("videoDescription"));
					vb.setVideoType(rs.getString("videoType"));
					vb.setVideoUploaderType(rs.getString("videoUploaderType"));
					vb.setVideoUploadDate(rs.getTimestamp("videoUploadDate"));
					vb.setVideoLikes(rs.getLong("videoLikes"));
					vb.setVideoUnlikes(rs.getLong("videoUnlikes"));
					vb.setVideoViews(rs.getLong("videoViews"));
					vb.setVideoStatus(rs.getString("videoStatus"));
					vb.setVideoImage(rs.getBlob("videoImage"));
					vb.setVideoImageFileName(rs.getString("videoImageFileName"));

				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			return vb;
		}
	}

	@Override
	public int updateVideo(VideoBean vb, long sizeInBytes) {
		int n = 0;
		String sql = "update videos set videoTitle = ?, videoUploaderAccount = ?"
				+ ", videoFile = ?, videoDescription = ?, videoType = ?"
				+ ", videoUploaderType = ?, videoUploadDate = ?, videoLikes = ?"
				+ ", videoUnlikes = ?, videoViews = ? ,videoStatus = ? " + " ,videoImage = ? ,videoImageFileName = ? "
				+ " where seqNo = ?";
		if (sizeInBytes == -1) { // 不修改圖片
			n = updateVideo(vb);
			return n;
		}
		try (Connection connection = ds.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setString(1, vb.getVideoTitle());
			ps.setString(2, vb.getVideoUploaderAccount());
			ps.setString(3, vb.getVideoFile());
			ps.setString(4, vb.getVideoDescription());
			ps.setString(5, vb.getVideoType());
			ps.setString(6, vb.getVideoUploaderType());
			ps.setTimestamp(7, vb.getVideoUploadDate());
			ps.setLong(8, vb.getVideoLikes());
			ps.setLong(9, vb.getVideoUnlikes());
			ps.setLong(10, vb.getVideoViews());
			ps.setString(11, vb.getVideoStatus());
			ps.setBlob(12, vb.getVideoImage());
			ps.setString(13, vb.getVideoImageFileName());
			ps.setLong(14, vb.getSeqNo());
			n = ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return n;
	}

	@Override
	public int updateVideo(VideoBean vb) {
		int n = 0;
		String sql = "update videos set videoTitle = ?, videoUploaderAccount = ?"
				+ ", videoFile = ?, videoDescription = ?, videoType = ?"
				+ ", videoUploaderType = ?, videoUploadDate = ?, videoLikes = ?"
				+ ", videoUnlikes = ?, videoViews = ? ,videoStatus = ? where seqNo = ?";
		try (Connection connection = ds.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.clearParameters();
			ps.setString(1, vb.getVideoTitle());
			ps.setString(2, vb.getVideoUploaderAccount());
			ps.setString(3, vb.getVideoFile());
			ps.setString(4, vb.getVideoDescription());
			ps.setString(5, vb.getVideoType());
			ps.setString(6, vb.getVideoUploaderType());
			ps.setTimestamp(7, vb.getVideoUploadDate());
			ps.setLong(8, vb.getVideoLikes());
			ps.setLong(9, vb.getVideoUnlikes());
			ps.setLong(10, vb.getVideoViews());
			ps.setString(11, vb.getVideoStatus());
			ps.setLong(12, vb.getSeqNo());
			n = ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return n;
	}

	@Override
	public int deleteVideo(Long seqNo) {
		int n = 0;
		String sql = "delete from videos where seqNo = ?";
		try (Connection connection = ds.getConnection(); PreparedStatement pStmt = connection.prepareStatement(sql);) {
			pStmt.setLong(1, seqNo);
			n = pStmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return n;
	}

	@Override
	public int backupVideo(VideoBean vb) throws SQLException {
		int n = 0;
		String sql = "insert into videosdeleted(videoTitle, videoUploaderAccount, "
				+ "videoFile, videoDescription, videoType, videoUploaderType, "
				+ "videoUploadDate, videoLikes, videoUnlikes, videoViews, videoStatus, videodeletedDate)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try (Connection connection = ds.getConnection(); PreparedStatement pStmst = connection.prepareStatement(sql);) {
			pStmst.setString(1, vb.getVideoTitle());
			pStmst.setString(2, vb.getVideoUploaderAccount());
			pStmst.setString(3, vb.getVideoFile());
			pStmst.setString(4, vb.getVideoDescription());
			pStmst.setString(5, vb.getVideoType());
			pStmst.setString(6, vb.getVideoUploaderType());
			pStmst.setTimestamp(7, vb.getVideoUploadDate());
			pStmst.setLong(8, vb.getVideoLikes());
			pStmst.setLong(9, vb.getVideoUnlikes());
			pStmst.setLong(10, vb.getVideoViews());
			pStmst.setString(11, vb.getVideoStatus());
			java.sql.Timestamp now = new java.sql.Timestamp(System.currentTimeMillis());
			pStmst.setTimestamp(12, now);
			n = pStmst.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return n;
	}

	@Override
	public boolean videoExists(String videoFile) {
		boolean exist = false;
		String sql = "select * from videos where videoFile = ?";
		try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, videoFile);
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
	public  LinkedList<HashMap<String,String>> queryInsertVideo() throws SQLException {
		 LinkedList<HashMap<String,String>> lhvideo = new LinkedList<HashMap<String,String>>();
		String sql = "select top(1) videoUploadDate, seqNo, videoTitle,videoUploaderAccount, videoFile, videoDescription, videoType"
				+ ", videoUploaderType, videoLikes, videoUnlikes, videoViews, videoStatus, videoImageFileName"
				+ " from videos where videoStatus = '1' order by videoUploadDate desc";
		try (Connection connection = ds.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {
			
			try (ResultSet rs = ps.executeQuery();) {
				
				while (rs.next()) {
					 HashMap<String,String>  m1 = new HashMap<String,String>();       
					 m1.put("seqNo",rs.getString("seqNo"));   
					 m1.put("videoTitle", rs.getString("videoTitle")); 
					 m1.put("videoUploaderAccount",rs.getString("videoUploaderAccount")); 
					 m1.put("videoFile", rs.getString("videoFile"));
					 m1.put("videoDescription", rs.getString("videoDescription"));
					 m1.put("videoType", rs.getString("videoType"));
					 m1.put("videoUploaderType", rs.getString("videoUploaderType"));
					 m1.put("videoUploadDate", rs.getString("videoUploadDate"));
					 m1.put("videoLikes", rs.getString("videoLikes"));
					 m1.put("videoUnlikes", rs.getString("videoUnlikes"));
					 m1.put("videoViews", rs.getString("videoViews"));
					 m1.put("videoStatus", rs.getString("videoStatus"));
					 m1.put("videoImageFileName", rs.getString("videoImageFileName"));
					 lhvideo.add(m1);
				 }
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			return lhvideo;
		}
	}

}
