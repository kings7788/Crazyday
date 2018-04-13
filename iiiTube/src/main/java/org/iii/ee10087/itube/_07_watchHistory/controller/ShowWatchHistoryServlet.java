package org.iii.ee10087.itube._07_watchHistory.controller;

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
import org.iii.ee10087.itube._07_watchHistory.model.WatchHistoryDAO;
import org.iii.ee10087.itube._07_watchHistory.model.WatchHistoryDAOImpl;
import org.iii.ee10087.itube._07_watchHistory.model.WatchHistoryLastDateBean;

/**
 * Servlet implementation class ShowWatchHistoryServlet
 */
@WebServlet("/_07_watchHistory/ShowWatchHistory.do")
public class ShowWatchHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		MemberBean mb = (MemberBean) session.getAttribute("LoginOK");

		WatchHistoryDAO whdao = new WatchHistoryDAOImpl();

		try {
			List<WatchHistoryLastDateBean> whldbean = whdao.queryWatchHistoryLastDate(mb.getAccount());
			session.setAttribute("watchHistory", whldbean);
			response.sendRedirect("watchHistory.jsp");
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
