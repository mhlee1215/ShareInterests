package com.si.dao;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.si.domain.Comment;

@Repository
public class CommentDao extends SqlMapClientDaoSupport{

	@Resource(name="sqlMapClient")
	protected void initDAO(SqlMapClient sqlMapClient) {
		this.setSqlMapClient(sqlMapClient);
	}

	@SuppressWarnings("unchecked")
	public List<Comment> readCommentList(Comment comment) {
		List<Comment> array = getSqlMapClientTemplate().queryForList("CommentSql.readCommentList", comment);
		return array;
	}

	public Comment readComment(Comment comment) {
		return (Comment)getSqlMapClientTemplate().queryForObject("CommentSql.readComment", comment);
	}

	public void createComment(Comment comment) {
		getSqlMapClientTemplate().insert("UserSql.createComment", comment);
	}

	public void deleteComment(Comment comment) {
		getSqlMapClientTemplate().delete("CommentSql.deleteComment", comment);
	}

	public void updateComment(Comment comment) {
		getSqlMapClientTemplate().update("CommentSql.updateComment", comment);
	}
}
