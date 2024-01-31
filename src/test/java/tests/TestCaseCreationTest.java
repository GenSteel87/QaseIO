package tests;

import org.testng.annotations.Test;
import pages.ProjectPage;

import java.util.HashMap;

public class TestCaseCreationTest extends BaseTest {
    @Test(description = "Test case should be created")
    public void testCaseShouldBeCreated() {
        HashMap<String, String> labelAndOption = new HashMap<>();
        labelAndOption.put("Severity", "Major"); //
        labelAndOption.put("Priority", "Medium");
        labelAndOption.put("Type", "Functional");
        labelAndOption.put("Layer", "API");
        labelAndOption.put("Is flaky", "Yes");
        labelAndOption.put("Behavior", "Negative");
        labelAndOption.put("Automation status", "Manual");

        new ProjectPage()
                .openLoginPage()
                .login(user, password)
                .createPrivateProject(projectName, projectCode)
                .clickAddSuiteButton()
                .createSuite(suiteName)
                .clickAddTestCaseButton()
                .setTitle(testCaseTitle)
                .setDescription(testCaseDescription)
                .selectOptionFromDropDown("Suite", suiteName)
                .selectOptionFromDropDownAll(labelAndOption)
                .clickSaveButton();
    }
}
