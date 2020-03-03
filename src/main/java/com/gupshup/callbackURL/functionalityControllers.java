package com.gupshup.callbackURL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
	public CallbackReply storeCallback(@RequestBody Callback callback) {
		CallbackReply callreply = new CallbackReply();
		CallbackService.getInstance().addCallback(callback);

		callback.setRequestId(callback.getRequestId());
		callback.setRequestPayload(callback.getRequestPayload());

		return callreply;

	}
}
