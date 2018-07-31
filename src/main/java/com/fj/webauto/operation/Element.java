package com.fj.webauto.operation;

import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
* author:张福军
* date:2018年6月25日
* time:上午6:33:32
* 
**/
import com.fj.webauto.browser.BaseBase;
import com.fj.webauto.file.CaseStatus;

public class Element extends BaseBase {
	static WebElement hxelement = null;

	/**
	 * 查找元素
	 * 
	 * @param locator
	 * @param log
	 */
	public static WebElement element(String locator, String log) {
		String mylocator = LocatorCheck.checkLocator(locator);
		if (mylocator == null || "".equals(mylocator)) {
			throw new NoSuchElementException(String.format("传入的定位器-%s-不符合要求，请检查", locator));
		}
		int retryTime = 3;
		if (config.containsKey("retry")) {
			retryTime = (int) config.get("retry");
		}
		WebDriverWait wdw = new WebDriverWait(driver, (long) Integer.parseInt((String) config.get("elementtimeout")));

		for (int i = 0; i < retryTime; i++) {
			try {
				if (mylocator.equalsIgnoreCase(LocatorCheck.xpath)) {
					hxelement = wdw.until(new Function<WebDriver, WebElement>() {
						public WebElement apply(WebDriver driver) {
							return driver.findElement(By.xpath(locator));
						}
					});
				} else if (mylocator.equalsIgnoreCase(LocatorCheck.classname)) {
					hxelement = wdw.until(new Function<WebDriver, WebElement>() {
						public WebElement apply(WebDriver driver) {
							return driver.findElement(By.className(locator));
						}
					});
				} else if (mylocator.equalsIgnoreCase(LocatorCheck.name)) {
					hxelement = wdw.until(new Function<WebDriver, WebElement>() {
						public WebElement apply(WebDriver driver) {
							return driver.findElement(By.name(locator));
						}
					});
				} else if (mylocator.equalsIgnoreCase(LocatorCheck.id)) {
					hxelement = wdw.until(new Function<WebDriver, WebElement>() {
						public WebElement apply(WebDriver driver) {
							return driver.findElement(By.id(locator));
						}
					});
				}
			} catch (WebDriverException ex) {
				// throw new WebDriverException(String.format("第%d次查找没有找到元素", i));
			}
			if (null != hxelement) {
				break;
			}
		}
		return hxelement;
	}

	/**
	 * 清除元素内容
	 * 
	 * @param locator
	 * @param log
	 */
	public static void clear(String locator, String log) {
		try {
			element(locator, log).clear();
			dbStep(CaseStatus.DONE.toString(), log);
		} catch (WebDriverException ex) {
			AssertOpration.assertFail(String.format("清除%s内容异常：%s;异常信息：%s", locator, log, ex.toString()));
		}
	}

	/**
	 * 获取元素tag类型
	 * 
	 * @param locator
	 * @return
	 */
	public static String getTagName(String locator, String log) {
		String tagName = null;
		try {
			tagName = element(locator, log).getTagName();
			dbStep(CaseStatus.DONE.toString(), log);
		} catch (WebDriverException ex) {
			AssertOpration.assertFail(String.format("获取tagname失败：定位器：%s,%s,异常信息：%s", locator, log, ex.toString()));
		}
		return tagName;
	}

	public static String getAttribute(String locator, String attr, String log) {
		String attribute = null;
		try {
			attribute = element(locator, log).getAttribute(attr);
			dbStep(CaseStatus.DONE.toString(), log);
		} catch (WebDriverException ex) {
			AssertOpration.assertFail(String.format("获取attribute失败：定位器：%s,%s,异常信息：%s", locator, log, ex.toString()));
		}
		return attribute;
	}

	public static String getCssValue(String locator, String key, String log) {
		String value = null;
		try {
			value = element(locator, log).getCssValue(key);
			dbStep(CaseStatus.DONE.toString(), log);
		} catch (WebDriverException ex) {
			AssertOpration.assertFail(String.format("获取cssvalue失败：定位器：%s,%s,异常信息：%s", locator, log, ex.toString()));
		}
		return value;
	}

	public static String getText(String locator, String log) {
		String text = null;
		try {
			text = element(locator, log).getText();
			dbStep(CaseStatus.DONE.toString(), log);
		} catch (WebDriverException ex) {
			AssertOpration.assertFail(String.format("获取text失败：定位器：%s,%s,异常信息：%s", locator, log, ex.toString()));
		}
		return text;
	}

	public static void click(String locator, String log) {
		try {
			element(locator, log).click();
			dbStep(CaseStatus.DONE.toString(), log);
		} catch (WebDriverException ex) {
			AssertOpration.assertFail(String.format("点击元素%s失败：%s,异常信息：%s", locator, log, ex.toString()));
		}
	}

	public static void typeText(String locator, String text, String log) {
		try {
			element(locator, log).sendKeys(text);
			dbStep(CaseStatus.DONE.toString(), log);
		} catch (WebDriverException ex) {
			AssertOpration.assertFail(String.format("输入文本%s至%s异常：%s,异常信息：%s;", text, locator, log, ex.toString()));
		}

	}

}
