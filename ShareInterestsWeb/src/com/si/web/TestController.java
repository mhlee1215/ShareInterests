package com.si.web;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

import com.si.domain.Article;
import com.si.domain.Category;
import com.si.domain.User;
import com.si.service.ArticleService;
import com.si.service.CategoryService;
import com.si.service.UserService;
import com.si.util.SendEmail;




@Controller

@RequestMapping("/test")
public class TestController {


	private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private final UserService userService = null;
	
	@Autowired
	private final CategoryService categoryService = null;
	
	@Autowired
	private final ArticleService articleService = null;
	
//	@RequestMapping("/{action}")
//    public @ResponseBody String testAction(HttpServletRequest request, HttpServletResponse response
//    		,@PathVariable(value = "action") String action
//			) throws Exception {
//
//		
////		Article a = new Article();
////		a.setAuthorId(2);
////		a.setHobbyId(1);
////		a.setDate("20160202");
////		a.setDescription("my description1");
////		a.setPriceMin(0);
////		a.setPriceMax(10000);
////		a.setPracticeHour(10);
//
//		
////		articleService.createArticle(a);
//		
//		Article a3 = new Article();
//		a3.setAuthorId(2);
////		articleService.readArticleList(a3);
////		a3.setHobbyId(1);
////		Article b = articleService.readArticle(a3);
////		b.setDescription("my description2");
////		articleService.updateArticle(a);
////		
//		List<Article> aa = articleService.readArticleList(new Article());
//////		articleService.deleteArticle(a);
////		
////		
////		System.out.println("action:"+action);
//////		List<Category> categoryList = categoryService.findAll();
////		System.out.println("JH: "+ categoryList);
//		
////		
//		return aa.toString();
//    }
	
	@RequestMapping("/email")
    public @ResponseBody String email(HttpServletRequest request, HttpServletResponse response
    		,@PathVariable(value = "action") String action
			) throws Exception {

		SendEmail se = new SendEmail();
		return "success";
    }
	
}
