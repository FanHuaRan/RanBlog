package com.fhr.ranblog.repositorys;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fhr.ranblog.models.Languagetype;

/**
 * A data access object (DAO) providing persistence and search support for
 * Languagetype entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.fhr.ranblog.models.Languagetype
 * @author MyEclipse Persistence Tools
 */
public class LanguagetypeDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(LanguagetypeDAO.class);
	// property constants
	public static final String LANGUAGE_NAME = "languageName";

	protected void initDao() {
		// do nothing
	}

	public void save(Languagetype transientInstance) {
		log.debug("saving Languagetype instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Languagetype persistentInstance) {
		log.debug("deleting Languagetype instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Languagetype findById(java.lang.Long id) {
		log.debug("getting Languagetype instance with id: " + id);
		try {
			Languagetype instance = (Languagetype) getHibernateTemplate().get("com.fhr.ranblog.models.Languagetype",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Languagetype instance) {
		log.debug("finding Languagetype instance by example");
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
		log.debug("finding Languagetype instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Languagetype as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByLanguageName(Object languageName) {
		return findByProperty(LANGUAGE_NAME, languageName);
	}

	public List findAll() {
		log.debug("finding all Languagetype instances");
		try {
			String queryString = "from Languagetype";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Languagetype merge(Languagetype detachedInstance) {
		log.debug("merging Languagetype instance");
		try {
			Languagetype result = (Languagetype) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Languagetype instance) {
		log.debug("attaching dirty Languagetype instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Languagetype instance) {
		log.debug("attaching clean Languagetype instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static LanguagetypeDAO getFromApplicationContext(ApplicationContext ctx) {
		return (LanguagetypeDAO) ctx.getBean("LanguagetypeDAO");
	}
}