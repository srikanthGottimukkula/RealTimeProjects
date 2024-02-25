package com.srikanth.app.serviceImpl;

import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.srikanth.app.constants.cafeConst;
import com.srikanth.app.dao.UserDao;
import com.srikanth.app.pojo.User;
import com.srikanth.app.service.UserService;
import com.srikanth.app.utils.cafeUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public ResponseEntity<String> signUp(Map<String, String> requestMap) {
		log.info("Inside signup{}", requestMap);
		try {
			if (validateSignUpMap(requestMap)) {
				User user = userDao.findByEmailId(requestMap.get("email"));
				if (Objects.isNull(user)) {
					userDao.save(getUserFromMap(requestMap));
					return cafeUtils.getResponseEntity("successfully Registerd!!", HttpStatus.OK);
				} else {
					return cafeUtils.getResponseEntity("Email is already existed!!", HttpStatus.BAD_REQUEST);
				}

			} else {
				return cafeUtils.getResponseEntity(cafeConst.INVALID_DATA, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return cafeUtils.getResponseEntity(cafeConst.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	private boolean validateSignUpMap(Map<String, String> requestMap) {
		if (requestMap.containsKey("name") && requestMap.containsKey("contactNumber") && requestMap.containsKey("email")
				&& requestMap.containsKey("password")) {
			return true;
		}
		return false;
	}

	private User getUserFromMap(Map<String, String> requestMap) {
		User user = new User();
		user.setName(requestMap.get("name"));
		user.setPassword(requestMap.get("password"));
		user.setEmail(requestMap.get("email"));
		user.setContactNumber(requestMap.get("contactNumber"));
		user.setStatus("false");
		user.setRole("user");
		return user;
	}

}


