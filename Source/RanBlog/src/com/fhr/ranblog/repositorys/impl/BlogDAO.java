package com.fhr.ranblog.repositorys.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fhr.ranblog.models.Blog;
import com.fhr.ranblog.repositorys.HibernateBaseDAO;
import com.fhr.ranblog.repositorys.IBlogDAO;

/**
 * Blog仓库实现
 * 
 * @see com.fhr.ranblog.models.Blog
 * @see com.fhr.ranblog.repositorys.IBlogDAO
 * @see com.fhr.ranblog.repositorys.HibernateBaseDao<T>
 * @author fhr
 */
@Repository
public class BlogDAO extends HibernateBaseDAO<Blog> implements IBlogDAO {
	// property constants
	public static final String BLOG_TYPE_ID = "blogTypeId";
	public static final String TITLE = "title";
	public static final String DIGEST = "digest";
	public static final String CONTENT = "content";
	public static final String PAGE_VIEW = "pageView";
	public static final String COMMENT_COUNT = "commentCount";
	public static final String KEYWORDS = "keywords";
	
	// constructor to DI SessionFactory
	@Autowired
	public BlogDAO(SessionFactory sessionFactory) {
		super();
		this.setSessionFactory(sessionFactory);
	}
	
	/* (non-Javadoc)
	 * @see com.fhr.ranblog.repositorys.impl.IBlogDAO#findByBlogTypeId(java.lang.Object)
	 */
	@Override
	public List<Blog> findByBlogTypeId(Object blogTypeId) {
		return findByProperty(BLOG_TYPE_ID, blogTypeId);
	}

	/* (non-Javadoc)
	 * @see com.fhr.ranblog.repositorys.impl.IBlogDAO#findByTitle(java.lang.Object)
	 */
	@Override
	public List<Blog> findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	/* (non-Javadoc)
	 * @see com.fhr.ranblog.repositorys.impl.IBlogDAO#findByDigest(java.lang.Object)
	 */
	@Override
	public List<Blog> findByDigest(Object digest) {
		return findByProperty(DIGEST, digest);
	}

	/* (non-Javadoc)
	 * @see com.fhr.ranblog.repositorys.impl.IBlogDAO#findByContent(java.lang.Object)
	 */
	@Override
	public List<Blog> findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	/* (non-Javadoc)
	 * @see com.fhr.ranblog.repositorys.impl.IBlogDAO#findByPageView(java.lang.Object)
	 */
	@Override
	public List<Blog> findByPageView(Object pageView) {
		return findByProperty(PAGE_VIEW, pageView);
	}

	/* (non-Javadoc)
	 * @see com.fhr.ranblog.repositorys.impl.IBlogDAO#findByCommentCount(java.lang.Object)
	 */
	@Override
	public List<Blog> findByCommentCount(Object commentCount) {
		return findByProperty(COMMENT_COUNT, commentCount);
	}

	/* (non-Javadoc)
	 * @see com.fhr.ranblog.repositorys.impl.IBlogDAO#findByKeywords(java.lang.Object)
	 */
	@Override
	public List<Blog> findByKeywords(Object keywords) {
		return findByProperty(KEYWORDS, keywords);
	}

}