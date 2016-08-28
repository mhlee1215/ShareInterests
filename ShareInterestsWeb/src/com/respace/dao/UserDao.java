package com.respace.dao;

import java.util.List;

import com.respace.domain.User;


public interface UserDao {
	public User readUser(User user);
	public void createUser(User user);
	public void deleteUser(User user);
	public void updateUser(User user);
	public List<User> findAll();
}
