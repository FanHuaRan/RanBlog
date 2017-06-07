package com.fhr.ranblog.repositorys;

import java.util.List;

import com.fhr.ranblog.models.BlogUser;
/**
 * BlogUser仓库接口
 * 
 * @see com.fhr.ranblog.repositorys.IBaseDAO
 * @see com.fhr.ranblog.repositorys.models.BlogUser
 * @author fhr
 */
public interface IBlogUserDAO extends IBaseDAO<BlogUser> {

	List<BlogUser> findByUserName(Object userName);

	List<BlogUser> findByPassword(Object password);

	List<BlogUser> findByEmail(Object email);

}