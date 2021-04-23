package com.marsMarketing.webhookreceiveSMS.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * Field DTO - Basic data to transfer
 *
 * @version 1.0
 *
 */
@Component
public class FieldDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String to;
	private String from;
	private String coding;
	private String priority;
	private String id;
	private String content;

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getCoding() {
		return coding;
	}

	public void setCoding(String coding) {
		this.coding = coding;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
