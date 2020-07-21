package io.gupshup.callbackService.controller;

import io.gupshup.callbackService.CallbackServiceApplication;
import io.gupshup.callbackService.model.Callback;
import io.gupshup.callbackService.repository.CallbackRepository;
import io.gupshup.callbackService.service.CallbackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;

@RestController
public class CallbackController {

	private final String CONTEXT = "/api/v1/request";
	private static final Logger LOGGER = LoggerFactory.getLogger(CallbackServiceApplication.class);

	@Autowired
	private CallbackRepository callbackRepository;

	@Autowired
	private CallbackService callbackService;

	@RequestMapping(value = CONTEXT)
	@ResponseBody
	public Callback storeCallback(@RequestBody(required = false) String callback, HttpServletRequest httpRequest) {

		LOGGER.info("----log request---", httpRequest);

		Callback callresponse = new Callback();

		Enumeration<String> headers = httpRequest.getHeaderNames();

		callresponse.setRequestType(httpRequest.getMethod());

		while (headers.hasMoreElements()) {
			String header = (headers.nextElement());
			callresponse.getHeaders().put(header, httpRequest.getHeader(header));

		}

		callresponse.setRequestPayload(callback);

        StringBuffer url = httpRequest.getRequestURL();
        String query = httpRequest.getQueryString();
        if (StringUtils.hasText(query)) {
            url.append('?').append(query);
        }
        callresponse.setAttribute(url.toString());



        callbackRepository.save(callresponse);

		return callresponse;
	}

}
