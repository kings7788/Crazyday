package org.iii.ee10087.itube._02_register.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Timestamp;
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
@MultipartConfig(location = "", 
fileSizeThreshold = 5*1024 * 1024, 
maxFileSize = 1024 * 1024 * 500, 
maxRequestSize = 1024 * 1024 * 500 * 5)


@WebServlet("/_02_register/registerMember.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		Collection<Part> parts = request.getParts();
		GlobalService.exploreParts(parts, request);
		
		if(parts != null){
			for(Part p : parts){
				String fldName = p.getName();
				String value = request.getParameter(fldName);
				
				if(p.getContentType() == null){
					if(fldName.equals("account")){
						account = value;
					}else if(fldName.equals("password")){
						password = value;
					}else if(fldName.equals("checkpassword")){
						checkpassword = value;
					}else if(fldName.equals("nickname")){
						nickname = value;
					}else if(fldName.equals("firstname")){
						firstname = value;
					}else if(fldName.equals("lastname")){
						lastname = value;
					}else if(fldName.equals("cellphone")){
						cellphone = value;
					}else if(fldName.equals("address")){
						address = value;
					}else if(fldName.equals("email")){
						email = value;
					}else if(fldName.equals("birthday")){
						birthday = value;
					}else if(fldName.equals("gender")){
						gender = value;
					}else if(fldName.equals("fileName")){
						fileName = value;
					}
				}else{
					fileName = GlobalService.getFileName(p);
					fileName = GlobalService.adjustFileName(fileName, GlobalService.IMAGE_FILENAME_LENGTH);
					if(fileName != null && fileName.trim().length() > 0){
						sizeInBytes = p.getSize();
						is = p.getInputStream();
					}else{
						errorMsg.put("errPicture","必須挑選圖片");
						
					}
				}
			}
			if(account == null || account.trim().length() == 0){
				errorMsg.put("errorAccountEmpty", "帳號必須輸入");
			}
			if(password == null || password.trim().length() == 0){
				errorMsg.put("errorPasswordEmpty", "密碼欄必須輸入");
			}
			if(checkpassword == null || checkpassword.trim().length() == 0){
				errorMsg.put("errorCheckpasswordEmpty", "密碼確認欄必須輸入");
			}
			
			
			if (password.trim().length() > 0 && checkpassword.trim().length() > 0){
				if (!password.trim().equals(checkpassword.trim())){
					errorMsg.put("errorCheckpasswordEmpty","密碼欄必須與確認欄一致");
					errorMsg.put("errorPasswordEmpty","*");
				}			
			}
			
			if(nickname == null || nickname.trim().length() == 0){
				errorMsg.put("errorNicknameEmpty", "暱稱欄必須輸入");
			}
			if(firstname == null || firstname.trim().length() == 0){
				errorMsg.put("errorFirstnameEmpty", "名字欄必須輸入");
			}
			if(lastname == null || lastname.trim().length() == 0){
				errorMsg.put("errorLastnameEmpty", "姓氏欄必須輸入");
			}
			if(cellphone == null || cellphone.trim().length() == 0){
				errorMsg.put("errorCellphoneEmpty", "電話欄必須輸入");
			}
			if(address == null || address.trim().length() == 0){
				errorMsg.put("errorAddressEmpty", "地址欄必須輸入");
			}
			if(email == null || email.trim().length() == 0){
				errorMsg.put("errorEmailEmpty", "電子信箱欄必須輸入");
			}
			if(birthday == null || birthday.trim().length() == 0){
				errorMsg.put("errorBirthdayEmpty", "生日欄必須輸入");
			}
			
			
			if(gender == null || gender.trim().length() == 0){
				errorMsg.put("errorGenderEmpty", "性別必須輸入");
			}
			
			
			
			
			
		}else{
			errorMsg.put("errorTitle", "此表單不是上傳檔案的表單");
		}
		
		if(!errorMsg.isEmpty()){
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			rd.forward(request, response);
			return;
		}
		try{
			MemberDAO dao = new MemberDAOIMP();
			if(dao.accountExists(account)){
				errorMsg.put("errorAccountDup", "此帳號已存在，請換新帳號");
			}else{
				Timestamp ts = new java.sql.Timestamp(System
						.currentTimeMillis());
				Blob blob = SystemUtils.fileToBlob(is,sizeInBytes);
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date parsedDate = dateFormat.parse(birthday);
				Timestamp birthdaytemp = new java.sql.Timestamp(parsedDate.getTime());
				MemberBean mem = new MemberBean( null,  account,  password,  nickname,  firstname,
						 lastname,  cellphone,  address,  email,  birthdaytemp,  gender,
						 ts,  blob,  fileName, 0L);
				
				int n = dao.saveMember(mem);
				if(n == 1){
					msgOK.put("InsertOK", "<Font color='red'>新增成功，請開始使用本系統</Font>" );
					response.sendRedirect("../index.jsp");
				}
			}
			if(!errorMsg.isEmpty()){
				RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
				rd.forward(request, response);
				return;
			}
		}catch(Exception e){
			e.printStackTrace();
			errorMsg.put("errorAccountDup", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			rd.forward(request, response);
		}
	}

}
