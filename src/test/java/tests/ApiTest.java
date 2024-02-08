package tests;

import com.google.gson.Gson;
import helpers.DataFactory;
import models.Project;
import models.VacancyResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ApiTest {
    @Test
    public void projectApi() {
        Project project = DataFactory.getRandomProject();

        given()
                .body(project)
                .header("Token", "a5662d8e919db636b5d2453930e40319716e657d2fde9c322fa725dee49c2ea7")
                .header("Content-Type", "application/json")
        .when()
                .post("https://api.qase.io/v1/project")
        .then()
                .log().all();
    }
}
