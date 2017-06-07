package com.fhr.ranblog.repositorys;

import java.util.List;

import com.fhr.ranblog.models.Authority;
/**
 * Authority仓库接口
 * 
 * @see com.fhr.ranblog.repositorys.IBaseDAO
 * @see com.fhr.ranblog.repositorys.models.Authority
 * @author fhr
 */
public interface IAuthorityDAO extends IBaseDAO<Authority> {

	List<Authority> findByBlogUserId(Object blogUserId);

	List<Authority> findByBlogRoleId(Object blogRoleId);

}