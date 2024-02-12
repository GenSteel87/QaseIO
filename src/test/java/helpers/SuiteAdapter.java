package helpers;

import models.Suite;

import static io.restassured.RestAssured.given;

public class SuiteAdapter extends ProjectAdapter{
    public String create(Suite suite, String projectCode) {
        given()
                .body(suite)
                .header("Token", TOKEN)
                .header("Content-Type", "application/json")
        .when()
                .post("https://api.qase.io/v1/suite/" + projectCode.toUpperCase())
        .then()
                .log().all();
        return suite.getTitle();
    }
}
