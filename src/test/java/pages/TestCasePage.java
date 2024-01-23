package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class TestCasePage extends ProjectPage {
    final String CREATE_TEST_HEADER = "//h1[text()='Create test case']";
    final String TITLE_INPUT_ID = "title";
    final String SELECTOR_STATUS = "//div[text()='Actual']";
    final String DESCRIPTION_INPUT = "//label[text()='Description']/parent::div//p";
    final String SELECTOR_SUITE_INPUT = "//label[text()='Suite']/parent::div/div";
    final String SELECTOR_SEVERITY_INPUT = "//label[text()='Severity']/parent::div/div";
    final String SELECTOR_PRIORITY_INPUT = "//label[text()='Priority']/parent::div/div";
    final String SELECTOR_TYPE_INPUT = "//label[text()='Type']/parent::div/div";
    final String SELECTOR_LAYER_INPUT = "//label[text()='Layer']/parent::div/div";
    final String SELECTOR_IS_FLAKY_INPUT = "//label[text()='Is flaky']/parent::div/div";
    final String SELECTOR_MILESTONE_INPUT = "//label[text()='Milestone']/parent::div/div";
    final String SELECTOR_BEHAVIOR_INPUT = "//label[text()='Behavior']/parent::div/div";
    final String SELECTOR_AUTOMATION_STATUS_INPUT = "//label[text()='Automation status']/parent::div/div";
    final String TO_BE_AUTOMATED_CHECKBOX_ID = "0-isToBeAutomated";
    final String PRE_CONDITION_INPUT = "//label[text()='Pre-conditions']/parent::div//p";
    final String POST_CONDITION_INPUT = "//label[text()='Post-conditions']/parent::div//p";
    final String SAVE_BUTTON = "save-case";
    final String TEST_CASE_ATTRIBUTE = "//label[text()='%s']/parent::div/div";

    private String[] attributeName = {"Suite", "Severity", "Priority", "Type", "Layer", "Is flaky", "Milestone", "Behavior", "Automation status"};
    private final SelenideElement addTestCaseButton = $(By.id(ADD_TEST_CASE_ID));
    private final SelenideElement createTestCaseHeader = $(By.xpath(CREATE_TEST_HEADER));
    private final SelenideElement titleField = $(By.id(TITLE_INPUT_ID));
    private final SelenideElement selectorStatus = $(By.xpath(SELECTOR_STATUS));
    private final SelenideElement descriptionField = $(By.xpath(DESCRIPTION_INPUT));
    private final SelenideElement selectorSuite = $(By.xpath(SELECTOR_SUITE_INPUT));
    private final SelenideElement selectorSeverity = $(By.xpath(SELECTOR_SEVERITY_INPUT));
    private final SelenideElement selectorPriority = $(By.xpath(SELECTOR_PRIORITY_INPUT));
    private final SelenideElement selectorType = $(By.xpath(SELECTOR_TYPE_INPUT));
    private final SelenideElement selectorLayer = $(By.xpath(SELECTOR_LAYER_INPUT));
    private final SelenideElement selectorIsFlaky = $(By.xpath(SELECTOR_IS_FLAKY_INPUT));
    private final SelenideElement selectorMilestone = $(By.xpath(SELECTOR_MILESTONE_INPUT));
    private final SelenideElement selectorBehavior = $(By.xpath(SELECTOR_BEHAVIOR_INPUT));
    private final SelenideElement selectorAutomationStatus = $(By.xpath(SELECTOR_AUTOMATION_STATUS_INPUT));
    private final SelenideElement toBeAutomatedCheckbox = $(By.id(TO_BE_AUTOMATED_CHECKBOX_ID));
    private final SelenideElement preConditionField = $(By.xpath(PRE_CONDITION_INPUT));
    private final SelenideElement postConditionField = $(By.xpath(POST_CONDITION_INPUT));
    private final SelenideElement saveButton = $(By.id(SAVE_BUTTON));

    @Step("Open test case creation page")
    public TestCasePage openPage(String projectName) {
        open("/case/" + projectName.toUpperCase() + "/create");
        return this;
    }
    @Step("'Create test case' is visible")
    public TestCasePage waitTillOpened() {
        createTestCaseHeader.shouldBe(Condition.visible);
        return this;
    }

    @Step("Set test case title")
    public TestCasePage setTitle(String testCaseTitle) {
        titleField.sendKeys(testCaseTitle);
        return this;
    }
    @Step("Set test case Description")
    public TestCasePage setDescription(String testCaseDescription) {
        descriptionField.sendKeys(testCaseDescription);
        return this;
    }
    @Step("Select Status")
    public TestCasePage selectStatus() {
        descriptionField.selectOption(1);
        return this;
    }

    @Step("Select test case attribute")
    public TestCasePage fillAllDropdownsWithFirstValue() {
        for(int i = 0; i<attributeName.length; i++) {
            $(By.xpath(String.format("//label[text()='%s']/parent::div/div", attributeName[i]))).selectOption(1);
        }
            return this;
    }
    @Step("Click [Save] button")
    public TestCasePage clickSaveButton() {
        saveButton.click();
        return this;
    }



}


