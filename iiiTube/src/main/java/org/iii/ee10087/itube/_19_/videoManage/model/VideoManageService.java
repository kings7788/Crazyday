package org.iii.ee10087.itube._19_.videoManage.model;

import java.io.InputStream;
import java.sql.SQLException;

public interface VideoManageService {
	public String saveVideoImageToFile(String folderPath, String path, InputStream is) throws SQLException;
	
	public String saveVideoToFile(String folderPath, String path, InputStream is) throws SQLException;
}
