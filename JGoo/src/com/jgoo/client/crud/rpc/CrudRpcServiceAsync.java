package com.jgoo.client.crud.rpc;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.jgoo.client.crud.CrudObject;
import com.jgoo.client.crud.service.Message;

public interface CrudRpcServiceAsync {
	public void createObject(CrudObject object, AsyncCallback<Message> callback);
	public void readObject(String key,  String className, AsyncCallback<CrudObject> callback);
	public void updateObject(CrudObject object, AsyncCallback<CrudObject> callback);
	public void deleteObject(String key,  String className, AsyncCallback<Message> callback);
	public void getAll(String className, AsyncCallback<ArrayList<CrudObject>> callback);
}
