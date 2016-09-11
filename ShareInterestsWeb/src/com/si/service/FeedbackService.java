package com.si.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.si.dao.FeedbackDao;
import com.si.domain.Feedback;

@Service
public class FeedbackService{
	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private FeedbackDao feedbackDao;
	
	public void setFeedbackLike(int userId, int articleId){
		Feedback fd = new Feedback();
		fd.setUserId(userId);
		fd.setArticleId(articleId);
		fd.setType(Feedback.TYPE_LIKE);
		createFeedback(fd);
	}
	
	public void removeFeedbackLike(int userId, int articleId){
		Feedback fd = new Feedback();
		fd.setUserId(userId);
		fd.setArticleId(articleId);
		fd.setType(Feedback.TYPE_LIKE);
		deleteFeedback(fd);
	}
	
	public void setFeedbackUseful(int userId, int articleId){
		Feedback fd = new Feedback();
		fd.setUserId(userId);
		fd.setArticleId(articleId);
		fd.setType(Feedback.TYPE_USEFUL);
		createFeedback(fd);
	}
	
	public void removeFeedbackUseful(int userId, int articleId){
		Feedback fd = new Feedback();
		fd.setUserId(userId);
		fd.setArticleId(articleId);
		fd.setType(Feedback.TYPE_USEFUL);
		deleteFeedback(fd);
	}
	
	public void setFeedbackFunny(int userId, int articleId){
		Feedback fd = new Feedback();
		fd.setUserId(userId);
		fd.setArticleId(articleId);
		fd.setType(Feedback.TYPE_FUNNY);
		createFeedback(fd);
	}
	
	public void removeFeedbackFunny(int userId, int articleId){
		Feedback fd = new Feedback();
		fd.setUserId(userId);
		fd.setArticleId(articleId);
		fd.setType(Feedback.TYPE_FUNNY);
		deleteFeedback(fd);
	}

	public List<Feedback> readFeedbackList(Feedback feedback) {
		return feedbackDao.readFeedbackList(feedback);
	}

	public Feedback readFeedback(Feedback feedback) {
		return feedbackDao.readFeedback(feedback);
	}

	public void createFeedback(Feedback feedback) {
		feedbackDao.createFeedback(feedback);
	}

	public void deleteFeedback(Feedback feedback) {
		feedbackDao.deleteFeedback(feedback);
	}

	public void updateFeedback(Feedback feedback) {
		feedbackDao.updateFeedback(feedback);
	}

}
