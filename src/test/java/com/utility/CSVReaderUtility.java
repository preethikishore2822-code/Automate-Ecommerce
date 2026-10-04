package com.utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class CSVReaderUtility {

	public static Iterator<User> readCSVFile() {

		System.out.println(System.getProperty("user.dir") + "//testData//logindata.csv");
		File file;
		FileReader fileReader;
		CSVReader csvreader;
		String[] data;
		List<User> userList = new ArrayList<>();

		try {
			file = new File(System.getProperty("user.dir") + "//testData//logindata.csv");
			fileReader = new FileReader(file);
			csvreader = new CSVReader(fileReader);
			csvreader.readNext();// skips the header row while it is not stored to any variable

			while ((data = csvreader.readNext()) != null) {

				User user = new User(data[0], data[1]);
				userList.add(user);

			}
		} catch (CsvValidationException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userList.iterator();

	}

}
