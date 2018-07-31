package com.fj.webauto.sparrow;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.fj.webauto.driver.ChromeBrowserDriver;
import com.fj.webauto.driver.Driver;

public class DriverFactory {
	
	static Driver driver = null;
	public WebDriver genDriver(Map<String,Object> config) {
		String browser = (String) config.get(AutoConstants.BROWSER);
		if(browser.equalsIgnoreCase("chrome")){
			driver = new ChromeBrowserDriver();
		}else if (browser.equalsIgnoreCase("safari")){
			
		}
		else if (browser.equalsIgnoreCase("firefox")){
			
		}else if (browser.equalsIgnoreCase("IE")){
			
		}else if (browser.equalsIgnoreCase("edge")){
			
		}else if (browser.equalsIgnoreCase("htmlunit")){
			
		}else{
			String os = System.getenv().get("os");
			if(os.equals("mac")){
				
			}else if (os.equalsIgnoreCase("winnt")){
				
			}
		}
		return driver.genDriver(config);
	}
	
	

}
