package com.fhr.ranblog.repositorys.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fhr.ranblog.models.Script;
import com.fhr.ranblog.repositorys.HibernateBaseDAO;
import com.fhr.ranblog.repositorys.IScriptDAO;

/**
 * Script仓库实现
 * 
 * @see com.fhr.ranblog.models.Script
 * @see com.fhr.ranblog.repositorys.IScriptDAO
 * @see com.fhr.ranblog.repositorys.HibernateBaseDao<T>
 * @author fhr
 */
@Repository
public class ScriptDAO extends HibernateBaseDAO<Script> implements IScriptDAO {
	// property constants
	public static final String LANGUAGE_TYPE_ID = "languageTypeId";
	public static final String SCRIPT_NAME = "scriptName";
	public static final String SCRIPT_CONTENT = "scriptContent";
	
	// constructor to DI SessionFactory
	@Autowired
	public ScriptDAO(SessionFactory sessionFactory) {
		super();
		this.setSessionFactory(sessionFactory);
	}
	
	/* (non-Javadoc)
	 * @see com.fhr.ranblog.repositorys.impl.IScriptDAO#findByLanguageTypeId(java.lang.Object)
	 */
	@Override
	public List<Script> findByLanguageTypeId(Object languageTypeId) {
		return findByProperty(LANGUAGE_TYPE_ID, languageTypeId);
	}

	/* (non-Javadoc)
	 * @see com.fhr.ranblog.repositorys.impl.IScriptDAO#findByScriptName(java.lang.Object)
	 */
	@Override
	public List<Script> findByScriptName(Object scriptName) {
		return findByProperty(SCRIPT_NAME, scriptName);
	}

	/* (non-Javadoc)
	 * @see com.fhr.ranblog.repositorys.impl.IScriptDAO#findByScriptContent(java.lang.Object)
	 */
	@Override
	public List<Script> findByScriptContent(Object scriptContent) {
		return findByProperty(SCRIPT_CONTENT, scriptContent);
	}
}