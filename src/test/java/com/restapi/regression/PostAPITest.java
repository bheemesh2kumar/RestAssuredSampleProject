package com.restapi.regression;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostAPITest

{

	@Test
	public void validatepostrequest() {
		RestAssured.baseURI = "https://reqres.in/";

		RequestSpecification RequestSpecificationref = RestAssured.given();

		JSONObject JSONObjectref = new JSONObject();

		JSONObjectref.put("name", "morpheus");
		JSONObjectref.put("job", "leader");

		RequestSpecificationref.header("Content-Type", "application/json");

		RequestSpecificationref.body(JSONObjectref.toJSONString());

		Response response = RequestSpecificationref.request(Method.POST, "/api/users?page=2");

		String str = response.getBody().asString();

		System.out.println(str);

		String staline = response.getStatusLine();

		System.out.println(staline);

		int statuscode = response.getStatusCode();

		System.out.println(statuscode);

	}

}
