package com.jgoo.client.appnav.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class ClearPanelPlace extends Place{
	
    public ClearPanelPlace()
    {
    }

   @Prefix("app")
   public static class Tokenizer implements PlaceTokenizer<ClearPanelPlace> {
	        @Override
	        public String getToken(ClearPanelPlace place) {
	            return "clear";
	        }

	        @Override
	        public ClearPanelPlace getPlace(String token) {
	            return new ClearPanelPlace();
	        }
	    }
}
