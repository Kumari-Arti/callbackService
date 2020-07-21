package io.gupshup.callbackService.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.gupshup.callbackService.Exceptionhandler.ResourceNotFoundException;
import io.gupshup.callbackService.model.Callback;
import io.gupshup.callbackService.repository.CallbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RequestController {
	
	@Autowired
	private CallbackRepository callbackRepository;

  /*private final String CONTEXT = "/getDetails/{requestId}";
	@GetMapping(value = CONTEXT)
	@ResponseBody*/


	@GetMapping("/request")
	public List < Callback > getAllRequests() {
		return (List<Callback>) callbackRepository.findAll();
	}

	@DeleteMapping("/request")
	public Map <String, Boolean> deleteAllRequests(){
		callbackRepository.deleteAll();
		Map < String, Boolean > response = new HashMap < >();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@GetMapping("/request/{requestId}")
	public ResponseEntity < Callback > getRequestById(@PathVariable(value = "requestId") Long requestId)
			throws ResourceNotFoundException {
		Callback callback = callbackRepository.findById(requestId)
				.orElseThrow(() -> new ResourceNotFoundException("Request not found for this id  :: " + requestId));
		return ResponseEntity.ok().body(callback);
	}

	@DeleteMapping("/request/{requestId}")
	public Map < String, Boolean > deleteRequest(@PathVariable(value = "requestId") Long requestId)
			throws ResourceNotFoundException {
		Callback callback = callbackRepository.findById(requestId)
				.orElseThrow(() -> new ResourceNotFoundException("Request not found for this id :: " + requestId));

		callbackRepository.delete(callback);
		Map < String, Boolean > response = new HashMap < >();
		response.put("deleted", Boolean.TRUE);
		return response;
	}


	/*@RequestMapping( value = "/getDetails/{requestId}", method = RequestMethod.GET )
	public List<Callback> getRequestById(@PathVariable Long requestId) {
		return callbackRepository.findByRequestId(requestId);
	}*/

}

