package com.gupshup.callbackURL;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {
	
	@Autowired
	private CallbackRepository callbackRepository;
	private long requestId; 
	
	private final String CONTEXT = "/api/v1/getDetails/{requestId}"; 

	@GetMapping(value = CONTEXT)

	@ResponseBody
	
	public List<Callback> getCallbacks(@PathVariable Long requestId) {
		return callbackRepository.findByRequestId(requestId);
	}
}

