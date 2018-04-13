package org.iii.ee10087.itube._09_likeUnlikeVideo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iii.ee10087.itube._05_videoManage.model.VideoBean;
import org.iii.ee10087.itube._05_videoManage.model.VideoDAO;
import org.iii.ee10087.itube._05_videoManage.model.VideoDAOImpl;
import org.iii.ee10087.itube._09_likeUnlikeVideo.model.LikeUnlikeVideoBean;
import org.iii.ee10087.itube._09_likeUnlikeVideo.model.LikeUnlikeVideoDAO;
import org.iii.ee10087.itube._09_likeUnlikeVideo.model.LikeUnlikeVideoDAOImpl;
import org.json.simple.JSONValue;

@WebServlet("/_09_likeUnlikeVideo/GetLikeStatus.do")
public class GetLikeStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// System.out.println("aaaaa");
		String videoSeqNotmp = request.getParameter("videoSeqNo");
		Long videoSeqNo = Long.parseLong(videoSeqNotmp);
		String userAccount = request.getParameter("userAccount");
		LikeUnlikeVideoBean luvb = new LikeUnlikeVideoBean();
		LikeUnlikeVideoDAO luvdao = new LikeUnlikeVideoDAOImpl();
		VideoDAO vdao = new VideoDAOImpl();
		try {
			luvb = luvdao.queryLikeUnlikeVideo(videoSeqNo, userAccount);
			VideoBean vb1 = vdao.queryVideo(videoSeqNo);
			LinkedList<HashMap<String, String>> l1 = new LinkedList<HashMap<String, String>>();
			HashMap<String, String> m1 = new HashMap<String, String>();
			m1.put("likeStatus", luvb.getStatus());
			m1.put("likes", String.valueOf(vb1.getVideoLikes()));
			m1.put("unlikes", String.valueOf(vb1.getVideoUnlikes()));
			l1.add(m1);
			String jsonString = JSONValue.toJSONString(m1);
			response.setHeader("content-type", "text/plain;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.println(jsonString);
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
