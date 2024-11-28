package RestAssured.APITesting;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class BearerAuthentication {

	@Test
	public void verifyBearer() {
		
		RequestSpecification requestspec=RestAssured.given();
		requestspec.baseUri("https://gorest.co.in");
		requestspec.basePath("public/v2/users");
		String auth="Bearer e488a2f65f919a8d12def8057e6eec8313225491191762f67bb9b8d2eff4dd78";
		requestspec.header("Authorization",auth);
		requestspec.contentType(ContentType.JSON);
		JSONObject jsondata = new JSONObject();	
		jsondata.put("name", "Rohit");
		jsondata.put("email", "rohit12345678@gmail.com");
		jsondata.put("gender", "Male");
		jsondata.put("status", "active");
		requestspec.body(jsondata.toJSONString());
		
		Response response=requestspec.post();
		ResponseBody responseBody=response.getBody();
		String stringResbody=responseBody.asPrettyString();
		System.out.println(stringResbody);
		
		JsonPath jsonpathview=responseBody.jsonPath();
		
		String emailpath=jsonpathview.get("email");
		
		
		Assert.assertEquals(emailpath, "rohit12345678@gmail.com");
		Assert.assertEquals(response.statusCode(), 201);
		if(response.getTime()<2000) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
		
		
	}
}
