package helpers;

import models.Project;
import utils.PropertyReader;

import static io.restassured.RestAssured.given;

public class ProjectAdapter {
    private final String TOKEN = System.getProperty("TOKEN", PropertyReader.getProperty("DEF_TOKEN"));
    public String create(Project project) {
        given()
                .body(project)
                .header("Token", TOKEN)
                .header("Content-Type", "application/json")
        .when()
                .post("https://api.qase.io/v1/project")
        .then()
                .log().all();
        return project.getCode().toUpperCase();
    }
    public Project getProjectByCode(String code) {
        ProjectApiResponse response =
        given()
                .header("Token", "a5662d8e919db636b5d2453930e40319716e657d2fde9c322fa725dee49c2ea7")
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
