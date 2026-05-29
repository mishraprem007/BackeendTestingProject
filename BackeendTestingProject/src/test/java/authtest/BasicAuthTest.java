package authtest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BasicAuthTest {

	@Test
	public void sampleTest() {
		JSONObject jObj = new JSONObject();
		jObj.put("password", "rmgy@9999");
		jObj.put("username", "rmgyantra");

		given().contentType(ContentType.JSON).body(jObj).auth().basic("rmgyantra", "rmgy@9999").log().all().when()
				.post("http://49.249.29.4:8091/login").then().log().all();

	}
}
