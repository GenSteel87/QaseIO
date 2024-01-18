package tests;

import org.testng.annotations.Test;

public class SuiteTest extends BaseTest{
    @Test
    public void suiteShouldBeCreated() {
        loginPage.login(user, password);
        projectPage.waitTillOpened();
        projectPage.projectNameShouldDisplayed(projectName);
    }
}
