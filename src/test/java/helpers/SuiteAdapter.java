package helpers;

import models.Project;
import models.Suite;

import static io.restassured.RestAssured.given;

public class SuiteAdapter extends ProjectAdapter{

    public String create(Suite suite, String projectCode) {
        given()
                .body(suite)
                .header("Token", "a5662d8e919db636b5d2453930e40319716e657d2fde9c322fa725dee49c2ea7")
                .header("Content-Type", "application/json")
        .when()
                .post("https://api.qase.io/v1/suite/" + projectCode.toUpperCase())
        .then()
                .log().all();
        return suite.getTitle();
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
