package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProjectsPage;

public class ProjectCreationTest extends BaseTest {

    @Test(description = "Private project should be created")
    public void privateProjectShouldBeCreated() {
        new LoginPage()
                .openLoginPage()
                .login(user, password)
                .waitTillOpened()
                .clickCreateNewProjectButton()
                .setProjectName(projectName)
                .setProjectCode(projectCode)
                .setProjectDescription(projectDescription)
                .clickCreateProjectButton()
                .projectNameShouldDisplayed(projectName)
                .projectCodeShouldDisplayed(projectCode);

    }

    @Test(description = "Public project should be created")
    public void publicProjectShouldBeCreated() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        new LoginPage()
                .openLoginPage()
                .login(user, password)
                .waitTillOpened()
                .clickCreateNewProjectButton()
                .setProjectName(projectName)
                .setProjectCode(projectCode)
                .setProjectDescription(projectDescription)
                .clickRadioButtonPublic()
                .clickCreateProjectButton()
                .projectNameShouldDisplayed(projectName)
                .projectCodeShouldDisplayed(projectCode);

    }
}