import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class ProjectTest extends BaseTest {
    @Test
    public void privateProjectShouldBeCreated() {
        String projectName = faker.app().name();
        String projectCode = faker.app().name();
        String projectDescription = faker.app().name();

        loginPage.openPage();
        loginPage.login("yauhenitest.stalkoutest@gmail.com", "123456Test_1G!");
        projectPage.waitTillOpened();
        projectPage.createNewPrivateProject(projectName, projectCode, projectDescription);
        $(By.xpath("//div[contains(text(),'" + projectName + "')]")).shouldBe(Condition.visible);
        $(By.xpath("//h1[contains(text(),'" + projectCode.toUpperCase() + "')]")).shouldBe(Condition.visible);
    }

    @Test
    public void publicProjectShouldBeCreated() {
        String projectName = faker.app().name();
        String projectCode = faker.app().name();
        String projectDescription = faker.app().name();

        loginPage.openPage();
        loginPage.login("yauhenitest.stalkoutest@gmail.com", "123456Test_1G!");
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

}
