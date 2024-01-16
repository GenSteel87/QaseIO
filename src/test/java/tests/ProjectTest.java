package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.Test;

public class ProjectTest extends BaseTest {

    @Test
    public void privateProjectShouldBeCreated() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        String projectName = faker.dog().name();
        String projectCode = faker.dog().name();
        String projectDescription = faker.app().name();

        loginPage.openPage();
        loginPage.login(user, password);
        projectPage.waitTillOpened();
        projectPage.clickCreateNewProjectButton();
        projectPage.setProjectName(projectName);
        projectPage.clearProjectCode();
        projectPage.setProjectCode(projectCode);
        projectPage.setProjectDescription(projectDescription);
        projectPage.clickCreateProjectButton();
        projectPage.projectNameShouldDisplayed(projectName);

    }

    @Test
    public void publicProjectShouldBeCreated() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        String projectName = faker.dog().name();
        String projectCode = faker.dog().name();
        String projectDescription = faker.app().name();

        loginPage.openPage();
        loginPage.login(user, password);
        projectPage.clickCreateNewProjectButton();
        projectPage.setProjectName(projectName);
        projectPage.clearProjectCode();
        projectPage.setProjectCode(projectCode);
        projectPage.setProjectDescription(projectDescription);
        projectPage.clickRadioButtonPublic();
        projectPage.clickCreateProjectButton();
        projectPage.projectNameShouldDisplayed(projectName);


    }
}