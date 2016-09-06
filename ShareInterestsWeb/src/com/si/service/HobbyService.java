package com.si.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.si.dao.HobbyDao;
import com.si.domain.Hobby;

@Service
public class HobbyService{
	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private HobbyDao hobbyDao;

	public List<Hobby> readHobbyList(Hobby hobby) {
		return hobbyDao.readHobbyList(hobby);
	}
	
	public List<Hobby> searchHobbyList(Hobby hobby) {
		return hobbyDao.searchHobbyList(hobby);
	}
	

	public Hobby readHobby(Hobby hobby) {
		return hobbyDao.readHobby(hobby);
	}

	public void createHobby(Hobby hobby) {
		hobbyDao.createHobby(hobby);
	}

	public void deleteHobby(Hobby hobby) {
		hobbyDao.deleteHobby(hobby);
	}

	public void updateHobby(Hobby hobby) {
		hobbyDao.updateHobby(hobby);
	}

}
