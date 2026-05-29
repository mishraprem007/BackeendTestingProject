package wireMocking;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class WireMockingClass {
	@Test
	public void wireMockTest() {
		JSONObject jObj = new JSONObject();
		jObj.put("debitCardNum", "1234567887654321");
		jObj.put("cvv", "543");
		jObj.put("expDate", "28/30");

		given().contentType(ContentType.JSON).body(jObj).when().post("http://localhost:9999/debitCard").then().log()
				.all();

	}
}
