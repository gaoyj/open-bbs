package com.openbbs.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author Jdz
 *
 * @param <T>
 */
public interface BaseDao<T> {

	public void setSuperSessionFactroy(SqlSessionFactory sessionFactory);

	public List<T> selectFind(String str, T t);

	public List<T> find(String str);

	public T get(String str, T t);

	public boolean insert(String str , T model);

	public boolean update(String str, T t);

	public boolean delete(String str,int id);

	public List<T> find(String str,String str2);

	public T get(String str,String str2);

	public List<T> get(String str,Map<String,Object> str2);

	public boolean updatebyid(String str1,String str2);

	public boolean  deletebyproductid(String str1,String id);

	public List<T> SelectListMap(String sqlstr ,Map<String, Object> map);

}
