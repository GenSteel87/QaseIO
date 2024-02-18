package helpers;

import io.qameta.allure.Step;
import models.Project;
import utils.PropertyReader;

import static io.restassured.RestAssured.given;

public class ProjectAdapter{
    public final String token = System.getProperty("TOKEN", PropertyReader.getProperty("DEF_TOKEN"));
    @Step("Create new project by API")
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
}
