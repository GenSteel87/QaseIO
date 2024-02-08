package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProjectSettingsPage extends ProjectPage{
    final String PROJECT_NAME_ID = "project-name";
    final String PROJECT_CODE_ID = "project-code";
    final String PROJECT_DESCRIPTION_ID = "description-area";
    final String RADIO_BUTTON_PUBLIC_CSS = "[value=public]";
    final String UPDATE_SETTINGS_CSS = "[type='submit']";
    final String SUCCESS_NOTIFICATION = "//span[text()='Project settings were successfully updated!']";
    final String DELETE_BUTTON = "//button/span[text()=' Delete project']";
    final String CONFIRM_DELETE_BUTTON = "//button/span[text()='Delete project']";

    private final SelenideElement projectNaneField = $(By.id(PROJECT_NAME_ID));
    private final SelenideElement projectCodeField = $(By.id(PROJECT_CODE_ID));
    private final SelenideElement projectDescriptionField = $(By.id(PROJECT_DESCRIPTION_ID));
    private final SelenideElement updateSettingsButton = $(By.cssSelector(UPDATE_SETTINGS_CSS));
    private final SelenideElement successNotification = $(By.xpath(SUCCESS_NOTIFICATION));
    private final SelenideElement radioButtonPublic = $(By.cssSelector(RADIO_BUTTON_PUBLIC_CSS));
    private final SelenideElement deleteProjectButton = $(By.xpath(DELETE_BUTTON));
    private final SelenideElement confirmDeleteProjectButton = $(By.xpath(CONFIRM_DELETE_BUTTON));

    @Step("Open project settings page")
    public ProjectSettingsPage openPage(String projectCode) {
        open("/project/" + projectCode.toUpperCase() + "/settings/general");
        return this;
    }
    @Step("Success notification should be displayed")
    public ProjectSettingsPage checkSuccessNotification() {
        successNotification.shouldBe(Condition.visible);
        return this;
    }
    @Step("Success notification should be displayed")
    public ProjectSettingsPage clickUpdateSettingsButton() {
        updateSettingsButton.click();
        return this;
    }
    @Step("Set project name")
    public ProjectSettingsPage setProjectName(String title) {
        projectNaneField.sendKeys(Keys.CONTROL + "a");
        projectNaneField.sendKeys(Keys.DELETE);
        projectNaneField.sendKeys(title);
        return this;
    }
    @Step("Set project code")
    public ProjectSettingsPage setProjectCode(String projectCode) {
        projectCodeField.sendKeys(Keys.CONTROL + "a");
        projectCodeField.sendKeys(Keys.DELETE);
        projectCodeField.sendKeys(projectCode);
        return this;
    }
    @Step("Set project description")
    public ProjectSettingsPage setProjectDescription(String projectDescription) {
        projectDescriptionField.sendKeys(projectDescription);
        return this;
    }
    @Step("Click [Public] radio button")
    public ProjectSettingsPage clickRadioButtonPublic() {
        radioButtonPublic.click();
        return this;
    }
    @Step("Click [Delete project] button")
    public ProjectSettingsPage clickDeleteProjectButton() {
        deleteProjectButton.click();
        return this;
    }
    @Step("Click [Delete project] button in confirmation pop-up")
    public ProjectsPage clickConfirmDeleteProjectButton() {
        confirmDeleteProjectButton.click();
        return new ProjectsPage();
    }
}
