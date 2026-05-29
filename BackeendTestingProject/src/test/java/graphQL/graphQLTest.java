package graphQL;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class graphQLTest {
	@Test
	public void getAllTest() {

		String query = "{ getAllProjects{ projectId projectName status } }";
		given().contentType(ContentType.JSON).body(query).when().post("http://49.249.29.4:8091/getAll").then().log()
				.all();
	}

	@Test
	public void getParticualrTest() {

		String query = "{ getAllProjects{ projectId  status } }";
		given().contentType(ContentType.JSON).body(query).when().post("http://49.249.29.4:8091/getAll").then().log()
				.all();
	}

	@Test
	public void addProject_graphqlTest() {
		String query = "mutation { addProject( projectName: \"Project Name\", teamSize: 5, createdBy: \"John Doe\", createdOn: \"2024-07-05\", status: \"Created\" ) { projectId projectName teamSize createdBy createdOn status } }";

		given().contentType(ContentType.JSON).body(query).when().post("http://49.249.29.4:8091/addProject-graphql")
				.then().log().all();

	}

	@Test
	public void getProject_graphqlTest() {
		String query = "{ findProject(projectId:\"NH_PROJ_***\"){ projectId projectName status createdBy teamSize } }";

		given().contentType(ContentType.JSON).body(query).when().post("http://49.249.29.4:8091/getProjectByProjectId")
				.then().log().all();

	}

	@Test
	public void updateProject_graphqlTest() {
		String query = " mutation { updateProject( projectId: \"NH_PROJ_117\" projectName: \"Updated Project Name\", teamSize: 1, createdBy: \"John Doe\", createdOn: \"2024-07-05\", status: \"Created\" ) { projectId projectName teamSize createdBy createdOn status } }";

		given().contentType(ContentType.JSON).body(query).when().post("http://49.249.29.4:8091/updateProject-graphql")
				.then().log().all();

	}

}
