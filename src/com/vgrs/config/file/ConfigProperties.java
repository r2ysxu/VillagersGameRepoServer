package com.vgrs.config.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {
	
	private static Properties prop = new Properties();
	
	static {
		try {
			File propertyFile = new File("config.properties");
			if (!propertyFile.exists()) propertyFile = new File("resources/config/config.properties"); // Fall back
			InputStream is = new FileInputStream(propertyFile);
			prop.load(is);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		String property = prop.getProperty(key);
		return property;
	}
}