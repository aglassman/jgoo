package com.jgoo.client.crud;


import com.google.gwt.user.client.ui.Composite;


public interface CrudForm {
	public abstract void clearForm();
	public abstract void loadForm(CrudObject object);
	public abstract CrudObject getObjectFromForm();
	public abstract Composite getComposite();
	public abstract void setEnabled(boolean b);
}
