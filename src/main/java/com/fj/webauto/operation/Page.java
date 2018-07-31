package com.fj.webauto.operation;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import com.fj.webauto.browser.BaseBase;
import com.fj.webauto.file.CaseStatus;

/**
 * author:张福军 date:2018年7月2日 time:下午3:44:49
 * 
 **/

public class Page extends BaseBase {

	public static void getUrl(String url, String log) {
		try {
			driver.get(url);
			dbStep(CaseStatus.DONE.toString(), log);
		} catch (WebDriverException ex) {
			AssertOpration.assertFail(String.format("打开url{%s}异常：%s;%s", url, ex.toString(), log));
		}
	}

	public static void quit(String log) {
		try {
			driver.quit();
			dbStep(CaseStatus.DONE.toString(), log, true);
		} catch (WebDriverException ex) {
			AssertOpration.assertFail(String.format("关闭driver异常：%s;%s", ex.toString(), log));
		}
	}

	public static void close(String log) {
		try {
			driver.close();
			dbStep(CaseStatus.DONE.toString(), log, true);
		} catch (WebDriverException ex) {
			AssertOpration.assertFail(String.format("退出浏览器异常：%s;%s", ex.toString(), log));
		}

	}

	public static void forward(String log) {
		try {
			driver.navigate().forward();
			dbStep(CaseStatus.DONE.toString(), log);
		} catch (WebDriverException ex) {
			AssertOpration.assertFail(String.format("浏览器向前异常：%s;异常信息：%s", log, ex.toString()));
		}
	}

	public static void back(String log) {
		try {
			driver.navigate().back();
			dbStep(CaseStatus.DONE.toString(), log);
		} catch (WebDriverException ex) {
			AssertOpration.assertFail(String.format("浏览器后退异常：%s;异常信息：%s", log, ex.toString()));
		}
	}

	public static void refresh(String log) {
		try {
			driver.navigate().refresh();
			dbStep(CaseStatus.DONE.toString(), log);
		} catch (WebDriverException ex) {
			AssertOpration.assertFail(String.format("浏览器刷新异常：%s;异常信息：%s", log, ex.toString()));
		}

	}

	public static String getTitle(String log) {
		String title = null;
		try {
			title = driver.getTitle();
			dbStep(CaseStatus.DONE.toString(), log);
		} catch (WebDriverException ex) {
			AssertOpration.assertFail(String.format("获取页面标题异常：%s;异常信息：%s", log, ex.toString()));
		}
		return title;
	}

	public static String getCurrentUrl(String log) {
		String currentUrl = null;
		try {
			currentUrl = driver.getCurrentUrl();
			dbStep(CaseStatus.DONE.toString(), log);
		} catch (WebDriverException ex) {
			AssertOpration.assertFail(String.format("获取页面当前URL异常：%s;异常信息：%s", log, ex.toString()));
		}
		return currentUrl;
	}

	public static void addCookie(String key, String value, String log) {
		try {
			Cookie cookie = new Cookie(key, value);
			driver.manage().addCookie(cookie);
			dbStep(CaseStatus.DONE.toString(), log);
		} catch (WebDriverException ex) {
			AssertOpration.assertFail(String.format("添加页面cookie异常：%s:%s;%s,异常信息：%s", key, value, log, ex.toString()));
		}
	}

	public static void deleteCookie(String key, String log) {
		try {
			driver.manage().deleteCookieNamed(key);
			dbStep(CaseStatus.DONE.toString(), log);
		} catch (WebDriverException ex) {
			AssertOpration.assertFail(String.format("删除页面cookie异常：%s;%s,异常信息：%s", key, log, ex.toString()));
		}
	}

	public static void switchWindow(String title, String log) {
		boolean find = true;
		try {
			Set<String> allWindow = driver.getWindowHandles();
			for (String window : allWindow) {
				if (title.trim().contentEquals(window.trim())) {
					driver.switchTo().window(window);
					break;
				} else {
					AssertOpration.assertFail(String.format("没有找到%s页面", title));
					find = false;
				}
			}
			if (find) {
				dbStep(CaseStatus.DONE.toString(), log);
			}
		} catch (WebDriverException ex) {
			AssertOpration.assertFail(String.format("切换到页面%s异常：%s;%s,异常信息：%s", title, log, ex.toString()));
		}
	}

	public static void scrollByOffsetY(String locator, int offsetY, String log) {
		try {
			WebElement ele = Element.element(locator, "");
			if (null == ele) {
				AssertOpration.assertFail(String.format("查找元素%s失败;log", locator, log));
			}
			actions.clickAndHold(ele).moveByOffset(0, offsetY).build().perform();
			actions.release().build().perform();
			dbStep(CaseStatus.DONE.toString(), log);
		} catch (WebDriverException ex) {
			AssertOpration.assertFail(String.format("滚动页面元素%s,距离%d,log,异常：%s", locator, offsetY, log, ex.toString()));
		}
	}

	public static void moveToElement(String locator, String log) {

		try {
			WebElement target = Element.element(locator, log);
			if (null == target) {
				AssertOpration.assertFail(String.format("查找元素%s失败;log", locator, log));
			}
			actions.moveToElement(target).build().perform();
			actions.release().build().perform();
			dbStep(CaseStatus.DONE.toString(), log);
		} catch (WebDriverException ex) {
			AssertOpration.assertFail(String.format("移动鼠标至%s代表的元素上; %s,异常：%s", locator, log, ex.toString()));
		}
	}

	public static void sleepFiveSecond() {
		try {
			Thread.sleep(5000);
			dbStep(CaseStatus.DONE.toString(), "等待5秒");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void sleepSomeTimes(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
			dbStep(CaseStatus.DONE.toString(), "等待" + seconds + "秒");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void switchFrameByIndex(int index) {
		try {
			driver.switchTo().frame(index);
			dbStep(CaseStatus.DONE.toString(), "切换进入第" + index + "个frame");

		} catch (WebDriverException ex) {
			AssertOpration.assertFail(String.format("切换进入第%d个frame异常：%s", index, ex.toString()));
		}
	}

	public static void switchFrame(String nameOrId) {
		try {
			driver.switchTo().frame(nameOrId);
			dbStep(CaseStatus.DONE.toString(), "切换进入frame " + nameOrId);
		} catch (WebDriverException ex) {
			AssertOpration.assertFail(String.format("切换进入frame:%s异常：%s", nameOrId, ex.toString()));
		}
	}

	public static void switchFrameByElement(WebElement ele) {
		try {
			driver.switchTo().frame(ele);
			dbStep(CaseStatus.DONE.toString(), "切换进入frame " + ele.toString());
		} catch (WebDriverException ex) {
			AssertOpration.assertFail(String.format("切换进入frame:%s异常：%s", ele.toString(), ex.toString()));
		}
	}

	public static void backDefault() {
		try {
			driver.switchTo().defaultContent();
			dbStep(CaseStatus.DONE.toString(), "从frame退出或回到上一层frame");
		} catch (WebDriverException ex) {
			AssertOpration.assertFail(String.format("从frame退出或回到上一层frame异常：%s", ex.toString()));
		}
	}
}
