package com.fhr.ranblog.models;

/**
 * Blogtype entity. @author MyEclipse Persistence Tools
 */

public class BlogType implements java.io.Serializable {

	// Fields

	private Short blogTypeId;
	private Integer blogTypeName;

	// Constructors

	/** default constructor */
	public BlogType() {
	}

	/** full constructor */
	public BlogType(Integer blogTypeName) {
		this.blogTypeName = blogTypeName;
	}

	// Property accessors

	public Short getBlogTypeId() {
		return this.blogTypeId;
	}

	public void setBlogTypeId(Short blogTypeId) {
		this.blogTypeId = blogTypeId;
	}

	public Integer getBlogTypeName() {
		return this.blogTypeName;
	}

	public void setBlogTypeName(Integer blogTypeName) {
		this.blogTypeName = blogTypeName;
	}

}