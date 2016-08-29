package com.respace.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.respace.dao.CategoryDao;
import com.respace.domain.Category;

public class CategoryServiceImpl implements CategoryService {

	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private CategoryDao		categoryDao;
	
	public List<Category> findAll() {
		return categoryDao.findAll();
	}


}
