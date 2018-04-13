package org.iii.ee10087.itube._05_videoManage.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iii.ee10087.itube._01_global.util.GlobalService;
import org.iii.ee10087.itube._02_register.model.MemberBean;
import org.iii.ee10087.itube._05_videoManage.model.VideoBean;
import org.iii.ee10087.itube._05_videoManage.model.VideoDAO;
import org.iii.ee10087.itube._05_videoManage.model.VideoDAOImpl;

/**
 * Servlet implementation class VideoManageServlet
 */
@WebServlet("/_05_videoManage/videoManage.do")
public class VideoManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int pageNo = 1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String requestURI = request.getRequestURI();
		
		if (session == null || session.isNew()) {
			 // 請使用者登入
			 response.sendRedirect(response.encodeRedirectURL ("../_03_login/login.jsp"));
			 return;
		}
		
		session.setAttribute("requestURI", requestURI);
		MemberBean mb = (MemberBean) session.getAttribute("LoginOK");
		if (mb == null) {
			 response.sendRedirect(response.encodeRedirectURL ("../_03_login/login.jsp"));
			 return;
		}
		VideoDAO vo = null;
		try{
			String pageNoStr = request.getParameter("pageNo");
			if(pageNoStr == null){
				pageNo = 1;
			}else {
				try{
					pageNo = Integer.parseInt(pageNoStr.trim());
				}catch(NumberFormatException e){
					pageNo = 1;
				}
			}
			
			
			vo = new VideoDAOImpl();
			request.setAttribute("voBean", vo);
			vo.setPageNo(pageNo);
			vo.setQueryAccount(mb.getAccount());
			vo.setRecordsPerPage(GlobalService.RECORDS_PER_PAGE);
			Collection<VideoBean> coll = vo.getPageVideos(mb.getAccount());
			request.setAttribute("pageNo", pageNo);
			request.setAttribute("totalPages", vo.getTotalPages());
			request.setAttribute("videos_DPP", coll);
			
			RequestDispatcher rd = request.getRequestDispatcher("videoManage.jsp");
			rd.forward(request, response);
			return;
		}catch(SQLException e){
			throw new ServletException(e);
		}
	}

}
