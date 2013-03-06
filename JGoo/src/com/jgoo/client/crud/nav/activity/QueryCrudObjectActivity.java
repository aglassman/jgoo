package com.jgoo.client.crud.nav.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.jgoo.client.crud.CrudFactory;
import com.jgoo.client.crud.query.CrudQueryResult;

public class QueryCrudObjectActivity extends AbstractActivity{

private final String canonicalName;
	
	public QueryCrudObjectActivity(String canonicalName)
	{
		this.canonicalName = canonicalName;
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		CrudQueryResult cqr = CrudFactory.get().getCrudQueryResult(canonicalName);
		panel.setWidget(cqr);
	}

}
