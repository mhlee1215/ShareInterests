package com.si.domain;

public class Feedback{
	public final static String TYPE_LIKE = "like";
	public final static String TYPE_USEFUL = "useful";
	public final static String TYPE_FUNNY = "funny";
	
	int id = 0;
	int  userId = 0;
	int  articleId = 0;
	String type = "";
	int query_start = 0;
	int query_number = 0;
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getUserId(){
		return userId;
	}
	public void setUserId(int userId){
		this.userId = userId;
	}

	public int getArticleId(){
		return articleId;
	}
	public void setArticleId(int articleId){
		this.articleId = articleId;
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
		return "{\"id\":\"" + id + "\",\"userId\":\"" + userId + "\",\"articleId\":\"" + articleId + "\",\"query_start\":\"" + query_start + "\",\"query_number\":\"" + query_number + "\"}";
	}

}