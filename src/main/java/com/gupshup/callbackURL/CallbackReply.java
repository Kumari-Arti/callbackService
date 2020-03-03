package com.gupshup.callbackURL;

public class CallbackReply {
	
	private static int requestId;
	private String requestPayload;
	private String id;
	
	public static int getRequestId() {
		return requestId;
	}
	public static void setRequestId(int requestId) {
		CallbackReply.requestId = requestId;
	}
	public String getRequestPayload() {
		return requestPayload;
	}
	public void setRequestPayload(String requestPayload) {
		this.requestPayload = requestPayload;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}	

}
