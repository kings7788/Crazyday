package org.iii.ee10087.itube._19_.VideoType.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VideoTypeServiceImpl implements VideoTypeService {

	@Autowired
	private VideoTypeDAO videoTypeDAO;

	@Transactional
	@Override
	public List<String> getAllVideoType() throws SQLException {
		return videoTypeDAO.getAllVideoType();
	}

}
