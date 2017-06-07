package com.fhr.ranblog.repositorys;

import java.util.List;

import com.fhr.ranblog.models.Script;
/**
 * Script仓库接口
 * 
 * @see com.fhr.ranblog.repositorys.IBaseDAO
 * @see com.fhr.ranblog.repositorys.models.Script
 * @author fhr
 */
public interface IScriptDAO extends IBaseDAO<Script>{

	List<Script> findByLanguageTypeId(Object languageTypeId);

	List<Script> findByScriptName(Object scriptName);

	List<Script> findByScriptContent(Object scriptContent);

}