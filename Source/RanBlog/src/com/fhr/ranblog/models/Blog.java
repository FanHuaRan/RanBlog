package com.fhr.ranblog.models;

import java.sql.Timestamp;

/**
 * Blog entity. @author MyEclipse Persistence Tools
 */

public class Blog implements java.io.Serializable {

	// Fields

	private Integer blogId;
	private Short blogTypeId;
	private String title;
	private String digest;
	private String content;
	private Timestamp publishTime;
	private Long pageView;
	private Long commentCount;
	private String keywords;

	// Constructors

	/** default constructor */
	public Blog() {
	}

	/** full constructor */
	public Blog(Short blogTypeId, String title, String digest, String content, Timestamp publishTime, Long pageView,
			Long commentCount, String keywords) {
		this.blogTypeId = blogTypeId;
		this.title = title;
		this.digest = digest;
		this.content = content;
		this.publishTime = publishTime;
		this.pageView = pageView;
		this.commentCount = commentCount;
		this.keywords = keywords;
	}

	// Property accessors

	public Integer getBlogId() {
		return this.blogId;
	}

	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}

	public Short getBlogTypeId() {
		return this.blogTypeId;
	}

	public void setBlogTypeId(Short blogTypeId) {
		this.blogTypeId = blogTypeId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDigest() {
		return this.digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getPublishTime() {
		return this.publishTime;
	}

	public void setPublishTime(Timestamp publishTime) {
		this.publishTime = publishTime;
	}

	public Long getPageView() {
		return this.pageView;
	}

	public void setPageView(Long pageView) {
		this.pageView = pageView;
	}

	public Long getCommentCount() {
		return this.commentCount;
	}

	public void setCommentCount(Long commentCount) {
		this.commentCount = commentCount;
	}

	public String getKeywords() {
		return this.keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

}