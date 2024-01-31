package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.HashMap;

import static com.codeborne.selenide.Selenide.*;

public class TestCasePage extends ProjectPage {
    final String CREATE_TEST_HEADER = "//h1[text()='Create test case']";
    final String TITLE_INPUT_ID = "title";
    final String SELECTOR_STATUS = "//div[text()='Actual']";
    final String DESCRIPTION_INPUT = "//label[text()='Description']/parent::div//p";
    final String SELECTOR_LABEL = "//label[text()='%s']/parent::div/div";
    final String SELECTOR_OPTION = "//div[text()='%s']";
    final String TO_BE_AUTOMATED_CHECKBOX_ID = "0-isToBeAutomated";
    final String CONDITION_INPUT = "//label[text()='%s']/parent::div//p";
    final String SAVE_BUTTON_ID = "save-case";

    private String[] attributeName = {"Suite", "Severity", "Priority", "Type", "Layer", "Is flaky", "Milestone", "Behavior", "Automation status"};
    private final SelenideElement addTestCaseButton = $(By.id(ADD_TEST_CASE_ID));
    private final SelenideElement createTestCaseHeader = $(By.xpath(CREATE_TEST_HEADER));
    private final SelenideElement titleField = $(By.id(TITLE_INPUT_ID));
    private final SelenideElement selectorStatus = $(By.xpath(SELECTOR_STATUS));
    private final SelenideElement descriptionField = $(By.xpath(DESCRIPTION_INPUT));
    private final SelenideElement selectorLabel = $(By.xpath(SELECTOR_LABEL));
    private final SelenideElement selectorOption = $(By.xpath(SELECTOR_OPTION));
    private final SelenideElement toBeAutomatedCheckbox = $(By.id(TO_BE_AUTOMATED_CHECKBOX_ID));
    private final SelenideElement saveButton = $(By.id(SAVE_BUTTON_ID));
    private HashMap<String, String> labelAndOption;

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
    @Step("Select option from dropdown")
    public TestCasePage selectOptionFromDropDown(String label, String option) {
        $(By.xpath(String.format(SELECTOR_LABEL, label))).shouldBe(Condition.visible).click();
        $(By.xpath(String.format(SELECTOR_OPTION, option))).shouldBe(Condition.visible).click();
        return this;
    }
    @Step("Select option from dropdown")
    public TestCasePage selectOptionFromDropDownAll(HashMap<String, String> labelAndOption) {
        labelAndOption.forEach((key, value)->this.selectOptionFromDropDown(key,value));
        return this;
    }
    @Step("Click [Save] button")
    public TestCasePage clickSaveButton() {
        saveButton.click();
        return this;
    }

}


