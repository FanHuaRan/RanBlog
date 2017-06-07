package com.fhr.ranblog.repositorys;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fhr.ranblog.models.BlogType;

/**
 * A data access object (DAO) providing persistence and search support for
 * Blogtype entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.fhr.ranblog.models.BlogType
 * @author MyEclipse Persistence Tools
 */
public class BlogtypeDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(BlogtypeDAO.class);
	// property constants
	public static final String BLOG_TYPE_NAME = "blogTypeName";

	protected void initDao() {
		// do nothing
	}

	public void save(BlogType transientInstance) {
		log.debug("saving Blogtype instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(BlogType persistentInstance) {
		log.debug("deleting Blogtype instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BlogType findById(java.lang.Short id) {
		log.debug("getting Blogtype instance with id: " + id);
		try {
			BlogType instance = (BlogType) getHibernateTemplate().get("com.fhr.ranblog.models.Blogtype", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(BlogType instance) {
		log.debug("finding Blogtype instance by example");
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
		log.debug("finding Blogtype instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Blogtype as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByBlogTypeName(Object blogTypeName) {
		return findByProperty(BLOG_TYPE_NAME, blogTypeName);
	}

	public List findAll() {
		log.debug("finding all Blogtype instances");
		try {
			String queryString = "from Blogtype";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public BlogType merge(BlogType detachedInstance) {
		log.debug("merging Blogtype instance");
		try {
			BlogType result = (BlogType) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(BlogType instance) {
		log.debug("attaching dirty Blogtype instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BlogType instance) {
		log.debug("attaching clean Blogtype instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static BlogtypeDAO getFromApplicationContext(ApplicationContext ctx) {
		return (BlogtypeDAO) ctx.getBean("BlogtypeDAO");
	}
}