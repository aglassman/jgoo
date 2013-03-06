package com.jgoo.client.crud.nav.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class QueryCrudObjectPlace extends Place{
	private String type;
    
	public QueryCrudObjectPlace(String type) {
       this.type=type;
    }

    public String getObjectType()
    {
    	return type;
    }
	
    @Prefix("crud-query")
	 public static class Tokenizer implements PlaceTokenizer<QueryCrudObjectPlace> {
    	
    		
    	
	        @Override
	        public String getToken(QueryCrudObjectPlace place) {
	            return place.getObjectType();
	        }

	        @Override
	        public QueryCrudObjectPlace getPlace(String token) {
	        	return new QueryCrudObjectPlace(token);
	        }
	    }
}
