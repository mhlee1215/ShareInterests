package com.si.domain;

public class Difficulty{
	int id = 0;
	int  articleId = 0;
	String  level = "";
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
	public String getLevel(){
		return level;
	}
	public void setLevel(String level){
		this.level = level;
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