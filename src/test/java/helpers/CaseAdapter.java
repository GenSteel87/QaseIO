package helpers;

import models.Case;

import static io.restassured.RestAssured.given;

public class CaseAdapter extends ProjectAdapter{
    public String create(Case testCase, String projectCode) {
        given()
                .body(testCase)
                .header("Token", token)
                .header("Content-Type", "application/json")
        .when()
                .post("https://api.qase.io/v1/case/" + projectCode.toUpperCase())
        .then()
                .log().all()
                .statusCode(200);
        return testCase.getTitle();
    }
}
