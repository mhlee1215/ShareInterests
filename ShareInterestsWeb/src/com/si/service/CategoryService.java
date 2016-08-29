package com.si.service;

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
	
	
	public Map<Integer, Category> findAll() {
		
		List<Hobby> hobbyList = hobbyDao.findAll();
		Map<Integer, Category> categoryMap = categoryDao.findAll();
		
		for(Hobby h : hobbyList){
			categoryMap.get(h.getCategoryId()).addHobby(h);
		}
		
		return categoryMap;
	}


}
