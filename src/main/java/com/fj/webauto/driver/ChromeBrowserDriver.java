package com.fj.webauto.driver;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.fj.webauto.file.PropertiesFile;
import com.fj.webauto.sparrow.AutoConstants;

public class ChromeBrowserDriver implements Driver {

	public RemoteWebDriver genDriver(Map<String, Object> config) {
		String osname = ((String) PropertiesFile.osProperties().get("os.name"));
		if (osname.contains("Mac") || osname.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", "tools/chromedriver");
		} else {
			System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
		}
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--user-agent=" + config.get(AutoConstants.USERAGENT));
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout((Long.parseLong((String) config.get(AutoConstants.PAGELOADTIME))), TimeUnit.MINUTES);
		return (RemoteWebDriver) driver;
	}

}
