package com.fj.webauto.operation;

import org.testng.Assert;

import com.fj.webauto.browser.BaseBase;
import com.fj.webauto.file.CaseStatus;

/**
 * author:张福军 date:2018年7月9日 time:下午1:03:44
 * 
 **/

public class AssertOpration extends BaseBase {
	/**
	 * 将case失败
	 * 
	 * @param log
	 */
	public static void assertFail(String log) {
		dbStep(CaseStatus.FAIL.toString(), log);
		assertFail();
	}

	private static void assertFail() {
		dbCaseUpdate(CaseStatus.FAIL.toString());
		config.put("caseResult", false);
		Assert.fail();
	}

	/**
	 * 断言expect 相等于actual
	 * 
	 * @param expect
	 * @param actual
	 */
	public static void assertEquals(String expect, String actual) {
		if (expect.equals(actual)) {
			dbStep(CaseStatus.DONE.toString(), expect + " is equlas " + actual + " is DONE");
		} else {
			assertFail("FAIL::" + expect + " is equals " + actual);
		}
	}

	/**
	 * 断言 expect 包含 actual或者相反
	 * 
	 * @param expect
	 * @param actual
	 */
	public static void assertContain(String expect, String actual) {
		if (expect.contains(actual) || actual.contains(expect)) {
			dbStep(CaseStatus.DONE.toString(), actual + " and " + expect + " is contained");
		} else {
			assertFail("FAIL::" + expect + " and " + actual + "is contained");
		}
	}

	/**
	 * 断言 value is True
	 * 
	 * @param value
	 */
	public static void assertTrue(boolean value) {
		if (value) {
			dbStep(CaseStatus.DONE.toString(), value + " is True");
		} else {
			assertFail("FAIL::" + value + " is True");
		}
	}

	/**
	 * 断言value is False
	 * 
	 * @param value
	 */
	public static void assertFalse(boolean value) {
		if (value) {
			assertFail("FAIL::" + value + " is False");
		} else {
			dbStep(CaseStatus.DONE.toString(), value + " is False");
		}
	}

}
