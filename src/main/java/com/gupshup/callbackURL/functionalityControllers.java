package com.gupshup.callbackURL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import java.util.logging.Level;

@RestController
public class functionalityControllers {

	private final String CONTEXT = "/api/v1/callbackURL";
	private static final Logger LOGGER = LoggerFactory.getLogger(CallbackUrlApplication.class);

	@Autowired
	private CallbackRepository callbackRepository;

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
	public Callback storeCallback(@RequestBody String callback, HttpServletRequest httpRequest) {

		LOGGER.info("----log request---", httpRequest);
		
		Callback callresponse = new Callback();

		Enumeration<String> headers = httpRequest.getHeaderNames();
		
		while (headers.hasMoreElements()) {
				String header = (headers.nextElement());
				LOGGER.info(headers.nextElement());
			    callresponse.getHeaders().put(header, httpRequest.getHeader(header));
		
		}

		

		callresponse.setRequestPayload(callback);
	
		callbackRepository.save(callresponse);
		/*
		 * CallbackService.getInstance().addCallback(callback);
		 * 
		 * callreply.setRequestId(callback.getRequestId());
		 * callreply.setRequestPayload(callback.getRequestPayload());
		 * 
		 * callreply.setId(1);
		 */

		return callresponse;
	}

}
