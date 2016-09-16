package com.si.domain;

public class Article{
	int id = 0;
	int  authorId = 0;
	int  hobbyId = 0;
	String  date = "";
	int  priceMin = 0;
	int  priceMax = 0;
	String  description = "";
	int  practiceHour = 0;
	int query_start = 0;
	int query_number = 0;
	String title = "";
	String articleAbstract = "";
	int likes = 0;
	
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArticleAbstract() {
		return articleAbstract;
	}
	public void setArticleAbstract(String articleAbstract) {
		this.articleAbstract = articleAbstract;
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

	public int getPracticeHour(){
		return practiceHour;
	}
	public void setPracticeHour(int practiceHour){
		this.practiceHour = practiceHour;
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

	@Override
	public String toString() {
		return "Article [id=" + id + ", authorId=" + authorId + ", hobbyId=" + hobbyId + ", date=" + date
				+ ", priceMin=" + priceMin + ", priceMax=" + priceMax + ", description=" + description
				+ ", practiceHour=" + practiceHour + ", query_start=" + query_start + ", query_number=" + query_number
				+ ", title=" + title + ", articleAbstract=" + articleAbstract + "]";
	}

}