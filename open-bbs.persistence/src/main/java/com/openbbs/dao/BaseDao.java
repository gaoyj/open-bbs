package com.openbbs.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;

import com.openbbs.dao.exception.RowMismatchException;

/**
 * @author Jdz
 *
 * @param <T>
 */
public interface BaseDao<T> {

	public void setSuperSessionFactroy(SqlSessionFactory sessionFactory);

	public List<T> find(String statement);
	
	public boolean insert(String statement , T t);

	public boolean update(String statement, T t, Integer... rows) throws RowMismatchException ;

	public boolean delete(String statement, T t, Integer... rows) throws RowMismatchException ;

}
