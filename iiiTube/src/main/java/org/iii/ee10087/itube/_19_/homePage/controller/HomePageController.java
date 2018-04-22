package org.iii.ee10087.itube._19_.homePage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {


	@RequestMapping("*")
	public String index() {
		return "index";
	}
	

}
