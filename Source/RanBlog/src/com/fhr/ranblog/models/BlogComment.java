package com.fhr.ranblog.models;

import java.sql.Timestamp;

/**
 * Blogcomment entity. @author MyEclipse Persistence Tools
 */

public class BlogComment implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4104346937274053102L;
	
	
	// Fields

	private Long blogCommentId;
	private Integer blogUserId;
	private Integer blogId;
	private String blogComment;
	private Timestamp commentTime;

	// Constructors

	/** default constructor */
	public BlogComment() {
	}

	/** full constructor */
	public BlogComment(Integer blogUserId, Integer blogId, String blogComment, Timestamp commentTime) {
		this.blogUserId = blogUserId;
		this.blogId = blogId;
		this.blogComment = blogComment;
		this.commentTime = commentTime;
	}

	// Property accessors

	public Long getBlogCommentId() {
		return this.blogCommentId;
	}

	public void setBlogCommentId(Long blogCommentId) {
		this.blogCommentId = blogCommentId;
	}

	public Integer getBlogUserId() {
		return this.blogUserId;
	}

	public void setBlogUserId(Integer blogUserId) {
		this.blogUserId = blogUserId;
	}

	public Integer getBlogId() {
		return this.blogId;
	}

	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}

	public String getBlogComment() {
		return this.blogComment;
	}

	public void setBlogComment(String blogComment) {
		this.blogComment = blogComment;
	}

	public Timestamp getCommentTime() {
		return this.commentTime;
	}

	public void setCommentTime(Timestamp commentTime) {
		this.commentTime = commentTime;
	}

}