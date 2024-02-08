package tests;

import helpers.DataFactory;
import helpers.ProjectAdapter;
import helpers.SuiteAdapter;
import models.Project;
import models.Suite;
import org.testng.annotations.Test;

public class SuiteCRUDTest extends BaseTest{
    @Test(description = "Suite should be created")
    public void suiteForProjectShouldBeCreated() {
        Project project = DataFactory.getRandomProject();
        Suite suite = DataFactory.getRandomSuite(project.getCode());

        ProjectAdapter projectAdapter = new ProjectAdapter();
        projectAdapter.create(project);

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
                clickAddSuiteButton().
                setSuiteName(suite.getTitle()).
                setSuiteDescription(suite.getDescription()).
                setSuitePrecondition(suite.getPreconditions()).
                clickCreateButton().
                suiteNameShouldDisplayed(suite.getTitle());

    }

    @Test(description = "Suite should be Updated")
    public void suiteShouldBeUpdated() {
        Project project = DataFactory.getRandomProject();
        Suite suite = DataFactory.getRandomSuite(project.getCode());
        Suite updatedSuite = DataFactory.getRandomSuite(project.getCode());

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
                clickEditeSuiteButton().
                setSuiteName(updatedSuite.getTitle()).
                setSuiteDescription(updatedSuite.getDescription()).
                setSuitePrecondition(updatedSuite.getPreconditions()).
                clickSaveSuiteButton().
                successNotificationIsDisplayed().
                suiteNameShouldDisplayed(updatedSuite.getTitle()).
                suiteDescriptionShouldDisplayed(updatedSuite.getDescription());

    }

    @Test(description = "Suite should be deleted")
    public void suiteShouldBeDeleted() {
        Project project = DataFactory.getRandomProject();
        Suite suite = DataFactory.getRandomSuite(project.getCode());

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
                clickDeleteSuiteButton().
                deleteSuiteNotificationWithSuiteNameShouldDisplayed(suite.getTitle()).
                clickConfirmDeleteSuiteButton().
                suiteNameShouldNotBeDisplayed(suite.getTitle());

    }

}
