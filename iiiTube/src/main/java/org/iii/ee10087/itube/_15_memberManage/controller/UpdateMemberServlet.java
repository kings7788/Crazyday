package org.iii.ee10087.itube._15_memberManage.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import org.iii.ee10087.itube._02_register.model.MemberBean;
import org.iii.ee10087.itube._02_register.model.MemberDAO;
import org.iii.ee10087.itube._02_register.model.MemberDAOIMP;

/**
 * Servlet implementation class RegisterServlet
 */
@MultipartConfig(location = "", fileSizeThreshold = 5 * 1024 * 1024, maxFileSize = 1024 * 1024
		* 500, maxRequestSize = 1024 * 1024 * 500 * 5)

@WebServlet("/_02_register/updateMember.do")
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Map<String, String> errorMsg = new HashMap<String, String>();
		Map<String, String> msgOK = new HashMap<String, String>();
		HttpSession session = request.getSession();
		request.setAttribute("MsgMap", errorMsg);
		session.setAttribute("MsgOK", msgOK);
		String account = "";
		String password = "";
		String checkpassword = "";
		String nickname = "";
		String firstname = "";
		String lastname = "";
		String cellphone = "";
		String address = "";
		String email = "";
		String birthday = "";
		String gender = "";
		String fileName = "";
		long sizeInBytes = 0;
		InputStream is = null;

		boolean pictureFlag = false;
		
		Collection<Part> parts = request.getParts();
		GlobalService.exploreParts(parts, request);
		MemberBean mb = new MemberBean();
		MemberDAO mo = new MemberDAOIMP();
		if (parts != null) {
			for (Part p : parts) {
				String fldName = p.getName();
				String value = request.getParameter(fldName);

				if (p.getContentType() == null) {
					if (fldName.equals("account")) {
						account = value;
					} else if (fldName.equals("nickname")) {
						nickname = value;
					} else if (fldName.equals("firstname")) {
						firstname = value;
					} else if (fldName.equals("lastname")) {
						lastname = value;
					} else if (fldName.equals("cellphone")) {
						cellphone = value;
					} else if (fldName.equals("address")) {
						address = value;
					} else if (fldName.equals("email")) {
						email = value;
					} else if (fldName.equals("birthday")) {
						birthday = value;
					} else if (fldName.equals("gender")) {
						gender = value;
					} else if (fldName.equals("fileName")) {
						fileName = value;
					}
				} else {
					fileName = GlobalService.getFileName(p);
					fileName = GlobalService.adjustFileName(fileName, GlobalService.IMAGE_FILENAME_LENGTH);
					if (fileName != null && fileName.trim().length() > 0) {
						sizeInBytes = p.getSize();
						is = p.getInputStream();
					} else {
						pictureFlag = true;

					}
				}
			}
			
			
			mb = mo.queryMember(account);

			if (nickname != null && nickname.trim().length() != 0) {
				mb.setNickname(nickname);

			}
			if (firstname != null && firstname.trim().length() != 0) {
				mb.setFirstname(firstname);
			}
			if (lastname != null && lastname.trim().length() != 0) {
				mb.setLastname(lastname);
			}
			if (cellphone != null && cellphone.trim().length() != 0) {
				mb.setCellphone(cellphone);
			}
			if (address != null && address.trim().length() != 0) {
				mb.setAddress(address);
			}
			if (email != null && email.trim().length() != 0) {
				mb.setEmail(email);
			}
			if (birthday != null && birthday.trim().length() != 0) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date parsedDate = null;
				try {
					parsedDate = dateFormat.parse(birthday);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Timestamp birthdaytemp = new java.sql.Timestamp(parsedDate.getTime());
				mb.setBirthday(birthdaytemp);
			}

			if (gender != null && gender.trim().length() != 0) {
				mb.setGender(gender);
			}

		} else {
			errorMsg.put("errorTitle", "此表單不是上傳檔案的表單");
		}

		if (!errorMsg.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("updateMember.jsp");
			rd.forward(request, response);
			return;
		}
		try {
			if(pictureFlag){
				Timestamp ts = new java.sql.Timestamp(System.currentTimeMillis());
				Blob blob = SystemUtils.fileToBlob(is, sizeInBytes);
				mb.setMemberImage(blob);
			}
			

			
			int n = mo.updateMember(mb);
			session.setAttribute("LoginOK", mb);
			if (n == 1) {
				msgOK.put("UpdateOK", "資料變更成功");
				response.sendRedirect("updateMember.jsp");
			}
			
			if (!errorMsg.isEmpty()) {
				RequestDispatcher rd = request.getRequestDispatcher("updateMember.jsp");
				rd.forward(request, response);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
			errorMsg.put("errorAccountDup", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("updateMember.jsp");
			rd.forward(request, response);
		}
	}

}
