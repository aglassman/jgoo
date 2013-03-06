package com.jgoo.client.crud.nav.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class NewCrudPlace extends Place{
	private String objectType;

    public NewCrudPlace(String objectType)
    {
    	this.objectType = objectType;
    }

   public String getObjectType()
   {
	   return objectType;
   }
	
    @Prefix("crud-new")
	 public static class Tokenizer implements PlaceTokenizer<NewCrudPlace> {
	        @Override
	        public String getToken(NewCrudPlace place) {
	            return place.getObjectType();
	        }

	        @Override
	        public NewCrudPlace getPlace(String token) {
	            return new NewCrudPlace(token);
	        }
	    }
}
