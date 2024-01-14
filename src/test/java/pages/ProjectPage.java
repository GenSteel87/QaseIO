package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProjectPage {

    final String CREATE_NEW_PROJECT_ID = "createButton";
    final String PROJECT_NAME_ID = "project-name";
    final String PROJECT_CODE_ID = "project-code";
    final String PROJECT_DESCRIPTION_ID = "description-area";
    final String CREATE_PROJECT_CSS = "[type=submit]";
    final String RADIO_BUTTON_PUBLIC_CSS = "[value=public]";
    final String CREATE_SUITE_BUTTON_ID = "create-suite-button";
    final String SUITE_NAME_INPUT_ID = "title";
    final String SUITE_DESCRIPTION_INPUT = "//label[text()='Description']/parent::div//following-sibling::div/input";
    final String SUITE_PRECONDITION_INPUT = "//label[text()='Preconditions']/parent::div//following-sibling::div/input";
    final String SUITE_CREATE_BUTTON_CSS = "[type=submit]";
    @Step("Open QaseIO")
    public void openPage() {
        open("/projects");
    }

    @Step("Create new project is visible")
    public void waitTillOpened() {
        $(By.id(CREATE_NEW_PROJECT_ID)).shouldBe(Condition.visible);
    }

    @Step("Click [Create new project]")
    public void clickCreateNewProjectButton() {
        $(By.id(CREATE_NEW_PROJECT_ID)).click();
    }

    @Step("Set project name")
    public void setProjectName(String projectName) {
        $(By.id(PROJECT_NAME_ID)).sendKeys(projectName);
    }

    @Step("Clear project code ")
    public void clearProjectCode() {
        $(By.id(PROJECT_CODE_ID)).clear();
    }

    @Step("Set project code")
    public void setProjectCode(String projectCode) {
        $(By.id(PROJECT_CODE_ID)).sendKeys(projectCode);
    }

    @Step("Set project description")
    public void setProjectDescription(String projectDescription) {
        $(By.id(PROJECT_DESCRIPTION_ID)).sendKeys(projectDescription);
    }

    @Step("Click [Create button]")
    public void clickCreateProjectButton() {
        $(CREATE_PROJECT_CSS).click();
    }

    @Step("Click [Public] radio button")
    public void clickRadioButtonPublic() {
        $(RADIO_BUTTON_PUBLIC_CSS).click();
    }

    @Step("Check project name")
    public void projectNameShouldDisplayed(String projectName) {
        $(By.xpath("//div[contains(text(),'" + projectName + "')]")).shouldBe(Condition.visible);
    }

    @Step("Check project code")
    public void projectCodeShouldDisplayed(String projectCode) {
        $(By.xpath("//h1[contains(text(),'" + projectCode.toUpperCase() + "')]")).shouldBe(Condition.visible);
    }

    //public void

    public void createNewPrivateProject(String projectName, String projectCode, String projectDescription) {
        $(By.id(CREATE_NEW_PROJECT_ID)).click();
        $(By.id(PROJECT_NAME_ID)).sendKeys(projectName);
        $(By.id(PROJECT_CODE_ID)).clear();
        $(By.id(PROJECT_CODE_ID)).sendKeys(projectCode);
        $(By.id(PROJECT_DESCRIPTION_ID)).sendKeys(projectDescription);
        $(CREATE_PROJECT_CSS).click();
    }
}
