package com.respace.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.respace.domain.User;
import com.respace.service.UserService;




@Controller
public class UserController {

	private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private final UserService userService = null;
	
	
	
	
	@RequestMapping("/index.do")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws Exception {

//		String submittedUserId = ServletRequestUtils.getStringParameter(request, "submittedUserId", "");
//		String loginComplete = ServletRequestUtils.getStringParameter(request, "loginComplete", "false");
//		String loginFail = ServletRequestUtils.getStringParameter(request, "loginFail", "false");
//		String logoutComplete = ServletRequestUtils.getStringParameter(request, "logoutComplete", "false");
//		String registerComplete = ServletRequestUtils.getStringParameter(request, "registerComplete", "false");
//		String registerFail = ServletRequestUtils.getStringParameter(request, "registerFail", "false");
//	    String userid = (String)request.getSession().getAttribute("userid");
//	    String user_type = (String) request.getSession().getAttribute("user_type");
//	    
//	   
//	    String language = (String)request.getSession().getAttribute("lang");
//		//LanguagePack lang = LanguageServiceImpl.getLangPack(language);
		
		List<User> userList = userService.findAll();
		//System.out.println(user);
		ModelAndView model = new ModelAndView("index");
		System.out.println(userList);
		model.addObject("user", userList);
		//model.addObject("page_title", lang.getStringHazardReportingSystem());
//		model.addObject("loginComplete", loginComplete);
//		model.addObject("loginFail", loginFail);
//		model.addObject("logoutComplete", logoutComplete);
//		model.addObject("registerComplete", registerComplete);
//		model.addObject("registerFail", registerFail);
//		model.addObject("submittedUserId", submittedUserId);
//		model.addObject("isUseController", "true");
//		model.addObject("user_type", user_type);
		
		
		
		model.addObject("active", "index");
				
		return model;
    }
	
	@RequestMapping("/login.do")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		logger.debug("public ModelAndView login");
		logger.debug("===[S]======================");
		logger.debug("email : "+email);
		logger.debug("password : "+password);
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		
		int result = userService.readUser(user);
		
		
		ModelAndView model = null;
		
		if(result == User.STATUS_NOT_FOUNDED){
			model = new ModelAndView("join");
			System.out.println("User does not exist! or password is wrong.");
			model.addObject("loginFail", "true");
		}
		else if(result == User.STATUS_FOUNDED){
			model = new ModelAndView("redirect:index.do");
			System.out.println("User is founded!");
						
			request.getSession().setAttribute("email", user.getEmail());
			request.getSession().setAttribute("islogin", "true");
			model.addObject("loginComplete", "true");
		}
		model.addObject("email", email);
		logger.debug("===[S]======================");
		return model;
    }
//	
	@RequestMapping("/register.do")
    public ModelAndView register(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		ModelAndView model = new ModelAndView("redirect:index.do");
		if( email == null || password == null){
			model.addObject("reason", "parameter_incomplete");
			model.addObject("registerFail", "true");
		}else{
			User user = new User();
			user.setEmail(email);
			user.setPassword(password);
			user.setType("1");	//Set as normal user
			int result = userService.createUser(user);
			if(result == User.STATUS_ALREADY_REGISTEREDED){
				System.out.println("The ID requested to register is already exists!");
				model.addObject("reason", "already_exist");
				model.addObject("registerFail", "true");
				//model.addObject("submittedUserId", id);
			}else if(result == User.STATUS_SUCCESS_REGISTER){
				
	//			UserIdMap userIdMap = new UserIdMap();
	//			userIdMap.setExternalId(id);
	//			userIdMap.setInternalId(nextId);
	//			userService.createUserIdMap(userIdMap);
	//			model.addObject("registerComplete", "true");
	//			model.addObject("submittedUserId", id);
				
				model.addObject("registerComplete", "true");
			}
		}
		return model;
    }
	
	@RequestMapping("/logout.do")
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		
		ModelAndView model = new ModelAndView("redirect:index.do");
		model.addObject("logoutComplete", "true");
		return model;
    }
//	
//	@RequestMapping("/findPassword.do")
//    public ModelAndView findPassword(HttpServletRequest request, HttpServletResponse response) {
//		
//		request.getSession().removeAttribute("userid");
//		
//		ModelAndView model = new ModelAndView("index");
//		model.addObject("logoutComplete", "true");
//		return model;
//    }
//	
//	
//	@RequestMapping("/changePassword.do")
//    public ModelAndView changePassword(HttpServletRequest request, HttpServletResponse response) {
//		
//		request.getSession().removeAttribute("userid");
//		
//		ModelAndView model = new ModelAndView("index");
//		model.addObject("logoutComplete", "true");
//		return model;
//    }
//	
}
