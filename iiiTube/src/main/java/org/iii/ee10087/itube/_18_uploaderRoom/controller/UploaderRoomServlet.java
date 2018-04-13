package org.iii.ee10087.itube._18_uploaderRoom.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iii.ee10087.itube._01_global.util.GlobalService;
import org.iii.ee10087.itube._05_videoManage.model.VideoBean;
import org.iii.ee10087.itube._05_videoManage.model.VideoDAO;
import org.iii.ee10087.itube._05_videoManage.model.VideoDAOImpl;

/**
 * Servlet implementation class UploaderRoomServlet
 */
@WebServlet("/_18_uploaderRoom/UploaderRoom.do")
public class UploaderRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int pageNo = 1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uploaderAccount = request.getParameter("uploaderAccount");
		VideoDAO vo = null;
		try {
			String pageNoStr = request.getParameter("pageNo");
			if (pageNoStr == null) {
				pageNo = 1;
			} else {
				try {
					pageNo = Integer.parseInt(pageNoStr.trim());
				} catch (NumberFormatException e) {
					pageNo = 1;
				}
			}
			request.setAttribute("videoUploaderAccount", uploaderAccount);
			vo = new VideoDAOImpl();
			request.setAttribute("voBean", vo);
			vo.setPageNo(pageNo);
			vo.setQueryAccount(uploaderAccount);
			vo.setRecordsPerPage(GlobalService.RECORDS_PER_PAGE);
			Collection<VideoBean> coll = vo.getPageVideos(uploaderAccount);
			request.setAttribute("pageNo", pageNo);
			request.setAttribute("totalPages", vo.getTotalPages());
			request.setAttribute("videos_DPP", coll);

			RequestDispatcher rd = request.getRequestDispatcher("uploaderRoom.jsp");
			rd.forward(request, response);
			return;
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}

}
