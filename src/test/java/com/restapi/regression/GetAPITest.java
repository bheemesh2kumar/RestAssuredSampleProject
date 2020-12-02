package com.restapi.regression;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAPITest {

	@Test
	public void getvalidation() {

		RestAssured.baseURI = "https://reqres.in";
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.GET, "/api/users?page=2");

		String str = response.getBody().asString();

		System.out.println(str);

		System.out.println(response.getStatusCode());

		System.out.println(response.getStatusLine());

	}

}
