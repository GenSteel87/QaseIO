package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
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
    final String DELETE_SUITE_SUCCESS_NOTIFICATION = "//span[text()='Suite was successfully deleted.']";
    final String CREATE_SUITE_SUCCESS_NOTIFICATION = "//span[text()='Suite was successfully created.']";
    final String DELETE_NOTIFICATION = "//h3[text()='Are you sure that you want to delete the suite \"' and text()='%s']";
    final String CREATE_QUICK_TEST_BUTTON_CSS = "[placeholder='+ Create quick test']";
    final String CREATE_CASE_SUCCESS_NOTIFICATION = "//span[text()='Test case was created successfully!']";
    final String EDIT_CASE_SUCCESS_NOTIFICATION = "//span[text()='Test case was edited successfully!']";
    final String DELETE_CASE_SUCCESS_NOTIFICATION = "//span[text()='Test case '%s' was successfully deleted']";
    final String CASE_TITLE = "//div[text() ='%s']";
    final String EDIT_CASE_BUTTON = "//div[text()='%s']/parent::h1//following-sibling::div//a";
    final String DELETE_CASE_BUTTON = "//button/span[text()=' Delete']";
    final String CONFIRM_DELETE_BUTTON = "//button/span[text()='Delete']";
    final String DELETE_CASE_POPUP = "//h3[text()='Delete test case']";

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
    private final SelenideElement deleteSuiteSuccessNotification = $(By.xpath(DELETE_SUITE_SUCCESS_NOTIFICATION));
    private final SelenideElement createSuiteSuccessNotification = $(By.xpath(CREATE_SUITE_SUCCESS_NOTIFICATION));
    private final SelenideElement createQuickTestButton = $(By.cssSelector(CREATE_QUICK_TEST_BUTTON_CSS));
    private final SelenideElement createCaseSuccessNotification = $(By.xpath(CREATE_CASE_SUCCESS_NOTIFICATION));
    private final SelenideElement editCaseSuccessNotification = $(By.xpath(EDIT_CASE_SUCCESS_NOTIFICATION));
    private final SelenideElement deleteCaseButton = $(By.xpath(DELETE_CASE_BUTTON));
    private final SelenideElement confirmDeleteCaseButton = $(By.xpath(CONFIRM_DELETE_BUTTON));
    private final SelenideElement deleteCasePopup = $(By.xpath(DELETE_CASE_POPUP));

    @Step("Open Project page")
    public ProjectPage openPage(String projectName) {
        open("/project/" + projectName.toUpperCase());
        return new ProjectPage();
    }
    @Step("Button [+ New Suite] is visible")
    public ProjectPage waitTillOpened() {
        log.info("Button [+ New Suite] is visible");
        addSuiteButton.shouldBe(Condition.appear);
        return this;
    }
    @Step("Button [+ Create quick test] is appear")
    public ProjectPage waitTillAllTestCasesAppear() {
        log.info("Button [+ Create quick test] is appear");
        createQuickTestButton.shouldBe(Condition.appear);
        return this;
    }
    @Step("Click [+Suite] button")
    public ProjectPage clickAddSuiteButton(){
        log.info("Click [+Suite] button");
        addSuiteButton.shouldBe(Condition.visible).click();
        return this;
    }
    @Step("Set suite name: '{suiteName}'")
    public ProjectPage setSuiteName(String suiteName) {
        log.info("Set suite name: '{}'", suiteName);
        suiteNameField.sendKeys(Keys.CONTROL + "a");
        suiteNameField.sendKeys(Keys.DELETE);
        suiteNameField.sendKeys(suiteName);
        return this;
    }
    @Step("Set Description: '{suiteDescription}'")
    public ProjectPage setSuiteDescription(String suiteDescription) {
        log.info("Set Description: '{}'", suiteDescription);
        suiteDescriptionField.sendKeys(Keys.CONTROL + "a");
        suiteDescriptionField.sendKeys(Keys.DELETE);
        suiteDescriptionField.sendKeys(suiteDescription);
        return this;
    }
    @Step("Set Preconditions: '{suitePrecondition}'")
    public ProjectPage setSuitePrecondition(String suitePrecondition) {
        log.info("Set Preconditions: '{}'", suitePrecondition);
        suitePreconditionField.sendKeys(Keys.CONTROL + "a");
        suitePreconditionField.sendKeys(Keys.DELETE);
        suitePreconditionField.sendKeys(suitePrecondition);
        return this;
    }
    @Step("Click [Create] button")
    public  ProjectPage clickCreateButton() {
        log.info("Click [Create] button");
        createSuiteButton.shouldBe(Condition.visible).click();
        return this;
    }
    @Step("Created suite name should be displayed: '{suiteName}'")
    public ProjectPage suiteNameShouldDisplayed(String suiteName) {
        log.info("Created suite name should be displayed: '{}'", suiteName);
        $(By.cssSelector("[title='" + suiteName + "']")).shouldBe(Condition.visible);
        return this;
    }
    @Step("Deleted suite name should not be displayed: '{suiteName}'")
    public ProjectPage suiteNameShouldNotBeDisplayed(String suiteName) {
        log.info("Deleted suite name should not be displayed: '{}'", suiteName);
        $(By.cssSelector("[title='" + suiteName + "']")).shouldBe(Condition.not(Condition.visible));
        return this;
    }
    @Step("Suite description should be displayed: '{suiteDescription}'")
    public ProjectPage suiteDescriptionShouldDisplayed(String suiteDescription) {
        log.info("Suite description should be displayed: '{}'", suiteDescription);
        $(By.xpath("//p[text()='" + suiteDescription + "']")).shouldBe(Condition.visible);
        return this;
    }
    @Step("Create Suite: '{suiteName}'")
    public ProjectPage createSuite(String suiteName) {
        log.info("Create Suite: '{}'", suiteName);
        setSuiteName(suiteName);
        clickCreateButton();
        return this;
    }
    @Step("Click [+ Case] button")
    public CasePage clickAddTestCaseButton() {
        log.info("Click [+ Case] button");
        addTestCaseButton.shouldBe(Condition.visible).click();
        return new CasePage();
    }
    @Step("Click [...] menu button")
    public ProjectPage clickThreeDotsMenu() {
        log.info("Click [...] menu button");
        threeDotsMenu.shouldBe(Condition.visible).click();
        return this;
    }
    @Step("Open project settings")
    public ProjectSettingsPage clickSettingsButton() {
        log.info("Open project settings");
        settingsButton.shouldBe(Condition.visible).click();
        return new ProjectSettingsPage();
    }
    @Step("Click edite suite button")
    public ProjectPage clickEditeSuiteButton() {
        log.info("Click edite suite button");
        editeSuiteButton.shouldBe(Condition.visible).click();
        return this;
    }
    @Step("Click delete suite button")
    public ProjectPage clickDeleteSuiteButton() {
        log.info("Click delete suite button");
        deleteSuiteButton.shouldBe(Condition.visible).click();
        return this;
    }
    @Step("Click save suite button")
    public ProjectPage clickSaveSuiteButton() {
        log.info("Click save suite button");
        saveSuiteButton.shouldBe(Condition.visible).click();
        return this;
    }
    @Step("Notification: Suite was successfully edited is displayed")
    public ProjectPage editSuiteSuccessNotificationIsDisplayed() {
        log.info("Notification: Suite was successfully edited is displayed");
        editeSuiteSuccessNotification.shouldBe(Condition.appear);
        return this;
    }
    @Step("Notification: Suite was successfully deleted is displayed")
    public ProjectPage deleteSuiteSuccessNotificationIsDisplayed() {
        log.info("Notification: Suite was successfully deleted is displayed");
        deleteSuiteSuccessNotification.shouldBe(Condition.appear);
        return this;
    }
    @Step("Notification: Suite was successfully created is displayed")
    public ProjectPage createSuiteSuccessNotificationIsDisplayed() {
        log.info("Notification: Suite was successfully created is displayed");
        createSuiteSuccessNotification.shouldBe(Condition.appear);
        return this;
    }
    @Step("Delete suite notification with suite name '{suiteName}' should be displayed")
    public ProjectPage deleteSuiteNotificationWithSuiteNameShouldDisplayed(String suiteName) {
        log.info("Delete suite notification with suite name '{}' should be displayed", suiteName);
        $(By.xpath(String.format(DELETE_NOTIFICATION, suiteName))).shouldBe(Condition.visible);
        return this;
    }
    @Step("Click confirm delete suite button")
    public ProjectPage clickConfirmDeleteSuiteButton() {
        log.info("Click confirm delete suite button");
        confirmDeleteSuiteButton.shouldBe(Condition.visible).click();
        return this;
    }
    @Step("Notification: Test case was created successfully! should be displayed")
    public ProjectPage createCaseSuccessNotificationShouldDisplayed() {
        log.info("Notification: Test case was created successfully! should be displayed");
        createCaseSuccessNotification.shouldBe(Condition.visible);
        return this;
    }
    @Step("Notification: Test case was edited successfully! should be displayed")
    public ProjectPage editCaseSuccessNotificationShouldDisplayed() {
        log.info("Notification: Test case was edited successfully! should be displayed");
        editCaseSuccessNotification.shouldBe(Condition.visible);
        return this;
    }
    @Step("Case title: '{caseTitle}' should be displayed")
    public ProjectPage caseTitleShouldDisplayed(String caseTitle) {
        log.info("Case title: '{}' should be displayed", caseTitle);
        $(By.xpath(String.format(CASE_TITLE, caseTitle))).shouldBe(Condition.visible);
        return this;
    }
    @Step("Click on test case title: '{caseTitle}'")
    public ProjectPage clickTestCaseTitle(String caseTitle) {
        log.info("Click on test case title: '{}'", caseTitle);
        $(By.xpath(String.format(CASE_TITLE, caseTitle))).shouldBe(Condition.visible).click();
        return this;
    }
    @Step("Click on edit '{caseTitle}' test case button")
    public ProjectPage clickEditTestCase(String caseTitle) {
        log.info("Click on edit '{}' test case button", caseTitle);
        $(By.xpath(String.format(EDIT_CASE_BUTTON, caseTitle))).shouldBe(Condition.visible).click();
        return new CasePage();
    }
    @Step("Click on [Delete] case button")
    public ProjectPage clickDeleteCaseButton() {
        log.info("Click on [Delete] case button");
        deleteCaseButton.shouldBe(Condition.visible).click();
        return this;
    }
    @Step("Click on confirm [Delete] case button")
    public ProjectPage clickConfirmDeleteCaseButton() {
        log.info("Click on confirm [Delete] case button");
        confirmDeleteCaseButton.shouldBe(Condition.visible).click();
        return this;
    }
    @Step("Notification: Test case '{projectCode}' was successfully deleted")
    public ProjectPage deleteCaseSuccessNotificationShouldDisplayed(String projectCode) {
        log.info("Notification: Test case '{}' was successfully deleted", projectCode);
        $(By.xpath("//span[text()='Test case ["+ projectCode +"-1] was successfully deleted'" ))
                .shouldBe(Condition.visible);
        return this;
    }
    @Step("Case title '{caseTitle}' should not be displayed")
    public ProjectPage testCaseTitleShouldNotBeDisplayed(String caseTitle) {
        log.info("Case title '{}' should not be displayed", caseTitle);
        $(By.xpath(String.format(CASE_TITLE, caseTitle))).shouldNot(Condition.visible);
        return this;
    }
    @Step("Delete test case popup is disappear")
    public ProjectPage deleteTestCasePopupShouldNotBeDisplayed() {
        log.info("Delete test case popup is disappear");
        deleteCasePopup.shouldNot(Condition.visible);
        return this;
    }
}
