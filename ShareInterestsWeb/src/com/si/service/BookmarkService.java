package com.si.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.si.dao.BookmarkDao;
import com.si.domain.Bookmark;

@Service
public class BookmarkService{
	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private BookmarkDao bookmarkDao;

	public List<Bookmark> readBookmarkList(Bookmark bookmark) {
		return bookmarkDao.readBookmarkList(bookmark);
	}

	public Bookmark readBookmark(Bookmark bookmark) {
		return bookmarkDao.readBookmark(bookmark);
	}

	public void createBookmark(Bookmark bookmark) {
		bookmarkDao.createBookmark(bookmark);
	}

	public void deleteBookmark(Bookmark bookmark) {
		bookmarkDao.deleteBookmark(bookmark);
	}

	public void updateBookmark(Bookmark bookmark) {
		bookmarkDao.updateBookmark(bookmark);
	}

}
