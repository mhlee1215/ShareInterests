package com.si.dao;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.si.domain.Hashtag;

@Repository
public class HashtagDao extends SqlMapClientDaoSupport{

	@Resource(name="sqlMapClient")
	protected void initDAO(SqlMapClient sqlMapClient) {
		this.setSqlMapClient(sqlMapClient);
	}

	@SuppressWarnings("unchecked")
	public List<Hashtag> readHashtagList(Hashtag hashtag) {
		List<Hashtag> array = getSqlMapClientTemplate().queryForList("HashtagSql.readHashtagList", hashtag);
		return array;
	}

	public Hashtag readHashtag(Hashtag hashtag) {
		return (Hashtag)getSqlMapClientTemplate().queryForObject("HashtagSql.readHashtag", hashtag);
	}

	public void createHashtag(Hashtag hashtag) {
		getSqlMapClientTemplate().insert("UserSql.createHashtag", hashtag);
	}

	public void deleteHashtag(Hashtag hashtag) {
		getSqlMapClientTemplate().delete("HashtagSql.deleteHashtag", hashtag);
	}

	public void updateHashtag(Hashtag hashtag) {
		getSqlMapClientTemplate().update("HashtagSql.updateHashtag", hashtag);
	}
}
