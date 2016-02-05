package it.experis.service.ds;

import it.experis.service.bean.Event;
import it.experis.service.bean.Resource;

import java.util.ArrayList;
import java.util.List;


public class CalendarDS {
	
	private List<Event> data;

	public CalendarDS() {
		
	}
	
	public List<Event> getData() {
		return data;
	}

	public void setData(List<Event> data) {
		this.data = data;
	}

	public List<Resource> getAllResources() {
		List<Resource> resourceList = new ArrayList<Resource>();
		Resource r1 = new Resource();
		Resource r2 = new Resource();
		Resource r3 = new Resource();
		Resource r4 = new Resource();
		Resource r5 = new Resource();
		Resource r6 = new Resource();
		Resource r7 = new Resource();
		Resource r8 = new Resource();
		Resource r9 = new Resource();
		
		r1.setId("luogo_1"); r1.setLuogo("luogo_1"); r1.setNome("Martin Andrea"); r1.setEventColor("magenta");
		r2.setId("luogo_2"); r2.setLuogo("luogo_1"); r2.setNome("Marabelli Angelica"); r2.setEventColor("red");
		r3.setId("luogo_3"); r3.setLuogo("luogo_1"); r3.setNome("Mannino Maddalena"); r3.setEventColor("blu");
		r4.setId("luogo_4"); r4.setLuogo("luogo_2"); r4.setNome("Mantica Paola"); r4.setEventColor("yellow");
		r5.setId("luogo_5"); r5.setLuogo("luogo_2"); r5.setNome("Serena Angel"); r5.setEventColor("green");
		r6.setId("luogo_6"); r6.setLuogo("luogo_2"); r6.setNome("Alex Moore"); r6.setEventColor("red");		
		r7.setId("luogo_7"); r7.setLuogo("luogo_2"); r7.setNome("Rolando Scevola"); r7.setEventColor("green");
		r8.setId("luogo_8"); r8.setLuogo("luogo_2"); r8.setNome("Snarh Janin"); r8.setEventColor("orange");
		r9.setId("luogo_9"); r9.setLuogo("luogo_2"); r9.setNome("Serena Dramis"); r9.setEventColor("ciano");
		
		resourceList.add(r1);
		resourceList.add(r2);
		resourceList.add(r3);
		resourceList.add(r4);
		resourceList.add(r5);
		resourceList.add(r6);
		resourceList.add(r7);
		resourceList.add(r8);
		resourceList.add(r9);

		return resourceList;
	}
	

		
	
	public List<Event> getAllEvents() {
		List<Event> eventList = new ArrayList<Event>();
		Event ev1 = new Event();
		Event ev2 = new Event();
		Event ev3 = new Event();
		Event ev4 = new Event();
		Event ev5 = new Event();
		Event ev6 = new Event();
		Event ev7 = new Event();
		Event ev8 = new Event();
		ev1.setId(1); ev1.setResourceId("luogo_1"); ev1.setStart("2015-12-25T08:00:00"); ev1.setEnd("2015-12-25T13:00:00"); ev1.setTitle("MAT"); ev1.setColor("orange");
		ev2.setId(2); ev2.setResourceId("luogo_1"); ev2.setStart("2015-12-26T15:00:00"); ev2.setEnd("2015-12-26T21:00:00"); ev2.setTitle("POM"); ev2.setColor("orange");
		ev3.setId(3); ev3.setResourceId("luogo_2"); ev3.setStart("2015-12-27T08:00:00"); ev3.setEnd("2015-12-27T13:00:00"); ev3.setTitle("MAT"); ev3.setColor("magenta");
		ev4.setId(4); ev4.setResourceId("luogo_2"); ev4.setStart("2015-12-28T15:00:00"); ev4.setEnd("2015-12-28T21:00:00"); ev4.setTitle("POM"); ev4.setColor("magenta");
		ev5.setId(5); ev5.setResourceId("luogo_3"); ev5.setStart("2015-12-29T08:00:00"); ev5.setEnd("2015-12-29T13:00:00"); ev5.setTitle("MAT"); ev5.setColor("green");
		ev6.setId(6); ev6.setResourceId("luogo_3"); ev6.setStart("2015-12-30T15:00:00"); ev6.setEnd("2015-12-30T21:00:00"); ev6.setTitle("POM"); ev6.setColor("green");
		ev7.setId(7); ev7.setResourceId("luogo_4"); ev7.setStart("2016-01-01T08:00:00"); ev7.setEnd("2016-01-01T13:00:00"); ev7.setTitle("MAT"); ev7.setColor("red");
		ev8.setId(8); ev8.setResourceId("luogo_5"); ev8.setStart("2016-01-02T15:00:00"); ev8.setEnd("2016-01-02T21:00:00"); ev8.setTitle("POM"); ev8.setColor("red");
		eventList.add(ev1);
		eventList.add(ev2);
		eventList.add(ev3);
		eventList.add(ev4);
		eventList.add(ev5);
		eventList.add(ev6);
		eventList.add(ev7);
		eventList.add(ev8);
		return eventList;
	}

	public List<Event> getEventDetail(String key) {
		List<Event> eventList = new ArrayList<Event>();
		Event ev1 = new Event();
		ev1.setId(Integer.parseInt(key)); 
		ev1.setResourceId(key); 
		ev1.setStart(key); 
		ev1.setEnd(key); 
		ev1.setTitle(key); 
		ev1.setColor(key);
		eventList.add(ev1);
		return eventList;
	}
	


	
}