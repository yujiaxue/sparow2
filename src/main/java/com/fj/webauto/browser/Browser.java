package com.fj.webauto.browser;

import org.openqa.selenium.WebElement;

import com.fj.webauto.operation.Alert;
import com.fj.webauto.operation.Element;
import com.fj.webauto.operation.Page;

public class Browser extends BaseBase {

	/**
	 * 打开指定url的网站
	 * 
	 * @param url
	 *            网站URL
	 */

	public void get(String url) {
		Page.getUrl(url, String.format("进入%s", url));
	}

	/**
	 * 打开指定url的网站
	 * 
	 * @param url
	 *            网站URL
	 * @param log
	 *            日志
	 */
	public void get(String url, String log) {
		Page.getUrl(url, log);
	}

	/**
	 * 退出driver
	 */
	public void quit() {
		Page.quit("退出driver关闭浏览器");
	}

	/**
	 * 退出浏览器
	 */
	public void close() {
		Page.close("退出浏览器");
	}

	/**
	 * 清除元素内内容
	 * 
	 * @param locator
	 *            定位器
	 */
	public void clear(String locator) {
		Element.clear(locator, String.format("清除元素%s的内容", locator));
	}

	/**
	 * 清除元素内内容
	 * 
	 * @param locator
	 *            定位器
	 * @param log
	 *            日志
	 */
	public void clear(String locator, String log) {
		Element.clear(locator, log);
	}

	/**
	 * 获取元素的tagName
	 * 
	 * @param locator
	 *            定位器
	 * @return 元素的tagName
	 */
	public String getTagName(String locator) {
		return Element.getTagName(locator, String.format("获取元素%s的tagname", locator));
	}

	// public void upload(String file) {
	//
	// }
	//
	/**
	 * 获取元素的属性值
	 * 
	 * @param locator
	 *            定位器
	 * @param attr
	 *            元素属性
	 * @param log
	 *            日志
	 * @return 元素属性值
	 */
	public String getAttribute(String locator, String attr, String log) {
		return Element.getAttribute(locator, attr, log);
	}

	/**
	 * 获取元素的css值
	 * 
	 * @param locator
	 *            定位器
	 * @param key
	 *            需要获取的元素css key
	 * @param log
	 *            日志
	 * @return css value
	 */
	public String getCssValue(String locator, String key, String log) {
		return Element.getCssValue(locator, key, log);
	}

	/**
	 * 获取元素文本
	 * 
	 * @param locator
	 *            定位器
	 * @return 元素文本
	 */
	public String getText(String locator) {
		return getText(locator, String.format("获取%s的文本", locator));
	}

	/**
	 * 获取元素文本
	 * 
	 * @param locator
	 *            定位器
	 * @param log
	 *            日志
	 * @return 元素文本
	 */
	public String getText(String locator, String log) {
		return Element.getText(locator, log);
	}

	//
	// public List<WebElement> elements() {
	//
	// }

	/**
	 * 按给定locator查找元素并点击
	 * 
	 * @param locator
	 *            定位器
	 */
	public void click(String locator) {
		click(locator, String.format("点击元素:%s", locator));
	}

	/**
	 * 按给定locator查找元素并点击
	 * 
	 * @param locator
	 *            定位器
	 * @param log
	 *            日志
	 */
	public void click(String locator, String log) {
		Element.click(locator, log);
	}

	/**
	 * 按给定locator查找元素并输入text
	 * 
	 * @param locator
	 *            定位器
	 * @param text
	 *            要输入的文本
	 */
	public void typeText(String locator, String text) {
		typeText(locator, text, String.format("输入文本%s至%s", text, locator));
	}

	/**
	 * 按给定locator查找元素并输入text
	 * 
	 * @param locator
	 *            定位器
	 * @param text
	 *            要输入的文本
	 * @param log
	 *            日志
	 */
	public void typeText(String locator, String text, String log) {
		Element.typeText(locator, text, log);
	}

	/**
	 * 操作浏览器前进
	 */
	public void forward() {
		forward("浏览器向前");
	}

	/**
	 * 操作浏览器前进
	 * 
	 * @param log
	 *            日志
	 */
	public void forward(String log) {
		Page.forward(log);
	}

	/**
	 * 操作浏览器后退
	 */
	public void back() {
		back("浏览器后退");
	}

	/**
	 * 操作浏览器后退
	 * 
	 * @param log
	 *            日志
	 */
	public void back(String log) {
		Page.back(log);
	}

	/**
	 * 操作浏览器刷新
	 */
	public void refresh() {
		Page.refresh("浏览器刷新");
	}

	/**
	 * 操作浏览器刷新
	 * 
	 * @param log
	 *            日志
	 */
	public void refresh(String log) {
		Page.refresh(log);
	}

	/**
	 * 获取当前页面标题
	 * 
	 * @return 页面标题
	 */
	public String getTitle() {
		return getTitle("获取页面标题");
	}

	/**
	 * 获取页面标题
	 * 
	 * @param log
	 *            日志
	 */
	public String getTitle(String log) {
		return Page.getTitle(log);
	}

	/**
	 * 获取当前页面URL
	 * 
	 * @return
	 */
	public String getCurrentUrl(String log) {
		return Page.getCurrentUrl(log);
	}

	public String getCurrentUrl() {
		return getCurrentUrl("获取当前页面URL");
	}

	public void addCookie(String key, String value) {
		Page.addCookie(key, value, "添加cookie");
	}

	public void deleteCookie(String key) {
		Page.deleteCookie(key, "删除cookie");
	}

	public void accept() {
		accept("确认对话框");
	}

	public void accept(String log) {
		Alert.accept(log);
	}

	public void dismiss(String log) {
		Alert.dismiss(log);
	}

	public void dismiss() {
		dismiss("取消对话框");
	}

	public void enterText(String value) {
		enterText(value, "输入对话框文本");
	}

	public void enterText(String value, String log) {
		Alert.enterText(value, log);
	}

	public String getAlertText() {
		return getText("获取对话框文本");
	}

	public String getAlertText(String log) {
		return Alert.getText(log);
	}

	public void switchWindow(int xh) {
		switchWindow(xh);
	}

	public void switchWindow(String title, String log) {
		Page.switchWindow(title, log);
	}

	public void scroolToElement(String locator) {
		WebElement ele = Element.element(locator, "");
		actions.moveToElement(ele).build().perform();

		actions.click(ele);

	}

	public void scroll(String locator) {
		jse.executeScript("window.scrollTo(document.body.scrollHeight,0);");
	}

	public void scrollheight() {

	}

	public void scrollByOffsetY(String locator, int offsetY, String log) {
		Page.scrollByOffsetY(locator, offsetY, log);
	}

	public void moveToElement(String locator) {
		moveToElement(locator, "移动鼠标到" + locator);
	}

	/**
	 * 移动鼠标到locator指定的元素上\\
	 * 
	 * @param locator
	 * @param log
	 */
	public void moveToElement(String locator, String log) {
		Page.moveToElement(locator, log);
	}

	/**
	 * 等待5秒
	 */
	public void sleepFiveSeconds() {
		Page.sleepFiveSecond();
	}

	/**
	 * 等待指定时间
	 * 
	 * @param seconds
	 *            秒
	 */
	public void sleepSomeTimes(int seconds) {
		Page.sleepSomeTimes(seconds);
	}

	/**
	 * 进入frame
	 * 
	 * @param index
	 *            frame序列号
	 */
	public void switchFrameByIndex(int index) {
		Page.switchFrameByIndex(index);
	}

	/**
	 * 进入frame 按name或id查找
	 * 
	 * @param nameOrId
	 *            frame的classname或id
	 */
	public void switchFrame(String nameOrId) {
		Page.switchFrame(nameOrId);
	}

	/**
	 * 进入ele指定的frame
	 * 
	 * @param ele
	 *            frame页面
	 */
	public void switchFrameByElement(WebElement ele) {
		Page.switchFrameByElement(ele);
	}

	/**
	 * 回到主页面或返回上一层frame
	 */
	public void backDefault() {
		Page.backDefault();
	}

}
