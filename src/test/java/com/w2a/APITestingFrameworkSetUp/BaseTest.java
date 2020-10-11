package com.w2a.APITestingFrameworkSetUp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.w2a.APITestingFramework.utilities.ExcelReader;

import io.restassured.RestAssured;

public class BaseTest {

	public static Properties config = new Properties();
	public static ExcelReader excel = new ExcelReader(".\\src\\test\\resources\\excel\\testdata.xlsx");
	private FileInputStream fis;

	@BeforeSuite
	public void setup() {

		try {
			fis = new FileInputStream(".\\src\\test\\resources\\properties\\config.properties");
		} catch (FileNotFoundException e1) {

			e1.printStackTrace();
		}
		try {
			config.load(fis);
		} catch (IOException e) {

			e.printStackTrace();
		}

		RestAssured.baseURI = config.getProperty("baseURI");
		RestAssured.basePath = config.getProperty("basePath");
	}

	@AfterSuite
	public void tearDown() {

	}
}
