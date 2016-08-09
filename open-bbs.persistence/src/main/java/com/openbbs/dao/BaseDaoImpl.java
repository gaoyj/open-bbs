package com.openbbs.dao;

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
		
		public List<T> selectFind(String str, T t){
			return getSqlSession().selectList(str, t);
		}
		
		public List<T> find(String str){
			return getSqlSession().selectList(str);
		}
		

		public T get(String str, T t) {
			return getSqlSession().selectOne(str, t);
		}

		public boolean insert(String str , T model) {
			return getSqlSession().insert(str, model)>0;
		}
		
		public boolean update(String str, T t) {
			return getSqlSession().update(str, t)>0;
		}
		
		public boolean delete(String str,int id) {
			return getSqlSession().delete(str, id)>0;
		}
		
		public List<T> find(String str,String str2){
			return getSqlSession().selectList(str,str2);
		}
		
		public T get(String str,String str2){
			return getSqlSession().selectOne(str, str2);
		}
		

		public List<T> get(String str,Map<String,Object> str2){
			return getSqlSession().selectList(str, str2);
		}
		
		public boolean updatebyid(String str1,String str2){
			
			return getSqlSession().update(str1, str2)>0;
			
		}
		public boolean  deletebyproductid(String str1,String id){
			
			return   getSqlSession().delete(str1,id)>0;
			
		}
		
		public List<T> SelectListMap(String sqlstr ,Map<String, Object> map){
			return getSqlSession().selectList(sqlstr,map);
		}
    
}
