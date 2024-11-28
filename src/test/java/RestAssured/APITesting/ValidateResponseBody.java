package RestAssured.APITesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ValidateResponseBody {

	@Test
	public void validateREs() {
		
	//	RestAssured.given().baseUri("https://api.restful-api.dev/objects").when().get().then().statusCode(200).log().all();
		
		RequestSpecification reqspec=RestAssured.given();
		
		reqspec.baseUri("https://api.restful-api.dev");
		reqspec.basePath("/objects");
		
		Response response=reqspec.get();
		
		
		ResponseBody responseBody=response.getBody();
		
		String responseString=responseBody.asPrettyString();
		
		System.out.println("Response Body:"+ responseString);
		
	//	Assert.assertEquals(responseString.contains("Apple Watch Series 8"), true);
		
		JsonPath jsonpathview=responseBody.jsonPath();
		
		String firstNamePath=jsonpathview.get("[1].name");
		
		Assert.assertEquals(firstNamePath, "Apple iPhone 12 Mini, 256GB, Blue");
		
		Assert.assertEquals(response.statusCode(), 200);
		
		
		
	}
}
