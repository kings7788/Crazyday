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

/**
 * Servlet implementation class likeVideoServlet
 */
@WebServlet("/_09_likeUnlikeVideo/likeunlikeVideo.do")
public class LikeUnlikeVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String videoSeqNotmp = request.getParameter("videoSeqNo");
		String userAccount = request.getParameter("userAccount");
		String status = request.getParameter("likeunlike");
		Long videoSeqNo = Long.parseLong(videoSeqNotmp);
		VideoDAO vdao = new VideoDAOImpl();
		VideoBean vb = new VideoBean();
		LikeUnlikeVideoBean luvb = new LikeUnlikeVideoBean();
		LikeUnlikeVideoDAO luvdao = new LikeUnlikeVideoDAOImpl();
//		System.out.println("aaaaaaaa");
		try {
			luvb = luvdao.queryLikeUnlikeVideo(videoSeqNo, userAccount);
			vb = vdao.queryVideo(videoSeqNo);
			
			if (status.equals("like")) {
				if (luvb == null) {
					LikeUnlikeVideoBean luvb1 = new LikeUnlikeVideoBean();
					java.sql.Timestamp now = new java.sql.Timestamp(System.currentTimeMillis());
					luvb1.setLikeUnLikeVideoDate(now);
					luvb1.setUserAccount(userAccount);
					luvb1.setVideoSeqNo(videoSeqNo);
					luvb1.setStatus("like");
					luvb1.setScore(1);
					luvdao.insertLikeUnlikeVideo(luvb1);

					vb.setVideoLikes(vb.getVideoLikes() + 1L);
					vdao.updateVideo(vb);
				} else if (luvb.getStatus().equals("like")) {
					if (luvb.getScore() > 0) {
						luvb.setScore(luvb.getScore() - 1);
					}

					luvb.setStatus("none");
					luvdao.updateLikeUnlikeVideo(luvb);
					
					if (vb.getVideoLikes() > 0L) {
						vb.setVideoLikes(vb.getVideoLikes() - 1L);
					}
					vdao.updateVideo(vb);

				} else if (luvb.getStatus().equals("unlike")) {
					java.sql.Timestamp now = new java.sql.Timestamp(System.currentTimeMillis());
					luvb.setLikeUnLikeVideoDate(now);
					luvb.setStatus("like");
					luvb.setScore(1);
					luvdao.updateLikeUnlikeVideo(luvb);

					if (vb.getVideoUnlikes() > 0L) {
						vb.setVideoUnlikes(vb.getVideoUnlikes() - 1L);
					}
					vb.setVideoLikes(vb.getVideoLikes() + 1L);
					vdao.updateVideo(vb);

				}else if (luvb.getStatus().equals("none")) {
					luvb.setStatus("like");
					luvb.setScore(luvb.getScore()+1);
					java.sql.Timestamp now = new java.sql.Timestamp(System.currentTimeMillis());
					luvb.setLikeUnLikeVideoDate(now);
					luvdao.updateLikeUnlikeVideo(luvb);
					vb.setVideoLikes(vb.getVideoLikes() + 1L);
					vdao.updateVideo(vb);
				}
			} else if (status.equals("unlike")) {
				if (luvb == null) {
					LikeUnlikeVideoBean luvb1 = new LikeUnlikeVideoBean();
					java.sql.Timestamp now = new java.sql.Timestamp(System.currentTimeMillis());
					luvb1.setLikeUnLikeVideoDate(now);
					luvb1.setUserAccount(userAccount);
					luvb1.setVideoSeqNo(videoSeqNo);
					luvb1.setStatus("unlike");
					luvb1.setScore(0);
					luvdao.insertLikeUnlikeVideo(luvb1);

					vb.setVideoUnlikes(vb.getVideoUnlikes() + 1L);
					vdao.updateVideo(vb);

				} else if (luvb.getStatus().equals("like")) {
					java.sql.Timestamp now = new java.sql.Timestamp(System.currentTimeMillis());
					luvb.setLikeUnLikeVideoDate(now);
					luvb.setStatus("unlike");
					luvb.setScore(0);
					luvdao.updateLikeUnlikeVideo(luvb);

					if (vb.getVideoLikes() > 0L) {
						vb.setVideoLikes(vb.getVideoLikes() - 1L);
					}

					vb.setVideoUnlikes(vb.getVideoUnlikes() + 1L);
					vdao.updateVideo(vb);

				} else if (luvb.getStatus().equals("unlike")) {
					luvb.setStatus("none");

					luvb.setScore(luvb.getScore() + 1);
					java.sql.Timestamp now = new java.sql.Timestamp(System.currentTimeMillis());
					luvb.setLikeUnLikeVideoDate(now);
					luvdao.updateLikeUnlikeVideo(luvb);

					if (vb.getVideoUnlikes() > 0L) {
						vb.setVideoUnlikes(vb.getVideoUnlikes() - 1L);
					}
					vdao.updateVideo(vb);
				}else if (luvb.getStatus().equals("none")) {
					luvb.setStatus("unlike");
					if(luvb.getScore() > 0){
						luvb.setScore(luvb.getScore()-1);
					}
					
					java.sql.Timestamp now = new java.sql.Timestamp(System.currentTimeMillis());
					luvb.setLikeUnLikeVideoDate(now);
					luvdao.updateLikeUnlikeVideo(luvb);
					vb.setVideoUnlikes(vb.getVideoUnlikes() + 1L);
					vdao.updateVideo(vb);
				}
			}
			VideoBean vb1 = vdao.queryVideo(videoSeqNo);
			LikeUnlikeVideoBean luvb1 = luvdao.queryLikeUnlikeVideo(videoSeqNo, userAccount);
			
			 LinkedList<HashMap<String,String>> l1 = new LinkedList<HashMap<String,String>>();
			 HashMap<String,String>  m1 = new HashMap<String,String>();       
			 m1.put("like",String.valueOf(vb1.getVideoLikes()));   
			 m1.put("unlike",String.valueOf(vb1.getVideoUnlikes()));
			 m1.put("likeStatus", luvb1.getStatus());
			 System.out.println(luvb1.getStatus());
			 l1.add(m1);
			 String jsonString = JSONValue.toJSONString(m1);
			 
			 
			
			response.setHeader("content-type", "text/plain;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.println(jsonString);
//			response.sendRedirect("../index.jsp");
//			response.sendRedirect(request.getHeader("referer"));
			return;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
