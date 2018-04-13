package org.iii.ee10087.itube._02_register.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.iii.ee10087.itube._01_global.util.GlobalService;
import org.iii.ee10087.itube._01_global.util.SystemUtils;
import org.iii.ee10087.itube._02_register.model.MemberBean;
import org.iii.ee10087.itube._02_register.model.MemberDAO;
import org.iii.ee10087.itube._02_register.model.MemberDAOIMP;

/**
 * Servlet implementation class RegisterServlet
 */
@MultipartConfig(location = "", 
fileSizeThreshold = 5*1024 * 1024, 
maxFileSize = 1024 * 1024 * 500, 
maxRequestSize = 1024 * 1024 * 500 * 5)


@WebServlet("/_02_register/deleteMember.do")
public class DeleteMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
