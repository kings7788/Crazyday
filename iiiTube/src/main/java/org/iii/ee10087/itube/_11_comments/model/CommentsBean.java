package org.iii.ee10087.itube._11_comments.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class CommentsBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long seqNo;
	private String userAccount;
	private Long videoSeqNo;
	private String comments;
	private Timestamp commentDate;
	private Long commentLike;
	private Long commentUnLike;
	public CommentsBean(Long seqNo, String userAccount, Long videoSeqNo, String comments, Timestamp commentDate,
			Long commentLike, Long commentUnLike) {
		super();
		this.seqNo = seqNo;
		this.userAccount = userAccount;
		this.videoSeqNo = videoSeqNo;
		this.comments = comments;
		this.commentDate = commentDate;
		this.commentLike = commentLike;
		this.commentUnLike = commentUnLike;
	}
	public CommentsBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(Long seqNo) {
		this.seqNo = seqNo;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public Long getVideoSeqNo() {
		return videoSeqNo;
	}
	public void setVideoSeqNo(Long videoSeqNo) {
		this.videoSeqNo = videoSeqNo;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Timestamp getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Timestamp commentDate) {
		this.commentDate = commentDate;
	}
	public Long getCommentLike() {
		return commentLike;
	}
	public void setCommentLike(Long commentLike) {
		this.commentLike = commentLike;
	}
	public Long getCommentUnLike() {
		return commentUnLike;
	}
	public void setCommentUnLike(Long commentUnLike) {
		this.commentUnLike = commentUnLike;
	}
	@Override
	public String toString() {
		return "CommentsBean [seqNo=" + seqNo + ", userAccount=" + userAccount + ", videoSeqNo=" + videoSeqNo
				+ ", comments=" + comments + ", commentDate=" + commentDate + ", commentLike=" + commentLike
				+ ", commentUnLike=" + commentUnLike + "]";
	}
	
	
	
}
