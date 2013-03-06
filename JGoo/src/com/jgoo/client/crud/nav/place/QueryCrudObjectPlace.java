package com.jgoo.client.crud.nav.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class QueryCrudObjectPlace extends Place{
	private String canonicalName;
    
	public QueryCrudObjectPlace(String canonicalName) {
       this.canonicalName=canonicalName;
    }

    public String getObjectCanonicalName()
    {
    	return canonicalName;
    }
	
    @Prefix("crud-query")
	 public static class Tokenizer implements PlaceTokenizer<QueryCrudObjectPlace> {
    	
    		
    	
	        @Override
	        public String getToken(QueryCrudObjectPlace place) {
	            return place.getObjectCanonicalName();
	        }

	        @Override
	        public QueryCrudObjectPlace getPlace(String token) {
	        	return new QueryCrudObjectPlace(token);
	        }
	    }
}
