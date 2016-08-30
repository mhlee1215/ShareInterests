package com.si.domain;

public class Asset{
	int id = 0;
	String  name = "";
	String  category = "";
	int query_start = 0;
	int query_number = 0;
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getCategory(){
		return category;
	}
	public void setCategory(String category){
		this.category = category;
	}
	public int getQuery_start(){
		return query_start;
	}
	public void setQuery_start(int query_start){
		this.query_start = query_start;
	}
	public int getQuery_number(){
		return query_number;
	}
	public void setQuery_number(int query_number){
		this.query_number = query_number;
	}
}