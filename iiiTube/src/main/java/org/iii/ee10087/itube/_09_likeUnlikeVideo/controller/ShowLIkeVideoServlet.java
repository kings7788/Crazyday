package org.iii.ee10087.itube._09_likeUnlikeVideo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iii.ee10087.itube._02_register.model.MemberBean;
import org.iii.ee10087.itube._09_likeUnlikeVideo.model.LikeUnlikeVideoDAO;
import org.iii.ee10087.itube._09_likeUnlikeVideo.model.LikeUnlikeVideoDAOImpl;
import org.iii.ee10087.itube._09_likeUnlikeVideo.model.LikeVideoOrderedBean;


@WebServlet("/_09_likeUnlikeVideo/ShowLIkeVideo.do")
public class ShowLIkeVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		MemberBean mb = (MemberBean) session.getAttribute("LoginOK");
		LikeUnlikeVideoDAO luvdao = new LikeUnlikeVideoDAOImpl();
		List<LikeVideoOrderedBean> llvob = null;
		try {
			llvob = luvdao.queryLikeVideos(mb.getAccount());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		session.setAttribute("likeVideos", llvob);
		response.sendRedirect("likeVideos.jsp");
		return;
	}

}
