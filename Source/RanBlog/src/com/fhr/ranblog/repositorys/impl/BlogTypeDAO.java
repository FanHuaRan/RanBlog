package com.fhr.ranblog.repositorys.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fhr.ranblog.models.BlogType;
import com.fhr.ranblog.repositorys.HibernateBaseDAO;
import com.fhr.ranblog.repositorys.IBlogTypeDAO;

/**
 * BlogType仓库实现
 * 
 * @see com.fhr.ranblog.models.BlogType
 * @see com.fhr.ranblog.repositorys.IBlogTypeDAO
 * @see com.fhr.ranblog.repositorys.HibernateBaseDao<T>
 * @author fhr
 */
@Repository
public class BlogTypeDAO extends HibernateBaseDAO<BlogType> implements IBlogTypeDAO {
	// property constants
	public static final String BLOG_TYPE_NAME = "blogTypeName";
	
	// constructor to DI SessionFactory
	@Autowired
	public BlogTypeDAO(SessionFactory sessionFactory) {
		super();
		this.setSessionFactory(sessionFactory);
	}
	
	/* (non-Javadoc)
	 * @see com.fhr.ranblog.repositorys.impl.IBlogTypeDAO#findByBlogTypeName(java.lang.Object)
	 */
	@Override
	public List<BlogType> findByBlogTypeName(Object blogTypeName) {
		return findByProperty(BLOG_TYPE_NAME, blogTypeName);
	}
}