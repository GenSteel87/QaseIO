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
    final String SUITE_CREATE_BUTTON_CSS = "[type=submit]";
    final String ADD_TEST_CASE_ID = "create-case-button";
    final String THREE_DOTS_MENU = "(//button/span/i)[3]";
    final String SETTINGS_BUTTON_CSS = "[aria-label='Settings']";
    final String EDIT_SUITE_BUTTON = "//i[@class='far fa-pencil']";

    private final SelenideElement addSuiteButton = $(By.id(CREATE_SUITE_BUTTON_ID));
    private final SelenideElement suiteNameField = $(By.id(SUITE_NAME_INPUT_ID));
    private final SelenideElement suiteDescriptionField = $(By.xpath(SUITE_DESCRIPTION_INPUT));
    private final SelenideElement suitePreconditionField = $(By.xpath(SUITE_PRECONDITION_INPUT));
    private final SelenideElement createSuiteButton = $(By.cssSelector(SUITE_CREATE_BUTTON_CSS));
    private final SelenideElement addTestCaseButton = $(By.id(ADD_TEST_CASE_ID));
    private final SelenideElement threeDotsMenu = $(By.xpath(THREE_DOTS_MENU));
    private final SelenideElement settingsButton = $(By.cssSelector(SETTINGS_BUTTON_CSS));
    private final SelenideElement editeSuiteButton = $(By.xpath(EDIT_SUITE_BUTTON));

    @Step("Open Project page")
    public ProjectPage openPage(String projectName) {
        open("/project/" + projectName.toUpperCase());
        return new ProjectPage();
    }
    @Step("Button [+ New Suite] is visible")
    public ProjectPage waitTillOpened() {
        addSuiteButton.shouldBe(Condition.visible);
        return this;
    }
    @Step("Click [+Suite] button")
    public ProjectPage clickAddSuiteButton(){
        addSuiteButton.click();
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
        createSuiteButton.click();
        return this;
    }
    @Step("Created suite name should be displayed")
    public ProjectPage suiteNameShouldDisplayed(String suiteName) {
        $(By.cssSelector("[title='" + suiteName + "']")).shouldBe(Condition.visible);
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
    public TestCasePage clickAddTestCaseButton() {
        addTestCaseButton.click();
        return new TestCasePage();
    }
    @Step("Click [...] menu button")
    public ProjectPage clickThreeDotsMenu() {
        threeDotsMenu.click();
        return this;
    }
    @Step("Open project settings")
    public ProjectSettingsPage clickSettingsButton() {
        settingsButton.click();
        return new ProjectSettingsPage();
    }
    @Step("Click edite suite button")
    public ProjectPage clickEditeSuiteButton() {
        editeSuiteButton.click();
        return this;
    }
}
