package com.fhr.ranblog.repositorys.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fhr.ranblog.models.BlogUser;
import com.fhr.ranblog.repositorys.HibernateBaseDAO;
import com.fhr.ranblog.repositorys.IBlogUserDAO;

/**
 * BlogUser仓库实现
 * 
 * @see com.fhr.ranblog.models.BlogUser
 * @see com.fhr.ranblog.repositorys.IBlogUserDAO
 * @see com.fhr.ranblog.repositorys.HibernateBaseDao<T>
 * @author fhr
 */
@Repository
public class BlogUserDAO extends HibernateBaseDAO<BlogUser> implements IBlogUserDAO {
	// property constants
	public static final String USER_NAME = "userName";
	public static final String PASSWORD = "password";
	public static final String EMAIL = "email";
	
	// constructor to DI SessionFactory
	@Autowired
	public BlogUserDAO(SessionFactory sessionFactory) {
		super();
		this.setSessionFactory(sessionFactory);
	}
	
	/* (non-Javadoc)
	 * @see com.fhr.ranblog.repositorys.impl.IBlogUserDAO#findByUserName(java.lang.Object)
	 */
	@Override
	public List<BlogUser> findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	/* (non-Javadoc)
	 * @see com.fhr.ranblog.repositorys.impl.IBlogUserDAO#findByPassword(java.lang.Object)
	 */
	@Override
	public List<BlogUser> findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	/* (non-Javadoc)
	 * @see com.fhr.ranblog.repositorys.impl.IBlogUserDAO#findByEmail(java.lang.Object)
	 */
	@Override
	public List<BlogUser> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}
}