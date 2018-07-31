package com.fj.webauto.test;

import java.io.IOException;

/**
 * author:张福军 date:2018年7月19日 time:下午6:34:51
 * 
 **/

public class LocalServer {

	public static void runserver() {
		try {
			Runtime.getRuntime().exec("java -jar tools/hxreport-1.0.jar");
			Thread.sleep(5000);
			openURL();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			System.out.println("可能需要你自行启动服务，命令：java -jar tools/hxreport-1.0.jar");
		}

	}

	public static void openURL() {
		if (java.awt.Desktop.isDesktopSupported()) {
			try {
				java.net.URI uri = java.net.URI.create("http://localhost:8091/cases");
				java.awt.Desktop dp = java.awt.Desktop.getDesktop();
				if (dp.isSupported(java.awt.Desktop.Action.BROWSE)) {
					dp.browse(uri);
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("可能需要你自行打开浏览器访问报告，地址是：http://localhost:8091/cases");
			}
		}
	}
}
