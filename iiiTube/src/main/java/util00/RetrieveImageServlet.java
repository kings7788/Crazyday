package util00;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iii.ee10087.itube._16_.FAQ.bean.*;

/**
 * Servlet implementation class RetrieveImageServlet
 */
@WebServlet("/getImageServlet")
public class RetrieveImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OutputStream os = null;
		InputStream is = null;
		String fileName = null;
		// 讀取瀏覽器傳送來的問題代號(memberQuesNum)
		try {
			String id = request.getParameter("id");

			String type = request.getParameter("type");
			// 產生專門讀取圖片的GetImageDao物件
			GetImageDao getImageDao = new GetImageImpl();

			int nId = 0;
			try {
				nId = Integer.parseInt(id);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			MemberQABean mem = new MemberQABean();
			mem.setMemberQuesNum(nId);
			MemberQABean mBean = getImageDao.getQAImage(mem);
			is = mBean.getMemQuespic().getBinaryStream();
			fileName = mBean.getMemFileName();
			// 由圖片檔的檔名來得到檔案的MIME型態
			String mimeType = getServletContext().getMimeType(fileName);
			// 設定輸出資料的型態
			response.setContentType(mimeType);
			// 取得能寫出非文字資料的OutputStream物件
			os = response.getOutputStream();
			// 如果圖片的來源有問題，就送回預設圖片(/images/NoImage.jpg)
			if (is == null) {
				is = getServletContext().getResourceAsStream("/images/NoImage.jpg");
			}
			int len = 0;
			byte[] bytes = new byte[8192];
			while ((len = is.read(bytes)) != -1) {
				os.write(bytes, 0, len);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
