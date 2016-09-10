package com.si.domain;

import java.net.URL;
import java.util.List;

public class Hobby{
	int id = 0;
	String  title = "";
	int  categoryId = 0;
	int query_start = 0;
	int query_number = 0;
	
	String represent_img_id = null;
	List<String> img_ids = null;
	
	
	public String getRepresent_img_id() {
		return represent_img_id;
	}
	public void setRepresent_img_id(String represent_img_id) {
		this.represent_img_id = represent_img_id;
	}
	public List<String> getImg_ids() {
		return img_ids;
	}
	public void setImg_idss(List<String> img_ids) {
		this.img_ids = img_ids;
	}

	
	
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