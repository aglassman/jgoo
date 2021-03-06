package com.jgoo.client.crud.nav;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;
import com.jgoo.client.CrudLauncher;
import com.jgoo.client.crud.Crud;
import com.jgoo.client.crud.CrudObject;
import com.jgoo.client.crud.nav.activity.QueryCrudObjectActivity;
import com.jgoo.client.crud.nav.place.NewCrudPlace;
import com.jgoo.client.crud.nav.place.QueryCrudObjectPlace;

public class CrudLocationActivities {
	
	private CrudObject crudObject;
	
	public  class ActivityDescription
	{
		public final String description;
		public final Widget widget;
		public ActivityDescription(String d, Widget w)
		{
			description = d;
			widget = w;
		}
	}
	
	public String getObjectCanonicalName()
	{
		return crudObject.getCanonicalName();
	}
	
	public String getObjectFriendlyName()
	{
		return crudObject.getFriendlyName();
	}
	
	public CrudLocationActivities(CrudObject curdObject)
	{
		this.crudObject = curdObject; 
	}
	
	public ArrayList<ActivityDescription> getActivities()
	{
		ArrayList<ActivityDescription> activities = new ArrayList<CrudLocationActivities.ActivityDescription>();
		Button b = new Button("New");
		b.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				CrudLauncher.getClientFactory().getPlaceController().goTo(new NewCrudPlace(crudObject.getCanonicalName()));
			}
		});
		
		activities.add(new ActivityDescription("New", b));
		
		
		Button b2 = new Button("Get All");
		b2.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				CrudLauncher.getClientFactory().getPlaceController().goTo(new QueryCrudObjectPlace(crudObject.getCanonicalName()));
			}
		});
		
		activities.add(new ActivityDescription("Get All", b2));
		return activities;
	}
}
