package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.ProjectPage;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public abstract class BaseTest {

    LoginPage loginPage;
    ProjectPage projectPage;
    Faker faker;
    String user;
    String password;

    @BeforeMethod(description = "Настройки браузера")
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.timeout = 10000;
        Configuration.baseUrl = "https://app.qase.io";
        open();
        getWebDriver().manage().window().maximize();

        faker = new Faker();
        loginPage = new LoginPage();
        projectPage = new ProjectPage();

        user = System.getProperty("user", PropertyReader.getProperty("def_user"));
        System.out.println(user);
        password = System.getProperty("password", PropertyReader.getProperty("def_password"));
        System.out.println(password);
    }

    @AfterMethod(alwaysRun = true, description = "Закрытие браузера")
    public void close() {
        closeWebDriver();
    }
}
