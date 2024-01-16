package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideConfig;
import com.github.javafaker.Faker;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.ProjectPage;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class BaseTest {

    LoginPage loginPage;
    ProjectPage projectPage;
    Faker faker;
    String user;
    String password;

    @BeforeMethod(description = "Set browser")
    public void setUp() {
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browser = "chrome";
        Configuration.headless = true;
        Configuration.timeout = 10000;
        Configuration.baseUrl = "https://app.qase.io";
        open();
        getWebDriver().manage().window().maximize();

        faker = new Faker();
        loginPage = new LoginPage();
        projectPage = new ProjectPage();

        user = System.getProperty("user", PropertyReader.getProperty("def_user"));
        password = System.getProperty("password", PropertyReader.getProperty("def_password"));


    }

    @AfterMethod(alwaysRun = true, description = "Close browser")
    public void close() {
        closeWebDriver();
    }
}
