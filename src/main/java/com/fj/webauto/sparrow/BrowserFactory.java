package com.fj.webauto.sparrow;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.fj.webauto.browser.BaseBase;
import com.fj.webauto.browser.Browser;
import com.fj.webauto.db.BatisFactory;
import com.fj.webauto.file.PropertiesFile;

public class BrowserFactory {

	public static Browser browser = null;
	public static WebDriver driver = null;
	public static DriverFactory driverFactory = new DriverFactory();
	public static Map<String, Object> config = PropertiesFile.readProperties();
	public static SqlSession session = null;

	public static synchronized Browser genBrowser() {
		if (driver == null) {
			driver = driverFactory.genDriver(config);
		}
		setDriverAttr(driver);
		browser = new Browser();
		return browser;
	}

	public static void setDriverAttr(WebDriver driver) {
		BaseBase.setDriver(driver);
		Actions action = new Actions(driver);
		BaseBase.setActions(action);
		JavascriptExecutor javascriptexe = (JavascriptExecutor) driver;
		BaseBase.setJavascript(javascriptexe);
		BaseBase.setConfig(config);
		BaseBase.setBatis(genSession());
	}

	public static SqlSession genSession() {
		session = BatisFactory.genDb((String) config.get("dbconfig"));
		return session;
	}

}
