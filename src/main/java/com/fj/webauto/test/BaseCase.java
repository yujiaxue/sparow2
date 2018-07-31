package com.fj.webauto.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.fj.webauto.annotation.CaseInfo;
import com.fj.webauto.browser.BaseBase;
import com.fj.webauto.browser.Browser;
import com.fj.webauto.db.po.MyCase;
import com.fj.webauto.file.CaseStatus;
import com.fj.webauto.sparrow.BrowserFactory;

/**
 * author:张福军 date:2018年7月3日 time:上午10:15:34
 * 
 * 所有case继承我
 **/

public class BaseCase {

	public Browser browser = null;
	MyCase mc = new MyCase();
	public String url = null;

	@BeforeClass
	public void beforeClass() {
		browser = BrowserFactory.genBrowser();

		if (this.getClass().isAnnotationPresent(CaseInfo.class)) {
			CaseInfo anno = this.getClass().getAnnotation(CaseInfo.class);
			mc.setCasename(anno.caseName());
			mc.setOwner(anno.owner());
			BaseBase.session.insert("test.insertCase", mc);
			BaseBase.config.put("caseid", mc.getId());
			BaseBase.config.put("caseResult", true);
		}
		url = (String) BaseBase.config.get("siteUrl");
	}

	@AfterClass
	public void afterClass() {
		if ((boolean) BaseBase.config.get("caseResult")) {
			mc.setStatus(CaseStatus.PASS.toString());
			BaseBase.session.update("test.updateCase", mc);
			BaseBase.session.commit();
		}

		LocalServer.runserver();
		if (Boolean.parseBoolean((String) BaseBase.config.get("isclose"))) {
			browser.close();
		}
		if (Boolean.parseBoolean(BaseBase.config.get("isquit").toString())) {
			browser.quit();
		}
		BaseBase.config.remove("caseid");
	}

}
