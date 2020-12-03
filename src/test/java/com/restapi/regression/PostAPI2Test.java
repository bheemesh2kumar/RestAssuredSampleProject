package com.restapi.regression;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostAPI2Test

{

	@Test
	public void postcreatevaliation() {

		RestAssured.baseURI = "https://reqres.in/";

		RequestSpecification Requestspecificationref = RestAssured.given();

		JSONObject JSONObjectref = new JSONObject();

		JSONObjectref.put("email", "eve.holt@reqres.in");

		JSONObjectref.put("password", "pistol");

		Requestspecificationref.header("Content-Type", "application/json");

		Requestspecificationref.body(JSONObjectref.toJSONString());

		Response response = Requestspecificationref.request(Method.POST, "/api/register");

		System.out.println("status code" + response.getStatusCode());

		System.out.println("status line" + response.getStatusLine());

		Headers headers = response.headers();

		for (Header header : headers) 
		{

			System.out.println("header name is " + header.getName() + "*******" + header.getValue());

		}

	}

}
