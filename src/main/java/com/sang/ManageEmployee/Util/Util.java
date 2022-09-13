package com.sang.ManageEmployee.Util;

public class Util {
	public static String getUserName(String content) {
		String[] arr = content.split("/");
		return arr[0];
	}

	public static String getPassword(String content) {
		String[] arr = content.split("/");
		return arr[1];
	}
}
