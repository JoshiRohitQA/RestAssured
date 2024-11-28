package RestAssured.APITesting;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class TestPatchMethod {
	@Test
	public void testpatch() {
		
		JSONObject jsondata = new JSONObject();
		jsondata.put("name", "Test Patch");
		
		RestAssured.given().baseUri("https://api.restful-api.dev/objects/ff80818193213c960193214eec040044").contentType(ContentType.JSON).body(jsondata.toJSONString()).when().patch().then().statusCode(200).log().all();	
	}
}


