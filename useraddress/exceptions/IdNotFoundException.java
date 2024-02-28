package org.jsp.useraddress.exceptions;

public class IdNotFoundException extends RuntimeException {
	
	@Override
	public String getMessage() {
		return "Invalid Id";
	}

}
