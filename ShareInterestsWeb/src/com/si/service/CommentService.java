package com.si.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.si.dao.CommentDao;
import com.si.domain.Comment;

@Service
public class CommentService{
	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private CommentDao commentDao;

	public List<Comment> readCommentList(Comment comment) {
		return commentDao.readCommentList(comment);
	}

	public Comment readComment(Comment comment) {
		return commentDao.readComment(comment);
	}

	public void createComment(Comment comment) {
		commentDao.createComment(comment);
	}

	public void deleteComment(Comment comment) {
		commentDao.deleteComment(comment);
	}

	public void updateComment(Comment comment) {
		commentDao.updateComment(comment);
	}

}
