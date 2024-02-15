package helpers;

import models.Project;
import utils.PropertyReader;

import static io.restassured.RestAssured.given;

public class ProjectAdapter {
    public final String token = System.getProperty("TOKEN", PropertyReader.getProperty("DEF_TOKEN"));
    public String create(Project project) {
        given()
                .body(project)
                .header("Token", token)
                .header("Content-Type", "application/json")
        .when()
                .post("https://api.qase.io/v1/project")
        .then()
                .log().all()
                .statusCode(200);
        return project.getCode().toUpperCase();
    }
    public Project getProjectByCode(String code) {
        ProjectApiResponse response =
        given()
                .header("Token", token)
                .header("Content-Type", "application/json")
        .when()
                .get("https://api.qase.io/v1/project"+ code.toUpperCase())
        .then()
                .log().all()
                .extract()
                .body().as(ProjectApiResponse.class);
        return response.getResult();

    }
}
