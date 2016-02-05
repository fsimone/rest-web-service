package it.experis.service.bean;


import java.util.List;

import javax.xml.bind.annotation.XmlAccessType; 
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="eventList")
@XmlAccessorType(XmlAccessType.FIELD)
public class EventList {
     
    private int count;
    
    @XmlElementWrapper(name="Lavoratori")
    @XmlElement(name="Lavoratore")
    private List<Event> lavoratori;
    
    public EventList(){
    	
    }
    public EventList(List<Event> events) {
    	this.lavoratori = events;
	}
    
    
	public List<Event> getLavoratori() {
        return lavoratori;
    }
    public void setLavoratori(List<Event> events) {
        this.lavoratori = events;
    }
    
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}