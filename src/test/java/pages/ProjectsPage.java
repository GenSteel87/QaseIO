package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class ProjectsPage extends LoginPage{

    final String CREATE_NEW_PROJECT_ID = "createButton";
    final String PROJECT_NAME_ID = "project-name";
    final String PROJECT_CODE_ID = "project-code";
    final String PROJECT_DESCRIPTION_ID = "description-area";
    final String CREATE_PROJECT_CSS = "[type=submit]";
    final String RADIO_BUTTON_PUBLIC_CSS = "[value=public]";
    final String PROJECT_LINK_BUTTON = "//*[contains(text(), '/s')]";
    final String PAGINATION = "//label[text()='Rows per page:']";
    final String THREE_DOTS_BUTTON = "[data-icon='ellipsis']";
    final String REMOVE_BUTTON = "//button[text()='Remove']";
    final String DELETE_PROJECT_BUTTON = "//button/span[text()='Delete project']";

    private final SelenideElement createNewProjectButton = $(By.id(CREATE_NEW_PROJECT_ID));
    private final SelenideElement projectNaneField = $(By.id(PROJECT_NAME_ID));
    private final SelenideElement projectCodeField = $(By.id(PROJECT_CODE_ID));
    private final SelenideElement projectDescriptionField = $(By.id(PROJECT_DESCRIPTION_ID));
    private final SelenideElement createProjectButton = $(CREATE_PROJECT_CSS);
    private final SelenideElement radioButtonPublic = $(RADIO_BUTTON_PUBLIC_CSS);
    private final SelenideElement pagination = $(By.xpath(PAGINATION));
    private final SelenideElement threeDotsButton = $(THREE_DOTS_BUTTON_CSS);
    private final SelenideElement removeProjectButton = $x(REMOVE_BUTTON);
    private final SelenideElement deleteProjectButton = $x(DELETE_PROJECT_BUTTON);

    @Step("Open Projects Page")
    public ProjectsPage openProjectsPage() {
        log.info("Open Projects Page");
        open("/projects");
        return this;
    }
    @Step("Open Project page /project/ + '{projectCode}'")
    public ProjectsPage openPage(String projectCode) {
        log.info("Open Project page /project/ + '{}'", projectCode);
        open("/project/" + projectCode.toUpperCase());
        return new ProjectPage();
    }
    @Step("Open Project page: '{projectName}'")
    public ProjectsPage openPageOfProject(String projectName) {
        log.info("Open Project page: '{}'", projectName);
        $(By.xpath("//*[contains(text(), '" + projectName + "')]" )).shouldBe(Condition.visible).click();
        return new ProjectPage();
    }
    @Step("Create new project is visible")
    public ProjectsPage waitTillOpened() {
        log.info("Create new project is visible");
        createProjectButton.shouldBe(Condition.visible);
        return this;
    }
    @Step("Pagination should appear")
    public ProjectsPage waitTillPaginationAppears() {
        log.info("Pagination should appear");
        pagination.shouldBe(Condition.appear);
        return this;
    }
    @Step("Click [Create new project] button")
    public ProjectsPage clickCreateNewProjectButton() {
        log.info("Click [Create new project] button");
        createNewProjectButton.click();
        return this;
    }
    @Step("Set project name: '{title}'")
    public ProjectsPage setProjectName(String title) {
        log.info("Set project name: '{}'", title);
        projectNaneField.sendKeys(Keys.CONTROL + "a");
        projectNaneField.sendKeys(Keys.DELETE);
        projectNaneField.sendKeys(title);
        return this;
    }
    @Step("Set project code: '{projectCode}'")
    public ProjectsPage setProjectCode(String projectCode) {
        log.info("Set project code: '{}'", projectCode);
        projectCodeField.sendKeys(Keys.CONTROL + "a");
        projectCodeField.sendKeys(Keys.DELETE);
        projectCodeField.sendKeys(projectCode);
        return this;
    }
    @Step("Set project description: '{projectDescription}'")
    public ProjectsPage setProjectDescription(String projectDescription) {
        log.info("Set project description: '{}'", projectDescription);
        projectDescriptionField.sendKeys(projectDescription);
        return this;
    }
    @Step("Click [Public] radio button")
    public ProjectsPage clickRadioButtonPublic() {
        log.info("Click [Public] radio button");
        radioButtonPublic.click();
        return this;
    }
    @Step("Click [Create button]")
    public ProjectPage clickCreateProjectButton() {
        log.info("Click [Create button]");
       createProjectButton.click();
       return new ProjectPage();
    }
    @Step("Check project name '{projectName}'")
    public ProjectPage projectNameShouldDisplayed(String projectName) {
        log.info("Check project name '{}'", projectName);
        $(By.xpath("//div[contains(text(),'" + projectName + "')]")).shouldBe(Condition.visible);
        return new ProjectPage();
    }
    @Step("Check project name: '{projectName}'")
    public ProjectPage projectNameShouldNotBeDisplayed(String projectName) {
        log.info("Check project name '{}'", projectName);
        $(By.xpath("//div[contains(text(),'" + projectName + "')]")).shouldBe(Condition.not(Condition.visible));
        return new ProjectPage();
    }
    @Step("Check project code: '{projectCode}'")
    public ProjectPage projectCodeShouldDisplayed(String projectCode) {
        log.info("Check project code '{}'", projectCode);
        $(By.xpath("//h1[contains(text(),'" + projectCode.toUpperCase() + "')]")).shouldBe(Condition.visible);
        return new ProjectPage();
    }
    @Step("Create private project with name: '{projectName}' and code '{projectCode}'")
    public ProjectPage createPrivateProject(String projectName, String projectCode) {
        log.info("Create private project with name: '{}' and code '{}'", projectName, projectCode);
        clickCreateNewProjectButton();
        setProjectName(projectName);
        setProjectCode(projectCode);
        clickCreateProjectButton();
        return new ProjectPage();
    }
    @Step("Create public project with name: '{projectName}' and code '{projectCode}'")
    public ProjectPage createPublicProject(String projectName, String projectCode) {
        log.info("Create public project with name: '{}' and code '{}'", projectName, projectCode);
        clickCreateNewProjectButton();
        setProjectName(projectName);
        setProjectCode(projectCode);
        clickCreateProjectButton();
        clickRadioButtonPublic();
        return new ProjectPage();
    }
    @Step("Delete all projects")
    public ProjectsPage deleteAllProjects() {
        log.info("Delete all projects");
        ElementsCollection threeDotsButtons = $$(THREE_DOTS_BUTTON_CSS);
        for (int i = 0; i<threeDotsButtons.size(); i++) {
            SelenideElement button = threeDotsButtons.get(0).shouldBe(Condition.visible);
            button.shouldBe(Condition.visible).click();
            removeProjectButton.shouldBe(Condition.visible).click();
            deleteProjectButton.shouldBe(Condition.visible).click();
        }
        return this;
    }
}
