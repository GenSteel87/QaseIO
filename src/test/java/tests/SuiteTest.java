package tests;

import org.testng.annotations.Test;

public class SuiteTest extends BaseTest{
    @Test
    public void suiteShouldBeCreated() {

        String projectName = faker.app().name();
        String projectCode = faker.app().name();
        String projectDescription = faker.app().name();

        loginPage.openPage();
        loginPage.login(user, password);
        projectPage.waitTillOpened();
        projectPage.createNewPrivateProject(projectName, projectCode, projectDescription);
        projectPage.projectNameShouldDisplayed(projectName);
    }
}
