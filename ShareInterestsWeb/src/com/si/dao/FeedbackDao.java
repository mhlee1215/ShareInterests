package com.si.dao;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.si.domain.Feedback;

@Repository
public class FeedbackDao extends SqlMapClientDaoSupport{

	@Resource(name="sqlMapClient")
	protected void initDAO(SqlMapClient sqlMapClient) {
		this.setSqlMapClient(sqlMapClient);
	}

	@SuppressWarnings("unchecked")
	public List<Feedback> readFeedbackList(Feedback feedback) {
		List<Feedback> array = getSqlMapClientTemplate().queryForList("FeedbackSql.readFeedbackList", feedback);
		return array;
	}

	public Feedback readFeedback(Feedback feedback) {
		return (Feedback)getSqlMapClientTemplate().queryForObject("FeedbackSql.readFeedback", feedback);
	}

	public void createFeedback(Feedback feedback) {
		getSqlMapClientTemplate().insert("FeedbackSql.createFeedback", feedback);
	}

	public void deleteFeedback(Feedback feedback) {
		getSqlMapClientTemplate().delete("FeedbackSql.deleteFeedback", feedback);
	}

	public void updateFeedback(Feedback feedback) {
		getSqlMapClientTemplate().update("FeedbackSql.updateFeedback", feedback);
	}
}
