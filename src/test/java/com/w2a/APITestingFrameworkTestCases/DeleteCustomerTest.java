package com.w2a.APITestingFrameworkTestCases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.APITestingFramework.utilities.DataUtil;
import com.w2a.APITestingFrameworkSetUp.BaseTest;

import APITestingFramework.APIs.DeleteCustomerAPI;
import io.restassured.response.Response;

public class DeleteCustomerTest extends BaseTest {

	@Test(dataProviderClass = DataUtil.class, dataProvider = "data")
	public void deleteCustomer(Hashtable<String, String> data) {

		Response response = DeleteCustomerAPI.sendDeleteRequesttoDeleteCustomerAPIWithValidId(data);
		// ExtentListeners.testReport.get().info(data.toString());

		response.prettyPrint();
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.statusCode(), 200);
	}

}