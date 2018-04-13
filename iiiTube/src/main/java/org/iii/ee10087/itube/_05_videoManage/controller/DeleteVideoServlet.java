package org.iii.ee10087.itube._05_videoManage.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iii.ee10087.itube._05_videoManage.model.VideoBean;
import org.iii.ee10087.itube._05_videoManage.model.VideoDAO;
import org.iii.ee10087.itube._05_videoManage.model.VideoDAOImpl;

/**
 * Servlet implementation class UpdateVideoServlet
 */
@WebServlet("/_05_videoManage/deleteVideo.do")
public class DeleteVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String> errorMsgs = new HashMap<String, String>();
		Map<String, String> successMsgs = new HashMap<String, String>();
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		session.setAttribute("ErrorMsgKey", errorMsgs);
		session.setAttribute("successMsgKey", successMsgs);
		
		try {
			String seqNotmp = request.getParameter("seqNoDelete");
			Long seqNo = Long.parseLong(seqNotmp);
			VideoDAO vo = new VideoDAOImpl();
			VideoBean vb = new VideoBean();
			vb = vo.queryVideo(seqNo);
			vo.backupVideo(vb);
			vo.deleteVideo(seqNo);
			successMsgs.put("success", "資料刪除成功");
//			response.sendRedirect(response.encodeRedirectURL("videoManage.do"));
			
			PrintWriter out = response.getWriter();
			out.write("刪除成功");
			return;
		} catch (Exception e) {
			e.printStackTrace();
			errorMsgs.put("Exception", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("videoManage.do");
			rd.forward(request, response);
		}
	}

}
