package com.srikanth.app.restImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.srikanth.app.constants.cafeConst;
import com.srikanth.app.rest.UserRest;
import com.srikanth.app.service.UserService;
import com.srikanth.app.utils.cafeUtils;

@RestController
public class UserRestImpl implements UserRest {
	
	@Autowired
	private UserService userService;

	
	@Override
	public ResponseEntity<String> signUp(Map<String, String> requestMap) {
		
	try {
		return userService.signUp(requestMap);
		
	}catch(Exception ex) {
		ex.printStackTrace();
	}
		
	return cafeUtils.getResponseEntity(cafeConst.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
		
		
	}
	
	
	
}



