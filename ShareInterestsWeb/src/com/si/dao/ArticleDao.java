package com.si.dao;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.si.domain.Article;

@Repository
public class ArticleDao extends SqlMapClientDaoSupport{

	@Resource(name="sqlMapClient")
	protected void initDAO(SqlMapClient sqlMapClient) {
		this.setSqlMapClient(sqlMapClient);
	}

	@SuppressWarnings("unchecked")
	public List<Article> readPopularArticleList(Article article) {
		List<Article> array = getSqlMapClientTemplate().queryForList("ArticleSql.readPopularArticleList", article);
		return array;
	}
	
	@SuppressWarnings("unchecked")
	public List<Article> readArticleList(Article article) {
		List<Article> array = getSqlMapClientTemplate().queryForList("ArticleSql.readArticleList", article);
		return array;
	}

	public Article readArticle(Article article) {
		return (Article)getSqlMapClientTemplate().queryForObject("ArticleSql.readArticle", article);
	}

	public void createArticle(Article article) {
		getSqlMapClientTemplate().insert("ArticleSql.createArticle", article);
	}

	public void deleteArticle(Article article) {
		getSqlMapClientTemplate().delete("ArticleSql.deleteArticle", article);
	}

	public void updateArticle(Article article) {
		getSqlMapClientTemplate().update("ArticleSql.updateArticle", article);
	}
}
