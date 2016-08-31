package com.si.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

import com.si.domain.Category;
import com.si.domain.User;
import com.si.service.CategoryService;
import com.si.service.UserService;




@Controller

@RequestMapping("/browse")
public class HobbyController {

	private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private final UserService userService = null;
	
	@Autowired
	private final CategoryService categoryService = null;
	
	@RequestMapping("/{category_name}/{hobby_title}/{action}.do")
    public ModelAndView article(HttpServletRequest request, HttpServletResponse response
    		,@PathVariable(value = "category_name") String categoryName
			,@PathVariable(value = "hobby_title") String hobbyTitle
			,@PathVariable(value = "action") String action) throws Exception {

		
		System.out.println("category_name:"+categoryName);
		System.out.println("hobby_title:"+hobbyTitle);
		System.out.println("action:"+action);
//		List<Category> categoryList = categoryService.findAll();
//		System.out.println("JH: "+ categoryList);
		ModelAndView model = new ModelAndView("article");
//		
		return model;
    }
	
	@RequestMapping("/{category_name}/{hobby_title}")
    public ModelAndView hobby(HttpServletRequest request, HttpServletResponse response
    		,@PathVariable(value = "category_name") String categoryName
			,@PathVariable(value = "hobby_title") String hobbyTitle
			) throws Exception {

		
		System.out.println("category_name:"+categoryName);
		System.out.println("hobby_title:"+hobbyTitle);
//		List<Category> categoryList = categoryService.findAll();
//		System.out.println("JH: "+ categoryList);
		ModelAndView model = new ModelAndView("hobby");
		model.addObject("hobbyTitle", hobbyTitle);
//		
		return model;
    }
	
}
