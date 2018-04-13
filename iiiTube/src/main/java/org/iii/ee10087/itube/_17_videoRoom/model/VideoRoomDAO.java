package org.iii.ee10087.itube._17_videoRoom.model;

import java.sql.SQLException;
import java.util.List;

import org.iii.ee10087.itube._05_videoManage.model.VideoBean;

public interface VideoRoomDAO {
	public List<VideoBean> getUploaderVideos() throws SQLException;
}
