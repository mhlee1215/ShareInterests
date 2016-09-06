package com.si.domain;

public class Hobby{
	int id = 0;
	String  title = "";
	int  categoryId = 0;
	int query_start = 0;
	int query_number = 0;
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}

	public String getTitle(){
		return title;
	}
	public void setTitle(String title){
		this.title = title;
	}

	public int getCategoryId(){
		return categoryId;
	}
	public void setCategoryId(int categoryId){
		this.categoryId = categoryId;
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

	public String toString() {
		return "{\"id\":\"" + id + "\",\"title\":\"" + title + "\",\"categoryId\":\"" + categoryId + "\",\"query_start\":\"" + query_start + "\",\"query_number\":\"" + query_number + "\"}";
	}

}