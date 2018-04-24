package org.iii.ee10087.itube._16_.contactlist.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iii.ee10087.itube._16_.FAQ.bean.*;
import org.iii.ee10087.itube._16_.FAQ.service.*;
import org.json.simple.JSONValue;

@WebServlet("/contactservlet")
public class contactservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberFAQService service = new MemberFAQService();
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
//		response.setHeader("content-type", "application/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		LinkedList<HashMap<String, String>> l1 = new LinkedList<HashMap<String, String>>();
		PrintWriter out = response.getWriter();
		try {
			List<MemberFAQBean> list = service.getALL();
			for (MemberFAQBean bean : list) {
				HashMap<String, String> m2 = new HashMap<String, String>();
				String a = bean.getMemberQuesNum().toString();
				m2.put("MemQuesNum", a);
				m2.put("MemId", bean.getMemId());
				m2.put("MemTopic", bean.getMemTopic());				
				m2.put("MemName", bean.getMemName());
				m2.put("MemEmail", bean.getMemMail());
				m2.put("MemTitle", bean.getMemTitle());
				m2.put("MemMessage", bean.getMemAsk());
				l1.add(m2);
			}
			String jsonString = JSONValue.toJSONString(l1);
			out.println(jsonString);

		} catch (SQLException e) {
			out.println("Error:" + e.getMessage());
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
