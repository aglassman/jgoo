package com.jgoo.client.crud.nav.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class EditCrudObjectPlace extends Place{
	private String objectKey;
	private String type;
    public EditCrudObjectPlace(String key,String type) {
        this.objectKey = key;
        this.type=type;
    }

    public String getObjectKey() {
        return objectKey;
    }
    
    public String getObjectType()
    {
    	return type;
    }
	
    @Prefix("crud-edit")
	 public static class Tokenizer implements PlaceTokenizer<EditCrudObjectPlace> {
    	
    		
    	
	        @Override
	        public String getToken(EditCrudObjectPlace place) {
	            return place.getObjectType() + ":" + place.getObjectKey();
	        }

	        @Override
	        public EditCrudObjectPlace getPlace(String token) {
	        	String[] tokens = token.split(":");
	        	return new EditCrudObjectPlace(tokens[1],tokens[0]);
	        }
	    }
}
