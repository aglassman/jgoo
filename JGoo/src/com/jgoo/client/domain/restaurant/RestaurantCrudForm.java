package com.jgoo.client.domain.restaurant;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.jgoo.client.crud.CrudForm;
import com.jgoo.client.crud.CrudObject;
import com.jgoo.shared.model.Restaurant;
import com.jgoo.shared.model.Tiny;

public class RestaurantCrudForm extends Composite implements CrudForm{
	
	@UiTemplate("Restaurant1.ui.xml")
	public interface Restuaruant1 extends UiBinder<Widget,RestaurantCrudForm>{}
	private static Restuaruant1 restaurant1 = GWT.create(Restuaruant1.class);
	
	@UiTemplate("Restaurant2.ui.xml")
	
	public interface Restaurant2 extends UiBinder<Widget,RestaurantCrudForm>{}
	private static Restaurant2 restaurant2 = GWT.create(Restaurant2.class);
	
	@UiField Label id;
	@UiField TextBox name;
	@UiField TextBox foodType;
	@UiField TextBox orderOnline;
	@UiField TextBox website;
	@UiField TextBox phone;
	@UiField TextBox address;
	@UiField TextBox city;
	@UiField TextBox state;
	@UiField TextBox zip;
	
	List<TextBox> fields;
	
	public RestaurantCrudForm(Class z)
	{
		if(z.equals(Restuaruant1.class))
		{
			initWidget(restaurant1.createAndBindUi(this));
		}
		else if(z.equals(Restaurant2.class))
		{
			initWidget(restaurant2.createAndBindUi(this));
		}
		else
		{
			throw new IllegalArgumentException("Not a valid binder class.");
		}
		fields = Arrays.asList(name,foodType,orderOnline,website,phone,address,city,state,zip);
	}



	@Override
	public Composite getComposite() {
		return this;
	}



	@Override
	public void clearForm() {
		id.setText(null);
		for(TextBox b: fields)
			b.setText("");
	}



	@Override
	public void loadForm(CrudObject object) {
		Restaurant restaurant = (Restaurant)object;
		id.setText(restaurant.getId() == null ? "" : restaurant.getId());
		name.setText(restaurant.getName());
		city.setText(restaurant.getCity());
		foodType.setText(restaurant.getFoodType());
		orderOnline.setText(restaurant.isOrderOnline() == null ? "" : restaurant.isOrderOnline().toString());
		website.setText(restaurant.getWebsite());
		phone.setText(restaurant.getPhone());
		address.setText(restaurant.getStreetAddress());
		state.setText(restaurant.getState());
		zip.setText(restaurant.getZip());
	}



	@Override
	public Restaurant getObjectFromForm() {
		Restaurant r = new Restaurant();
		r.setId(id.getText().equals("") ? null : id.getText());
		r.setName(name.getValue());
		r.setCity(city.getValue());
		r.setFoodType(foodType.getValue());
		r.setOrderOnline(2l);
		r.setWebsite(website.getText());
		r.setPhone(phone.getText());
		r.setStreetAddress(address.getText());
		r.setState(state.getText());
		r.setZip(zip.getText());
		return r;
	}



	@Override
	public void setEnabled(boolean b) {
		for(TextBox box: fields)
			box.setEnabled(b);
	}



	@Override
	public String getCanonicalName() {
		return Restaurant.canonicalName;
	}
	
	
}
