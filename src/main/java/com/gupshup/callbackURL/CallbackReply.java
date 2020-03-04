package com.gupshup.callbackURL;

public class CallbackReply {
	
	private static int id;
	private String requestPayload;
	private String requestId;
	
	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		CallbackReply.id = id;
	}
	public String getRequestPayload() {
		return requestPayload;
	}
	public void setRequestPayload(String requestPayload) {
		this.requestPayload = requestPayload;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}


}
