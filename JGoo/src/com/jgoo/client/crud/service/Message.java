package com.jgoo.client.crud.service;

import java.io.Serializable;

public class Message implements Serializable{
	public String message;
	public MessageType type;
	public enum MessageType{INFO,SUCCESS,WARNING,FAILURE}
	public String key;
	public Message(){}
	
	public Message(MessageType type, String message)
	{
		this.type = type;
		this.message = message;
	}
}
