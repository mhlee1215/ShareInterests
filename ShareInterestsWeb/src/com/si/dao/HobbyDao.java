package com.si.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.si.domain.Hobby;

@Repository
public class HobbyDao extends SqlMapClientDaoSupport {
	@Resource(name="sqlMapClient")
	 protected void initDAO(SqlMapClient sqlMapClient) {        
		 this.setSqlMapClient(sqlMapClient);
	 } 
	
	@SuppressWarnings("unchecked")
	public List<Hobby> findAll() {
		return getSqlMapClientTemplate().queryForList("HobbySql.readHobbyList");
	}

}
