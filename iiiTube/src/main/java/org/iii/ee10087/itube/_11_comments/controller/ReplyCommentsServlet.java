package org.iii.ee10087.itube._11_comments.controller;

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

import org.iii.ee10087.itube._11_comments.model.ReplyCommentsBean;
import org.iii.ee10087.itube._11_comments.model.ReplyCommentsDAO;
import org.iii.ee10087.itube._11_comments.model.ReplyCommentsDAOImpl;
import org.json.simple.JSONValue;

/**
 * Servlet implementation class ReplyCommentsServlet
 */
@WebServlet("/_11_comments/ReplyComments.do")
public class ReplyCommentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String replywords = request.getParameter("replywords");
		String commentSeqNotmp = request.getParameter("commentSeqNo");
		Long commentSeqNo = Long.parseLong(commentSeqNotmp);
		String userAccount = request.getParameter("userAccount");
//		System.out.println(replywords + commentSeqNo + userAccount);
		ReplyCommentsBean rcb = new ReplyCommentsBean(0L,userAccount,commentSeqNo,replywords,null,0L,0L);
		ReplyCommentsDAO rcdao = new ReplyCommentsDAOImpl();
		ReplyCommentsBean newrcb = null;
		try {
			int n = rcdao.saveReplyComments(rcb);
			newrcb = rcdao.getLastReplyComments(rcb);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LinkedList<HashMap<String, String>> l1 = new LinkedList<HashMap<String, String>>();
		HashMap<String, String> m1 = new HashMap<String, String>();
		m1.put("seqNo", String.valueOf(newrcb.getSeqNo()));
		m1.put("replyCommentsUserAccount", newrcb.getReplyCommentsUserAccount());
		m1.put("commentSeqNo", String.valueOf(newrcb.getCommentSeqNo()));
		m1.put("replyComments", newrcb.getReplyComments());
		m1.put("replyCommentsDate", String.valueOf(newrcb.getReplyCommentsDate()));
		m1.put("replyCommentLike", String.valueOf(newrcb.getReplyCommentLike()));
		m1.put("replyCommentUnLike", String.valueOf(newrcb.getReplyCommentUnLike()));

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
