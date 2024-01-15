package tests;

import org.testng.annotations.Test;

import static org.checkerframework.checker.units.qual.Prefix.nano;

public class ProjectTest extends BaseTest {

    @Test
    public void privateProjectShouldBeCreated() {
        String projectName = faker.dog().name();
        String projectCode = faker.dog().name();
        String projectDescription = faker.app().name();

        loginPage.openPage();
        loginPage.login(user, password);
        projectPage.waitTillOpened();
        System.out.println("нажать");
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

        String projectName = faker.dog().name();
        String projectCode = faker.dog().name();
        String projectDescription = faker.app().name();

        loginPage.openPage();
        loginPage.login(user, password);
        System.out.println("нажать");
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