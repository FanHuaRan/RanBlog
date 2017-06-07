package com.fhr.ranblog.models;

/**
 * Languagetype entity. @author MyEclipse Persistence Tools
 */

public class LanguageType implements java.io.Serializable {

	// Fields

	private Long languageTypeId;
	private String languageName;

	// Constructors

	/** default constructor */
	public LanguageType() {
	}

	/** full constructor */
	public LanguageType(String languageName) {
		this.languageName = languageName;
	}

	// Property accessors

	public Long getLanguageTypeId() {
		return this.languageTypeId;
	}

	public void setLanguageTypeId(Long languageTypeId) {
		this.languageTypeId = languageTypeId;
	}

	public String getLanguageName() {
		return this.languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

}