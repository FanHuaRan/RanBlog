package com.fhr.ranblog.repositorys.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fhr.ranblog.models.LanguageType;
import com.fhr.ranblog.repositorys.HibernateBaseDAO;
import com.fhr.ranblog.repositorys.ILanguageTypeDAO;

/**
 * LanguageType仓库实现
 * 
 * @see com.fhr.ranblog.models.LanguageType
 * @see com.fhr.ranblog.repositorys.ILanguageTypeDAO
 * @see com.fhr.ranblog.repositorys.HibernateBaseDao<T>
 * @author fhr
 */
@Repository
public class LanguageTypeDAO extends HibernateBaseDAO<LanguageType> implements ILanguageTypeDAO {
	// property constants
	public static final String LANGUAGE_NAME = "languageName";
	
	// constructor to DI SessionFactory
	@Autowired
	public LanguageTypeDAO(SessionFactory sessionFactory) {
		super();
		this.setSessionFactory(sessionFactory);
	}
	
	/* (non-Javadoc)
	 * @see com.fhr.ranblog.repositorys.impl.ILanguageTypeDAO#findByLanguageName(java.lang.Object)
	 */
	@Override
	public List<LanguageType> findByLanguageName(Object languageName) {
		return findByProperty(LANGUAGE_NAME, languageName);
	}
}