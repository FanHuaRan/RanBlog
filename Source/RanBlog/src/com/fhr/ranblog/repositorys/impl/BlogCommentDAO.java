package com.fhr.ranblog.repositorys.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fhr.ranblog.models.BlogComment;
import com.fhr.ranblog.repositorys.HibernateBaseDAO;
import com.fhr.ranblog.repositorys.IBlogCommentDAO;

/**
 * BlogComment仓库实现
 * 
 * @see com.fhr.ranblog.models.Blogcomment
 * @see com.fhr.ranblog.repositorys.IBlogCommentDAO
 * @see com.fhr.ranblog.repositorys.HibernateBaseDao<T>
 * @author fhr
 */
@Repository
public class BlogCommentDAO extends HibernateBaseDAO<BlogComment> implements IBlogCommentDAO {
	// property constants
	public static final String BLOG_USER_ID = "blogUserId";
	public static final String BLOG_ID = "blogId";
	public static final String BLOG_COMMENT = "blogComment";

	// constructor to DI SessionFactory
	@Autowired
	public BlogCommentDAO(SessionFactory sessionFactory) {
		super();
		this.setSessionFactory(sessionFactory);
	}
	
	/* (non-Javadoc)
	 * @see com.fhr.ranblog.repositorys.impl.IBlogCommentDAO#findByBlogUserId(java.lang.Object)
	 */
	@Override
	public List<BlogComment> findByBlogUserId(Object blogUserId) {
		return findByProperty(BLOG_USER_ID, blogUserId);
	}

	/* (non-Javadoc)
	 * @see com.fhr.ranblog.repositorys.impl.IBlogCommentDAO#findByBlogId(java.lang.Object)
	 */
	@Override
	public List<BlogComment> findByBlogId(Object blogId) {
		return findByProperty(BLOG_ID, blogId);
	}

	/* (non-Javadoc)
	 * @see com.fhr.ranblog.repositorys.impl.IBlogCommentDAO#findByBlogComment(java.lang.Object)
	 */
	@Override
	public List<BlogComment> findByBlogComment(Object blogComment) {
		return findByProperty(BLOG_COMMENT, blogComment);
	}
}