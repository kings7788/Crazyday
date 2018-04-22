package org.iii.ee10087.itube._19_.videoManage.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.iii.ee10087.itube._19_.VideoType.model.VideoTypeService;
import org.iii.ee10087.itube._19_.videoManage.model.VideoBean;
import org.iii.ee10087.itube._19_.videoManage.model.VideoManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class VideoManageController {

	@Autowired
	private VideoManageService videoManageService;
	@Autowired
	private VideoTypeService videoTypeService;
	// @RequestMapping("videoManage")
	// public String videoManageHomePage() {
	// return "videoManage/videoManage";
	// }

	@RequestMapping(value = "/videos/{account}", method = RequestMethod.GET)
	public String getAddNewVideoForm(Model model) {

		VideoBean vb = new VideoBean();
		model.addAttribute("VideoBean", vb);
		return "videoManage/videoManage";

	}

	// 新增圖片
	@RequestMapping(value = "/videos/add", method = RequestMethod.POST)
	public @ResponseBody String processAddNewVideoForm(@ModelAttribute("VideoBean") VideoBean vb, BindingResult result,
			HttpServletRequest request) {
		String[] suppressedFields = result.getSuppressedFields();
		if (vb.getAccount().equals("")) {
			vb.setAccount("bob");
		}
		if (suppressedFields.length > 0) {
			System.out.println("嘗試輸入不允許的欄位");
			throw new RuntimeException("嘗試輸入不允許的欄位: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}

		// 取出影片封面圖片檔名
		MultipartFile videoImage = vb.getVideoImage();
		String originalImageName = videoImage.getOriginalFilename();
		vb.setVideoImageFileName(originalImageName);
		// 取出影片檔名
		MultipartFile videoFile = vb.getVideoFile();
		String originalFileName = videoFile.getOriginalFilename();
		vb.setVideoFileName(originalFileName);
		// 取出影片封面圖片副檔名
		String extImage = originalImageName.substring(originalImageName.lastIndexOf("."));
		// 取出影片副檔名
		String extVideo = originalFileName.substring(originalFileName.lastIndexOf("."));

		// 影片資料寫入資料庫
		try {
			vb = videoManageService.insertVideo(vb, extImage, extVideo, videoImage, videoFile);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return "ok";

	}

	@ModelAttribute("videoTypeList")
	public List<String> getVideoType() {
		List<String> videoTypeList = null;
		try {
			videoTypeList = videoTypeService.getAllVideoType();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return videoTypeList;
	}

	@ModelAttribute("userVideoList")
	public List<VideoBean> getUserVideos(@PathVariable("account") String account) {
		List<VideoBean> videoBeanList = null;

		 videoBeanList = videoManageService.getUserVideos(account);

		return videoBeanList;
	}
}
