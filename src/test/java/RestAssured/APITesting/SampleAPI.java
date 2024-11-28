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

public class SampleAPI {
	@Test
	public void sampleAPI() {
		RequestSpecification requestSpec=RestAssured.given();
		requestSpec.baseUri("https://gorest.co.in");
		requestSpec.basePath("/public/v2/users");
		requestSpec.contentType(ContentType.JSON);
		String bearerToken="Bearer e488a2f65f919a8d12def8057e6eec8313225491191762f67bb9b8d2eff4dd78";
		requestSpec.header("Authorization",bearerToken);
		
		JSONObject jsondata= new JSONObject();
		jsondata.put("name", "Sandeep");
		jsondata.put("email", "sandeep1111@yopmail.com");
		jsondata.put("gender", "Male");
		jsondata.put("status", "active");
		
		requestSpec.body(jsondata.toJSONString());
		Response response=requestSpec.post();
		ResponseBody responseBody=response.getBody();
		String responseBodyPretty=responseBody.asPrettyString();
		System.out.println(responseBodyPretty);
		
		JsonPath jsonpathview=responseBody.jsonPath();
		String emailvalue=jsonpathview.get("email");
		
		
		
		Assert.assertEquals(response.statusCode(), 201);
		Assert.assertEquals(emailvalue, "sandeep1111@yopmail.com");
		System.out.println(response.getTime());
		
		if(response.getTime()<2000) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
		
		
		
		
	}

}
