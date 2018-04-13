package org.iii.ee10087.itube._05_videoManage.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Timestamp;
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

@MultipartConfig(location = "", 
fileSizeThreshold = 5*1024 * 1024, 
maxFileSize = 1024 * 1024 * 500, 
maxRequestSize = 1024 * 1024 * 500 * 5)


@WebServlet("/_05_videoManage/insertVideo.do")
public class InsertVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Map<String, String> errorMsgs = new HashMap<String, String>();
		Map<String, String> successMsgs = new HashMap<String, String>();
		HttpSession session = request.getSession();
		request.setAttribute("ErrorMsgKey", errorMsgs);
		session.setAttribute("successMsgKey", successMsgs);

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

		if (parts != null) {
			for (Part p : parts) {
				String fldName = p.getName();
				String value = request.getParameter(fldName);

				if (p.getContentType() == null) {
					if (fldName.equals("videoTitleInsert")) {
						videoTitle = value;
					} else if (fldName.equals("videoUploaderAccountInsert")) {
						videoUploaderAccount = value;
					} else if (fldName.equals("videoFileInsert")) {
						videoFile = value;
					} else if (fldName.equals("videoDescriptionInsert")) {
						videoDescription = value;
					} else if (fldName.equals("videoTypeInsert")) {
						videoType = value;
					} else if (fldName.equals("videoImageFileNameInsert")) {
						videoImageFileName = value;
					}
				} else {
					videoImageFileName = GlobalService.getFileName(p);
					videoImageFileName = GlobalService.adjustFileName(videoImageFileName,
							GlobalService.IMAGE_FILENAME_LENGTH);
					if (videoImageFileName != null && videoImageFileName.trim().length() > 0) {
						sizeInBytes = p.getSize();
						is = p.getInputStream();
					} else {
						errorMsgs.put("VideoImageEmptyError", "必須挑選圖片");

					}
				}
			}
			if (videoTitle == null || videoTitle.trim().length() == 0) {
				errorMsgs.put("VideoTitleEmptyError", "影片標題欄必須輸入");
			}

			// -----------

			if (videoFile == null || videoFile.trim().length() == 0) {
				errorMsgs.put("VideoFileEmptyError", "youtube內嵌碼欄必須輸入");
			} else {
				String[] arr1 = videoFile.split("\"");
				for (String data : arr1) {
					System.out.println(data);
				}
				for (String data : arr1) {
					String trimString = data.trim();
					if (trimString.length() >= 24) {
						String subStringData = trimString.substring(0, 24);
						if (subStringData.equals("https://www.youtube.com/")) {
							videoFile = data;
							break;
						}
					}
				}

			}

			// -----------
			if (videoDescription == null || videoDescription.trim().length() == 0) {
				errorMsgs.put("VideoDescriptionEmptyError", "影片描述欄必須輸入");
			}
			if (videoType == null || videoType.trim().length() == 0) {
				errorMsgs.put("VideoTypeEmptyError", "影片種類欄必須輸入");
			}

		} else {
			errorMsgs.put("Exception", "此表單不是上傳檔案的表單");
		}
		if (!errorMsgs.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("insertVideo.jsp");
			rd.forward(request, response);
			return;
		}

		try {
			VideoDAO vao = new VideoDAOImpl();
			if (vao.videoExists(videoFile)) {
				errorMsgs.put("errorVideoDup", "此影片已存在");
			} else {
				Timestamp ts = new java.sql.Timestamp(System.currentTimeMillis());
				Blob blob = SystemUtils.fileToBlob(is, sizeInBytes);
				VideoService vs = new VideoServiceImpl();
				videoType = vs.transferVideoType(videoType);
				VideoBean mem = new VideoBean(0L, videoTitle, videoUploaderAccount, videoFile, videoDescription,
						videoType, "", ts, 0L, 0L, 0L, "1", blob, videoImageFileName);

				int n = vao.saveVideo(mem);
				
				if (n == 1) {
					successMsgs.put("success", "<Font color='red'>新增成功</Font>");
					PrintWriter out = response.getWriter();
					out.write("新增成功!");
//					response.sendRedirect(response.encodeRedirectURL("insertVideo.jsp"));
					return;
				}
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher rd = request.getRequestDispatcher("insertVideo.jsp");
				rd.forward(request, response);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
			errorMsgs.put("Exception", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("insertVideo.jsp");
			rd.forward(request, response);
			return;
		}

	}

}
