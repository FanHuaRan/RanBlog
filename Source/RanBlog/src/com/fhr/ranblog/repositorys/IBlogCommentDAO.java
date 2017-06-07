package com.fhr.ranblog.repositorys;

import java.util.List;

import com.fhr.ranblog.models.BlogComment;
/**
 * BlogComment仓库接口
 * 
 * @see com.fhr.ranblog.repositorys.IBaseDAO
 * @see com.fhr.ranblog.repositorys.models.BlogComment
 * @author fhr
 */
public interface IBlogCommentDAO extends IBaseDAO<BlogComment>{

	List<BlogComment> findByBlogUserId(Object blogUserId);

	List<BlogComment> findByBlogId(Object blogId);

	List<BlogComment> findByBlogComment(Object blogComment);

}