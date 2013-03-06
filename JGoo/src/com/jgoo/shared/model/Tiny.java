package com.jgoo.shared.model;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.jgoo.client.crud.CrudObject;

@PersistenceCapable
public class Tiny implements CrudObject, Serializable{
	
	
	public static final String canonicalName = "com.jgoo.shared.model.Tiny";
	public static final String friendlyName = "Tiny";
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "false")
	private String id;
	
	private String name;
	private String description;
	private Date today;
	
	public Tiny(){}
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getToday() {
		return today;
	}
	public void setToday(Date today) {
		this.today = today;
	}

	@Override
	public String toString() {
		return "Tiny [id=" + id + ", name=" + name + ", description="
				+ description + ", today=" + today + "]";
	}
	
	public String getCanonicalName()
	{
		return canonicalName;
	}

	@Override
	public String getFriendlyName() {
		return friendlyName;
	}
	
	
}
