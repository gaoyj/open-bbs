package com.openbbs.dao.base.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Jdz
 *
 * @param <T>
 */
public class BaseDaoImpl<T> extends SqlSessionDaoSupport implements BaseDao<T>{

	@Resource
	public void setSuperSessionFactroy(SqlSessionFactory sessionFactory) {
		super.setSqlSessionFactory(sessionFactory);
	}

	public List<T> find(String statement) {
		return getSqlSession().selectList(statement);
	}

	public boolean insert(String statement, T t) {
		return getSqlSession().insert(statement, t) > 0;
	}

	public boolean update(String statement, T t, Integer... rows) throws RowMismatchException {
		int expectRows = rows.length==1 ? rows[0] : 1;
		int affectedRows = getSqlSession().update(statement, t);
		if(expectRows != affectedRows){
			throw new RowMismatchException();
		}
		
		return affectedRows > 0;
	}

	public boolean delete(String statement, T t, Integer... rows) throws RowMismatchException  {
		int expectRows = rows.length==1 ? rows[0] : 1;
		int affectedRows = getSqlSession().delete(statement, t);
		if(expectRows != affectedRows){
			throw new RowMismatchException();
		}
		
		return affectedRows > 0;
	}
	
}
