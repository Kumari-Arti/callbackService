package com.gupshup.callbackURL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CallbackService {
	
		private static List<Callback> callbacks;
		
		private static CallbackService calladd = null;
		
		private CallbackService() {
			callbacks = new ArrayList<Callback>();
		}
		

	    public static CallbackService getInstance() {
	        if(calladd == null) {
	              calladd = new CallbackService();
	              return calladd;
	            }
	            else {
	                return calladd;
	            }
	    }
		public void addCallback(Callback callback) {
			callbacks.add(callback);
		}
		
		public List<Callback> getCallback(){
			return callbacks;
		}
		
}
