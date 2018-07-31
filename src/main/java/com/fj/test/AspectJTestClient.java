package com.fj.test;

/**
 * author:张福军 date:2018年7月5日 time:下午1:50:02
 * 
 **/

public class AspectJTestClient {

	public static void main(String[] args) {

		new StockService().getBaseInfo("MSFT");

		// new FundService().getBaseInfo("BBBIX");
	}
}
