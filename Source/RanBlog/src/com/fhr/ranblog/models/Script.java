package com.fhr.ranblog.models;

import java.sql.Timestamp;

/**
 * Script entity. @author MyEclipse Persistence Tools
 */

public class Script implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5075794770042692634L;
	
	// Fields

	private Long scriptId;
	private Long languageTypeId;
	private String scriptName;
	private String scriptContent;
	private Timestamp editTime;

	// Constructors

	/** default constructor */
	public Script() {
	}

	/** full constructor */
	public Script(Long languageTypeId, String scriptName, String scriptContent, Timestamp editTime) {
		this.languageTypeId = languageTypeId;
		this.scriptName = scriptName;
		this.scriptContent = scriptContent;
		this.editTime = editTime;
	}

	// Property accessors

	public Long getScriptId() {
		return this.scriptId;
	}

	public void setScriptId(Long scriptId) {
		this.scriptId = scriptId;
	}

	public Long getLanguageTypeId() {
		return this.languageTypeId;
	}

	public void setLanguageTypeId(Long languageTypeId) {
		this.languageTypeId = languageTypeId;
	}

	public String getScriptName() {
		return this.scriptName;
	}

	public void setScriptName(String scriptName) {
		this.scriptName = scriptName;
	}

	public String getScriptContent() {
		return this.scriptContent;
	}

	public void setScriptContent(String scriptContent) {
		this.scriptContent = scriptContent;
	}

	public Timestamp getEditTime() {
		return this.editTime;
	}

	public void setEditTime(Timestamp editTime) {
		this.editTime = editTime;
	}

}