package com.si.web;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
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
import com.si.domain.Hobby;
import com.si.domain.User;
import com.si.service.ArticleService;
import com.si.service.CategoryService;
import com.si.service.HobbyService;
import com.si.service.UserService;
import com.si.util.SISessionManager;




@Controller

@RequestMapping("/browse")
public class HobbyController {
private Logger logger = Logger.getLogger(getClass());
	@Autowired
	ServletContext context; 

	@Autowired
	private final UserService userService = null;
	
	@Autowired
	private final HobbyService hobbyService = null;
	
	@Autowired
	private final CategoryService categoryService = null;
	
	@Autowired
	private final ArticleService articleService = null;
	
	@RequestMapping(value="/{category_name}/{hobby_title}/{user_id}")
    public ModelAndView article(HttpServletRequest request, HttpServletResponse response
    		,@PathVariable(value = "category_name") String categoryName
			,@PathVariable(value = "hobby_title") String hobbyTitle
			,@PathVariable(value = "user_id") int userId) throws Exception {

		String action = ServletRequestUtils.getStringParameter(request, "action", "");
		System.out.println("category_name:"+categoryName);
		System.out.println("11hobby_title:"+hobbyTitle);
		System.out.println("userId:"+userId);
		String authority = "other";
		
		Category pCat = new Category();
		pCat.setName(categoryName);
		Category cat = categoryService.readCategory(pCat);
		if(cat == null) return getErrorPage();
		
		Hobby pHobby = new Hobby();
		pHobby.setCategoryId(cat.getId());
		pHobby.setTitle(hobbyTitle);
		Hobby hobby = hobbyService.readHobby(pHobby);
		if(hobby == null) return getErrorPage();
		
		//User name overlapping problem can be occurred.
		//Normal user and facebook username.
		User pUser = new User();
		pUser.setId(userId);
		User u = userService.readUserData(pUser);
		if(u == null) return getErrorPage();
		
		
		
		
		
		Object userObj = request.getSession().getAttribute("user");
		User user = null;//(User) userObj;
		
		boolean isMyArticle = false;
		boolean isForRead = false;
		if(userObj != null){
			user = (User) userObj;
			if(u.getId() != user.getId()){
				action = "read";
				isForRead = true;
			}else{
				isMyArticle = true;
				authority = "my";
			}
			
		}else{
			action = "read";
			isForRead = true;
		}
		
		
		
		Article pArticle = new Article();
		pArticle.setAuthorId(userId);
		pArticle.setHobbyId(hobby.getId());
		Article article = articleService.readArticle(pArticle);
		if(article == null){
			if(isMyArticle){
				articleService.createArticle(pArticle);
				article = articleService.readArticle(pArticle);
			}else{
				return getErrorPage();
			}
		}
		
//		List<Category> categoryList = categoryService.findAll();
//		System.out.println("JH: "+ categoryList);
		ModelAndView model = new ModelAndView("article");
		model.addObject("categoryName", categoryName);
		model.addObject("hobbyTitle", hobbyTitle);
		model.addObject("action", action);
		model.addObject("article", article);
		model.addObject("authority", authority);
		model.addObject("author", u);
		return model;
    }
	
	@RequestMapping("/{category_name}/{hobby_title}")
    public ModelAndView hobby(HttpServletRequest request, HttpServletResponse response
    		,@PathVariable(value = "category_name") String categoryName
			,@PathVariable(value = "hobby_title") String hobbyTitle
			) throws Exception {

		System.out.println("category_name:"+categoryName);
		System.out.println("hobby_title:"+hobbyTitle);
		
		Category pCat = new Category();
		pCat.setName(categoryName);
		Category cat = categoryService.readCategory(pCat);
		if(cat == null) return getErrorPage();
		
		Hobby pHobby = new Hobby();
		pHobby.setCategoryId(cat.getId());
		pHobby.setTitle(hobbyTitle);
		Hobby hobby = hobbyService.readHobby(pHobby);
		if(hobby == null) return getErrorPage();
		
		User user = (User) request.getSession().getAttribute("user");
		
		
		ModelAndView model = SISessionManager.SIModelAndView("hobby", request);
		model.addObject("categoryName", categoryName);
		model.addObject("hobbyTitle", hobbyTitle);
		
		
		String actionArticleDisplay = "";
		String actionArticleUrl = "";
		
		if(user == null){
			actionArticleDisplay = "Write my article";
			actionArticleUrl = context.getContextPath()+"/"+"login.do";
			model.addObject("action", "loginRequired");
		}
		else{
			
			Article pArticle = new Article();
			pArticle.setAuthorId(user.getId());
			pArticle.setHobbyId(hobby.getId());
			Article article = articleService.readArticle(pArticle);
			
			if(article == null){
//				articleService.createArticle(pArticle);
//				article = articleService.readArticle(pArticle);
				
				actionArticleUrl = context.getContextPath()+"/browse/"+categoryName+"/"+hobbyTitle+"/"+user.getId()+"?action=edit";
				actionArticleDisplay = "Write my article";
				//model.addObject("action", "edit");
			} 
			else{
				actionArticleUrl = context.getContextPath()+"/browse/"+categoryName+"/"+hobbyTitle+"/"+user.getId()+"?action=read";
				actionArticleDisplay = "Read my article";
				//model.addObject("action", "read");
			}
		}
		
		model.addObject("actionArticleDisplay", actionArticleDisplay);
		model.addObject("actionArticleUrl", actionArticleUrl);
		return model;
    }
	
	
    public ModelAndView getErrorPage(){
    	return new ModelAndView("error");
    }
	
    @RequestMapping(value="/updateArticle.do", produces = "text/html;charset=UTF-8")
    public @ResponseBody String updateArticle(HttpServletRequest request, HttpServletResponse response){
    	
    	String description = ServletRequestUtils.getStringParameter(request, "description", "");
    	int articleId = ServletRequestUtils.getIntParameter(request, "articleId", 0);
    	int authorId = ServletRequestUtils.getIntParameter(request, "authorId", 0);
    	
    	System.out.println("description:"+description);
    	
    	Article article = new Article();
    	article.setId(articleId);
    	article.setAuthorId(authorId);
    	article.setDescription(description);
    	articleService.updateArticle(article);
    	

    	return "success";
    }
    
    @RequestMapping(value="/search.do")
    public ModelAndView search(HttpServletRequest request, HttpServletResponse response){
    	ModelAndView model = SISessionManager.SIModelAndView("search", request);
    	model.addObject("active", "search");
    	
    	String keyword = request.getParameter("keyword");
    	Hobby hobby = new Hobby();
    	hobby.setTitle(keyword);

    	List<Hobby> searchResult = this.hobbyService.searchHobbyList(hobby);
    	
    	model.addObject(searchResult);
    	model.addObject("keyword", keyword);
    	return model;
    }
	
}
