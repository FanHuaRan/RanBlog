package com.fhr.ranblog.repositorys;

import java.util.List;

import com.fhr.ranblog.models.BlogType;

/**
 * BlogType仓库接口
 * 
 * @see com.fhr.ranblog.repositorys.IBaseDAO
 * @see com.fhr.ranblog.repositorys.models.BlogType
 * @author fhr
 */
public interface IBlogTypeDAO extends IBaseDAO<BlogType>{

	List<BlogType> findByBlogTypeName(Object blogTypeName);

}