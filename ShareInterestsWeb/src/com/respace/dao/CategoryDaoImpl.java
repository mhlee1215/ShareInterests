package com.respace.dao;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.respace.domain.Category;

public class CategoryDaoImpl extends SqlMapClientDaoSupport implements CategoryDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findAll() {
		return getSqlMapClientTemplate().queryForList("UserSql.readUserList");
	}

}
