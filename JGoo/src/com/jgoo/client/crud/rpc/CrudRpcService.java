package com.jgoo.client.crud.rpc;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.jgoo.client.crud.CrudObject;
import com.jgoo.client.crud.service.Message;

@RemoteServiceRelativePath("crud")
public interface CrudRpcService extends RemoteService{
	public Message createObject(CrudObject object);
	public CrudObject readObject(String key, String className);
	public CrudObject updateObject(CrudObject object);
	public Message deleteObject(String key,  String className);
	public ArrayList<CrudObject> getAll(String className);
}
