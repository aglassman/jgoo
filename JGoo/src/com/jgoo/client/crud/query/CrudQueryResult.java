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
import com.jgoo.client.crud.service.CrudService;

public class CrudQueryResult extends Composite{
	interface MyUiBinder extends UiBinder<Widget,CrudQueryResult>{}
	private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);
	
	@UiField VerticalPanel resultPanel;
	
	private final CrudService crudService;
	private final String objectType;
	
	
	public CrudQueryResult(String crudType,final CrudService crudService)
	{
		this.objectType = crudType;
		this.crudService = crudService;
		
		initWidget(uiBinder.createAndBindUi(this));
		
		crudService.getAll(new AsyncCallback<ArrayList<CrudObject>>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(ArrayList<CrudObject> result) {
				for(final CrudObject c: result)
				{
					Label l = new Label(c.toString());
					l.addClickHandler(new ClickHandler() {
						
						@Override
						public void onClick(ClickEvent event) {
							CrudLauncher.getClientFactory().getPlaceController().goTo(new EditCrudObjectPlace(c.getId(), objectType));
						}
					});
					resultPanel.add(l);
				}
			}});
	}
}
