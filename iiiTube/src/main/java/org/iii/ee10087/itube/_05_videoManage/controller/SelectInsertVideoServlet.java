package org.iii.ee10087.itube._05_videoManage.controller;

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

import org.iii.ee10087.itube._05_videoManage.model.VideoDAO;
import org.iii.ee10087.itube._05_videoManage.model.VideoDAOImpl;
import org.json.simple.JSONValue;

/**
 * Servlet implementation class SelectInsertVideoServlet
 */
@WebServlet("/_05_videoManage/SelectInsertVideo.do")
public class SelectInsertVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SelectInsertVideoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("content-type", "application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
//		String seqNoTmp = request.getParameter("seqNo");
//		Long seqNo = Long.parseLong(seqNoTmp);
		VideoDAO vo = new VideoDAOImpl();
		LinkedList<HashMap<String, String>> l1 = null;
		try {
			l1 = vo.queryInsertVideo();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String jsonString = JSONValue.toJSONString(l1);
		out.println(jsonString);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
