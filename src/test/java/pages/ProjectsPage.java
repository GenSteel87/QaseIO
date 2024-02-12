package pages;

import com.codeborne.selenide.Condition;
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
    final String PROJECT_LINK_BUTTON = "//a[text()='%s']";
    final String PAGINATION = "//label[text()='Rows per page:']";

    private final SelenideElement createNewProjectButton = $(By.id(CREATE_NEW_PROJECT_ID));
    private final SelenideElement projectNaneField = $(By.id(PROJECT_NAME_ID));
    private final SelenideElement projectCodeField = $(By.id(PROJECT_CODE_ID));
    private final SelenideElement projectDescriptionField = $(By.id(PROJECT_DESCRIPTION_ID));
    private final SelenideElement createProjectButton = $(CREATE_PROJECT_CSS);
    private final SelenideElement radioButtonPublic = $(RADIO_BUTTON_PUBLIC_CSS);
    private final SelenideElement projectLinkButton = $(By.xpath(PROJECT_LINK_BUTTON));
    private final SelenideElement pagination = $(By.xpath(PAGINATION));

    @Step("Open Projects Page")
    public ProjectsPage openProjectsPage() {
        open("/projects");
        return this;
    }
    @Step("Open Project page")
    public ProjectsPage openPage(String projectCode) {
        open("/project/" + projectCode.toUpperCase());
        return new ProjectPage();
    }
    @Step("Open Project page")
    public ProjectsPage openPageOfProject(String projectName) {
        $(By.xpath(String.format(PROJECT_LINK_BUTTON, projectName))).shouldBe(Condition.visible).click();
        return new ProjectPage();
    }
    @Step("Create new project is visible")
    public ProjectsPage waitTillOpened() {
        createProjectButton.shouldBe(Condition.visible);
        return this;
    }
    @Step("All projects should be visible")
    public ProjectsPage waitTillAllProjectsAppears() {
        pagination.shouldBe(Condition.appear);
        return this;
    }
    @Step("Click [Create new project] button")
    public ProjectsPage clickCreateNewProjectButton() {
        createNewProjectButton.click();
        return this;
    }
    @Step("Set project name")
    public ProjectsPage setProjectName(String title) {
        projectNaneField.sendKeys(Keys.CONTROL + "a");
        projectNaneField.sendKeys(Keys.DELETE);
        projectNaneField.sendKeys(title);
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
    @Step("Check project name")
    public ProjectPage projectNameShouldNotBeDisplayed(String projectName) {
        $(By.xpath("//div[contains(text(),'" + projectName + "')]")).shouldBe(Condition.not(Condition.visible));
        return new ProjectPage();
    }
    @Step("Check project code")
    public ProjectPage projectCodeShouldDisplayed(String projectCode) {
        $(By.xpath("//h1[contains(text(),'" + projectCode.toUpperCase() + "')]")).shouldBe(Condition.visible);
        return new ProjectPage();
    }
    @Step("Create private project")
    public ProjectPage createPrivateProject(String projectName, String projectCode) {
        clickCreateNewProjectButton();
        setProjectName(projectName);
        setProjectCode(projectCode);
        clickCreateProjectButton();
        return new ProjectPage();
    }
    @Step("Create public project")
    public ProjectPage createPublicProject(String projectName, String projectCode) {
        clickCreateNewProjectButton();
        setProjectName(projectName);
        setProjectCode(projectCode);
        clickCreateProjectButton();
        clickRadioButtonPublic();
        return new ProjectPage();
    }

}
