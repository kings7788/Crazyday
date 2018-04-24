package org.iii.ee10087.itube._16_.FAQ.springControll;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iii.ee10087.itube._16_.FAQ.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QAController {
	@Autowired
	ServletContext context;
	@Autowired
	MemberFAQService service;
	@RequestMapping("/customerreport/qa")
	public String insertContact(Model model,HttpServletRequest request,
											HttpServletResponse response,HttpSession session) {
		
		
		
		return null;
	}
}
