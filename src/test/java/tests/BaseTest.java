package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.ProjectPage;
import pages.ProjectsPage;
import pages.TestCasePage;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class BaseTest {

    LoginPage loginPage;
    ProjectPage projectPage;
    ProjectsPage projectsPage;
    TestCasePage testCasePage;
    Faker faker;
    String user;
    String password;
    String projectName;
    String projectCode;
    String projectDescription;
    String suiteName;
    String suiteDescription;
    String suitePrecondition;
    String testCaseTitle;
    String testCaseDescription;
    String testCasePreConditions;
    String testCasePostConditions;

    @BeforeMethod(description = "Set browser")
    public void setUp() {

        Configuration.browser = "chrome";
        Configuration.headless = true;
        Configuration.timeout = 30000;
        Configuration.baseUrl = "https://app.qase.io";
        open();
        getWebDriver().manage().window().maximize();

        faker = new Faker();
        loginPage = new LoginPage();
        projectPage = new ProjectPage();
        projectsPage = new ProjectsPage();
        testCasePage = new TestCasePage();

        user = System.getProperty("user", PropertyReader.getProperty("DEF_USER"));
        password = System.getProperty("password", PropertyReader.getProperty("DEF_PASSWORD"));

        projectName = faker.lorem().characters(5);
        projectCode = faker.lorem().characters(5);
        projectDescription = faker.lorem().sentence();
        suiteName = faker.lorem().characters(5);
        suiteDescription = faker.lorem().characters(5);
        suitePrecondition = faker.lorem().characters(5);
        testCaseTitle = faker.lorem().characters(5);
        testCaseDescription = faker.lorem().characters(5);
        testCasePreConditions = faker.lorem().characters(5);
        testCasePostConditions = faker.lorem().characters(5);

    }

    @AfterMethod(alwaysRun = true, description = "Close browser")
    public void close() {
        closeWebDriver();
    }
}
