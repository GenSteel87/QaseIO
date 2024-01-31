package tests;

import org.testng.annotations.Test;
import pages.ProjectPage;

public class SuiteTest extends BaseTest{
    @Test(description = "Suite should be created")
    public void suiteShouldBeCreated() {
        new ProjectPage()
                .openLoginPage()
                .login(user, password)
                .createPrivateProject(projectName, projectCode)
                .clickAddSuiteButton()
                .setSuiteName(suiteName)
                .setSuiteDescription(suiteDescription)
                .setSuitePrecondition(suitePrecondition)
                .clickCreateButton()
                .suiteNameShouldDisplayed(suiteName);

    }

}
