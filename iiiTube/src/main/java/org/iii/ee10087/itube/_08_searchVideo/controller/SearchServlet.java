package org.iii.ee10087.itube._08_searchVideo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iii.ee10087.itube._05_videoManage.model.VideoBean;
import org.iii.ee10087.itube._08_searchVideo.model.SearchDAO;
import org.iii.ee10087.itube._08_searchVideo.model.SearchDAOImpl;

/**
 * Servlet implementation class searchServler
 */
@WebServlet("/_08_searchVideo/search.do")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String searchinputtmp = request.getParameter("searchinput");
		HttpSession session = request.getSession();
		SearchDAO sdao = new SearchDAOImpl();
		String searchinput = null;
		
		searchinputtmp = searchinputtmp.replaceAll("\\s+", " ");
		String[] searchArray = searchinputtmp.split(" ");
		String videoUploaderAccountqueryWordslike = "";
		for(int i = 0; i < searchArray.length; i ++){
			if(i == 0){
				videoUploaderAccountqueryWordslike = videoUploaderAccountqueryWordslike + " videoUploaderAccount like " + " '%" + searchArray[i] + "%' ";
			}else{
				videoUploaderAccountqueryWordslike = videoUploaderAccountqueryWordslike + " or videoUploaderAccount like " + " '%" + searchArray[i] + "%' ";
			}
			
		}
		
		String videoUploaderAccountqueryWordsnotlike = "";
		for(int i = 0; i < searchArray.length; i ++){
			if(i == 0){
				videoUploaderAccountqueryWordsnotlike = videoUploaderAccountqueryWordsnotlike + " videoUploaderAccount not like " + " '%" + searchArray[i] + "%' ";
			}else{
				videoUploaderAccountqueryWordsnotlike = videoUploaderAccountqueryWordsnotlike + " or videoUploaderAccount not like " + " '%" + searchArray[i] + "%' ";
			}
			
		}
		
		String videoTitlequeryWordslike = "";
		for(int i = 0; i < searchArray.length; i ++){
			if(i == 0){
				videoTitlequeryWordslike = videoTitlequeryWordslike + " videoTitle like " + " '%" + searchArray[i] + "%' ";
			}else{
				videoTitlequeryWordslike = videoTitlequeryWordslike + " or videoTitle like " + " '%" + searchArray[i] + "%' ";
			}
			
		}
		
		String videoTitlequeryWordsnotlike = "";
		for(int i = 0; i < searchArray.length; i ++){
			if(i == 0){
				videoTitlequeryWordsnotlike = videoTitlequeryWordsnotlike + " videoTitle not like " + " '%" + searchArray[i] + "%' ";
			}else{
				videoTitlequeryWordsnotlike = videoTitlequeryWordsnotlike + " or videoTitle not like " + " '%" + searchArray[i] + "%' ";
			}
			
		}
		
		String videoDescriptionqueryWordslike = "";
		for(int i = 0; i < searchArray.length; i ++){
			if(i == 0){
				videoDescriptionqueryWordslike = videoDescriptionqueryWordslike + " videoDescription like " + " '%" + searchArray[i] + "%' ";
			}else{
				videoDescriptionqueryWordslike = videoDescriptionqueryWordslike + " or videoDescription like " + " '%" + searchArray[i] + "%' ";
			}
			
		}
		
		String videoDescriptionqueryWordsnotlike = "";
		for(int i = 0; i < searchArray.length; i ++){
			if(i == 0){
				videoDescriptionqueryWordsnotlike = videoDescriptionqueryWordsnotlike + " videoDescription not like " + " '%" + searchArray[i] + "%' ";
			}else{
				videoDescriptionqueryWordsnotlike = videoDescriptionqueryWordsnotlike + " or videoDescription not like " + " '%" + searchArray[i] + "%' ";
			}
			
		}
		
		String videoTypequeryWordslike = "";
		for(int i = 0; i < searchArray.length; i ++){
			if(i == 0){
				videoTypequeryWordslike = videoTypequeryWordslike + " videoType like " + " '%" + searchArray[i] + "%' ";
			}else{
				videoTypequeryWordslike = videoTypequeryWordslike + " or videoType like " + " '%" + searchArray[i] + "%' ";
			}
			
		}
		
		String videoTypequeryWordsnotlike = "";
		for(int i = 0; i < searchArray.length; i ++){
			if(i == 0){
				videoTypequeryWordsnotlike = videoTypequeryWordsnotlike + " videoType not like " + " '%" + searchArray[i] + "%' ";
			}else{
				videoTypequeryWordsnotlike = videoTypequeryWordsnotlike + " or videoType not like " + " '%" + searchArray[i] + "%' ";
			}
			
		}
		
		String videoUploadDatequeryWordslike = "";
		for(int i = 0; i < searchArray.length; i ++){
			if(i == 0){
				videoUploadDatequeryWordslike = videoUploadDatequeryWordslike + " videoUploadDate like " + " '%" + searchArray[i] + "%' ";
			}else{
				videoUploadDatequeryWordslike = videoUploadDatequeryWordslike + " or videoUploadDate like " + " '%" + searchArray[i] + "%' ";
			}
			
		}
		
		String videoUploadDatequeryWordsnotlike = "";
		for(int i = 0; i < searchArray.length; i ++){
			if(i == 0){
				videoUploadDatequeryWordsnotlike = videoUploadDatequeryWordsnotlike + " videoUploadDate not like " + " '%" + searchArray[i] + "%' ";
			}else{
				videoUploadDatequeryWordsnotlike = videoUploadDatequeryWordsnotlike + " or videoUploadDate not like " + " '%" + searchArray[i] + "%' ";
			}
			
		}
		
		try {
			List<VideoBean> lvb1 = sdao.queryAllVideosByUploader(videoUploaderAccountqueryWordslike);
			session.setAttribute("searchResult1", lvb1);
			
			List<VideoBean> lvb2 = sdao.queryAllVideosByTitle(videoTitlequeryWordslike , videoUploaderAccountqueryWordslike);
			session.setAttribute("searchResult2", lvb2);
			
			List<VideoBean> lvb3 = sdao.queryAllVideosByDescription(videoDescriptionqueryWordslike, 
					videoUploaderAccountqueryWordslike, videoTitlequeryWordslike);
			session.setAttribute("searchResult3", lvb3);
			
			List<VideoBean> lvb4 = sdao.queryAllVideosByVideoType(videoTypequeryWordslike, videoUploaderAccountqueryWordslike,
					videoTitlequeryWordslike, videoDescriptionqueryWordslike);
			session.setAttribute("searchResult4", lvb4);
			
			List<VideoBean> lvb5 = sdao.queryAllVideosByVideoUploadDate(videoUploadDatequeryWordslike, 
					videoUploaderAccountqueryWordslike, videoTitlequeryWordslike, videoDescriptionqueryWordslike, videoTypequeryWordslike);
			session.setAttribute("searchResult5", lvb5);
			
			
			response.sendRedirect("../_08_searchVideo/search.jsp");
			return;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
