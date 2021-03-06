package com.fhr.ranblog.repositorys;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
/**
 * Hibernate Dao泛型基类
 * 基本的增删改查实现
 * @author fhr
 * @param <T>
 */
public class HibernateBaseDAO<T extends Serializable> extends HibernateDaoSupport implements IBaseDAO<T> {
	//日志组件
	protected static final Logger log = Logger.getLogger(HibernateBaseDAO.class);
	//实体名
	private String entityName=null;
	//实体名带包名
	private String entityFullName=null;
	//实体class
	private Class<T> entityClass;
	
	@SuppressWarnings("unchecked")
	public HibernateBaseDAO(){
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		entityClass = (Class<T>) params[0];
		entityName = entityClass.getSimpleName();
		entityFullName = entityClass.getName();
	}
	
	protected void initDao() {
		// do nothing
	}
	/* (non-Javadoc)
	 * @see com.fhr.ranblog.repositorys.IBaseDAO#save(T)
	 */
	@Override
	public void save(T transientInstance) {
		try {
			getHibernateTemplate().save(transientInstance);
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	/* (non-Javadoc)
	 * @see com.fhr.ranblog.repositorys.IBaseDAO#update(T)
	 */
	@Override
	public void update(T transientInstance) {
		try {
			getHibernateTemplate().update(transientInstance);
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
	/* (non-Javadoc)
	 * @see com.fhr.ranblog.repositorys.IBaseDAO#delete(T)
	 */
	@Override
	public void delete(T persistentInstance) {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	/* (non-Javadoc)
	 * @see com.fhr.ranblog.repositorys.IBaseDAO#deleteByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public void deleteByProperty(String propertyName, Object value) {
		try {
			List<T> instances=findByProperty(propertyName, value);
			instances.stream().forEach(instance->getHibernateTemplate().delete(instance));
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.fhr.ranblog.repositorys.IBaseDAO#delete(java.lang.Integer)
	 */
	@Override
	public void delete(Integer id) {
		try {
			T persistentInstance=findById(id);
			if(persistentInstance!=null){
				getHibernateTemplate().delete(persistentInstance);
			}
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	/* (non-Javadoc)
	 * @see com.fhr.ranblog.repositorys.IBaseDAO#deleteAll()
	 */
	@Override
	public void deleteAll(){
		try {
			List<T> instances=findAll();
			instances.stream().forEach(persistentInstance->{
				delete(persistentInstance);
			});
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	/* (non-Javadoc)
	 * @see com.fhr.ranblog.repositorys.IBaseDAO#findById(java.io.Serializable)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public T findById(Serializable id) {
		try {
			T instance =(T)getHibernateTemplate().get(entityFullName, id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	/* (non-Javadoc)
	 * @see com.fhr.ranblog.repositorys.IBaseDAO#findAll()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		try {
			String queryString = "from " +entityName;
			return  (List<T>) getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	/* (non-Javadoc)
	 * @see com.fhr.ranblog.repositorys.IBaseDAO#findTopNByHQL(java.lang.String, int)
	 */
	@Override
	@SuppressWarnings({ "unchecked" })
	public List<T> findTopNByHQL(final String hql,int n){
		try{
			List<T> result=(List<T>) this.getHibernateTemplate().execute(new HibernateCallback<Object>() {
				@Override
				public Object doInHibernate(Session arg0) throws HibernateException, SQLException {
					Query query=arg0.createQuery(hql);
					query.setMaxResults(n);
					List<T> result=query.list();
					return result;
				}
			});
			return result;
		}catch(RuntimeException re){
			log.error("find by "+hql+" name failed", re);
			throw re;
		}
	}
	/* (non-Javadoc)
	 * @see com.fhr.ranblog.repositorys.IBaseDAO#findByHQL(java.lang.String, java.lang.Object)
	 */
	@Override
	@SuppressWarnings({ "unchecked" })
	public List<T> findByHQL(String hql,Object ...params){
		try{
			return (List<T>) getHibernateTemplate().find(hql,params);
		}catch(RuntimeException re){
			log.error("find by "+hql+" failed", re);
			throw re;
		}
	}
	/* (non-Javadoc)
	 * @see com.fhr.ranblog.repositorys.IBaseDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<T> findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from "+entityName+" as model where model." + propertyName + "= ?";
			return (List<T>) getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	/* (non-Javadoc)
	 * @see com.fhr.ranblog.repositorys.IBaseDAO#findByExample(T)
	 */
	@Override
	public List<T> findByExample(T instance) {
		try {
			List<T> results = getHibernateTemplate().findByExample(instance);
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.fhr.ranblog.repositorys.IBaseDAO#merge(T)
	 */
	@Override
	public T merge(T detachedInstance) {
		try {
			T result = getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.fhr.ranblog.repositorys.IBaseDAO#attachDirty(T)
	 */
	@Override
	public void attachDirty(T instance) {
		try {
			 getHibernateTemplate().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.fhr.ranblog.repositorys.IBaseDAO#attachClean(T)
	 */
	@Override
	public void attachClean(T instance) {
		try {
			 getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

}
