package com.si.service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.commons.mail.EmailException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.si.dao.UserDao;
import com.si.domain.User;
import com.si.util.Crypto;



@Service
public class UserService {

	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private UserDao		userDao;
	
	boolean isEncrypt = true;

	public List<User> findAll() {
		return userDao.findAll();
	}

	public int createUser(User user) throws Exception {
		
		
		//Encrypt
        if(isEncrypt)
        	 user.setPassword(Crypto.encrypt(user.getPassword()));       
		User paramUser = new User();
		paramUser.setEmail(user.getEmail());
		User foundUser = readUserData(paramUser);
		logger.debug("create User");
		logger.debug("==[S]============================");
		
		if(foundUser != null){
			logger.debug("User is already registered. Cancel Register.");
			logger.debug("==[E]============================");
			return User.STATUS_ALREADY_REGISTEREDED;
		}
		else{
			logger.debug("User doesn't find. Go Register.");
			userDao.createUser(user);
			
			//Make User Folser
			String cmd = "mkdir";
			String resultStr = "";
			
			//Make ID folder
			//resultStr+=Env.exeCmd(cmd+" "+Env.ENV_DATA_PATH+user.getInternalid());
			if(!resultStr.equals(""))resultStr+="<br>";
		
			//Make Log folder
			//Env.exeCmd(cmd+" "+Env.ENV_LOG_PATH+user.getInternalid());
			System.out.println(resultStr);
			logger.debug("==[E]============================");
			return User.STATUS_SUCCESS_REGISTER;
		}
		
		
	}

	

	public int readUser(User user) throws Exception {
		
		if(isEncrypt)
		    user.setPassword(Crypto.encrypt(user.getPassword()));
        //
		User readed = userDao.readUser(user);
		
		if(readed == null){
			return User.STATUS_NOT_FOUNDED;
		}else{
			return User.STATUS_FOUNDED;
		}
	}
	
	public User readUserData(User user) throws Exception {
		return userDao.readUser(user);
	}

	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	public int verifyUser(String email) {

		User paramUser = new User();
		paramUser.setEmail(email);
		User user = userDao.readUser(paramUser);
		if (user != null) {
			if (user.getIsverified().equals("Y")) {
				//alread verified.
				return User.STATUS_ALREADY_VERIFIED;
			} else {
				paramUser.setIsverified("Y");
				paramUser.setStatus(User.STATUS_VERIFIED);
				userDao.updateUser(paramUser);
				// Activate successfully.
				return User.STATUS_SUCCESS_VERIFIED;
			}
		}
		// Activate fail.
		return User.STATUS_NOT_FOUNDED;
	}

	public int deleteUser(String id) {
		return deleteUser(id, false);
	}
	
	public int deleteUser(String email, boolean isDeleteRow) {
		User paramUser = new User();
		paramUser.setEmail(email);
		User user = userDao.readUser(paramUser);
		if (user != null) {
			if (user.getIsdeleted().equals("Y")) {
				//alread deleted.
				return User.STATUS_ALREADY_DELETED;
			} else {
				userDao.deleteUser(paramUser);
				return User.STATUS_SUCCESS_DELETED;
			}
		}
		// Delete fail.
		return User.STATUS_DELTE_FAIL;
		
	}

	public int findPassword(String id) throws EmailException,
			MalformedURLException {
		// TODO Auto-generated method stub
		return 0;
	}



	

}
