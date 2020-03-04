package com.gupshup.callbackURL;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Callback {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long requestId;
	private String requestPayload;
	@ElementCollection
	private Map<String, String> headers = new HashMap<>();
	@ElementCollection
	private Map<String, String> attributes = new HashMap<String, String>();
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

	public Map<String, String> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
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

	@Override
	public String toString() {
		return "Callback [requestId=" + requestId + ", requestPayload=" + requestPayload + ", headers=" + headers
				+ ", attributes=" + attributes + ", requestType=" + requestType + "]";
	}

}
