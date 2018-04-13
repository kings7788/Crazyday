package org.iii.ee10087.itube.memberRegister.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
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

import org.iii.ee10087.itube.HibernateSessionFactory.HibernateUtil;
import org.iii.ee10087.itube.memberRegister.bean.MemberBean;
import org.iii.ee10087.itube.memberRegister.dao.MemberDAO;
import org.iii.ee10087.itube.memberRegister.dao.MemberDAOHibernate;

import util.GlobalService;
import util.SystemUtils;

@MultipartConfig(location = "", 
fileSizeThreshold = 5*1024 * 1024, 
maxFileSize = 1024 * 1024 * 500, 
maxRequestSize = 1024 * 1024 * 500 * 5)


@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
    } 

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Map<String, String> errorMessage = new HashMap<>();
		String target = (String) session.getAttribute("target");
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("errorMessage", errorMessage);
		
		Collection<Part> parts = request.getParts();
		
		String fileName = "";
		long sizeInBytes = 0;
		InputStream is = null;
		
		String account = request.getParameter("mAcc");
		if(account == null || account.trim().length()==0){
			errorMessage.put("account", "帳號欄必須輸入");
		}
		
		String password = request.getParameter("mPwd");
		if(password == null || password.trim().length()==0){
			errorMessage.put("password", "密碼欄必須輸入");
		}
		
		String name = request.getParameter("mName");
		if(name == null || name.trim().length()==0){
			errorMessage.put("name", "姓名欄必須輸入");
		}
		
		String email = request.getParameter("mEmail");
		if(email == null || email.trim().length()==0){
			errorMessage.put("email", "電子信箱必須輸入");
		}
		
		String phone = request.getParameter("mPhone");
		
		String address = request.getParameter("mAddr");
		if(address == null || address.trim().length()==0){
			errorMessage.put("address", "地址必須輸入");
		}
		
		for (Part p : parts) {
			String fldName = p.getName();
			String value = request.getParameter(fldName);
			if (p.getContentType() != null) {

				// 取出圖片檔的檔名
				fileName = GlobalService.getFileName(p);
				// 調整圖片檔檔名的長度，需要檔名中的附檔名，所以調整主檔名以免檔名太長無法寫入表格
				fileName = GlobalService.adjustFileName(fileName, GlobalService.IMAGE_FILENAME_LENGTH);
				if (fileName != null && fileName.trim().length() > 0) {
					sizeInBytes = p.getSize();
					is = p.getInputStream();
				} else {
					errorMessage.put("errPicture", "必須挑選圖片檔");
				}
				
			}
		}
		
		Blob photo = null;
		
		if(is!=null) {
		try {
			photo = SystemUtils.fileToBlob(is, sizeInBytes);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
		java.sql.Date registerdate = new java.sql.Date(System.currentTimeMillis());
		java.sql.Date lastlogin = new java.sql.Date(System.currentTimeMillis());
		
		if(!errorMessage.isEmpty()){				//錯誤Map內有錯誤訊息，退回註冊頁面並顯示錯誤訊息
			RequestDispatcher rd = request.getRequestDispatcher(target);
			rd.forward(request, response);
			
			return;
		}
		
		MemberBean mb = new MemberBean(account, password, name, email, phone, address, photo, registerdate, lastlogin ,false);
		try{
			MemberDAO mfio = new MemberDAOHibernate(HibernateUtil.getSessionFactory());
			mfio.insert(mb);
			session.setAttribute("memberBean", mb);
			String contextPath = getServletContext().getContextPath();
			 response.sendRedirect(response.encodeRedirectURL(contextPath + target));
				return;
			} catch (SQLException e) {
				if (e.getMessage().indexOf("重複的索引鍵") != -1 || 
					e.getMessage().indexOf("Duplicate entry") != -1) {
					errorMessage.put("acc","帳號重複，請重新輸入帳號");
				} else {
					errorMessage.put("exception","資料庫存取錯誤:" + e.getMessage());
				}
				RequestDispatcher rd = request.getRequestDispatcher(target);
				rd.forward(request, response);
				return;
			} 
		}
		
	}

