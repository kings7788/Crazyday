package org.iii.ee10087.itube._01_global.util;

import org.iii.ee10087.itube._02_register.model.MemberBean;
import org.iii.ee10087.itube._02_register.model.MemberDAO;
import org.iii.ee10087.itube._02_register.model.MemberDAOIMP;
import org.iii.ee10087.itube._05_videoManage.model.VideoBean;
import org.iii.ee10087.itube._05_videoManage.model.VideoDAO;
import org.iii.ee10087.itube._05_videoManage.model.VideoDAOImpl;

public class GetImageImpl implements GetImageDAO{

	public GetImageImpl(){
		
	}
	
	
	@Override
	public MemberBean getMemberImage(String account) {
		MemberBean mb = null;
		try{
			MemberDAO dao = new MemberDAOIMP();
			mb = dao.queryMember(account);
		}catch(Exception e){
			e.printStackTrace();
		}
		return mb;
	}
	
	@Override
	public VideoBean getVideoImage(Long videoSeqNo) {
		VideoBean vb = null;
		try{
			VideoDAO vao = new VideoDAOImpl();
			vb = vao.queryVideo(videoSeqNo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return vb;
	}

}
