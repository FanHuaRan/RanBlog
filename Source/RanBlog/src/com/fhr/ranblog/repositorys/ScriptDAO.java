package com.fhr.ranblog.repositorys;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fhr.ranblog.models.Script;

/**
 * A data access object (DAO) providing persistence and search support for
 * Script entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.fhr.ranblog.models.Script
 * @author MyEclipse Persistence Tools
 */
public class ScriptDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(ScriptDAO.class);
	// property constants
	public static final String LANGUAGE_TYPE_ID = "languageTypeId";
	public static final String SCRIPT_NAME = "scriptName";
	public static final String SCRIPT_CONTENT = "scriptContent";

	protected void initDao() {
		// do nothing
	}

	public void save(Script transientInstance) {
		log.debug("saving Script instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Script persistentInstance) {
		log.debug("deleting Script instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Script findById(java.lang.Long id) {
		log.debug("getting Script instance with id: " + id);
		try {
			Script instance = (Script) getHibernateTemplate().get("com.fhr.ranblog.models.Script", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Script instance) {
		log.debug("finding Script instance by example");
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
		log.debug("finding Script instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Script as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByLanguageTypeId(Object languageTypeId) {
		return findByProperty(LANGUAGE_TYPE_ID, languageTypeId);
	}

	public List findByScriptName(Object scriptName) {
		return findByProperty(SCRIPT_NAME, scriptName);
	}

	public List findByScriptContent(Object scriptContent) {
		return findByProperty(SCRIPT_CONTENT, scriptContent);
	}

	public List findAll() {
		log.debug("finding all Script instances");
		try {
			String queryString = "from Script";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Script merge(Script detachedInstance) {
		log.debug("merging Script instance");
		try {
			Script result = (Script) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Script instance) {
		log.debug("attaching dirty Script instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Script instance) {
		log.debug("attaching clean Script instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ScriptDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ScriptDAO) ctx.getBean("ScriptDAO");
	}
}