package com.jgoo.client.crud;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.jgoo.client.CrudLauncher;
import com.jgoo.client.crud.nav.place.EditCrudObjectPlace;
import com.jgoo.client.crud.nav.place.NewCrudPlace;
import com.jgoo.client.crud.rpc.CrudRpcServiceAsync;
import com.jgoo.client.crud.service.Message;
import com.jgoo.client.crud.service.Message.MessageType;

public class Crud extends Composite{
	interface MyUiBinder extends UiBinder<Widget,Crud>{}
	private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);
	
	@UiField VerticalPanel crudPanel;
	@UiField Label title;
	@UiField Label message;
	@UiField SimplePanel fields;
	@UiField Button create;
	@UiField Button read;
	@UiField Button update;
	@UiField Button delete;
	
	private final CrudRpcServiceAsync crudRpcService;
	private final CrudForm crudForm;
	private final CrudObject crudObject;
	
	
	public Crud(CrudObject crudObject,final CrudRpcServiceAsync crudRpcService, final CrudForm crudForm)
	{
		this.crudObject = crudObject;
		this.crudRpcService = crudRpcService;
		this.crudForm = crudForm;
		
		initWidget(uiBinder.createAndBindUi(this));
		title.setText(crudObject.getFriendlyName() + " CRUD");
		fields.add(crudForm.getComposite());
		
	}
	
	private void setMessage(Message m)
	{
		if(m == null)
		{
			message.setText(null);
			return;
		}
		switch(m.type){
			case FAILURE:
				message.setStyleName("gwt-Label messageRed");
				break;
			case INFO:
				message.setStyleName("gwt-Label messageBlue");
				break;
			case SUCCESS:
				message.setStyleName("gwt-Label messageGreen");
				break;
			case WARNING:
				message.setStyleName("gwt-Label messageYellow");
				break;
		}
		message.setText(m.message);
	}
	
	private void setEnabled(boolean b)
	{
		create.setEnabled(b);
		read.setEnabled(b);
		update.setEnabled(b);
		delete.setEnabled(b);
		crudForm.setEnabled(b);
	}
	
	@UiHandler("create")
	void onClickCreate(ClickEvent e)
	{
		setEnabled(false);
		final CrudObject object = crudForm.getObjectFromForm();
		crudRpcService.createObject(object,new AsyncCallback<Message>() {
			
			@Override
			public void onSuccess(Message result) {
				setMessage(result);
				if(result.key != null)
					CrudLauncher.getClientFactory().getPlaceController().goTo(new EditCrudObjectPlace(result.key, crudObject.getCanonicalName()));
			}
			
			@Override
			public void onFailure(Throwable caught) {
				setMessage(new Message(MessageType.FAILURE,"Service failure: "+caught.getMessage()));
				setEnabled(true);
			}
		});
	}
	
	@UiHandler("read")
	void onClickRead(ClickEvent e)
	{
		setEnabled(false);
		CrudObject object = crudForm.getObjectFromForm();
		crudRpcService.readObject(object.getId(),object.getCanonicalName(),new AsyncCallback<CrudObject>() {

			@Override
			public void onFailure(Throwable caught) {
				setMessage(new Message(MessageType.FAILURE,caught.getMessage()));
				setEnabled(true);
			}

			@Override
			public void onSuccess(CrudObject result) {
				if(result != null)
				{
					crudForm.loadForm(result);
					setMessage(new Message(MessageType.SUCCESS,"Object reloaded."));
				}
				else
				{
					setMessage(new Message(MessageType.WARNING,"No object returned."));
				}
				setEnabled(true);
		}});
	}
	
	@UiHandler("update")
	void onClickUpdate(ClickEvent e)
	{
		setEnabled(false);
		CrudObject object = crudForm.getObjectFromForm();
		crudRpcService.updateObject(object,new AsyncCallback<CrudObject>() {

			@Override
			public void onFailure(Throwable caught) {
				setMessage(new Message(MessageType.FAILURE,caught.getMessage()));
				setEnabled(true);
			}

			@Override
			public void onSuccess(CrudObject result) {
				if(result != null)
				{
					crudForm.loadForm(result);
					setMessage(new Message(MessageType.SUCCESS,"Object updated."));
				}
				else
				{
					setMessage(new Message(MessageType.WARNING,"Update failed, No object returned."));
				}
				setEnabled(true);
			}
		});
	}
	
	
	@UiHandler("delete")
	void onClickDelete(ClickEvent e)
	{
		final CrudObject object = crudForm.getObjectFromForm();
		setEnabled(false);
		crudRpcService.deleteObject(object.getId(),object.getCanonicalName(), new AsyncCallback<Message>() {
			
			@Override
			public void onSuccess(Message result) {
				crudForm.clearForm();
				setMessage(result);
				setEnabled(true);
				CrudLauncher.getClientFactory().getPlaceController().goTo(new NewCrudPlace(crudObject.getCanonicalName()));
			}
			
			@Override
			public void onFailure(Throwable caught) {
				setMessage(new Message(MessageType.FAILURE,caught.getMessage()));
				setEnabled(true);
			}
		});
	}
	
	public void load(String key)
	{
		setEnabled(false);
		crudRpcService.readObject(key,crudForm.getCanonicalName(), new AsyncCallback<CrudObject>(){

			@Override
			public void onFailure(Throwable caught) {
				setMessage(new Message(MessageType.FAILURE,caught.getMessage()));
				setEnabled(true);
			}

			@Override
			public void onSuccess(CrudObject result) {
				if(result != null)
				{
					crudForm.loadForm(result);
				}
				else
				{
					setMessage(new Message(MessageType.WARNING,"No object returned."));
				}
				setEnabled(true);
			}});
	}
	
	@UiHandler("message")
	void onMessageWasClicked(ClickEvent event)
	{
		message.setText(null);
	}
	
	public String getCrudType()
	{
		return crudObject.getCanonicalName();
	}
	
	public void reset()
	{
		crudForm.clearForm();
	}
	
	public void newForm()
	{
		crudForm.clearForm();
		setMessage(null);
	}
}
