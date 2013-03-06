package com.jgoo.client.crud.nav.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.jgoo.client.crud.Crud;
import com.jgoo.client.crud.CrudFactory;

public class LoadCrudActivty extends AbstractActivity{

	private final String key;
	private final String objectType;
	
	public LoadCrudActivty(String objectType, String key)
	{
		this.key = key;
		this.objectType = objectType;
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		Crud crud = CrudFactory.get().getCrudMap().get(objectType);
		panel.setWidget(crud);
		crud.load(key);
	}

}
