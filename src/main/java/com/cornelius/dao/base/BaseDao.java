package com.cornelius.dao.base;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * DAO基类
 * @author wxk
 *
 */
public class BaseDao extends SqlSessionDaoSupport implements SqlSession{
	
	@Override
	@Resource
	public void setSqlSessionFactory(SqlSessionFactory factory){
		super.setSqlSessionFactory(factory);
	}
	
	public <T> T selectOne(String statement) {
		return getSqlSession().selectOne(statement);
	}

	public <T> T selectOne(String statement, Object parameter) {
		return getSqlSession().selectOne(statement, parameter);
	}

	public <E> List<E> selectList(String statement) {
		return getSqlSession().selectList(statement);
	}

	public <E> List<E> selectList(String statement, Object parameter) {
		return getSqlSession().selectList(statement, parameter);
	}

	public <E> List<E> selectList(String statement, Object parameter, RowBounds rowBounds) {
		return getSqlSession().selectList(statement, parameter, rowBounds);
	}

	public <K, V> Map<K, V> selectMap(String statement, String mapKey) {
		return getSqlSession().selectMap(statement, mapKey);
	}

	public <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey) {
		return getSqlSession().selectMap(statement, parameter, mapKey);
	}

	public <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey, RowBounds rowBounds) {
		return getSqlSession().selectMap(statement, parameter, mapKey, rowBounds);
	}

	public <T> Cursor<T> selectCursor(String statement) {
		return getSqlSession().selectCursor(statement);
	}

	public <T> Cursor<T> selectCursor(String statement, Object parameter) {
		return getSqlSession().selectCursor(statement, parameter);
	}

	public <T> Cursor<T> selectCursor(String statement, Object parameter, RowBounds rowBounds) {
		return getSqlSession().selectCursor(statement, parameter, rowBounds);
	}

	public void select(String statement, Object parameter, ResultHandler handler) {
		getSqlSession().select(statement, parameter, handler);
	}

	public void select(String statement, ResultHandler handler) {
		getSqlSession().select(statement, handler);
	}

	public void select(String statement, Object parameter, RowBounds rowBounds, ResultHandler handler) {
		getSqlSession().select(statement, parameter, rowBounds, handler);
	}

	public int insert(String statement) {
		return getSqlSession().insert(statement);
	}

	public int insert(String statement, Object parameter) {
		return getSqlSession().insert(statement,parameter);
	}

	public int update(String statement) {
		return getSqlSession().update(statement);
	}

	public int update(String statement, Object parameter) {
		return getSqlSession().update(statement, parameter);
	}

	public int delete(String statement) {
		return getSqlSession().delete(statement);
	}

	public int delete(String statement, Object parameter) {
		return getSqlSession().delete(statement, parameter);
	}

	public void commit() {
		getSqlSession().commit();
	}

	public void commit(boolean force) {
		getSqlSession().commit(force);
	}

	public void rollback() {
		getSqlSession().rollback();
	}

	public void rollback(boolean force) {
		getSqlSession().rollback(force);
	}

	public List<BatchResult> flushStatements() {
		return getSqlSession().flushStatements();
	}

	//无法手动关闭，会报异常
	public void close() {
		
	}

	public void clearCache() {
		getSqlSession().clearCache();
	}

	public Configuration getConfiguration() {
		return getSqlSession().getConfiguration();
	}

	public <T> T getMapper(Class<T> type) {
		return getSqlSession().getMapper(type);
	}

	public Connection getConnection() {
		return getSqlSession().getConnection();
	}
}
