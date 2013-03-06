package com.jgoo.server.crud.rpc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;


import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.jgoo.client.crud.CrudObject;
import com.jgoo.client.crud.rpc.CrudRpcService;
import com.jgoo.client.crud.service.Message;
import com.jgoo.client.crud.service.Message.MessageType;
import com.jgoo.shared.model.Restaurant;
import com.jgoo.shared.model.Tiny;

public class CrudServiceImpl extends RemoteServiceServlet implements CrudRpcService{

	private static final PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("transactions-optional");
	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	@Override
	public Message createObject(CrudObject object) {
		object.setId(null);		
		PersistenceManager pm = pmf.getPersistenceManager();
		
		try{
			pm.makePersistent(object);
		}
		catch(Exception e)
		{
			return new Message(Message.MessageType.FAILURE,e.getMessage());
		}
		 finally {
			pm.close();
		}
		Message m = new Message(Message.MessageType.SUCCESS,"Tiny successfully saved.");
		m.key = object.getId();
		return m;
	}
	
	@Override
	public CrudObject readObject(String key,  String className)
	{
		if(key == null)
			return null;
		
		PersistenceManager pm = pmf.getPersistenceManager();
		
		try{
			return (CrudObject)pm.detachCopy(pm.getObjectById(Class.forName(className),key));
		}
		catch(JDOObjectNotFoundException e)
		{
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		finally {
			pm.close();
		}
	}
	
	@Override
	public CrudObject updateObject(CrudObject object) {
		
		if(object.getId() == null || object.getId().equals(""))
		{
			return null;
		}
		
		PersistenceManager pm = pmf.getPersistenceManager();
		
		try{
			pm.makePersistent(object);
			object = pm.detachCopy(object);
			return object;
		}
		catch(Exception e)
		{
			return null;
		}
		 finally {
			pm.close();
		}
	}
	
	@Override
	public Message deleteObject(String key, String className) {
		
		if(key == null || key.equals(""))
		{
			return new Message(MessageType.FAILURE,"Cannot delete object, no id.");
		}
		
		PersistenceManager pm = pmf.getPersistenceManager();
		
		try{
			pm.deletePersistent(pm.getObjectById(Class.forName(className), key));
			return new Message(MessageType.SUCCESS,"Object successfully deleted.");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return new Message(MessageType.FAILURE,"Failed to delete object: " +e.getMessage());
		}
		 finally {
			pm.close();
		}
	}

	@Override
	public ArrayList<CrudObject> getAll(String className) {
		List results = null;
		PersistenceManager pm = pmf.getPersistenceManager();
		try{
			Query q = pm.newQuery(Class.forName(className));
			results = (List)q.execute();
			return new ArrayList<CrudObject>(pm.detachCopyAll(results));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally
		{
			pm.close();
		}
		return null;
//		ArrayList<CrudObject> results = new ArrayList<CrudObject>();
//		String[] spit = className.split("\\.");
//		
//		com.google.appengine.api.datastore.Query query = new com.google.appengine.api.datastore.Query(spit[spit.length-1]);
//		com.google.appengine.api.datastore.PreparedQuery pq = datastore.prepare(query);
//		for(Entity result :pq.asIterable())
//		{
//			if(spit[spit.length-1].equalsIgnoreCase("tiny"))
//			{
//				Tiny t = new Tiny();
//				t.setId(KeyFactory.keyToString(result.getKey()));
//				t.setName((String)result.getProperty("name"));
//				t.setDescription((String)result.getProperty("description"));
//				t.setToday((Date)result.getProperty("today"));
//				results.add(t);
//			}
//			else if(spit[spit.length-1].equalsIgnoreCase("restaurant"))
//			{
//				Restaurant r = new Restaurant();
//				r.setId(KeyFactory.keyToString(result.getKey()));
//				r.setName((String)result.getProperty("name"));
//				r.setCity((String)result.getProperty("city"));
//				r.setFoodType((String)result.getProperty("foodType"));
//				results.add(r);
//			}
//		}
//		
//		return results;
	}

}
