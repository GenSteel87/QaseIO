package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProjectsPage extends LoginPage{

    final String CREATE_NEW_PROJECT_ID = "createButton";
    final String PROJECT_NAME_ID = "project-name";
    final String PROJECT_CODE_ID = "project-code";
    final String PROJECT_DESCRIPTION_ID = "description-area";
    final String CREATE_PROJECT_CSS = "[type=submit]";
    final String RADIO_BUTTON_PUBLIC_CSS = "[value=public]";

    private final SelenideElement createNewProjectButton = $(By.id(CREATE_NEW_PROJECT_ID));
    private final SelenideElement projectNaneField = $(By.id(PROJECT_NAME_ID));
    private final SelenideElement projectCodeField = $(By.id(PROJECT_CODE_ID));
    private final SelenideElement projectDescriptionField = $(By.id(PROJECT_DESCRIPTION_ID));
    private final SelenideElement createProjectButton = $(CREATE_PROJECT_CSS);
    private final SelenideElement radioButtonPublic = $(RADIO_BUTTON_PUBLIC_CSS);

    @Step("Open Projects Page")
    public ProjectsPage openProjectsPage() {
        open("/projects");
        return this;
    }
    @Step("Create new project is visible")
    public ProjectsPage waitTillOpened() {
        createProjectButton.shouldBe(Condition.visible);
        return this;
    }
    @Step("Click [Create new project] button")
    public ProjectsPage clickCreateNewProjectButton() {
        createNewProjectButton.click();
        return this;
    }
    @Step("Set project name")
    public ProjectsPage setProjectName(String projectName) {
        projectNaneField.sendKeys(projectName);
        return this;
    }
    @Step("Set project code")
    public ProjectsPage setProjectCode(String projectCode) {
        projectCodeField.sendKeys(Keys.CONTROL + "a");
        projectCodeField.sendKeys(Keys.DELETE);
        projectCodeField.sendKeys(projectCode);
        return this;
    }
    @Step("Set project description")
    public ProjectsPage setProjectDescription(String projectDescription) {
        projectDescriptionField.sendKeys(projectDescription);
        return this;
    }
    @Step("Click [Public] radio button")
    public ProjectsPage clickRadioButtonPublic() {
        radioButtonPublic.click();
        return this;
    }
    @Step("Click [Create button]")
    public ProjectPage clickCreateProjectButton() {
       createProjectButton.click();
       return new ProjectPage();
    }
    @Step("Check project name")
    public ProjectPage projectNameShouldDisplayed(String projectName) {
        $(By.xpath("//div[contains(text(),'" + projectName + "')]")).shouldBe(Condition.visible);
        return new ProjectPage();
    }
    @Step("Check project code")
    public ProjectsPage projectCodeShouldDisplayed(String projectCode) {
        $(By.xpath("//h1[contains(text(),'" + projectCode.toUpperCase() + "')]")).shouldBe(Condition.visible);
        $(By.xpath("//h1[contains(text(),'" + projectCode.toUpperCase() + "')]")).getText();
        return this;
    }




}
