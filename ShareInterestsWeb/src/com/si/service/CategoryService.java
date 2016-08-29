package com.si.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.si.dao.CategoryDao;
import com.si.domain.Category;

@Service
public class CategoryService {

	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private CategoryDao		categoryDao;
	
	public List<Category> findAll() {
		return categoryDao.findAll();
	}


}
