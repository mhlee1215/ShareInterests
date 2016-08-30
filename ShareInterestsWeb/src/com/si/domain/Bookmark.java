package com.si.domain;

public class Bookmark{
	int id = 0;
	int  userId = 0;
	int  hobbyId = 0;
	int query_start = 0;
	int query_number = 0;
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public int getUserId(){
		return userId;
	}
	public void setUserId(int userId){
		this.userId = userId;
	}
	public int getHobbyId(){
		return hobbyId;
	}
	public void setHobbyId(int hobbyId){
		this.hobbyId = hobbyId;
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