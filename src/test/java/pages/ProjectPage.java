package pages;

import com.codeborne.selenide.Condition;
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

    public void openPage() {
        open("/projects");
    }

    public void waitTillOpened() {
        $(By.id(CREATE_NEW_PROJECT_ID)).shouldBe(Condition.visible);
    }

    public void clickCreateNewProjectButton() {
        $(By.id(CREATE_NEW_PROJECT_ID)).click();
    }

    public void setProjectName(String projectName) {
        $(By.id(PROJECT_NAME_ID)).sendKeys(projectName);
    }

    public void setProjectCode(String projectCode) {
        $(By.id(PROJECT_CODE_ID)).clear();
        $(By.id(PROJECT_CODE_ID)).sendKeys(projectCode);
    }

    public void setProjectDescription(String projectDescription) {
        $(By.id(PROJECT_DESCRIPTION_ID)).sendKeys(projectDescription);
    }

    public void clickCreateProjectButton() {
        $(CREATE_PROJECT_CSS).click();
    }

    public void clickRadioButtonPublic() {
        $(RADIO_BUTTON_PUBLIC_CSS).click();
    }

    public void projectNameShouldDisplayed(String projectName) {
        $(By.xpath("//div[contains(text(),'" + projectName + "')]")).shouldBe(Condition.visible);
    }

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
