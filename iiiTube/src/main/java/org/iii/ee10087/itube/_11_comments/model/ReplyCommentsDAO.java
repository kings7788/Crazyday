package org.iii.ee10087.itube._11_comments.model;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;

public interface ReplyCommentsDAO {
	public int saveReplyComments(ReplyCommentsBean rcb) throws SQLException;
	
	public ReplyCommentsBean getLastReplyComments(ReplyCommentsBean rcb) throws SQLException;
	
	public LinkedList<HashMap<String,String>> getAllReplyComments(Long commentSeqNo) throws SQLException;
}
