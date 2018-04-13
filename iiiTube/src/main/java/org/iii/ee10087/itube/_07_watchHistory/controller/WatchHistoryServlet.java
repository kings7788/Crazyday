package org.iii.ee10087.itube._07_watchHistory.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iii.ee10087.itube._05_videoManage.model.VideoBean;
import org.iii.ee10087.itube._05_videoManage.model.VideoDAO;
import org.iii.ee10087.itube._05_videoManage.model.VideoDAOImpl;
import org.iii.ee10087.itube._07_watchHistory.model.WatchHistoryBean;
import org.iii.ee10087.itube._07_watchHistory.model.WatchHistoryDAO;
import org.iii.ee10087.itube._07_watchHistory.model.WatchHistoryDAOImpl;

/**
 * Servlet implementation class WatchHistoryServlet
 */
@WebServlet("/_07_watchHistory/watchHistory.do")
public class WatchHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String videoSeqNotmp = request.getParameter("videoSeqNo");
		String userAccount = request.getParameter("userAccount");
		Long videoSeqNo = Long.parseLong(videoSeqNotmp);
		HttpSession session = request.getSession();
		VideoBean vb = new VideoBean();
		VideoDAO vdao = new VideoDAOImpl();

		WatchHistoryDAO whdao = new WatchHistoryDAOImpl();

		try {
			vb = vdao.queryVideo(videoSeqNo);
			vb.setVideoViews(vb.getVideoViews() + 1L);
			vdao.updateVideo(vb);
			vb = vdao.queryVideo(videoSeqNo);

			java.sql.Timestamp now = new java.sql.Timestamp(System.currentTimeMillis());

			WatchHistoryBean whb = new WatchHistoryBean(0L, userAccount, videoSeqNo, now, 0L);
			whdao.insertWatchHistory(whb);
			session.setAttribute("watchVideoBean", vb);
			response.sendRedirect("../_17_videoRoom/videoRoom.jsp");
			return;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
