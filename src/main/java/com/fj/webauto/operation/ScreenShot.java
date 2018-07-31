package com.fj.webauto.operation;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.fj.webauto.browser.BaseBase;

/**
 * author:张福军 date:2018年6月29日 time:上午10:59:20
 * 
 **/

public class ScreenShot extends BaseBase {

	public static String ScreenShotSave() {
		DateFormat bf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS");
		Date date = new Date();
		String format = bf.format(date);
		String filename = null;
		if (config.get("imgpath").toString().endsWith(File.separator)) {
			filename = config.get("imgpath") + format + ".png";
		} else {
			filename = config.get("imgpath") + File.separator + format + ".png";
		}

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotFile, new File(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return format;
	}
}
