package com.si.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.si.dao.DifficultyDao;
import com.si.domain.Difficulty;

@Service
public class DifficultyService{
	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private DifficultyDao difficultyDao;

	public List<Difficulty> readDifficultyList(Difficulty difficulty) {
		return difficultyDao.readDifficultyList(difficulty);
	}

	public Difficulty readDifficulty(Difficulty difficulty) {
		return difficultyDao.readDifficulty(difficulty);
	}

	public void createDifficulty(Difficulty difficulty) {
		difficultyDao.createDifficulty(difficulty);
	}

	public void deleteDifficulty(Difficulty difficulty) {
		difficultyDao.deleteDifficulty(difficulty);
	}

	public void updateDifficulty(Difficulty difficulty) {
		difficultyDao.updateDifficulty(difficulty);
	}

}
