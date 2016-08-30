package com.si.dao;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.si.domain.Difficulty;

@Repository
public class DifficultyDao extends SqlMapClientDaoSupport{

	@Resource(name="sqlMapClient")
	protected void initDAO(SqlMapClient sqlMapClient) {
		this.setSqlMapClient(sqlMapClient);
	}

	@SuppressWarnings("unchecked")
	public List<Difficulty> readDifficultyList(Difficulty difficulty) {
		List<Difficulty> array = getSqlMapClientTemplate().queryForList("DifficultySql.readDifficultyList", difficulty);
		return array;
	}

	public Difficulty readDifficulty(Difficulty difficulty) {
		return (Difficulty)getSqlMapClientTemplate().queryForObject("DifficultySql.readDifficulty", difficulty);
	}

	public void createDifficulty(Difficulty difficulty) {
		getSqlMapClientTemplate().insert("UserSql.createDifficulty", difficulty);
	}

	public void deleteDifficulty(Difficulty difficulty) {
		getSqlMapClientTemplate().delete("DifficultySql.deleteDifficulty", difficulty);
	}

	public void updateDifficulty(Difficulty difficulty) {
		getSqlMapClientTemplate().update("DifficultySql.updateDifficulty", difficulty);
	}
}
