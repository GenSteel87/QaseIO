package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import pages.*;
import utils.PropertyReader;
import utils.TestListener;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Log4j2
public class BaseTest {

    LoginPage loginPage;
    ProjectPage projectPage;
    ProjectSettingsPage projectSettingsPage;
    ProjectsPage projectsPage;
    CasePage casePage;
    Faker faker;
    String user;
    String password;
    @BeforeMethod(description = "Set browser")
    public void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide().screenshots(true));
        Configuration.browser = "chrome";
        Configuration.headless = true;
        Configuration.timeout = 90000;
        Configuration.baseUrl = "https://app.qase.io";
        open();
        getWebDriver().manage().window().maximize();

        faker = new Faker();
        loginPage = new LoginPage();
        projectPage = new ProjectPage();
        projectSettingsPage = new ProjectSettingsPage();
        projectsPage = new ProjectsPage();
        casePage = new CasePage();

        user = System.getProperty("user", PropertyReader.getProperty("DEF_USER"));
        password = System.getProperty("password", PropertyReader.getProperty("DEF_PASSWORD"));
    }

    @AfterMethod(alwaysRun = true, description = "Close browser")
    public void close() {
        closeWebDriver();
    }
}
