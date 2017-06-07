package com.fhr.ranblog.repositorys;

import java.util.List;

import com.fhr.ranblog.models.LanguageType;
/**
 * LanguageType仓库接口
 * 
 * @see com.fhr.ranblog.repositorys.IBaseDAO
 * @see com.fhr.ranblog.repositorys.models.LanguageType
 * @author fhr
 */
public interface ILanguageTypeDAO extends IBaseDAO<LanguageType> {

	List<LanguageType> findByLanguageName(Object languageName);

}