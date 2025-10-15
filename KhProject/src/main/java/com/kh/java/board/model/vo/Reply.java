package com.kh.java.board.model.vo;

import java.sql.Date;

public class Reply {
	private Long replyNO;
	private String replyContent;
	private Long refBno;
	private String replyWriter;
	private Date createDate;
	private String status;
	
	public Reply() {
		super();
	}
	
	public Reply(Long replyNO, String replyContent, Long refBno, String replyWriter, Date createDate, String status) {
		super();
		this.replyNO = replyNO;
		this.replyContent = replyContent;
		this.refBno = refBno;
		this.replyWriter = replyWriter;
		this.createDate = createDate;
		this.status = status;
	}
	
	public Long getReplyNO() {
		return replyNO;
	}
	public void setReplyNO(Long replyNO) {
		this.replyNO = replyNO;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public Long getRefBno() {
		return refBno;
	}
	public void setRefBno(Long refBno) {
		this.refBno = refBno;
	}
	public String getReplyWriter() {
		return replyWriter;
	}
	public void setReplyWriter(String replyWriter) {
		this.replyWriter = replyWriter;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Reply [replyNO=" + replyNO + ", replyContent=" + replyContent + ", refBno=" + refBno + ", replyWriter="
				+ replyWriter + ", createDate=" + createDate + ", status=" + status + "]";
	}
	
	
}
