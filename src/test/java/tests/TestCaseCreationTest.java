package tests;

import org.testng.annotations.Test;
import pages.ProjectPage;
import pages.TestCasePage;

public class TestCaseCreationTest extends BaseTest{
    @Test(description = "Test case should be created")
    public void testCaseShouldBeCreated() {
        new ProjectPage()
                .openLoginPage()
                .login(user, password)
                .createPrivateProject(projectName, projectCode)
                .clickAddSuiteButton()
                .createSuite(suiteName)
                .clickAddTestCaseButton()
                .setTitle(testCaseTitle)
                .fillAllDropdownsWithFirstValue()
                .clickSaveButton();
    }
}
