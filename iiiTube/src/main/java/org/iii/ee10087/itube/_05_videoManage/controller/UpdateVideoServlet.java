package org.iii.ee10087.itube._05_videoManage.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.iii.ee10087.itube._01_global.util.GlobalService;
import org.iii.ee10087.itube._01_global.util.SystemUtils;
import org.iii.ee10087.itube._05_videoManage.model.VideoBean;
import org.iii.ee10087.itube._05_videoManage.model.VideoDAO;
import org.iii.ee10087.itube._05_videoManage.model.VideoDAOImpl;
import org.iii.ee10087.itube._05_videoManage.model.VideoService;
import org.iii.ee10087.itube._05_videoManage.model.VideoServiceImpl;

@MultipartConfig(location = "", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 500, maxRequestSize = 1024
		* 1024 * 500 * 5)

@WebServlet("/_05_videoManage/updateVideo.do")
public class UpdateVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		VideoBean vb = new VideoBean();
		String pageNo = "1";
		Map<String, String> errorMsgs = new HashMap<String, String>();
		Map<String, String> successMsgs = new HashMap<String, String>();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setAttribute("ErrorMsgKey", errorMsgs);
		session.setAttribute("successMsgKey", successMsgs);
		try {
			Long seqNo = 0L;
			String videoTitle = "";
			String videoUploaderAccount = "";
			String videoFile = "";
			String videoDescription = "";
			String videoType = "";
			String videoImageFileName = "";
			long sizeInBytes = 0;
			InputStream is = null;
			
			Collection<Part> parts = request.getParts();
			GlobalService.exploreParts(parts, request);
			
			if (parts != null) {   // 如果這是一個上傳資料的表單				
				for (Part p : parts) {
					String fldName = p.getName();
					String value = request.getParameter(fldName);
					if (p.getContentType() == null) {
						if (fldName.equals("videoTitle")) {
							videoTitle = value;
							vb.setVideoTitle(videoTitle);
							if (value == null || videoTitle.trim().length() == 0) {
								errorMsgs.put("VideoTitleEmptyError", "必須輸入影片標題");
							} else {
								request.setAttribute("videoTitle", videoTitle);
							}
						} else if (fldName.equals("seqNo")) {
							seqNo = Long.parseLong(value);
							vb.setVideoUploaderAccount(videoUploaderAccount);
							request.setAttribute("seqNo", seqNo);
							
						} else if (fldName.equals("videoUploaderAccount")) {
							videoUploaderAccount = value;
							vb.setVideoUploaderAccount(videoUploaderAccount);
							request.setAttribute("videoUploaderAccount", videoUploaderAccount);
							
						} else if (fldName.equals("videoFile")) {
							videoFile = value;
							vb.setVideoFile(videoFile);
							
							request.setAttribute("videoFile", videoFile);
							
						} else if (fldName.equals("videoDescription")) {
							videoDescription = value;
							vb.setVideoDescription(videoDescription);
							if (value == null || videoDescription.trim().length() == 0) {
								errorMsgs.put("VideoDescriptionEmptyError", "必須輸入影片描述");
							} else {
								request.setAttribute("videoDescription", videoDescription);
							}
						} else if (fldName.equals("videoType")) {
//							VideoService vs = new VideoServiceImpl();
//							String videoTypeTmp = vs.transferVideoType(value);
//							videoType = videoTypeTmp;
							videoType = value;
							vb.setVideoType(videoType);
							if (value == null || videoType.trim().length() == 0) {
								errorMsgs.put("VideoTypeEmptyError", "必須輸入影片種類");
							} else {
								request.setAttribute("videoType", videoType);
							}
						}else if (fldName.equals("pageNo")){
							pageNo = value;
						} 

					} else {
						videoImageFileName = getFileName(p); // 此為圖片檔的檔名
						if (videoImageFileName != null && videoImageFileName.trim().length() > 0) {
							sizeInBytes = p.getSize();
							is = p.getInputStream();
						} else {
							sizeInBytes = -1;
						}
					} 
				}
			} else {
				errorMsgs.put("errTitle", "此表單不是上傳檔案的表單");
			}if (!errorMsgs.isEmpty()) {
				   RequestDispatcher rd = request.getRequestDispatcher("BookUpdate.jsp");
				   rd.forward(request, response);
				   return;
				} 
				
				VideoDAO vdao = new VideoDAOImpl();
				
				
				Blob blob = null;
				if (sizeInBytes != -1){
					blob = SystemUtils.fileToBlob(is, sizeInBytes);
				}
				VideoBean newVideoBean = new VideoBean();
				newVideoBean = vdao.queryVideo(seqNo);
				newVideoBean.setVideoTitle(videoTitle);
				newVideoBean.setVideoDescription(videoDescription);
				
				newVideoBean.setVideoType(videoType);
				newVideoBean.setVideoImage(blob);
				newVideoBean.setVideoImageFileName(videoImageFileName);
				vdao.updateVideo(newVideoBean, sizeInBytes); 
				//successMsgs.put("success" , "資料修改成功");
//				RequestDispatcher rd = request.getRequestDispatcher("videoManage.do?pageNo=" + pageNo);
//				rd.forward(request, response);
				PrintWriter out = response.getWriter();
				out.write("修改成功");
				return;
			} catch (Exception e) {
				e.printStackTrace();
				errorMsgs.put("errDBMessage", e.getMessage());
				RequestDispatcher rd = request.getRequestDispatcher("updateVideo.jsp");
				rd.forward(request, response);
			}
		}
		
		
		
		
		
			private String getFileName(final Part part) {
				for (String content : part.getHeader("content-disposition").split(";")) {
					if (content.trim().startsWith("filename")) {
						return content.substring(content.indexOf('=') + 1).trim()
								.replace("\"", "");
					}
				}
				return null;
			}
		
		
		
		
		
		
		
		
		
//		
//		Map<String, String> errorMsgs = new HashMap<String, String>();
//		Map<String, String> successMsgs = new HashMap<String, String>();
//		request.setCharacterEncoding("UTF-8");
//		HttpSession session = request.getSession();
//		session.setAttribute("ErrorMsgKey", errorMsgs);
//		session.setAttribute("successMsgKey", successMsgs);
//		
//		try {
//			String videoTitle = request.getParameter("videoTitle");
//			String seqNotmp = request.getParameter("seqNo");
//			Long seqNo = Long.parseLong(seqNotmp);
//			String videoDescription = request.getParameter("videoDescription");
//			String videoType = request.getParameter("videoType");
//			
//
//			VideoBean vb = new VideoBean();
//			VideoDAO vo = new VideoDAOImpl();
//			vb = vo.queryVideo(seqNo);
//			
//			if (videoTitle == null || videoTitle.trim().length() == 0) {
//			}else{
//				vb.setVideoTitle(videoTitle);
//				request.setAttribute("videoTitle", videoTitle);
//			}
//			
//			if (videoDescription == null || videoDescription.trim().length() == 0) {
//			}else{
//				vb.setVideoDescription(videoDescription);
//				request.setAttribute("videoDescription", videoDescription);
//			}
//			
//			if (videoType == null || videoType.trim().length() == 0) {
//			}else{
//				vb.setVideoType(videoType);
//				request.setAttribute("videoType", videoType);
//			}
//			
//			VideoService vs = new VideoServiceImpl();
//			videoType = vs.transferVideoType(videoType);
//			vb.setVideoType(videoType);
//			if (!errorMsgs.isEmpty()) {
//				RequestDispatcher rd = request.getRequestDispatcher("updateVideo.jsp");
//				rd.forward(request, response);
//				return;
//			}
//			
//			vo.updateVideo(vb);
//			
//			successMsgs.put("success", "資料變更成功");
//			response.sendRedirect(response.encodeRedirectURL("videoManage.do"));
//			return;
//		} catch (Exception e) {
//			e.printStackTrace();
//			errorMsgs.put("Exception", e.getMessage());
//			RequestDispatcher rd = request.getRequestDispatcher("updateVideo.jsp");
//			rd.forward(request, response);
//		}
	}


