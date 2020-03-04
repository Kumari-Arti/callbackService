package com.gupshup.callbackURL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class functionalityControllers {

	private final String CONTEXT = "/api/v1/callbackURL";

	/*
	 * @GetMapping(value = CONTEXT) public String greeting(){ return "Hello"; }
	 * 
	 * @PostMapping(value = CONTEXT)
	 * 
	 * @ResponseStatus(HttpStatus.CREATED) public void createCallback(@RequestBody
	 * Callback callback) { CallbackService.addCallback(callback); }
	 */

	@Autowired
	private CallbackService callbackService;

	@GetMapping(value = CONTEXT)

	@ResponseBody
	public List<Callback> getCallbacks() {
		return CallbackService.getInstance().getCallback();
	}

	@PostMapping(value = CONTEXT)

	@ResponseBody
	public CallbackReply storeCallback(@RequestBody Callback callback, HttpServletRequest httpRequest) {

		System.out.println("callback" +callback);
		System.out.println("httprequest" +httpRequest);
		CallbackReply callreply = new CallbackReply();
		CallbackService.getInstance().addCallback(callback);
		
		  callreply.setRequestId(callback.getRequestId());
		  callreply.setRequestPayload(callback.getRequestPayload());

		callreply.setId(1);

		return callreply;
	
	}

}
