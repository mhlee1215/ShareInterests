package com.si.domain;

public class Article {
	int id;
	int authorId;
	int hobbyId;
	String date;
	int priceMin; 
	int priceMax;
	String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public int getHobbyId() {
		return hobbyId;
	}
	public void setHobbyId(int hobbyId) {
		this.hobbyId = hobbyId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getPriceMin() {
		return priceMin;
	}
	public void setPriceMin(int priceMin) {
		this.priceMin = priceMin;
	}
	public int getPriceMax() {
		return priceMax;
	}
	public void setPriceMax(int priceMax) {
		this.priceMax = priceMax;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\",\"authorId\":\"" + authorId + "\",\"hobbyId\":\"" + hobbyId + "\",\"date\":\""
				+ date + "\",\"priceMin\":\"" + priceMin + "\",\"priceMax\":\"" + priceMax + "\",\"description\":\""
				+ description + "\"}";
	}
}
