package RestAssured.APITesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test01getMethod {

	@Test
	public void testGet() {
		Response res=RestAssured.get("https://api.restful-api.dev/objects/7");
		System.out.println(res.getStatusCode());
		System.out.println(res.getBody().asPrettyString());
		System.out.println(res.getTime());
		System.out.println(res.getHeader("Content-Type"));
		
		
		Assert.assertEquals(200, res.getStatusCode());
	}
	
	@Test
	public void testget01() {
		
		RestAssured.given().baseUri("https://api.restful-api.dev/objects/7").when().get().then().statusCode(200).log().all();
	}
	
	
		
		
				
	}

