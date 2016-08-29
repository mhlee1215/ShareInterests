package com.si.domain;

import java.util.ArrayList;
import java.util.List;

public class Category {
	
	private int		id				= 0;	// ID
	private String 	name			= "";
	private List<Hobby>	hobbyList   = null;
	
	public Category(){
		this.hobbyList = new ArrayList<>();
	}
	
	
	public void addHobby(Hobby hobby){
		this.hobbyList.add(hobby);
	}
	
	public int size(){
		return this.hobbyList.size();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Hobby> getHobbyList() {
		return hobbyList;
	}
	public void setHobbyList(List<Hobby> hobbyList) {
		this.hobbyList = hobbyList;
	}
	
}
