package schemaValidation;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;
import PojoClassUtility.ProjectPojo;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class SchemaValidationTest {
	@Test
	public void sampleTest() {

		ProjectPojo pObj = new ProjectPojo("TestProject", "Created", "TestManager", 0);
		Response res = given().contentType(ContentType.JSON).body(pObj).when()
				.post("http://49.249.29.4:8091/addProject");
		res.then().log().all();
		res.then().body(JsonSchemaValidator.matchesJsonSchema(new File("./test_Resource//jsonschema.json")));

	}
}
