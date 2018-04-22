package org.iii.ee10087.itube._19_.VideoType.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;

import org.iii.ee10087.itube._19_.VideoType.model.VideoTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class VideoTypeController {

	@Autowired
	private VideoTypeService videoTypeService;
	@Autowired
	ServletContext context;

//	@ModelAttribute("videoTypeList")
//	public List<String> getVideoType() {
//		List<String> videoTypeList = null;
//		try {
//			videoTypeList = videoTypeService.getAllVideoType();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return videoTypeList;
//	}
}
