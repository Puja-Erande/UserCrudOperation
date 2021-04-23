package com.kpi.ninja.assignment.validator;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.kpi.ninja.assignment.exception.UserApiException;
import com.kpi.ninja.assignment.model.User;

@Component
public class UserValidator {

	public void validateRequest(User userDetails) {

		rejectIfNullOrEmpty(userDetails);
	}

	private void rejectIfNullOrEmpty(User userDetails) {
		if (ObjectUtils.isEmpty(userDetails)
				|| !(Optional.ofNullable(userDetails.getUserId()).isPresent())) {
			throw new UserApiException("BAD REQUEST", "403", "USERID OR USERREQUEST IS NULL");
		}
	}

	public void validateRequest(int userId) {
		
		if(!Optional.ofNullable(userId).isPresent())
		{
			throw new UserApiException("BAD REQUEST", "403", "USERID IS NULL");
		}
	}
}
