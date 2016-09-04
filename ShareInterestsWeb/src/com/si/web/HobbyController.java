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




@Controller

//@RequestMapping("/test")
public class HobbyController {
private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private final UserService userService = null;
	
	@Autowired
	private final CategoryService categoryService = null;
	
	@RequestMapping("/{category_name}/{hobby_title}/{action}")
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
		model.addObject("categoryName", categoryName);
		model.addObject("hobbyTitle", hobbyTitle);
		model.addObject("action", action);
		return model;
    }
	
	@RequestMapping("/{category_name}/{hobby_title}.do")
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
	
	@RequestMapping(value = "/fileUpload.do", method = RequestMethod.GET)
    public String dragAndDrop(Model model) {
         
        return "fileUpload";
         
    }
     
    @RequestMapping(value = "/fileUpload/post.do") //ajax에서 호출하는 부분
    @ResponseBody
    public String upload(MultipartHttpServletRequest multipartRequest) { //Multipart로 받는다.
         
        Iterator<String> itr =  multipartRequest.getFileNames();
         
        while (itr.hasNext()) { //받은 파일들을 모두 돌린다.
             
            MultipartFile mpf = multipartRequest.getFile(itr.next());
            String originFileName = mpf.getOriginalFilename();
            System.out.println("FILE_INFO: "+originFileName); //받은 파일 리스트 출력
             
       }
         
        return "success";
    }
     
	
     
	
}
