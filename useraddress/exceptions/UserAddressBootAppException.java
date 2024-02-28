package org.jsp.useraddress.exceptions;

import org.jsp.useraddress.dto.User;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserAddressBootAppException extends RuntimeException {
	
	@ExceptionHandler(IdNotFoundException.class)
	public String handleINFE(Exception e) {
		return  e.getMessage();
	}

}
