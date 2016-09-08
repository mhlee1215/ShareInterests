package com.si.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

import com.si.domain.Category;
import com.si.domain.User;
import com.si.service.CategoryService;
import com.si.service.UserService;
import com.si.util.SISessionManager;




@Controller

//@RequestMapping("/main")
public class UserController {

	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private final UserService userService = null;

	@Autowired
	private final CategoryService categoryService = null;

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

		List<Category> categoryList = categoryService.findAll();
		System.out.println("JH: "+ categoryList);
		ModelAndView model = SISessionManager.SIModelAndView("index", request);
		model.addObject("category", categoryList);


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
		
		String result = ServletRequestUtils.getStringParameter(request, "result", "");
		String referrer = request.getHeader("referer");
		System.out.println("referrer::"+referrer);
		ModelAndView model = SISessionManager.SIModelAndView("login", request);
		model.addObject("result", result);
		model.addObject("callbackUrl", referrer);
		//model.addObject("active", "login");
		if(model.getModel().get("user") != null){
			return new ModelAndView("redirect:index.do");
		}
		return model;
	}

	@RequestMapping("/requestLogin.do")
	public @ResponseBody String requestLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String email = ServletRequestUtils.getStringParameter(request, "email", "");
		String password = ServletRequestUtils.getStringParameter(request, "password", "");

		
		
		logger.debug("public ModelAndView login");
		logger.debug("===[S]======================");
		logger.debug("email : "+email);
		logger.debug("password : "+password);
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);

		String errorStr = "";
		try{
			int result = userService.readUser(user);

			if(result == User.STATUS_NOT_FOUNDED){
				System.out.println("User does not exist! or password is wrong.");
				return "notfound";
			}
			else if(result == User.STATUS_FOUNDED){
				System.out.println("User is founded!");
				User userFound = userService.readUserData(user);
				request.getSession().setAttribute("user", userFound);
				return "success";
			}
		}catch(Exception e){
			errorStr += e.toString();
		}

		return "error_"+errorStr;
	}

	//	
	@RequestMapping("/requestSignup.do")
	public @ResponseBody String requestSignup(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String email = ServletRequestUtils.getStringParameter(request, "email", "");
		String name = ServletRequestUtils.getStringParameter(request, "name", "");
		String password = ServletRequestUtils.getStringParameter(request, "password", "");

		String errorStr = "";
		try{
			if( email != null && password != null){
				User user = new User();
				user.setName(name);
				user.setEmail(email);
				user.setPassword(password);

				int result = userService.createUser(user);
				if(result == User.STATUS_ALREADY_REGISTEREDED){
					System.out.println("The ID requested to register is already exists!");
					return "already_registered";
				}else if(result == User.STATUS_SUCCESS_REGISTER){
					return "success";
				}
			}else{
				errorStr += "parameterNotSatisfied:email:"+email+", password:"+password;
			}
		}catch(Exception e){
			errorStr+=e.toString();
		}
		return "error_"+errorStr;
	}

	@RequestMapping("/logout.do")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();

		ModelAndView model = new ModelAndView("redirect:index.do");
		model.addObject("logoutComplete", "true");
		return model;
	}
	
	@RequestMapping("/about.do")
	public ModelAndView about(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = SISessionManager.SIModelAndView("about", request);
		model.addObject("active", "about");
		return model;
	}


//	@RequestMapping("/category/{Cat1}/{Cat2}/{Cat3}")
//	public ModelAndView categoryTest(HttpServletRequest request, HttpServletResponse response
//			,@PathVariable(value = "Cat1") String Cat1
//			,@PathVariable(value = "Cat2") String Cat2
//			,@PathVariable(value = "Cat3") String Cat3
//			) {
//		//	    String remainingPaths = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
//		//	    logger.debug("path = " + path + "/" + remainingPaths);
//
//		System.out.println("Cat1: "+Cat1);
//		System.out.println("Cat2: "+Cat2);
//		System.out.println("Cat3: "+Cat3);
//
//		return new ModelAndView("index");
//	}
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
