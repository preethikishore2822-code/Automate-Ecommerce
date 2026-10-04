package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.Env;

public class PropertiesUtil {

	public static String readProperty(Env env, String propertyName) {
		System.out.println(System.getProperty("user.dir"));
		File file = new File(System.getProperty("user.dir") + "//config//" + env + ".properties");
		FileReader reader = null;
		Properties properties = new Properties();

		try {
			reader = new FileReader(file);
			properties.load(reader);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		catch (IOException e) {
			e.printStackTrace();
		}

		return properties.getProperty(propertyName);

	}

}
