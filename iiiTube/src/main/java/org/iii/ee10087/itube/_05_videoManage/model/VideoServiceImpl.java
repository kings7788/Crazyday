package org.iii.ee10087.itube._05_videoManage.model;

public class VideoServiceImpl implements VideoService{

	@Override
	public String transferVideoType(String videoType) {
		switch (videoType) {
			case "song":
				videoType = "音樂";
				break;
	
			case "sport":
				videoType = "運動";
				break;
			case "game":
				videoType = "遊戲";
				break;
			case "news":
				videoType = "新聞";
				break;
			case "liveStream":
				videoType = "直播";
				break;
			case "technology":
				videoType = "科技";
				break;
			case "food":
				videoType = "美食";
				break;
			case "politics":
				videoType = "政治";
				break;
			case "fashion":
				videoType = "時尚";
				break;
			case "movie":
				videoType = "電影";
				break;
			case "other":
				videoType = "其他";
				break;
		}
		return videoType;
	}

}
