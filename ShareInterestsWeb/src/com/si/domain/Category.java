package com.si.domain;

import java.util.ArrayList;
import java.util.List;

public class Category {
	
	private int		id				= 0;	// ID
	private String 	name			= "";
	private List<Hobby>	hobbyList   = null;
	int query_start = 0;
	int query_number = 0;
	
	public int getQuery_start() {
		return query_start;
	}


	public void setQuery_start(int query_start) {
		this.query_start = query_start;
	}


	public int getQuery_number() {
		return query_number;
	}


	public void setQuery_number(int query_number) {
		this.query_number = query_number;
	}


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


	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", hobbyList=" + hobbyList + ", query_start=" + query_start
				+ ", query_number=" + query_number + "]";
	}
}
