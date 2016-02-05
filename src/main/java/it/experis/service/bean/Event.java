package it.experis.service.bean;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessType;



@XmlAccessorType(XmlAccessType.FIELD)
public class Event {
 
	@XmlElement(name="id")
	private long id;

	@XmlElement(name="resourceId")
	private String resourceId;
	
	@XmlElement(name="start")
    private String start;
	
	@XmlElement(name="end")
    private String end;
	
	@XmlElement(name="title")
    private String title;

	@XmlElement(name="color")
    private String color;
	
    public Event(){
    	
    }

    public long getId() {
    	return id;
    }
    
    public void setId(long id) {
    	this.id = id;
    }

    public String getResourceId() {
    	return resourceId;
    }
    
    public void setResourceId(String resourceId) {
    	this.resourceId = resourceId;
    }
    
	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
 
    
 
}
