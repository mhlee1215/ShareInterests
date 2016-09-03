package com.si.domain;
import java.util.Date;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class FacebookResponse {

	String id;
	String birthday;
	String email;
	String first_name;
	String gender;
	String last_name;
	String link;
	String locale;
	String name;
	String timezone;
	String updated_time;
	boolean verified;

	

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getBirthday() {
		return birthday;
	}



	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getFirst_name() {
		return first_name;
	}



	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getLast_name() {
		return last_name;
	}



	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}



	public String getLink() {
		return link;
	}



	public void setLink(String link) {
		this.link = link;
	}



	public String getLocale() {
		return locale;
	}



	public void setLocale(String locale) {
		this.locale = locale;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getTimezone() {
		return timezone;
	}



	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}



	public String getUpdated_time() {
		return updated_time;
	}



	public void setUpdated_time(String updated_time) {
		this.updated_time = updated_time;
	}



	public boolean isVerified() {
		return verified;
	}



	public void setVerified(boolean verified) {
		this.verified = verified;
	}



	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\",\"birthday\":\"" + birthday
				+ "\",\"email\":\"" + email + "\",\"first_name\":\""
				+ first_name + "\",\"gender\":\"" + gender
				+ "\",\"last_name\":\"" + last_name + "\",\"link\":\"" + link
				+ "\",\"locale\":\"" + locale + "\",\"name\":\"" + name
				+ "\",\"timezone\":\"" + timezone + "\",\"updated_time\":\""
				+ updated_time + "\",\"verified\":\"" + verified + "\"}";
	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String json = "{\"id\":\"12345\",\"username\":\"myusername\",\"email\":\"myemail\u0040yahoo.it\",\"link\":\"http://www.facebook.com/mysusername\",\"updated_time\":\"2013-01-04T10:50:26+0000\"}";
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
				.create();

		FacebookResponse response = gson.fromJson(json, FacebookResponse.class);
		System.out.println(response);
	}
}