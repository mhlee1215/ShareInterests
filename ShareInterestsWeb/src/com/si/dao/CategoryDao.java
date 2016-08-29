package com.si.dao;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.si.domain.Category;

@Repository
public class CategoryDao extends SqlMapClientDaoSupport {
	@Resource(name="sqlMapClient")
	 protected void initDAO(SqlMapClient sqlMapClient) {        
		 this.setSqlMapClient(sqlMapClient);
	 } 
	
	@SuppressWarnings("unchecked")
	public Map<Integer, Category> findAll() {
		return getSqlMapClientTemplate().queryForMap("CategorySql.readCategoryList", "", "key", "value");
	}

}