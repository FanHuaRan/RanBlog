package com.fhr.ranblog.repositorys;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fhr.ranblog.models.BlogComment;

/**
 * A data access object (DAO) providing persistence and search support for
 * Blogcomment entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.fhr.ranblog.models.Blogcomment
 * @author MyEclipse Persistence Tools
 */
public class BlogcommentDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(BlogcommentDAO.class);
	// property constants
	public static final String BLOG_USER_ID = "blogUserId";
	public static final String BLOG_ID = "blogId";
	public static final String BLOG_COMMENT = "blogComment";

	protected void initDao() {
		// do nothing
	}

	public void save(BlogComment transientInstance) {
		log.debug("saving Blogcomment instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(BlogComment persistentInstance) {
		log.debug("deleting Blogcomment instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BlogComment findById(java.lang.Long id) {
		log.debug("getting Blogcomment instance with id: " + id);
		try {
			BlogComment instance = (BlogComment) getHibernateTemplate().get("com.fhr.ranblog.models.BlogComment", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(BlogComment instance) {
		log.debug("finding Blogcomment instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Blogcomment instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Blogcomment as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByBlogUserId(Object blogUserId) {
		return findByProperty(BLOG_USER_ID, blogUserId);
	}

	public List findByBlogId(Object blogId) {
		return findByProperty(BLOG_ID, blogId);
	}

	public List findByBlogComment(Object blogComment) {
		return findByProperty(BLOG_COMMENT, blogComment);
	}

	public List findAll() {
		log.debug("finding all Blogcomment instances");
		try {
			String queryString = "from Blogcomment";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public BlogComment merge(BlogComment detachedInstance) {
		log.debug("merging Blogcomment instance");
		try {
			BlogComment result = (BlogComment) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(BlogComment instance) {
		log.debug("attaching dirty Blogcomment instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BlogComment instance) {
		log.debug("attaching clean Blogcomment instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static BlogcommentDAO getFromApplicationContext(ApplicationContext ctx) {
		return (BlogcommentDAO) ctx.getBean("BlogcommentDAO");
	}
}