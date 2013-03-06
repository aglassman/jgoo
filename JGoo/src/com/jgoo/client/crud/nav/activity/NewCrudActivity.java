package com.jgoo.client.crud.nav.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.jgoo.client.crud.Crud;
import com.jgoo.client.crud.CrudFactory;

public class NewCrudActivity extends AbstractActivity{

	private String objectType;
	
	public NewCrudActivity(String objectType)
	{
		this.objectType = objectType;
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		Crud crud = CrudFactory.get().getCrudMap().get(objectType);
		crud.newForm();
		panel.setWidget(crud);
	}

}
