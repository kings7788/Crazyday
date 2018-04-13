package org.iii.ee10087.itube._11_comments.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class ReplyCommentsBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long seqNo;
	private String replyCommentsUserAccount;
	private Long commentSeqNo;
	private String replyComments;
	private Timestamp replyCommentsDate;
	private Long replyCommentLike;
	private Long replyCommentUnLike;
	
	public ReplyCommentsBean() {
		super();
	}
	public ReplyCommentsBean(Long seqNo, String replyCommentsUserAccount, Long commentSeqNo, String replyComments,
			Timestamp replyCommentsDate, Long replyCommentLike, Long replyCommentUnLike) {
		super();
		this.seqNo = seqNo;
		this.replyCommentsUserAccount = replyCommentsUserAccount;
		this.commentSeqNo = commentSeqNo;
		this.replyComments = replyComments;
		this.replyCommentsDate = replyCommentsDate;
		this.replyCommentLike = replyCommentLike;
		this.replyCommentUnLike = replyCommentUnLike;
	}
	public Long getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(Long seqNo) {
		this.seqNo = seqNo;
	}
	public String getReplyCommentsUserAccount() {
		return replyCommentsUserAccount;
	}
	public void setReplyCommentsUserAccount(String replyCommentsUserAccount) {
		this.replyCommentsUserAccount = replyCommentsUserAccount;
	}
	public Long getCommentSeqNo() {
		return commentSeqNo;
	}
	public void setCommentSeqNo(Long commentSeqNo) {
		this.commentSeqNo = commentSeqNo;
	}
	public String getReplyComments() {
		return replyComments;
	}
	public void setReplyComments(String replyComments) {
		this.replyComments = replyComments;
	}
	public Timestamp getReplyCommentsDate() {
		return replyCommentsDate;
	}
	public void setReplyCommentsDate(Timestamp replyCommentsDate) {
		this.replyCommentsDate = replyCommentsDate;
	}
	public Long getReplyCommentLike() {
		return replyCommentLike;
	}
	public void setReplyCommentLike(Long replyCommentLike) {
		this.replyCommentLike = replyCommentLike;
	}
	public Long getReplyCommentUnLike() {
		return replyCommentUnLike;
	}
	public void setReplyCommentUnLike(Long replyCommentUnLike) {
		this.replyCommentUnLike = replyCommentUnLike;
	}
	@Override
	public String toString() {
		return "ReplyCommentsBean [seqNo=" + seqNo + ", replyCommentsUserAccount=" + replyCommentsUserAccount
				+ ", commentSeqNo=" + commentSeqNo + ", replyComments=" + replyComments + ", replyCommentsDate="
				+ replyCommentsDate + ", replyCommentLike=" + replyCommentLike + ", replyCommentUnLike="
				+ replyCommentUnLike + "]";
	}
	
	
}
