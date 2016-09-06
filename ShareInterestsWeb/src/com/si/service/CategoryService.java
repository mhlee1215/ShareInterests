package com.si.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.si.dao.CategoryDao;
import com.si.dao.HobbyDao;
import com.si.domain.Category;
import com.si.domain.Hobby;

@Service
public class CategoryService {

	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private CategoryDao		categoryDao;

	@Autowired
	private HobbyDao		hobbyDao;


	public List<Category> findAll() {

		List<Hobby> hobbyList = hobbyDao.findAll();
		List<Category> categoryList = categoryDao.findAll();

		Map<Integer, Category> categoryMap = new HashMap<>();
		for(Category c : categoryList){
			categoryMap.put(c.getId(), c);
		}

		for(Hobby h : hobbyList){
			Category c = categoryMap.get(h.getCategoryId());
			if(c !=null) c.addHobby(h);
		}

		return categoryList;
	}

	public List<Category> readCategoryList(Category category) {
		return categoryDao.readCategoryList(category);
	}

	public Category readCategory(Category category) {
		return categoryDao.readCategory(category);
	}

	public void createCategory(Category category) {
		categoryDao.createCategory(category);
	}

	public void deleteCategory(Category category) {
		categoryDao.deleteCategory(category);
	}

	public void updateCategory(Category category) {
		categoryDao.updateCategory(category);
	}


}
