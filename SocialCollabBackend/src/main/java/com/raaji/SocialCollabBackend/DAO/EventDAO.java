package com.raaji.SocialCollabBackend.DAO;

import java.util.List;

import com.raaji.SocialCollabBackend.Model.Event;

public interface EventDAO
{
	public boolean addEvent(Event event);
	
	public boolean deleteEvent(int id);
	
	public Event getEvent(int id);
	
	public List<Event> listEvent();
	
}
