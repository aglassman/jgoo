package com.jgoo.client.crud;

import java.util.HashMap;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.web.bindery.event.shared.EventBus;
import com.jgoo.client.crud.nav.activity.CrudActivityMapper;
import com.jgoo.client.crud.query.CrudQueryResult;
import com.jgoo.client.crud.rpc.CrudRpcServiceAsync;


public class CrudFactory {
	
	private final CrudRpcServiceAsync crudRpcService;
	private final HashMap<String,Crud> crudMap;
	private final ActivityManager activityManager;
	
	private static CrudFactory singleton;
	
	private CrudFactory(EventBus eventBus, CrudRpcServiceAsync crudRpcService)
	{
		this.crudRpcService = crudRpcService;
		this.crudMap = new HashMap<String,Crud>();
		ActivityMapper activityMapper = new CrudActivityMapper();
		activityManager = new ActivityManager(activityMapper, eventBus);
	}
	
	public static void init(EventBus eventBus, CrudRpcServiceAsync crudRpcService)
	{
		if(singleton == null)
			singleton = new CrudFactory(eventBus,crudRpcService);
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
	

	public void register(CrudObject crudObject, CrudForm crudForm) {
		crudMap.put(crudObject.getCanonicalName(), new Crud(crudObject, crudRpcService, crudForm));
	}

	public CrudQueryResult getCrudQueryResult(String canonicalName) {
		return new CrudQueryResult(canonicalName,crudRpcService);
	}
	
}
