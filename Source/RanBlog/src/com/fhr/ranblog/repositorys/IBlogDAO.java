package com.fhr.ranblog.repositorys;

import java.util.List;

import com.fhr.ranblog.models.Blog;
/**
 * Blog仓库接口
 * 
 * @see com.fhr.ranblog.repositorys.IBaseDAO
 * @see com.fhr.ranblog.repositorys.models.Blog
 * @author fhr
 */
public interface IBlogDAO  extends IBaseDAO<Blog>{

	List<Blog> findByBlogTypeId(Object blogTypeId);

	List<Blog> findByTitle(Object title);

	List<Blog> findByDigest(Object digest);

	List<Blog> findByContent(Object content);

	List<Blog> findByPageView(Object pageView);

	List<Blog> findByCommentCount(Object commentCount);

	List<Blog> findByKeywords(Object keywords);

}