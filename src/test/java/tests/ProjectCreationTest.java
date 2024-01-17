package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.Test;
import pages.ProjectsPage;

public class ProjectCreationTest extends BaseTest {

    @Test(description = "Private project should be created")
    public void privateProjectShouldBeCreated() {
        new ProjectsPage()
                .openProjectsPage()
                .waitTillOpened()
                .clickCreateNewProjectButton()
                .setProjectName(projectName)
                .setProjectCode(projectCode)
                .clickCreateProjectButton()
                .projectNameShouldDisplayed(projectName)
                .projectCodeShouldDisplayed(projectCode);

    }

    @Test
    public void publicProjectShouldBeCreated() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        String projectName = faker.dog().name();
        String projectCode = faker.dog().name();
        String projectDescription = faker.app().name();


        loginPage.login(user, password);
        projectPage.clickCreateNewProjectButton();
        projectPage.setProjectName(projectName);

        projectPage.setProjectCode(projectCode);
        projectPage.setProjectDescription(projectDescription);
        projectPage.clickRadioButtonPublic();
        projectPage.clickCreateProjectButton();
        projectPage.projectNameShouldDisplayed(projectName);


    }
}