package com.si.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.si.dao.ArticleDao;
import com.si.domain.Article;

@Service
public class ArticleService{
	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private ArticleDao articleDao;

	public List<Article> readPopularArticleList(Article article) {
		return articleDao.readPopularArticleList(article);
	}
	
	public List<Article> readArticleList(Article article) {
		return articleDao.readArticleList(article);
	}

	public Article readArticle(Article article) {
		return articleDao.readArticle(article);
	}

	public void createArticle(Article article) {
		articleDao.createArticle(article);
	}

	public void deleteArticle(Article article) {
		articleDao.deleteArticle(article);
	}

	public void updateArticle(Article article) {
		articleDao.updateArticle(article);
	}

}
