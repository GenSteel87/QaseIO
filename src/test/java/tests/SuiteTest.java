package tests;

import org.testng.annotations.Test;

public class SuiteTest extends BaseTest{
    @Test
    public void suiteShouldBeCreated() {

        String projectName = faker.app().name();
        String projectCode = faker.app().name();
        String projectDescription = faker.app().name();


        loginPage.login(user, password);
        projectPage.waitTillOpened();

        projectPage.projectNameShouldDisplayed(projectName);
    }
}
