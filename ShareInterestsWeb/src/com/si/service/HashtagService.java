package com.si.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.si.dao.HashtagDao;
import com.si.domain.Hashtag;

@Service
public class HashtagService{
	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private HashtagDao hashtagDao;

	public List<Hashtag> readHashtagList(Hashtag hashtag) {
		return hashtagDao.readHashtagList(hashtag);
	}

	public Hashtag readHashtag(Hashtag hashtag) {
		return hashtagDao.readHashtag(hashtag);
	}

	public void createHashtag(Hashtag hashtag) {
		hashtagDao.createHashtag(hashtag);
	}

	public void deleteHashtag(Hashtag hashtag) {
		hashtagDao.deleteHashtag(hashtag);
	}

	public void updateHashtag(Hashtag hashtag) {
		hashtagDao.updateHashtag(hashtag);
	}

}
