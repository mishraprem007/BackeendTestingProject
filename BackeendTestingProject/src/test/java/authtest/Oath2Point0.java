package authtest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Oath2Point0 {

	@Test
	public void oauth2Test() {
		Response resp = given().formParam("client_id", "ninza-client")
				.formParam("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
				.formParam("grant_type", "client_credentials").when()
				.post("http://49.249.29.4:8180/auth/realms/ninza/protocol/openid-connect/token");

		resp.then().log().all();

		String token = resp.jsonPath().get("access_token");
		System.out.println(token);
	}
}
