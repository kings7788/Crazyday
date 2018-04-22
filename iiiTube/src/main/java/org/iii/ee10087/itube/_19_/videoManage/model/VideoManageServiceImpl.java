package org.iii.ee10087.itube._19_.videoManage.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

@Service
public class VideoManageServiceImpl implements VideoManageService{

	@Override
	public String saveVideoImageToFile(String folderPath, String path, InputStream is) throws SQLException {
		File fileFolder = new File(folderPath);
		fileFolder.mkdirs();
		File file = new File(path);
		
		try (FileOutputStream output = new FileOutputStream(file)) {
			byte[] buffer = new byte[1024]; // Adjust if you want
			int bytesRead;
			while ((bytesRead = is.read(buffer)) != -1) {
				output.write(buffer, 0, bytesRead);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}

	@Override
	public String saveVideoToFile(String folderPath, String path, InputStream is) throws SQLException {
		File fileFolder = new File(folderPath);
		fileFolder.mkdirs();
		File file = new File(path);

		try (FileOutputStream output = new FileOutputStream(file)) {
			byte[] buffer = new byte[1024]; // Adjust if you want
			int bytesRead;
			while ((bytesRead = is.read(buffer)) != -1) {
				output.write(buffer, 0, bytesRead);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}

}
