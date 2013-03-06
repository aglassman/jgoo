package com.jgoo.client.crud.nav.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.jgoo.client.crud.nav.place.EditCrudObjectPlace;
import com.jgoo.client.crud.nav.place.NewCrudPlace;
import com.jgoo.client.crud.nav.place.QueryCrudObjectPlace;

public class CrudActivityMapper implements ActivityMapper{

	public CrudActivityMapper()
	{
		
	}
	
	@Override
	public Activity getActivity(Place place) {
		if(place instanceof EditCrudObjectPlace)
			return new LoadCrudActivty(((EditCrudObjectPlace) place).getObjectType(),((EditCrudObjectPlace) place).getObjectKey());
		if(place instanceof NewCrudPlace)
			return new NewCrudActivity(((NewCrudPlace)place).getObjectType());
		if(place instanceof QueryCrudObjectPlace)
			return new QueryCrudObjectActivity(((QueryCrudObjectPlace)place).getObjectCanonicalName());
		return null;
	}

}
