package com.fhr.ranblog.repositorys.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fhr.ranblog.models.Authority;
import com.fhr.ranblog.repositorys.HibernateBaseDAO;
import com.fhr.ranblog.repositorys.IAuthorityDAO;

/**
 * Authority仓库实现
 * 
 * @see com.fhr.ranblog.models.Authority
 * @see com.fhr.ranblog.repositorys.IAuthorityDAO
 * @see com.fhr.ranblog.repositorys.HibernateBaseDao<T>
 * @author fhr
 */
@Repository
public class AuthorityDAO extends  HibernateBaseDAO<Authority> implements IAuthorityDAO {
	// property constants
	public static final String BLOG_USER_ID = "blogUserId";
	public static final String BLOG_ROLE_ID = "blogRoleId";
	//constructor to DI SessionFactory
	@Autowired
	public AuthorityDAO(SessionFactory sessionFactory){
		super();
		this.setSessionFactory(sessionFactory);
	}
	
	/* (non-Javadoc)
	 * @see com.fhr.ranblog.repositorys.impl.IAuthorityDAO#findByBlogUserId(java.lang.Object)
	 */
	@Override
	public List<Authority> findByBlogUserId(Object blogUserId) {
		return findByProperty(BLOG_USER_ID, blogUserId);
	}

	/* (non-Javadoc)
	 * @see com.fhr.ranblog.repositorys.impl.IAuthorityDAO#findByBlogRoleId(java.lang.Object)
	 */
	@Override
	public List<Authority> findByBlogRoleId(Object blogRoleId) {
		return findByProperty(BLOG_ROLE_ID, blogRoleId);
	}
}