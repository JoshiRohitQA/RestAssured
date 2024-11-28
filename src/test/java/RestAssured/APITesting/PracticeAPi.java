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

public class PracticeAPi {
	
	@Test
	public void testAPI() {
		
		
		RequestSpecification requestSpec=RestAssured.given();
		
		requestSpec.baseUri("https://api.restful-api.dev/objects");
		requestSpec.contentType(ContentType.JSON);
		
		JSONObject jsondata = new JSONObject();
		jsondata.put("name", "Apple MacBook Pro 16");
		JSONObject data = new JSONObject();
		data.put("year", 2023);
		data.put("price",1849.99);
		data.put("CPU model", "Intel Core i9");
		data.put("Hard disk size", "1 TB");
		data.put("color", "red");
		
		jsondata.put("data", data);
		requestSpec.body(jsondata.toJSONString());
		
		Response response=requestSpec.post();
		
		ResponseBody responseBody=response.getBody();
		String resBody=responseBody.asPrettyString();
		System.out.println("Response is ->"+ resBody);
		
		JsonPath jsonpathview=responseBody.jsonPath();
		String fristnamepath=jsonpathview.get("name");
		
		Assert.assertEquals(fristnamepath,"Apple MacBook Pro 16" );
		Assert.assertEquals(response.statusCode(), 200);
		
		
		
	}

}
