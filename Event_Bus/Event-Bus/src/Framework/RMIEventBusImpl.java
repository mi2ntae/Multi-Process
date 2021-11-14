/**
 * Copyright(c) 2021 All rights reserved by Jungho Kim in MyungJi University 
 */

package Framework;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

public class RMIEventBusImpl extends UnicastRemoteObject implements RMIEventBus {
    private static final long serialVersionUID = 1L; //Default value   
    static Vector<EventQueue> eventQueueList;

	public RMIEventBusImpl() throws RemoteException {
		super();
		eventQueueList = new Vector<EventQueue>(15, 1);
	}
	public static void main(String args[]) {
		try {
			RMIEventBusImpl eventBus = new RMIEventBusImpl();
//			Properties prop = new Properties();
//			prop.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
//			prop.put(Context.PROVIDER_URL, "rmi://192.168.0.10");
//			Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
//			registry.rebind("EventBus", eventBus);
//			Context ctx = new InitialContext(prop);
//			ctx.bind("EventBus", eventBus);
//			System.setProperty("java.rmi.server.useLocalHostname",  "true");
//			System.setProperty("java.rmi.server.hostname",  "127.0.0.1");
			
	      	Naming.rebind("//127.0.0.1:1099/EventBus", eventBus);
	      	System.out.println("Event Bus is running now...");
		} catch (Exception e) {
			System.out.println("Event bus startup error: " + e);
		}
		
	}
	synchronized public long register() throws RemoteException {
		EventQueue newEventQueue = new EventQueue();
		eventQueueList.add( newEventQueue );
		System.out.println("Component (ID:"+ newEventQueue.getId() + ") is registered...");
		return newEventQueue.getId();
	}
	synchronized public void unRegister(long id) throws RemoteException {
		EventQueue eventQueue;
		for ( int i = 0; i < eventQueueList.size(); i++ ) {
			eventQueue =  eventQueueList.get(i);			
			if (eventQueue.getId() == id) {
				eventQueue = eventQueueList.remove(i);
				System.out.println("Component (ID:"+ id + ") is unregistered...");
			}
		}
	}
	synchronized public void sendEvent(Event sentEvent) throws RemoteException {
		EventQueue eventQueue;
		for ( int i = 0; i < eventQueueList.size(); i++ ) {
			eventQueue = eventQueueList.get(i);
			eventQueue.addEvent(sentEvent);
			eventQueueList.set(i, eventQueue);
		}
		System.out.println("Event Inforamtion(ID: "+sentEvent.getEventId()+", Message: "+sentEvent.getMessage()+")");
	}
	synchronized public EventQueue getEventQueue(long id) throws RemoteException {
		EventQueue originalQueue = null; 
		EventQueue copiedQueue =  null;
		for ( int i = 0; i < eventQueueList.size(); i++ ) {
			originalQueue =  eventQueueList.get(i);
			if (originalQueue.getId() == id) {
				originalQueue = eventQueueList.get(i);
				copiedQueue = originalQueue.getCopy();
				originalQueue.clearEventQueue();
			}
		}
		return copiedQueue;
	}
}