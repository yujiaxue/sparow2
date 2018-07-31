package com.fj.webauto.driver;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public interface Driver {

	public WebDriver genDriver(Map<String,Object> config);
	
}
