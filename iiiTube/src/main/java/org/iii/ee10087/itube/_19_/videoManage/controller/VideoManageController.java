package org.iii.ee10087.itube._19_.videoManage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VideoManageController {
	@RequestMapping("videoManage")
	public String videoManageHomePage() {
		return "videoManage/videoManage";
	}
}
