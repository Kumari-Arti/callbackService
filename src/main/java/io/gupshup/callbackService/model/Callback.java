package io.gupshup.callbackService.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.*;

@Entity
public class Callback {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long requestId;

	@Column(columnDefinition = "TEXT")
	private String requestPayload;

	@Column(columnDefinition = "TEXT")
	private String attribute;

	@ElementCollection
	private Map<String, String> headers = new HashMap<>();

/*
	@ElementCollection
	private Map<String, String> attributes = new HashMap<String, String>();*/

	private String requestType;

	public long getRequestId() {
		return requestId;
	}

	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getRequestPayload() {
		return requestPayload;
	}

	public void setRequestPayload(String requestPayload) {
		this.requestPayload = requestPayload;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

}
