package com.jgoo.shared.model;

import java.io.Serializable;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.jgoo.client.crud.CrudObject;


@PersistenceCapable
public class Restaurant implements CrudObject, Serializable{
	
	private static final String className = "com.jgoo.shared.model.Restaurant";
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
	private String id;
	
	@Persistent
	private String name;
	@Persistent
	private String streetAddress;
	@Persistent
	private String city;
	@Persistent
	private String state;
	@Persistent
	private String zip;
	@Persistent
	private String phone;
	@Persistent
	private String website;
	@Persistent
	private Long orderOnline;
	@Persistent
	private String foodType;
	
	
	public Restaurant(){}
	public Restaurant(String id, String name, String streetAddress, String city,
			String state, String zip, String phone, String website,
			Long orderOnline, String foodType) {
		this.id = id;
		this.name = name;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.website = website;
		this.orderOnline = orderOnline;
		this.foodType = foodType;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public Long isOrderOnline() {
		return orderOnline;
	}
	public void setOrderOnline(Long orderOnline) {
		this.orderOnline = orderOnline;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	
	
	
	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", streetAddress="
				+ streetAddress + ", city=" + city + ", state=" + state
				+ ", zip=" + zip + ", phone=" + phone + ", website=" + website
				+ ", orderOnline=" + orderOnline + ", foodType=" + foodType
				+ "]";
	}
	public static String getCanonicalName()
	{
		return className;
	}
}
