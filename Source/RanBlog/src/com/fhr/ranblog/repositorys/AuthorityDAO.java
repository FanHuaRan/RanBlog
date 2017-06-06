package com.fhr.ranblog.repositorys;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fhr.ranblog.models.Authority;

/**
 * A data access object (DAO) providing persistence and search support for
 * Authority entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.fhr.ranblog.models.Authority
 * @author MyEclipse Persistence Tools
 */
public class AuthorityDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(AuthorityDAO.class);
	// property constants
	public static final String BLOG_USER_ID = "blogUserId";
	public static final String BLOG_ROLE_ID = "blogRoleId";

	protected void initDao() {
		// do nothing
	}

	public void save(Authority transientInstance) {
		log.debug("saving Authority instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Authority persistentInstance) {
		log.debug("deleting Authority instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Authority findById(java.lang.Long id) {
		log.debug("getting Authority instance with id: " + id);
		try {
			Authority instance = (Authority) getHibernateTemplate().get("com.fhr.ranblog.models.Authority", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Authority instance) {
		log.debug("finding Authority instance by example");
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
		log.debug("finding Authority instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Authority as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByBlogUserId(Object blogUserId) {
		return findByProperty(BLOG_USER_ID, blogUserId);
	}

	public List findByBlogRoleId(Object blogRoleId) {
		return findByProperty(BLOG_ROLE_ID, blogRoleId);
	}

	public List findAll() {
		log.debug("finding all Authority instances");
		try {
			String queryString = "from Authority";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Authority merge(Authority detachedInstance) {
		log.debug("merging Authority instance");
		try {
			Authority result = (Authority) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Authority instance) {
		log.debug("attaching dirty Authority instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Authority instance) {
		log.debug("attaching clean Authority instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AuthorityDAO getFromApplicationContext(ApplicationContext ctx) {
		return (AuthorityDAO) ctx.getBean("AuthorityDAO");
	}
}