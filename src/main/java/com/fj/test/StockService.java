package com.fj.test;

/**
 * author:张福军 date:2018年7月5日 time:下午1:49:39
 * 
 **/

public class StockService {

	@MonitorMethod
	public String getBaseInfo(String ticker) {
		try {
			System.out.println("woshigetbaseinfo");
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "";
	}
}