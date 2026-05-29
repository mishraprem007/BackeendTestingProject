package sslHandling;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class SSLHandlingTest {

	@Test
	public void sslAndTslTest() {
		JSONObject jObj = new JSONObject();
		jObj.put("city", "Banglore");
		jObj.put("country", "India");
		jObj.put("email", "test43986@gmail.com");
		jObj.put("firstName", "TestName");
		jObj.put("gender", "MALE");
		jObj.put("lastName", "TestLastName");
		jObj.put("password", "Banglore@12");
		jObj.put("phone", "9802768901");
		jObj.put("state", "KARNATKA");
		jObj.put("zoneId", "ALPHA");

		given().relaxedHTTPSValidation().contentType(ContentType.JSON).body(jObj).when()
				.post("https://www.shoppersstack.com/shopping/shoppers").then().log().all();
	}
}
