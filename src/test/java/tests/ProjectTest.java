package tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class ProjectTest extends BaseTest {
    @Test
    public void privateProjectShouldBeCreated() {
        String projectName = faker.app().name();
        String projectCode = faker.app().name();
        String projectDescription = faker.app().name();

        loginPage.openPage();
        loginPage.login(user, password);
        projectPage.waitTillOpened();
        projectPage.createNewPrivateProject(projectName, projectCode, projectDescription);
        projectPage.projectNameShouldDisplayed(projectName);
        projectPage.projectCodeShouldDisplayed(projectCode);
    }

    @Test
    public void publicProjectShouldBeCreated() {
        String projectName = faker.app().name();
        String projectCode = faker.app().name();
        String projectDescription = faker.app().name();

        loginPage.openPage();
        loginPage.login(user, password);
        projectPage.waitTillOpened();
        projectPage.clickCreateNewProjectButton();
        projectPage.setProjectName(projectName);
        projectPage.setProjectCode(projectCode);
        projectPage.setProjectDescription(projectDescription);
        projectPage.clickRadioButtonPublic();
        projectPage.clickCreateProjectButton();
        projectPage.projectNameShouldDisplayed(projectName);
        projectPage.projectCodeShouldDisplayed(projectCode);

    }

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
        projectPage.projectCodeShouldDisplayed(projectCode);

    }

}
