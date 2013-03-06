package com.jgoo.client.domain.tiny;

import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.jgoo.client.crud.CrudForm;
import com.jgoo.client.crud.CrudObject;
import com.jgoo.shared.model.Tiny;

public class TinyCrudForm extends Composite implements CrudForm{
	
	@UiTemplate("Tiny1.ui.xml")
	public interface Tiny1 extends UiBinder<Widget,TinyCrudForm>{}
	private static Tiny1 tiny1 = GWT.create(Tiny1.class);
	
	@UiTemplate("Tiny2.ui.xml")
	public interface Tiny2 extends UiBinder<Widget,TinyCrudForm>{}
	private static Tiny2 tiny2 = GWT.create(Tiny2.class);
	
	@UiField Label id;
	@UiField TextBox nameVal;
	@UiField TextBox descriptionVal;
	@UiField TextBox todayVal;
	
	
	
	public TinyCrudForm(Class z)
	{
		if(z.equals(Tiny1.class))
		{
			initWidget(tiny1.createAndBindUi(this));
		}
		else if(z.equals(Tiny2.class))
		{
			initWidget(tiny2.createAndBindUi(this));
		}
		else
		{
			throw new IllegalArgumentException("Not a valid binder class.");
		}
		
	}



	@Override
	public Composite getComposite() {
		return this;
	}



	@Override
	public void clearForm() {
		id.setText(null);
		nameVal.setText("");
		descriptionVal.setText("");
		todayVal.setText("");
	}



	@Override
	public void loadForm(CrudObject object) {
		Tiny tiny = (Tiny)object;
		id.setText(tiny.getId() == null ? "" : tiny.getId());
		nameVal.setText(tiny.getName());
		descriptionVal.setText(tiny.getDescription());
		todayVal.setText(tiny.getToday() == null ? "" : tiny.getToday().toString());
	}



	@Override
	public Tiny getObjectFromForm() {
		Tiny t = new Tiny();
		t.setId(id.getText().equals("") ? null : id.getText());
		t.setName(nameVal.getValue());
		t.setDescription(descriptionVal.getValue());
		t.setToday(new Date());
		return t;
	}



	@Override
	public void setEnabled(boolean b) {
		nameVal.setEnabled(b);
		descriptionVal.setEnabled(b);
		todayVal.setEnabled(b);
	}
	
	
}
