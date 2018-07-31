package com.fj.webauto.operation;

/**
 * author:张福军 date:2018年6月25日 time:上午6:44:33
 * 
 **/

public class LocatorCheck {
	final static String xpath = "XPATH";
	final static String id = "ID";
	final static String name = "NAME";
	final static String classname = "CLASSNAME";

	public static String checkLocator(String locator) {
		String mylocator = null;
		if (locator == null || "".equals(locator.trim())) {
			return null;
		}
		if (locator.startsWith("//")) {
			mylocator = xpath;
		} else if (locator.startsWith("~")) {
			mylocator = id;
		} else if (locator.startsWith("-")) {
			mylocator = name;
		} else if (locator.startsWith("")) {
			mylocator = classname;
		} else {
			mylocator = xpath;
		}
		return mylocator;
	}
}
