package org.iii.ee10087.itube._01_global.util;

import org.iii.ee10087.itube._02_register.model.MemberBean;
import org.iii.ee10087.itube._05_videoManage.model.VideoBean;

public interface GetImageDAO {
	public MemberBean getMemberImage(String account);
	
	public VideoBean getVideoImage(Long videoSeqNo);
}
