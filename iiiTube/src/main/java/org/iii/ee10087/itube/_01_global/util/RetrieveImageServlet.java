package org.iii.ee10087.itube._01_global.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iii.ee10087.itube._02_register.model.MemberBean;
import org.iii.ee10087.itube._05_videoManage.model.VideoBean;

/**
 * Servlet implementation class RetrieveImageServlet
 */
@WebServlet("/_01_global/getImage")
public class RetrieveImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OutputStream os = null;
		InputStream is = null;
		String fileName = null;
		
		try{
			String account = request.getParameter("account");
			
			String videoSeqNotmp = request.getParameter("videoSeqNo");
			
			String type = request.getParameter("type");
			
			GetImageDAO getImageDAO = new GetImageImpl();
			
			if(type.equalsIgnoreCase("MEMBER")){
				MemberBean mb = getImageDAO.getMemberImage(account);
				is = mb.getMemberImage().getBinaryStream();
				fileName = mb.getFileName();
			}else if (type.equalsIgnoreCase("VIDEO")) {
				Long videoSeqNo = 0L;
				try {
					videoSeqNo = Long.parseLong(videoSeqNotmp);
				} catch(NumberFormatException ex) {
					;
				}
				VideoBean vBean = getImageDAO.getVideoImage(videoSeqNo);
				is = vBean.getVideoImage().getBinaryStream();
				fileName = vBean.getVideoImageFileName();
			}
			
			String mimeType = getServletContext().getMimeType(fileName);
			response.setContentType(mimeType);
			os = response.getOutputStream();
			if(is == null){
				is = getServletContext().getResourceAsStream("/images/boyCannotFound.jpg");
			}
			int len = 0;
			byte[] bytes = new byte[8192];
			while((len = is.read(bytes)) != -1){
				os.write(bytes, 0, len);
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}



}
