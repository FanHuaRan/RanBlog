package com.fhr.ranblog.models;

/**
 * Authority entity. @author MyEclipse Persistence Tools
 */

public class Authority implements java.io.Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -1373423981294736953L;
	
	// Fields

	private Long authorityId;
	private Integer blogUserId;
	private Short blogRoleId;

	// Constructors

	/** default constructor */
	public Authority() {
	}

	/** full constructor */
	public Authority(Integer blogUserId, Short blogRoleId) {
		this.blogUserId = blogUserId;
		this.blogRoleId = blogRoleId;
	}

	// Property accessors

	public Long getAuthorityId() {
		return this.authorityId;
	}

	public void setAuthorityId(Long authorityId) {
		this.authorityId = authorityId;
	}

	public Integer getBlogUserId() {
		return this.blogUserId;
	}

	public void setBlogUserId(Integer blogUserId) {
		this.blogUserId = blogUserId;
	}

	public Short getBlogRoleId() {
		return this.blogRoleId;
	}

	public void setBlogRoleId(Short blogRoleId) {
		this.blogRoleId = blogRoleId;
	}

}