package com.jgoo.client.appnav.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class ClearPanelActivity extends AbstractActivity{

	public ClearPanelActivity()
	{
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		panel.setWidget(null);
	}

}

