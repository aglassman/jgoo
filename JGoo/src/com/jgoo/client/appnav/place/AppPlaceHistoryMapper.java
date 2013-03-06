package com.jgoo.client.appnav.place;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import com.jgoo.client.crud.nav.place.EditCrudObjectPlace;
import com.jgoo.client.crud.nav.place.NewCrudPlace;
import com.jgoo.client.crud.nav.place.QueryCrudObjectPlace;

@WithTokenizers({ClearPanelPlace.Tokenizer.class,EditCrudObjectPlace.Tokenizer.class, NewCrudPlace.Tokenizer.class,QueryCrudObjectPlace.Tokenizer.class, TestComponentPlace.Tokenizer.class})
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {

}
