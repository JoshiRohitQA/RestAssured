package RestAssured.APITesting;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Revise {
	
	@Test
	public void revAPi() {
		RequestSpecification requestSpec=RestAssured.given();
		requestSpec.baseUri("https://gorest.co.in");
		requestSpec.basePath("/public/v2/users");
		requestSpec.contentType(ContentType.JSON);
		String bearerToken="Bearer e488a2f65f919a8d12def8057e6eec8313225491191762f67bb9b8d2eff4dd78";
		requestSpec.headers("Authorization",bearerToken);
		JSONObject jsondata = new JSONObject();
		jsondata.put("name", "RohitJoshi");
		jsondata.put("email", "rohit12345@yopmail.com");
		jsondata.put("gender", "Male");
		jsondata.put("status", "active");
		
		requestSpec.body(jsondata.toJSONString());
		Response response=requestSpec.post();
		ResponseBody responseBody=response.getBody();
		String stringResponse=responseBody.asPrettyString();
		System.out.println(stringResponse);
		JsonPath jsonpathview=responseBody.jsonPath();
		String mail=jsonpathview.get("email");
		Assert.assertEquals(mail, "rohit12345@yopmail.com");
		Assert.assertEquals(response.statusCode(), 201);
		
		
		
		
	}

}
