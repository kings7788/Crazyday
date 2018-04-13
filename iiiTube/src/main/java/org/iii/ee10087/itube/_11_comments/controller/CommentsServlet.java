package org.iii.ee10087.itube._11_comments.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iii.ee10087.itube._11_comments.model.CommentsBean;
import org.iii.ee10087.itube._11_comments.model.CommentsDAO;
import org.iii.ee10087.itube._11_comments.model.CommentsDAOImpl;
import org.json.simple.JSONValue;


@WebServlet("/_11_comments/comments.do")
public class CommentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userAccount = request.getParameter("userAccount");
		String videoSeqNotmp = request.getParameter("videoSeqNo");
		Long videoSeqNo = Long.parseLong(videoSeqNotmp);
		String comments = request.getParameter("comments");
		CommentsBean cb = new CommentsBean(0L,userAccount,videoSeqNo,comments,null,0L,0L);
		
		CommentsDAO cdao = new CommentsDAOImpl();
		CommentsBean newcb = null;
		try {
			cdao.saveComments(cb);
			newcb = cdao.getLastComments(cb);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LinkedList<HashMap<String, String>> l1 = new LinkedList<HashMap<String, String>>();
		HashMap<String, String> m1 = new HashMap<String, String>();
		m1.put("seqNo", String.valueOf(newcb.getSeqNo()));
		m1.put("userAccount", newcb.getUserAccount());
		m1.put("videoSeqNo", String.valueOf(newcb.getVideoSeqNo()));
		m1.put("comments", newcb.getComments());
		m1.put("commentDate", String.valueOf(newcb.getCommentDate()));
		m1.put("commentLike", String.valueOf(newcb.getCommentLike()));
		m1.put("commentUnLike", String.valueOf(newcb.getCommentUnLike()));

		l1.add(m1);
		String jsonString = JSONValue.toJSONString(m1);
		response.setHeader("content-type", "text/plain;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println(jsonString);
		return;
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
