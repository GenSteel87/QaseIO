package tests;

import helpers.DataFactory;
import models.Project;
import org.testng.annotations.Test;
import pages.LoginPage;

public class ProjectCRUDTest extends BaseTest {

    @Test(description = "Private project should be created")
    public void privateProjectShouldBeCreated() {
        Project project = DataFactory.getRandomProject();

        new LoginPage()
                .openLoginPage()
                .login(user, password)
                .waitTillOpened()
                .clickCreateNewProjectButton()
                .setProjectName(project.getTitle())
                .setProjectCode(project.getCode())
                .setProjectDescription(project.getDescription())
                .clickCreateProjectButton()
                .projectNameShouldDisplayed(project.getTitle())
                .projectCodeShouldDisplayed(project.getCode());

    }

    @Test(description = "Private project should be updated")
    public void privateProjectShouldBeUpdated() {
        Project project = DataFactory.getRandomProject();
        Project updatedProject = DataFactory.getRandomProject();

        new LoginPage()
                .openLoginPage()
                .login(user, password)
                .waitTillOpened()
                .createPrivateProject(project.getTitle(), project.getCode())
                .projectNameShouldDisplayed(project.getTitle())
                .projectCodeShouldDisplayed(project.getCode())
                .clickSettingsButton()
                .setProjectName(updatedProject.getTitle())
                .setProjectCode(updatedProject.getCode())
                .setProjectDescription(updatedProject.getDescription())
                .clickRadioButtonPublic()
                .clickUpdateSettingsButton()
                .checkSuccessNotification();

    }
    @Test(description = "Private project should be deleted")
    public void privateProjectShouldBeDeleted() {
        Project project = DataFactory.getRandomProject();

        new LoginPage()
                .openLoginPage()
                .login(user, password)
                .waitTillOpened()
                .createPrivateProject(project.getTitle(), project.getCode())
                .projectNameShouldDisplayed(project.getTitle())
                .projectCodeShouldDisplayed(project.getCode())
                .clickSettingsButton()
                .clickDeleteProjectButton()
                .clickConfirmDeleteProjectButton()
                .projectNameShouldNotBeDisplayed(project.getTitle());

    }
}