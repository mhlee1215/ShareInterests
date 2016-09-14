package com.si.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.si.dao.MediaDao;
import com.si.domain.Hobby;
import com.si.domain.Media;

@Service
public class MediaService{
	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private MediaDao mediaDao;

	public List<Media> readMediaList(Media media) {
		return mediaDao.readMediaList(media);
	}

	public Media readMedia(Media media) {
		return mediaDao.readMedia(media);
	}

	public void createMedia(Media media) {
		mediaDao.createMedia(media);
	}

	public void deleteMedia(Media media) {
		mediaDao.deleteMedia(media);
	}

	public void updateMedia(Media media) {
		mediaDao.updateMedia(media);
	}
	
	

}
