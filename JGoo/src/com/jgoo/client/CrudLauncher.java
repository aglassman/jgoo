package com.jgoo.client;

import java.util.ArrayList;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.jgoo.client.appnav.activity.AppActivityMapper;
import com.jgoo.client.appnav.place.AppPlaceHistoryMapper;
import com.jgoo.client.appnav.place.ClearPanelPlace;
import com.jgoo.client.crud.Crud;
import com.jgoo.client.crud.CrudFactory;
import com.jgoo.client.crud.nav.CrudLocationActivities;
import com.jgoo.client.crud.rpc.CrudRpcService;
import com.jgoo.client.crud.rpc.CrudRpcServiceAsync;
import com.jgoo.client.docpanel.MainAppDoc;
import com.jgoo.client.domain.restaurant.RestaurantCrudForm;
import com.jgoo.client.domain.tiny.TinyCrudForm;
import com.jgoo.shared.model.Restaurant;
import com.jgoo.shared.model.Tiny;
/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CrudLauncher implements EntryPoint {
	

	private static ClientFactory clientFactory;
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		clientFactory = GWT.create(ClientFactory.class);
		ActivityMapper appActivityMaper = new AppActivityMapper();
		ActivityManager appActivityManager = new ActivityManager(appActivityMaper, clientFactory.getEventBus());
		
		//Any Place Tokenizers will need to be added to AppPlaceHistoryMapper before compile
		PlaceHistoryMapper appPlaceHistoryMapper = GWT.create(AppPlaceHistoryMapper.class);
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(appPlaceHistoryMapper);
		
		CrudRpcServiceAsync crudRpcService = GWT.create(CrudRpcService.class);
		
		CrudFactory.init(clientFactory.getEventBus(),crudRpcService);
		CrudFactory cf = CrudFactory.get();
		cf.register(new Tiny(), new TinyCrudForm(TinyCrudForm.Tiny1.class));
		cf.register(new Restaurant(), new RestaurantCrudForm(RestaurantCrudForm.Restuaruant1.class));
		
		ArrayList<CrudLocationActivities> activities = new ArrayList<CrudLocationActivities>();
		activities.add(new CrudLocationActivities(new Tiny()));
		activities.add(new CrudLocationActivities(new Restaurant()));
		
		MainAppDoc mainAppDoc = new MainAppDoc(activities);
		
		
		
		cf.getActivityManager().setDisplay(mainAppDoc.getCenterPanel());
		
		RootLayoutPanel.get().add(mainAppDoc);
		
		Place defaultPlace = new ClearPanelPlace();
		historyHandler.register(clientFactory.getPlaceController(), clientFactory.getEventBus(), defaultPlace);
		historyHandler.handleCurrentHistory();
		
		DOM.removeChild(RootPanel.getBodyElement(),DOM.getElementById("loading"));
		
	
		
	}
	
	public static ClientFactory getClientFactory()
	{
		return clientFactory;
	}
}
