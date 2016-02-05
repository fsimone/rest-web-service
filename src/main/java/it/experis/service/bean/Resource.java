package it.experis.service.bean;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessType;



@XmlAccessorType(XmlAccessType.FIELD)
public class Resource {
	
	@XmlElement(name="id")
	private String id;

	@XmlElement(name="luogo")
	private String luogo;

	@XmlElement(name="nome")
	private String nome;

	@XmlElement(name="eventColor")
	private String eventColor;
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLuogo() {
		return luogo;
	}

	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEventColor() {
		return eventColor;
	}

	public void setEventColor(String eventColor) {
		this.eventColor = eventColor;
	}
	
}
