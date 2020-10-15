package com.w2a.APITestingFramework.utilities;

import org.json.JSONObject;

public class TestUtils {
	public static boolean JsonhasKey(String Json, String key) {
		JSONObject jsonObject = new JSONObject(Json);
		return jsonObject.has(key);

	}

	public static String getJasonKeyValue(String Json, String key) {

		JSONObject jsonObject = new JSONObject(Json);
		return jsonObject.get(key).toString();

	}
}
