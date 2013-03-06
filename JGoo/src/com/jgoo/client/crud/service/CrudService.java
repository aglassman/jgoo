package com.jgoo.client.crud.service;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.jgoo.client.crud.CrudObject;

public interface CrudService {
	public void create(CrudObject t,AsyncCallback<Message> callback);
	public void read(String key, AsyncCallback<CrudObject> callback);
	public void update(CrudObject t, AsyncCallback<CrudObject> callback);
	public void delete(String key,AsyncCallback<Message> callback);
	public void getAll(AsyncCallback<ArrayList<CrudObject>> callback);
}
