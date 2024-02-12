package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.HashMap;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CasePage extends ProjectPage {
    final String CREATE_TEST_HEADER = "//h1[text()='Create test case']";
    final String TITLE_INPUT_ID = "title";
    final String SELECTOR_STATUS = "//div[text()='Actual']";
    final String DESCRIPTION_FIELD = "//label[text()='Description']/parent::div//p";
    final String FILLED_DESCRIPTION_FIELD = "(//label[text()='Description']/parent::div//p[text()='%s'])[2]";
    final String SELECTOR_LABEL = "//label[text()='%s']/parent::div/div";
    final String SELECTOR_OPTION = "//div[text()='%s']";
    final String SELECTOR_SUITE = "//label[text()='Suite']/parent::div/div";
    final String TO_BE_AUTOMATED_CHECKBOX_ID = "0-isToBeAutomated";
    final String PRE_CONDITION_FIELD = "(//label[text()='Pre-conditions']/parent::div//p[text()='%s'])[2]";
    final String SAVE_BUTTON_ID = "save-case";
    final String POST_CONDITION_FIELD = "(//label[text()='Post-conditions']/parent::div//p[text()='%s'])[2]";

    private final SelenideElement addTestCaseButton = $(By.id(ADD_TEST_CASE_ID));
    private final SelenideElement createTestCaseHeader = $(By.xpath(CREATE_TEST_HEADER));
    private final SelenideElement titleField = $(By.id(TITLE_INPUT_ID));
    private final SelenideElement selectorSuite = $(By.xpath(SELECTOR_SUITE));
    private final SelenideElement selectorStatus = $(By.xpath(SELECTOR_STATUS));
    private final SelenideElement descriptionField = $(By.xpath(DESCRIPTION_FIELD));
    private final SelenideElement selectorLabel = $(By.xpath(SELECTOR_LABEL));
    private final SelenideElement selectorOption = $(By.xpath(SELECTOR_OPTION));
    private final SelenideElement toBeAutomatedCheckbox = $(By.id(TO_BE_AUTOMATED_CHECKBOX_ID));
    private final SelenideElement saveButton = $(By.id(SAVE_BUTTON_ID));

    @Step("Open test case creation page")
    public CasePage openPage(String projectName) {
        open("/case/" + projectName.toUpperCase() + "/create");
        return this;
    }
    @Step("'Create test case' is visible")
    public CasePage waitTillOpened() {
        createTestCaseHeader.shouldBe(Condition.visible);
        return this;
    }
    @Step("Set test case title")
    public CasePage setTitle(String testCaseTitle) {
        titleField.sendKeys(Keys.CONTROL + "a");
        titleField.sendKeys(Keys.DELETE);
        titleField.sendKeys(testCaseTitle);
        return this;
    }
    @Step("Set test case Description")
    public CasePage setDescription(String testCaseDescription) {
        descriptionField.sendKeys(Keys.CONTROL + "a");
        descriptionField.sendKeys(Keys.DELETE);
        descriptionField.sendKeys(testCaseDescription);
        return this;
    }
    @Step("Edit test case Description")
    public CasePage editDescription(String testCaseDescription, String updatedTestCaseDescription) {
        $(By.xpath(String.format(FILLED_DESCRIPTION_FIELD, testCaseDescription))).
                shouldBe(Condition.visible).setValue(updatedTestCaseDescription);
        return this;
    }
    @Step("Test case Description should be displayed")
    public CasePage caseDescriptionShouldBeDisplayed(String testCaseDescription) {
        descriptionField.shouldBe(Condition.visible);
        return this;
    }
    @Step("Select created suite from dropdown")
    public CasePage selectCreatedSuiteFromDropDown(String suiteTitle) {
        selectorSuite.shouldBe(Condition.visible).click();
        $(By.xpath(String.format(SELECTOR_OPTION, suiteTitle))).shouldBe(Condition.visible).click();
        return this;
    }
    @Step("Select option from dropdown")
    public CasePage selectOptionFromDropDown(String label, String option) {
        $(By.xpath(String.format(SELECTOR_LABEL, label))).shouldBe(Condition.visible).click();
        $(By.xpath(String.format(SELECTOR_OPTION, option))).shouldBe(Condition.visible).click();
        return this;
    }
    @Step("Check selected option from dropdown")
    public CasePage checkSelectedOptionFromDropDown(String label, String option) {
        $(By.xpath(String.format(SELECTOR_LABEL, label))).shouldBe(Condition.visible);
        $(By.xpath(String.format(SELECTOR_OPTION, option))).shouldBe(Condition.visible);
        return this;
    }
    @Step("Select option from dropdown")
    public CasePage selectOptionFromDropDownAll(HashMap<String, String> labelAndOption) {
        labelAndOption.forEach((key, value)->this.selectOptionFromDropDown(key,value));
        return this;
    }
    @Step("Check selected option from all dropdowns")
    public CasePage checkSelectOptionFromDropDownAll(HashMap<String, String> labelAndOption) {
        labelAndOption.forEach((key, value)->this.checkSelectedOptionFromDropDown(key,value));
        return this;
    }
    @Step("Click [Save] button")
    public CasePage clickSaveButton() {
        saveButton.click();
        return this;
    }
    @Step("Edit test case Pre-conditions")
    public CasePage editPreConditions(String testCasePreConditions, String updatedTestCasePreConditions) {
        $(By.xpath(String.format(PRE_CONDITION_FIELD, testCasePreConditions))).
                shouldBe(Condition.visible).setValue(updatedTestCasePreConditions);
        return this;
    }
    @Step("Test case Pre-conditions should be displayed")
    public CasePage casePreConditionsShouldBeDisplayed(String testCasePreConditions) {
        $(By.xpath(String.format(PRE_CONDITION_FIELD, testCasePreConditions))).shouldBe(Condition.visible);
        return this;
    }
    @Step("Edit test case Post-conditions")
    public CasePage editPostConditions(String testCasePostConditions, String updatedTestCasePostConditions) {
        $(By.xpath(String.format(POST_CONDITION_FIELD, testCasePostConditions))).
                shouldBe(Condition.visible).setValue(updatedTestCasePostConditions);
        return this;
    }
    @Step("Test case Pre-conditions should be displayed")
    public CasePage casePostConditionsShouldBeDisplayed(String testCasePostConditions) {
        $(By.xpath(String.format(POST_CONDITION_FIELD, testCasePostConditions))).shouldBe(Condition.visible);
        return this;
    }
}


