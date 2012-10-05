package org.exampledriven.jaxb;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Book {
	
	private String author;
	private String title;
	private String secret;
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getSecret() {
		return secret;
	}
	@XmlTransient
	public void setSecret(String secret) {
		this.secret = secret;
	}

}
