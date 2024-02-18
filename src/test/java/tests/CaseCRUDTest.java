package tests;

import helpers.CaseAdapter;
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
                waitTillPaginationAppears().
                clickOnNameOfProject(project.getTitle());
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
                caseTitleShouldDisplayed(testCase.getTitle()).
                clickTestCaseTitle(testCase.getTitle()).
                clickEditTestCase(testCase.getTitle());
        casePage.checkSelectOptionFromDropDownAll(fieldValues);
    }

    @Test(description = "Test case should be edited")
    public void testCaseShouldBeEdited() {
        Project project = DataFactory.getRandomProject();
        Case testCase = DataFactory.getRandomCaseByAPI(project.getCode());
        Case updatedTestCase = DataFactory.getRandomCaseWithOutSuite(project.getCode());

        ProjectAdapter projectAdapter = new ProjectAdapter();
        projectAdapter.create(project);
        CaseAdapter caseAdapter = new CaseAdapter();
        caseAdapter.create(testCase, project.getCode());

        loginPage.
                openLoginPage().
                login(user, password);
        projectsPage.
                waitTillOpened().
                waitTillPaginationAppears().
                clickOnNameOfProject(project.getTitle());
        projectPage.
                waitTillAllTestCasesAppear().
                waitTillOpened().
                caseTitleShouldDisplayed(testCase.getTitle()).
                clickTestCaseTitle(testCase.getTitle()).
                clickEditTestCase(testCase.getTitle());
        casePage.
                setTitle(updatedTestCase.getTitle()).
                editDescription(testCase.getDescription(), updatedTestCase.getDescription()).
                editPreConditions(testCase.getPreconditions(), updatedTestCase.getPreconditions()).
                clickSaveButton();
        projectPage.
                editCaseSuccessNotificationShouldDisplayed().
                caseTitleShouldDisplayed(updatedTestCase.getTitle()).
                clickTestCaseTitle(updatedTestCase.getTitle()).
                clickEditTestCase(updatedTestCase.getTitle());
        casePage.
                caseDescriptionShouldBeDisplayed(updatedTestCase.getDescription()).
                casePreConditionsShouldBeDisplayed(updatedTestCase.getPreconditions());
    }

    @Test(description = "Test case should be deleted")
    public void testCaseShouldBeDeleted() {
        Project project = DataFactory.getRandomProject();
        Case testCase = DataFactory.getRandomCaseByAPI(project.getCode());

        ProjectAdapter projectAdapter = new ProjectAdapter();
        projectAdapter.create(project);
        CaseAdapter caseAdapter = new CaseAdapter();
        caseAdapter.create(testCase, project.getCode());

        loginPage.
                openLoginPage().
                login(user, password);
        projectsPage.
                waitTillOpened().
                waitTillPaginationAppears().
                clickOnNameOfProject(project.getTitle());
        projectPage.
                waitTillAllTestCasesAppear().
                waitTillOpened().
                caseTitleShouldDisplayed(testCase.getTitle()).
                clickTestCaseTitle(testCase.getTitle()).
                clickDeleteCaseButton().
                clickConfirmDeleteCaseButton().
                deleteTestCasePopupShouldNotBeDisplayed().
                testCaseTitleShouldNotBeDisplayed(testCase.getTitle());
    }
}
