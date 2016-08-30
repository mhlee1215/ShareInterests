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
