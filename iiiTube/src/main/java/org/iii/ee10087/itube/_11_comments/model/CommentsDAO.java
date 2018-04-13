package org.iii.ee10087.itube._11_comments.model;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;

public interface CommentsDAO {
	public int saveComments(CommentsBean cb) throws SQLException;
	
	public CommentsBean getLastComments(CommentsBean cb) throws SQLException;
	
	public LinkedList<HashMap<String,String>> getAllComments(Long videoSeqNo) throws SQLException;
}
