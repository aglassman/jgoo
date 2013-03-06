package com.jgoo.client.crud;

import java.util.HashMap;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.web.bindery.event.shared.EventBus;
import com.jgoo.client.crud.nav.activity.CrudActivityMapper;
import com.jgoo.client.crud.query.CrudQueryResult;
import com.jgoo.client.crud.service.CrudService;
import com.jgoo.client.domain.tiny.TinyCrudForm;
import com.jgoo.client.domain.tiny.TinyService;


public class CrudFactory {
	
	private final HashMap<String,CrudService> serviceMap;
	private final HashMap<String,Crud> crudMap;
	private final ActivityManager activityManager;
	
	private static CrudFactory singleton;
	
	private CrudFactory(EventBus eventBus)
	{
		serviceMap = new HashMap<String, CrudService>();
		crudMap = new HashMap<String,Crud>();
		ActivityMapper activityMapper = new CrudActivityMapper();
		activityManager = new ActivityManager(activityMapper, eventBus);
	}
	
	public static void init(EventBus eventBus)
	{
		if(singleton == null)
			singleton = new CrudFactory(eventBus);
	}
	
	public static CrudFactory get()
	{
		return singleton;
	}

	public HashMap<String, Crud> getCrudMap() {
		return crudMap;
	}

	public ActivityManager getActivityManager() {
		return activityManager;
	}

	public HashMap<String, CrudService> getCrudServiceMap()
	{
		return serviceMap;
	}

	public void register(String objectType, CrudService crudService, CrudForm crudForm) {
		crudMap.put(objectType, new Crud(objectType, crudService, crudForm));
		serviceMap.put(objectType, crudService);
		
	}

	public CrudQueryResult getCrudQueryResult(String objectType) {
		return new CrudQueryResult(objectType, serviceMap.get(objectType));
	}
	
}
