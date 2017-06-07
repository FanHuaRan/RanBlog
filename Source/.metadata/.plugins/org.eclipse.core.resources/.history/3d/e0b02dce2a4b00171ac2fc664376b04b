package com.fhr.ranblog.repositorys;

import java.io.Serializable;
import java.util.List;

public interface IBaseDAO<T extends Serializable> {

	void save(T transientInstance);

	void update(T transientInstance);

	void delete(T persistentInstance);

	void deleteByProperty(String propertyName, Object value);

	void delete(Integer id);

	void deleteAll();

	T findById(Serializable id);

	List<T> findAll();

	List<T> findTopNByHQL(String hql, int n);

	List<T> findByHQL(String hql, Object... params);

	List<T> findByProperty(String propertyName, Object value);

	List<T> findByExample(T instance);

	T merge(T detachedInstance);

	void attachDirty(T instance);

	void attachClean(T instance);

}