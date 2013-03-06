package com.jgoo.client.appnav.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class TestComponentPlace extends Place{
    public TestComponentPlace()
    {
    }

   public static class Tokenizer implements PlaceTokenizer<TestComponentPlace> {
	        @Override
	        public String getToken(TestComponentPlace place) {
	            return "testComponent";
	        }

	        @Override
	        public TestComponentPlace getPlace(String token) {
	            return new TestComponentPlace();
	        }
	    }
}
