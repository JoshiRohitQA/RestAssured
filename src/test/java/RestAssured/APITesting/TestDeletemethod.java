package RestAssured.APITesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class TestDeletemethod {
	
	@Test
	public void delete() {
		
		RestAssured.given().baseUri("https://api.restful-api.dev/objects/ff80818193213c960193214eec040044").when().delete().then().statusCode(200).log().all();
	}

}
