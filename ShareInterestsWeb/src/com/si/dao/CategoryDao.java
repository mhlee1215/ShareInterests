package com.si.dao;

import java.util.List;

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
	
	public List<Category> findAll() {
		return readCategoryList(new Category());
	}
	
	@SuppressWarnings("unchecked")
	public List<Category> readCategoryList(Category category) {
		List<Category> array = getSqlMapClientTemplate().queryForList("CategorySql.readCategoryList", category);
		return array;
	}

	public Category readCategory(Category category) {
		return (Category)getSqlMapClientTemplate().queryForObject("CategorySql.readCategory", category);
	}

	public void createCategory(Category category) {
		getSqlMapClientTemplate().insert("CategorySql.createCategory", category);
	}

	public void deleteCategory(Category category) {
		getSqlMapClientTemplate().delete("CategorySql.deleteCategory", category);
	}

	public void updateCategory(Category category) {
		getSqlMapClientTemplate().update("CategorySql.updateCategory", category);
	}

}
