package com.jgoo.client.domain.restaurant;

import java.util.ArrayList;
import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.jgoo.client.crud.CrudObject;
import com.jgoo.client.crud.rpc.CrudRpcService;
import com.jgoo.client.crud.rpc.CrudRpcServiceAsync;
import com.jgoo.client.crud.service.CrudService;
import com.jgoo.client.crud.service.Message;
import com.jgoo.shared.model.Restaurant;
import com.jgoo.shared.model.Tiny;

public class RestaurantService implements CrudService{

	private static CrudRpcServiceAsync crudRpcService = GWT.create(CrudRpcService.class);
	
	@Override
	public void create(CrudObject object,AsyncCallback<Message> callback) {
		crudRpcService.createObject(object, callback);
	}

	@Override
	public void read(String key,AsyncCallback<CrudObject> callback) {
		crudRpcService.readObject(key,Restaurant.getCanonicalName(),callback);
	}

	@Override
	public void update(CrudObject object,AsyncCallback<CrudObject> callback) {
		crudRpcService.updateObject(object, callback);
	}

	@Override
	public void delete(String key,AsyncCallback<Message> callback) {
		crudRpcService.deleteObject(key,Restaurant.getCanonicalName(),callback);
	}

	@Override
	public void getAll(AsyncCallback<ArrayList<CrudObject>> callback) {
		crudRpcService.getAll(Restaurant.getCanonicalName(),callback);
	}

}
