package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class LoginPage {
    final String EMAIL_CSS = "[name=email";
    final String PASS_CSS = "[name=password]";
    final String SUBMIT_CSS = "[type=submit]";

    private final SelenideElement emailField = $(EMAIL_CSS);
    private final SelenideElement passwordField = $(PASS_CSS);
    private final SelenideElement submitButton = $(SUBMIT_CSS);
    @Step("Open Login page")
    public LoginPage openLoginPage() {
        log.info("Open Login page");
        open("/login");
        return this;
    }

    @Step("Login by user name: '{user}' and password: '{password}'")
    public ProjectsPage login(String user, String password) {
        log.info("Login by user name: '{user}' and password: '{password}'");
        emailField.sendKeys(user);
        passwordField.sendKeys(password);
        submitButton.click();
        return new ProjectsPage();
    }
}
