package com.fhr.ranblog.repositorys;

import java.util.List;

import com.fhr.ranblog.models.BlogRole;
/**
 * BlogRole仓库接口
 * 
 * @see com.fhr.ranblog.repositorys.IBaseDAO
 * @see com.fhr.ranblog.repositorys.models.BlogRole
 * @author fhr
 */
public interface IBlogRoleDAO extends IBaseDAO<BlogRole>{

	List<BlogRole> findByBlogRoleName(Object blogRoleName);

}