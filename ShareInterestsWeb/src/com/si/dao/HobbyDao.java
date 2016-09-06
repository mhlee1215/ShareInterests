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
	
	public List<Hobby> findAll() {
		return readHobbyList(new Hobby());
	}
	
	@SuppressWarnings("unchecked")
	public List<Hobby> readHobbyList(Hobby hobby) {
		List<Hobby> array = getSqlMapClientTemplate().queryForList("HobbySql.readHobbyList", hobby);
		return array;
	}

	public Hobby readHobby(Hobby hobby) {
		return (Hobby)getSqlMapClientTemplate().queryForObject("HobbySql.readHobby", hobby);
	}

	public void createHobby(Hobby hobby) {
		getSqlMapClientTemplate().insert("HobbySql.createHobby", hobby);
	}

	public void deleteHobby(Hobby hobby) {
		getSqlMapClientTemplate().delete("HobbySql.deleteHobby", hobby);
	}

	public void updateHobby(Hobby hobby) {
		getSqlMapClientTemplate().update("HobbySql.updateHobby", hobby);
	}

}
