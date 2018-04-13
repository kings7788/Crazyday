package org.iii.ee10087.itube._16_videoWatchLater.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iii.ee10087.itube._16_videoWatchLater.model.VideoWatchLaterBean;
import org.iii.ee10087.itube._16_videoWatchLater.model.VideoWatchLaterDAO;
import org.iii.ee10087.itube._16_videoWatchLater.model.VideoWatchLaterDAOImpl;

/**
 * Servlet implementation class VideoWatchLaterServlet
 */
@WebServlet("/_16_videoWatchLater/VideoWatchLater.do")
public class VideoWatchLaterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String videoSeqNotmp = request.getParameter("videoSeqNo");
		String userAccount = request.getParameter("userAccount");
		Long videoSeqNo = Long.parseLong(videoSeqNotmp);
		
		VideoWatchLaterDAO vwldao = new VideoWatchLaterDAOImpl();
		VideoWatchLaterBean vwlb = new VideoWatchLaterBean();
		java.sql.Timestamp now = new java.sql.Timestamp(System.currentTimeMillis());
		try {
			vwlb = vwldao.queryVideoWatchLater(videoSeqNo, userAccount);
			if(vwlb == null){
				
				VideoWatchLaterBean vwlb1 = new VideoWatchLaterBean(0L , userAccount , videoSeqNo , "watchLater" , now , 1L);
				vwldao.insertVideoWatchLater(vwlb1);
			}else if(vwlb.getStatus().equals("watchLater")){
				vwlb.setStatus("notWatch");
				vwlb.setWatchLaterVideoDate(now);
				vwldao.updateVideoWatchLater(vwlb);
				
			}else if(vwlb.getStatus().equals("notWatch")){
				vwlb.setStatus("watchLater");
				vwlb.setWatchLaterVideoDate(now);
				vwlb.setScore(vwlb.getScore() + 1L);
				vwldao.updateVideoWatchLater(vwlb);

			}
			response.sendRedirect("../index.jsp");
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
