package it.experis.service.bean;

public class SMS {
	
	private String username; 
	private String password; 
	private String method;
	private String[] recipients; 
	private String text; 
	private String smsType; 
	private String senderNumber; 
	private String senderString; 
	private String charset;
	private String[] methodList;
	private String submit;
	
	

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String[] getRecipients() {
		return recipients;
	}
	public void setRecipients(String[] recipients) {
		this.recipients = recipients;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getSmsType() {
		return smsType;
	}
	public void setSmsType(String smsType) {
		this.smsType = smsType;
	}
	public String getSenderNumber() {
		return senderNumber;
	}
	public void setSenderNumber(String senderNumber) {
		this.senderNumber = senderNumber;
	}
	public String getSenderString() {
		return senderString;
	}
	public void setSenderString(String senderString) {
		this.senderString = senderString;
	}
	public String getCharset() {
		return charset;
	}
	public void setCharset(String charset) {
		this.charset = charset;
	}
	public String[] getMethodList() {
		return methodList;
	}
	public void setMethodList(String[] methodList) {
		this.methodList = methodList;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}

	

}
