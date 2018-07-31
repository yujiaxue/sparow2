package com.fj.webauto.file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class PropertiesFile {

	public static Map<String, Object> readProperties() {
		Map<String, Object> properties = new HashMap<String, Object>();
		Properties p = new Properties();
		try {
			// p.load(new BufferedInputStream(new FileInputStream(new
			// File("/Auto.properties"))));
			p.load(PropertiesFile.class.getClassLoader().getResourceAsStream("Auto.properties"));
			Set<Entry<Object, Object>> entrySet = p.entrySet();
			for (Entry<Object, Object> entry : entrySet) {
				properties.put((String) entry.getKey(), (String) entry.getValue());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

	public static Map<Object, Object> osProperties() {
		return System.getProperties();
	}
}
