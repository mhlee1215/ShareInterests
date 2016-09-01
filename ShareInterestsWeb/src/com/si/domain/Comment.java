package com.si.domain;

public class Comment{
	int id = 0;
	int  userId = 0;
	int  articleId = 0;
	String  description = "";
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

	public int getArticleId(){
		return articleId;
	}
	public void setArticleId(int articleId){
		this.articleId = articleId;
	}

	public String getDescription(){
		return description;
	}
	public void setDescription(String description){
		this.description = description;
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
		return "{\"id\":\"" + id + "\",\"userId\":\"" + userId + "\",\"articleId\":\"" + articleId + "\",\"description\":\"" + description + "\",\"query_start\":\"" + query_start + "\",\"query_number\":\"" + query_number + "\"}";
	}

}