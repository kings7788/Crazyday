package org.iii.ee10087.itube._19_.homePage.controller;

import java.util.List;

import org.iii.ee10087.itube._19_.homePage.model.HomePageService;
import org.iii.ee10087.itube._19_.videoManage.model.VideoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {
	@Autowired
	private HomePageService homePageService;

	@RequestMapping("*")
	public String index() {
		return "index";
	}
	
	@ModelAttribute("hotVideoList")
	public List<VideoBean> getHotVideos() {
		return homePageService.getHotVideo();
	}
	@ModelAttribute("newVideoList")
	public List<VideoBean> getNewVideos() {
		return homePageService.getNewVideo();
	}
}
