package org.iii.ee10087.itube._08_searchVideo.model;

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

public class SearchDAOImpl implements SearchDAO {
	private static final long serialVersionUID = 1L;

	DataSource ds = null;

	public SearchDAOImpl() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(GlobalService.JNDI_DB_NAME);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public List<VideoBean> queryAllVideosByUploader(String videoUploaderAccountqueryWordslike) throws SQLException {
		List<VideoBean> list = new ArrayList<VideoBean>();
		String sql = "select * from videos where ( " + videoUploaderAccountqueryWordslike + " ) order by videoUploadDate";

		try (Connection connection = ds.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {

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
	public List<VideoBean> queryAllVideosByTitle(String videoTitlequeryWordslike,
			String videoUploaderAccountqueryWordslike) throws SQLException {
		List<VideoBean> list = new ArrayList<VideoBean>();
		String sql = "select * from videos where ( " + videoTitlequeryWordslike + " ) and not ( " + videoUploaderAccountqueryWordslike
				+ " ) order by videoUploadDate";

		try (Connection connection = ds.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {
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
	public List<VideoBean> queryAllVideosByDescription(String videoDescriptionqueryWordslike,
			String videoUploaderAccountqueryWordslike, String videoTitlequeryWordslike) throws SQLException {
		List<VideoBean> list = new ArrayList<VideoBean>();
		String sql = "select * from videos where ( " + videoDescriptionqueryWordslike + " ) and not ( "
				+ videoUploaderAccountqueryWordslike + " ) and not ( " + videoTitlequeryWordslike + " ) order by videoUploadDate";

		try (Connection connection = ds.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {
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
	public List<VideoBean> queryAllVideosByVideoType(String videoTypequeryWordslike,
			String videoUploaderAccountqueryWordslike, String videoTitlequeryWordslike,
			String videoDescriptionqueryWordslike) throws SQLException {
		List<VideoBean> list = new ArrayList<VideoBean>();
		String sql = "select * from videos where ( " + videoTypequeryWordslike + " ) and not ( " + videoUploaderAccountqueryWordslike
				+ " ) and not ( " + videoTitlequeryWordslike + " ) and not ( " + videoDescriptionqueryWordslike
				+ " ) order by videoUploadDate";

		try (Connection connection = ds.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {
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
	public List<VideoBean> queryAllVideosByVideoUploadDate(String videoUploadDatequeryWordslike,
			String videoUploaderAccountqueryWordslike, String videoTitlequeryWordslike,
			String videoDescriptionqueryWordslike, String videoTypequeryWordslike) throws SQLException {
		List<VideoBean> list = new ArrayList<VideoBean>();
		String sql = "select * from videos where " + " ( " + videoUploadDatequeryWordslike + ") and not ( "
				+ videoUploaderAccountqueryWordslike + ") and not ( " + videoTitlequeryWordslike + ") and not ( "
				+ videoDescriptionqueryWordslike + ") and not ( " + videoTypequeryWordslike + " ) "
				+ "order by videoUploadDate";

		try (Connection connection = ds.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {
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

}
