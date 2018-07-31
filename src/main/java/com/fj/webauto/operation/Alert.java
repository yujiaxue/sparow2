package com.fj.webauto.operation;

import org.openqa.selenium.WebDriverException;

import com.fj.webauto.browser.BaseBase;
import com.fj.webauto.file.CaseStatus;

/**
 * author:张福军 date:2018年7月9日 time:下午8:20:39
 * 
 **/

public class Alert extends BaseBase {

	public static void accept(String log) {
		try {
			driver.switchTo().alert().accept();
			dbStep(CaseStatus.DONE.toString(), log);
		} catch (WebDriverException ex) {
			AssertOpration.assertFail(String.format("对话框确认异常：%s;异常信息：%s", log, ex.toString()));
		}
	}

	public static void dismiss(String log) {
		try {
			driver.switchTo().alert().dismiss();
			dbStep(CaseStatus.DONE.toString(), log);
		} catch (WebDriverException ex) {
			AssertOpration.assertFail(String.format("对话框取消异常：%s;异常信息：%s", log, ex.toString()));
		}
	}

	public static void enterText(String value, String log) {
		try {
			driver.switchTo().alert().sendKeys(value);
			dbStep(CaseStatus.DONE.toString(), log);
		} catch (WebDriverException ex) {
			AssertOpration.assertFail(String.format("对话框输入文本%s异常：%s;异常信息：%s", value, log, ex.toString()));
		}
	}

	public static String getText(String log) {
		String text = null;
		try {
			text = driver.switchTo().alert().getText();
		} catch (WebDriverException ex) {
			AssertOpration.assertFail(String.format("对话框获取文本异常：%s;异常信息：%s", log, ex.toString()));
		}
		return text;
	}

}
