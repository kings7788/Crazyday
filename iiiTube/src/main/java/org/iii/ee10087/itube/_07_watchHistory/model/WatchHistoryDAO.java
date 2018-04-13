package org.iii.ee10087.itube._07_watchHistory.model;

import java.sql.SQLException;
import java.util.List;

public interface WatchHistoryDAO {
	List<WatchHistoryBean> queryWatchHistory(String userAccount) throws SQLException;

	int insertWatchHistory(WatchHistoryBean whb) throws SQLException;

	public List<WatchHistoryLastDateBean> queryWatchHistoryLastDate(String userAccount) throws SQLException;
}
