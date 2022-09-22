package com.tsystems.mms.demoapp.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

	private static final String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

	public static boolean isValid(String email) {

		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(email);

		boolean isValid = matcher.matches();

		return isValid;
	}

}
