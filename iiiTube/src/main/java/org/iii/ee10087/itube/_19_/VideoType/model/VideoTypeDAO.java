package org.iii.ee10087.itube._19_.VideoType.model;

import java.sql.SQLException;
import java.util.List;

public interface VideoTypeDAO {
	public List<String> getAllVideoType() throws SQLException;
}
