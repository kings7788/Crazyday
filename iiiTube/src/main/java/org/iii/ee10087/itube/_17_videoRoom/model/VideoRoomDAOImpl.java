package org.iii.ee10087.itube._17_videoRoom.model;

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

public class VideoRoomDAOImpl implements VideoRoomDAO, Serializable {

	private static final long serialVersionUID = 1L;
	private String videoUploaderAccount;
	DataSource ds = null;

	public VideoRoomDAOImpl() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(GlobalService.JNDI_DB_NAME);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public String getVideoUploaderAccount() {
		return videoUploaderAccount;
	}

	public void setVideoUploaderAccount(String videoUploaderAccount) {
		this.videoUploaderAccount = videoUploaderAccount;
	}

	@Override
	public List<VideoBean> getUploaderVideos() throws SQLException {
		List<VideoBean> list = new ArrayList<VideoBean>();
		String sql = "select top(?) videoViews, seqNo ,videoTitle, videoUploaderAccount, videoFile, videoDescription, videoType, videoUploaderType,"
				+ "videoUploadDate, videoLikes, videoUnlikes, videoStatus from videos where videoUploaderAccount = ? order by VideoViews desc ";

		int videosNumberInBlock = GlobalService.SHOW_VIDEOS_NUMBER_IN_BLOCK;
		
		String videoUploaderAccount1 = videoUploaderAccount;
		try (Connection connection = ds.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setInt(1, videosNumberInBlock);
			ps.setString(2, videoUploaderAccount1);
			try (ResultSet rs = ps.executeQuery()) {
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
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return list;
	}
}
