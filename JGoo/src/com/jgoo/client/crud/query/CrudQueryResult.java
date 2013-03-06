package com.jgoo.client.crud.query;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.jgoo.client.CrudLauncher;
import com.jgoo.client.crud.CrudForm;
import com.jgoo.client.crud.CrudObject;
import com.jgoo.client.crud.nav.place.EditCrudObjectPlace;
import com.jgoo.client.crud.rpc.CrudRpcServiceAsync;

public class CrudQueryResult extends Composite{
	interface MyUiBinder extends UiBinder<Widget,CrudQueryResult>{}
	private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);
	
	@UiField VerticalPanel resultPanel;
	
	
	
	public CrudQueryResult(final String canonicalName,final CrudRpcServiceAsync crudService)
	{
		
		initWidget(uiBinder.createAndBindUi(this));
		
		crudService.getAll(canonicalName,new AsyncCallback<ArrayList<CrudObject>>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(ArrayList<CrudObject> result) {
				if(result == null)
				{
					Label l = new Label("No objects found.");
					resultPanel.add(l);
					return;
				}
				for(final CrudObject c: result)
				{
					Label l = new Label(c.toString());
					l.addClickHandler(new ClickHandler() {
						
						@Override
						public void onClick(ClickEvent event) {
							CrudLauncher.getClientFactory().getPlaceController().goTo(new EditCrudObjectPlace(c.getId(), canonicalName));
						}
					});
					resultPanel.add(l);
				}
			}});
	}
}
