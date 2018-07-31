package com.fj.webauto.test;

import org.testng.annotations.Test;

import com.fj.webauto.annotation.CaseInfo;

@CaseInfo(caseName = "哈哈", owner = "张福军")
public class Test1 extends BaseCase {

	@Test
	public void test01() {

		// Browser b = BrowserFactory.genBrowser();
		// b.get("https://www.mmall.com");
		System.out.println("ok.......");
	}

}
