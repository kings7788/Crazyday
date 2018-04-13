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

import org.iii.ee10087.itube._11_comments.model.ReplyCommentsDAOImpl;
import org.json.simple.JSONValue;


@WebServlet("/_11_comments/showReplyComments.do")
public class showReplyCommentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String videoSeqNotmp = request.getParameter("commentSeqNo");
		Long videoSeqNo = Long.parseLong(videoSeqNotmp);
		ReplyCommentsDAOImpl rcdao = new ReplyCommentsDAOImpl();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("content-type", "application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		LinkedList<HashMap<String,String>> allComments = null;
		try {
			allComments = rcdao.getAllReplyComments(videoSeqNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String jsonString = JSONValue.toJSONString(allComments);
		out.println(jsonString);
		return ;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
