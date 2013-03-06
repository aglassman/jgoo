package com.jgoo.client.docpanel;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.StackPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.jgoo.client.CrudLauncher;
import com.jgoo.client.appnav.place.ClearPanelPlace;
import com.jgoo.client.appnav.place.TestComponentPlace;
import com.jgoo.client.crud.nav.CrudLocationActivities;
import com.jgoo.client.crud.nav.CrudLocationActivities.ActivityDescription;

public class MainAppDoc extends Composite{
	interface MyUiBinder extends UiBinder<Widget,MainAppDoc>{}
	private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);
	
	@UiField DockLayoutPanel docLayoutPanel;
	@UiField SimplePanel centerPanel;
	@UiField StackPanel stackPanel;
	@UiField Button clear;
	@UiField Button testComponent;
	
	public MainAppDoc(ArrayList<CrudLocationActivities> activites)
	{
		initWidget(uiBinder.createAndBindUi(this));
		
		
		for(CrudLocationActivities locationActivities : activites)
		{
			VerticalPanel buttonPanel = new VerticalPanel();
			for(ActivityDescription ad : locationActivities.getActivities())
			{
				buttonPanel.add(ad.widget);
			}
			stackPanel.add(buttonPanel,locationActivities.getObjectType());
		}
		
//		form1. addClickHandler(new ClickHandler() {
//			
//			@Override
//			public void onClick(ClickEvent event) {
//				centerPanel.clear();
//				TinyCrudForm c = new TinyCrudForm(TinyCrudForm.Tiny1.class);
//				CrudService cs = new TinyService();
//				Crud crud = new Crud("Tiny CRUD Form",cs,c);
//				centerPanel.add(crud);
//			}
//		});
		
//		form2.addClickHandler(new ClickHandler() {
//			
//			@Override
//			public void onClick(ClickEvent event) {
//				TinyCrud c = new TinyCrud(TinyCrud.Tiny2.class);
//				CrudService cs = new TinyService();
//				Crud crud = new Crud("Tiny CRUD Form",cs,c);
//				centerPanel.add(crud);
//			}
//		});
//		clear.addClickHandler(new ClickHandler() {
//			
//			@Override
//			public void onClick(ClickEvent event) {
//				centerPanel.clear();
//			}
//		});
		
	}
	
	@UiHandler("clear")
	public void onClearButtonClick(ClickEvent e)
	{
		CrudLauncher.getClientFactory().getPlaceController().goTo(new ClearPanelPlace());
	}
	
	@UiHandler("testComponent")
	public void testComponenetButtonClick(ClickEvent e)
	{
		CrudLauncher.getClientFactory().getPlaceController().goTo(new TestComponentPlace());
	}
	
	public SimplePanel getCenterPanel()
	{
		return centerPanel;
	}
	
}
