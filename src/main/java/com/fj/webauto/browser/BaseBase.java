package com.fj.webauto.browser;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.fj.webauto.db.po.MyCase;
import com.fj.webauto.db.po.Steps;
import com.fj.webauto.operation.ScreenShot;

public class BaseBase {

	public static WebDriver driver = null;
	public static WebElement element = null;
	public static Actions actions = null;
	public static JavascriptExecutor jse = null;
	public static Map<String, Object> config = null;
	public static SqlSession session = null;
	// public static BrowserWindowFunc browserWindowFunc = null;

	public static void setDriver(WebDriver dri) {
		driver = dri;
	}

	public static void setActions(Actions ac) {
		actions = ac;
	}

	public static void setJavascript(JavascriptExecutor javascriptexe) {
		jse = javascriptexe;
	}

	public static void setConfig(Map<String, Object> configs) {
		config = configs;
	}

	public static void setBatis(SqlSession mysession) {
		session = mysession;
	}

	public static void dbStep(String status, String log) {
		// Steps step = new Steps();
		// step.setCaseId((int) config.get("caseid"));
		// step.setStepName(log);
		// step.setImg(ScreenShot.ScreenShotSave());
		// step.setStatus(status);
		// session.insert("test.insertStep", step);
		// session.commit();
		dbStep(status, log, false);
	}

	public static void dbStep(String status, String log, boolean image) {
		Steps step = new Steps();
		step.setCaseId((int) config.get("caseid"));
		step.setStepName(log);
		if (image) {
			step.setImg("");
		} else {
			step.setImg(ScreenShot.ScreenShotSave());
		}

		step.setStatus(status);
		session.insert("test.insertStep", step);
		session.commit();
	}

	public static void dbCaseUpdate(String status) {
		int id = (int) config.get("caseid");
		MyCase mc = new MyCase();
		mc.setStatus(status);
		mc.setId(id);
		session.update("test.updateCase", mc);
		session.commit();
	}
}
