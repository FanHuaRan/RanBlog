package com.fhr.ranblog.repositorys.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fhr.ranblog.models.BlogRole;
import com.fhr.ranblog.repositorys.HibernateBaseDAO;
import com.fhr.ranblog.repositorys.IBlogRoleDAO;

/**
 * BlogRole仓库实现
 * 
 * @see com.fhr.ranblog.models.BlogRole
 * @see com.fhr.ranblog.repositorys.IBlogRoleDAO
 * @see com.fhr.ranblog.repositorys.HibernateBaseDao<T>
 * @author fhr
 */
@Repository
public class BlogRoleDAO extends HibernateBaseDAO<BlogRole> implements IBlogRoleDAO {
	// property constants
	public static final String BLOG_ROLE_NAME = "blogRoleName";
	
	// constructor to DI SessionFactory
	@Autowired
	public BlogRoleDAO(SessionFactory sessionFactory) {
		super();
		this.setSessionFactory(sessionFactory);
	}
	
	/* (non-Javadoc)
	 * @see com.fhr.ranblog.repositorys.impl.IBlogRoleDAO#findByBlogRoleName(java.lang.Object)
	 */
	@Override
	public List<BlogRole> findByBlogRoleName(Object blogRoleName) {
		return findByProperty(BLOG_ROLE_NAME, blogRoleName);
	}
}