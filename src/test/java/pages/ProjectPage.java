package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProjectPage extends ProjectsPage {


    final String CREATE_SUITE_BUTTON_ID = "create-suite-button";
    final String SUITE_NAME_INPUT_ID = "title";
    final String SUITE_DESCRIPTION_INPUT = "//label[text()='Description']/parent::div//following-sibling::div/input";
    final String SUITE_PRECONDITION_INPUT = "//label[text()='Preconditions']/parent::div//following-sibling::div/input";
    final String CREATE_SUITE_BUTTON_CSS = "[type=submit]";
    final String DELETE_SUITE_BUTTON_CSS = "[type=submit]";
    final String ADD_TEST_CASE_ID = "create-case-button";
    final String THREE_DOTS_MENU = "(//button/span/i)[3]";
    final String SETTINGS_BUTTON_CSS = "[aria-label='Settings']";
    final String EDIT_SUITE_BUTTON = "//i[@class='far fa-pencil']";
    final String DELETE_SUITE_BUTTON = "//i[@class='far fa-trash']";
    final String SUITE_SAVE_BUTTON_CSS = "[type='submit']";
    final String EDIT_SUITE_SUCCESS_NOTIFICATION = "//span[text()='Suite was successfully edited.']";
    final String CREATE_SUITE_SUCCESS_NOTIFICATION = "//span[text()='Suite was successfully created.']";
    final String DELETE_SUITE_SUCCESS_NOTIFICATION = "//span[text()='Suite was successfully deleted.']";
    final String DELETE_NOTIFICATION = "//h3[text()='Are you sure that you want to delete the suite \"' and text()='%s']";
    final String CREATE_QUICK_TEST_BUTTON_CSS = "[placeholder='+ Create quick test']";
    final String CREATE_CASE_SUCCESS_NOTIFICATION = "//span[text()='Test case was created successfully!']";
    final String EDIT_CASE_SUCCESS_NOTIFICATION = "//span[text()='Test case was edited successfully!']";
    final String CASE_TITLE = "//div[text() ='%s']";
    final String EDIT_CASE_BUTTON = "//div[text()='%s']/parent::h1//following-sibling::div//a";

    private final SelenideElement addSuiteButton = $(By.id(CREATE_SUITE_BUTTON_ID));
    private final SelenideElement suiteNameField = $(By.id(SUITE_NAME_INPUT_ID));
    private final SelenideElement suiteDescriptionField = $(By.xpath(SUITE_DESCRIPTION_INPUT));
    private final SelenideElement suitePreconditionField = $(By.xpath(SUITE_PRECONDITION_INPUT));
    private final SelenideElement createSuiteButton = $(By.cssSelector(CREATE_SUITE_BUTTON_CSS));
    private final SelenideElement confirmDeleteSuiteButton = $(By.cssSelector(DELETE_SUITE_BUTTON_CSS));
    private final SelenideElement addTestCaseButton = $(By.id(ADD_TEST_CASE_ID));
    private final SelenideElement threeDotsMenu = $(By.xpath(THREE_DOTS_MENU));
    private final SelenideElement settingsButton = $(By.cssSelector(SETTINGS_BUTTON_CSS));
    private final SelenideElement editeSuiteButton = $(By.xpath(EDIT_SUITE_BUTTON));
    private final SelenideElement deleteSuiteButton = $(By.xpath(DELETE_SUITE_BUTTON));
    private final SelenideElement saveSuiteButton = $(By.cssSelector(SUITE_SAVE_BUTTON_CSS));
    private final SelenideElement editeSuiteSuccessNotification = $(By.xpath(EDIT_SUITE_SUCCESS_NOTIFICATION));
    private final SelenideElement createSuiteSuccessNotification = $(By.xpath(CREATE_SUITE_SUCCESS_NOTIFICATION));
    private final SelenideElement deleteSuiteSuccessNotification = $(By.xpath(DELETE_SUITE_SUCCESS_NOTIFICATION));
    private final SelenideElement createQuickTestButton = $(By.cssSelector(CREATE_QUICK_TEST_BUTTON_CSS));
    private final SelenideElement createCaseSuccessNotification = $(By.xpath(CREATE_CASE_SUCCESS_NOTIFICATION));
    private final SelenideElement editCaseSuccessNotification = $(By.xpath(EDIT_CASE_SUCCESS_NOTIFICATION));

    @Step("Open Project page")
    public ProjectPage openPage(String projectName) {
        open("/project/" + projectName.toUpperCase());
        return new ProjectPage();
    }
    @Step("Button [+ New Suite] is visible")
    public ProjectPage waitTillOpened() {
        addSuiteButton.shouldBe(Condition.appear);
        return this;
    }
    @Step("Button [+ Create quick test] is appear")
    public ProjectPage waitTillAllTestCasesAppear() {

        createQuickTestButton.shouldBe(Condition.appear);
        return this;
    }
    @Step("Click [+Suite] button")
    public ProjectPage clickAddSuiteButton(){
        addSuiteButton.shouldBe(Condition.visible).click();
        return this;
    }
    @Step("Set suite name")
    public ProjectPage setSuiteName(String suiteName) {
        suiteNameField.sendKeys(Keys.CONTROL + "a");
        suiteNameField.sendKeys(Keys.DELETE);
        suiteNameField.sendKeys(suiteName);
        return this;
    }
    @Step("Set Description")
    public ProjectPage setSuiteDescription(String suiteDescription) {
        suiteDescriptionField.sendKeys(Keys.CONTROL + "a");
        suiteDescriptionField.sendKeys(Keys.DELETE);
        suiteDescriptionField.sendKeys(suiteDescription);
        return this;
    }
    @Step("Set Preconditions")
    public ProjectPage setSuitePrecondition(String suitePrecondition) {
        suitePreconditionField.sendKeys(Keys.CONTROL + "a");
        suitePreconditionField.sendKeys(Keys.DELETE);
        suitePreconditionField.sendKeys(suitePrecondition);
        return this;
    }
    @Step("Click [Create] button")
    public  ProjectPage clickCreateButton() {
        createSuiteButton.shouldBe(Condition.visible).click();
        return this;
    }
    @Step("Created suite name should be displayed")
    public ProjectPage suiteNameShouldDisplayed(String suiteName) {
        $(By.cssSelector("[title='" + suiteName + "']")).shouldBe(Condition.visible);
        return this;
    }
    @Step("Deleted suite name should not be displayed")
    public ProjectPage suiteNameShouldNotBeDisplayed(String suiteName) {
        $(By.cssSelector("[title='" + suiteName + "']")).shouldBe(Condition.not(Condition.visible));
        return this;
    }
    @Step("Suite description should be displayed")
    public ProjectPage suiteDescriptionShouldDisplayed(String suiteDescription) {
        $(By.xpath("//p[text()='" + suiteDescription + "']")).shouldBe(Condition.visible);
        return this;
    }
    @Step("Create Suite")
    public ProjectPage createSuite(String suiteName) {
        setSuiteName(suiteName);
        clickCreateButton();
        return this;
    }
    @Step("Click [+ Case] button")
    public CasePage clickAddTestCaseButton() {
        addTestCaseButton.shouldBe(Condition.visible).click();
        return new CasePage();
    }
    @Step("Click [...] menu button")
    public ProjectPage clickThreeDotsMenu() {
        threeDotsMenu.shouldBe(Condition.visible).click();
        return this;
    }
    @Step("Open project settings")
    public ProjectSettingsPage clickSettingsButton() {
        settingsButton.shouldBe(Condition.visible).click();
        return new ProjectSettingsPage();
    }
    @Step("Click edite suite button")
    public ProjectPage clickEditeSuiteButton() {
        editeSuiteButton.shouldBe(Condition.visible).click();
        return this;
    }
    @Step("Click delete suite button")
    public ProjectPage clickDeleteSuiteButton() {
        deleteSuiteButton.shouldBe(Condition.visible).click();
        return this;
    }
    @Step("Click save suite button")
    public ProjectPage clickSaveSuiteButton() {
        saveSuiteButton.shouldBe(Condition.visible).click();
        return this;
    }
    @Step("Notification: Suite was successfully edited is displayed")
    public ProjectPage editSuiteSuccessNotificationIsDisplayed() {
        editeSuiteSuccessNotification.shouldBe(Condition.appear);
        return this;
    }
    @Step("Notification: Suite was successfully created is displayed")
    public ProjectPage createSuiteSuccessNotificationIsDisplayed() {
        createSuiteSuccessNotification.shouldBe(Condition.appear);
        return this;
    }
    @Step("Notification: Suite was successfully deleted is displayed")
    public ProjectPage deleteSuiteSuccessNotificationIsDisplayed() {
        deleteSuiteSuccessNotification.shouldBe(Condition.appear);
        return this;
    }
    @Step("Delete suite notification with suite name should be displayed")
    public ProjectPage deleteSuiteNotificationWithSuiteNameShouldDisplayed(String suiteName) {
        $(By.xpath(String.format(DELETE_NOTIFICATION, suiteName))).shouldBe(Condition.visible);
        return this;
    }
    @Step("Click confirm delete suite button")
    public ProjectPage clickConfirmDeleteSuiteButton() {
        confirmDeleteSuiteButton.shouldBe(Condition.visible).click();
        return this;
    }
    @Step("Notification: Test case was created successfully! should be displayed")
    public ProjectPage createCaseSuccessNotificationShouldDisplayed() {
        createCaseSuccessNotification.shouldBe(Condition.visible);
        return this;
    }
    @Step("Notification: Test case was edited successfully! should be displayed")
    public ProjectPage editCaseSuccessNotificationShouldDisplayed() {
        editCaseSuccessNotification.shouldBe(Condition.visible);
        return this;
    }
    @Step("Case title should be displayed")
    public ProjectPage caseTitleShouldDisplayed(String caseTitle) {
        $(By.xpath(String.format(CASE_TITLE, caseTitle))).shouldBe(Condition.visible);
        return this;
    }
    @Step("Click on test case title")
    public ProjectPage clickTestCaseTitle(String caseTitle) {
        $(By.xpath(String.format(CASE_TITLE, caseTitle))).shouldBe(Condition.visible).click();
        return this;
    }
    @Step("Click on edit test case button")
    public ProjectPage clickEditTestCase(String caseTitle) {
        $(By.xpath(String.format(EDIT_CASE_BUTTON, caseTitle))).shouldBe(Condition.visible).click();
        return new CasePage();
    }
}
