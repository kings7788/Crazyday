package org.iii.ee10087.itube._14_videoType.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.iii.ee10087.itube._01_global.util.GlobalService;


public class VideoTypeDAOImpl implements Serializable, VideoTypeDAO{

	private static final long serialVersionUID = 1L;
	DataSource ds = null;
	
	public VideoTypeDAOImpl(){
		try{
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup(GlobalService.JNDI_DB_NAME);
		}catch(Exception e){
			throw new RuntimeException(e.getMessage());
		}
	}
	
	@Override
	public List<VideoTypeBean> getVideoAllTypes() {
		List<VideoTypeBean> list = new ArrayList<VideoTypeBean>();
		String sql = "select seqNo , videoType, score from videoTypes order by score";
		
		
		try(Connection connection = ds.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
				){
			
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()){
					VideoTypeBean vb = new VideoTypeBean();
					vb.setSeqNo(rs.getLong("seqNo"));
					vb.setVideoType(rs.getString("videoType"));
					
					list.add(vb);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

}
