package com.ui.dataproviders;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojo.TestData;
import com.ui.pojo.User;
import com.utility.CSVReaderUtility;

public class LoginDataProvider {

	@DataProvider(name = "loginJSONdataprovider")
	public Iterator<Object[]> loginJSONSDataProvider() {

		Gson gson = new Gson();
		File file = new File(System.getProperty("user.dir") + "//testData//logindata.json");
		FileReader reader = null;

		try {
			file = new File(System.getProperty("user.dir") + "//testData//logindata.json");
			reader = new FileReader(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		TestData data = gson.fromJson(reader, TestData.class);
		List<Object[]> dataToReturn = new ArrayList<>();
		for (User user : data.getData()) {
			dataToReturn.add(new Object[] { user });
		}
		return dataToReturn.iterator();
	}
	
	@DataProvider(name = "loginCSVDataProvider")
	public Iterator<User> loginCSVDataProvider()
	{
		return CSVReaderUtility.readCSVFile();
		
	}
	
	

}
