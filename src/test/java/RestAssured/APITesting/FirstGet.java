package RestAssured.APITesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FirstGet {

	@Test
	public void testFirst() {
		Response res=RestAssured.get("https://api.restful-api.dev/objects/7");
		System.out.println(res.asPrettyString());
		System.out.println(res.getStatusCode());
		Assert.assertEquals(200, res.getStatusCode());
		
	}
	
}
