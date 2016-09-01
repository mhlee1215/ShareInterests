package com.si.domain;

public class Hashtag{
	int id = 0;
	int  articleId = 0;
	String  name = "";
	int query_start = 0;
	int query_number = 0;
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}

	public int getArticleId(){
		return articleId;
	}
	public void setArticleId(int articleId){
		this.articleId = articleId;
	}

	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
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
		return "{\"id\":\"" + id + "\",\"articleId\":\"" + articleId + "\",\"name\":\"" + name + "\",\"query_start\":\"" + query_start + "\",\"query_number\":\"" + query_number + "\"}";
	}

}