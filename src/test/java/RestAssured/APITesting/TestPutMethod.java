package RestAssured.APITesting;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class TestPutMethod {

	@Test
	public void testput() {
		
		JSONObject jsondata = new JSONObject();
		jsondata.put("name", "Apple MacBook Pro 16");
		JSONObject data = new JSONObject();
		data.put("year", 2023);
		data.put("price",1849.99);
		data.put("CPU model", "Intel Core i9");
		data.put("Hard disk size", "1 TB");
		data.put("color", "red");
		
		jsondata.put("data", data);
		
		RestAssured.given().baseUri("https://api.restful-api.dev/objects/ff80818193213c960193214eec040044").contentType(ContentType.JSON).body(jsondata.toJSONString()).when().put().then().statusCode(200).log().all();	
	}
}
