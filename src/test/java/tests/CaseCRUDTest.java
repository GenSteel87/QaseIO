package tests;

import helpers.DataFactory;
import helpers.ProjectAdapter;
import helpers.SuiteAdapter;
import models.Case;
import models.Project;
import models.Suite;
import org.testng.annotations.Test;

import java.util.HashMap;

public class CaseCRUDTest extends BaseTest {
    @Test(description = "Test case should be created")
    public void testCaseShouldBeCreated() {
        Project project = DataFactory.getRandomProject();
        Suite suite = DataFactory.getRandomSuite(project.getCode());
        Case testCase = DataFactory.getRandomCase(project.getCode(), suite.getTitle());
        HashMap<String, String> fieldValues = Case.DropDowns.mapWithValuesForTheCaseTest();

        ProjectAdapter projectAdapter = new ProjectAdapter();
        projectAdapter.create(project);
        SuiteAdapter suiteAdapter = new SuiteAdapter();
        suiteAdapter.create(suite, project.getCode());



        loginPage.
                openLoginPage().
                login(user, password);
        projectsPage.
                waitTillOpened().
                waitTillAllProjectsAppears().
                openPageOfProject(project.getTitle());
        projectPage.
                waitTillAllTestCasesAppear().
                waitTillOpened().
                clickAddTestCaseButton();
        casePage.
                setTitle(testCase.getTitle()).
                setDescription(testCase.getDescription()).
                selectCreatedSuiteFromDropDown(suite.getTitle()).
                selectOptionFromDropDownAll(fieldValues).
                clickSaveButton();
        projectPage.
                createCaseSuccessNotificationShouldDisplayed().
                caseTitleShouldDisplayed(testCase.getTitle());
    }
}
