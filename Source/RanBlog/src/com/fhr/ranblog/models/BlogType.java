package com.fhr.ranblog.models;

/**
 * Blogtype entity. @author MyEclipse Persistence Tools
 */

public class BlogType implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3982255907580119520L;
	
	// Fields

	private Short blogTypeId;
	private String blogTypeName;
	private Long blogCount;
	// Constructors

	/** default constructor */
	public BlogType() {
	}

	/** full constructor */
	public BlogType(String blogTypeName,Long blogCount) {
		this.blogTypeName = blogTypeName;
		this.blogCount=blogCount;
	}

	// Property accessors

	public Short getBlogTypeId() {
		return this.blogTypeId;
	}

	public void setBlogTypeId(Short blogTypeId) {
		this.blogTypeId = blogTypeId;
	}

	public String getBlogTypeName() {
		return this.blogTypeName;
	}

	public void setBlogTypeName(String blogTypeName) {
		this.blogTypeName = blogTypeName;
	}

	public Long getBlogCount() {
		return blogCount;
	}

	public void setBlogCount(Long blogCount) {
		this.blogCount = blogCount;
	}
	

}