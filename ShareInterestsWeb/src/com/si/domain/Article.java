package com.si.domain;

public class Article
{
	int id = 0;
	int  authorId = 0;
	int  hobbyId = 0;
	String  date = "";
	int  priceMin = 0;
	int  priceMax = 0;
	String  description = "";
	int query_start = 0;
	int query_number = 0;
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public int getAuthorId(){
		return authorId;
	}
	public void setAuthorId(int authorId){
		this.authorId = authorId;
	}
	public int getHobbyId(){
		return hobbyId;
	}
	public void setHobbyId(int hobbyId){
		this.hobbyId = hobbyId;
	}
	public String getDate(){
		return date;
	}
	public void setDate(String date){
		this.date = date;
	}
	public int getPriceMin(){
		return priceMin;
	}
	public void setPriceMin(int priceMin){
		this.priceMin = priceMin;
	}
	public int getPriceMax(){
		return priceMax;
	}
	public void setPriceMax(int priceMax){
		this.priceMax = priceMax;
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
}