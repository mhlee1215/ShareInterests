package com.si.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.si.domain.User;

public class SISessionManager {
	public static ModelAndView SIModelAndView(String page, HttpServletRequest request){
		ModelAndView mav = new ModelAndView(page);
		
		//User Info Add
		String attName = "user";
		Object obj = request.getSession().getAttribute(attName);
		User user = null;
		if(obj instanceof User)
			user = (User) obj;
		
		if(user != null) mav.addObject(attName, user);
		
		
		return mav;
	}
}
