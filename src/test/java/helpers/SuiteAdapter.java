package helpers;

import io.qameta.allure.Step;
import models.Suite;

import static io.restassured.RestAssured.given;

public class SuiteAdapter extends ProjectAdapter{
    @Step("Create suite by API")
    public String create(Suite suite, String projectCode) {
        given()
                .body(suite)
                .header("Token", token)
                .header("Content-Type", "application/json")
        .when()
                .post("https://api.qase.io/v1/suite/" + projectCode.toUpperCase())
        .then()
                .log().all()
                .statusCode(200);
        return suite.getTitle();
    }
}
