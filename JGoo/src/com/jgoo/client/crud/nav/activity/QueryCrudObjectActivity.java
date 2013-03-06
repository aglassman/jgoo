package com.jgoo.client.crud.nav.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.jgoo.client.crud.Crud;
import com.jgoo.client.crud.CrudFactory;
import com.jgoo.client.crud.query.CrudQueryResult;
import com.jgoo.client.domain.tiny.TinyCrudForm;
import com.jgoo.client.domain.tiny.TinyService;
import com.jgoo.client.domain.tiny.TinyCrudForm.Tiny1;
import com.jgoo.shared.model.Tiny;

public class QueryCrudObjectActivity extends AbstractActivity{

private final String objectType;
	
	public QueryCrudObjectActivity(String objectType)
	{
		this.objectType = objectType;
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		CrudQueryResult cqr = CrudFactory.get().getCrudQueryResult(objectType);
		panel.setWidget(cqr);
	}

}
