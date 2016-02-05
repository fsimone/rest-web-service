package it.experis.service.bean;


import java.util.List;

import javax.xml.bind.annotation.XmlAccessType; 
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="resourceList")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResourceList {
     
    private int count;
    
    @XmlElement(name="rows")
    private List<Resource> rows;
    
    public ResourceList(){
    	
    }
    public ResourceList(List<Resource> resources) {
    	this.rows = resources;
	}
    
    
	public List<Resource> getRows() {
        return rows;
    }
    public void setRows(List<Resource> resources) {
        this.rows = resources;
    }
    
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}