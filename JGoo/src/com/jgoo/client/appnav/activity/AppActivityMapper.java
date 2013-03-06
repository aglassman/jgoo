package com.jgoo.client.appnav.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.jgoo.client.appnav.place.ClearPanelPlace;
import com.jgoo.client.appnav.place.TestComponentPlace;

public class AppActivityMapper implements ActivityMapper {

	public AppActivityMapper()
	{
		super();
	}
	
	@Override
	public Activity getActivity(Place place) {
		if(place instanceof ClearPanelPlace)
			return new ClearPanelActivity();
		if(place instanceof TestComponentPlace)
			return new TestComponentActivity();
		return null;
	}

}
