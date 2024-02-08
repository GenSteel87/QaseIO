package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import helpers.DataFactory;
import helpers.ProjectAdapter;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.extern.log4j.Log4j;
import models.Project;
import models.Suite;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {

    LoginPage loginPage;
    ProjectPage projectPage;
    ProjectSettingsPage projectSettingsPage;
    ProjectsPage projectsPage;
    TestCasePage testCasePage;
    Faker faker;
    String user;
    String password;
    String TOKEN;

    @BeforeMethod(description = "Set browser")
    public void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.browser = "chrome";
        Configuration.headless = true;
        Configuration.timeout = 90000;
        Configuration.baseUrl = System.getProperty("BASE_URL", PropertyReader.getProperty("BASE_URL"));;
        open();
        getWebDriver().manage().window().maximize();

        faker = new Faker();
        loginPage = new LoginPage();
        projectPage = new ProjectPage();
        projectSettingsPage = new ProjectSettingsPage();
        projectsPage = new ProjectsPage();
        testCasePage = new TestCasePage();

        user = System.getProperty("user", PropertyReader.getProperty("DEF_USER"));
        password = System.getProperty("password", PropertyReader.getProperty("DEF_PASSWORD"));
        TOKEN = System.getProperty("TOKEN", PropertyReader.getProperty("DEF_TOKEN"));

    }

    @AfterMethod(alwaysRun = true, description = "Close browser")
    public void close() {
        closeWebDriver();
    }
}
