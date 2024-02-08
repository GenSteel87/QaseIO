package pages;

import com.codeborne.selenide.SelenideElement;
import io.netty.util.internal.logging.InternalLogger;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    final String EMAIL_CSS = "[name=email";
    final String PASS_CSS = "[name=password]";
    final String SUBMIT_CSS = "[type=submit]";

    private final SelenideElement emailField = $(EMAIL_CSS);
    private final SelenideElement passwordField = $(PASS_CSS);
    private final SelenideElement submitButton = $(SUBMIT_CSS);
    @Step("Open Login page")
    public LoginPage openLoginPage() {
        open("/login");
        return this;
    }

    @Step("Login by user name: DEF_USER and password: DEF_PASSWORD")
    public ProjectsPage login(String user, String password) {
        emailField.sendKeys(user);
        passwordField.sendKeys(password);
        submitButton.click();
        return new ProjectsPage();
    }
}
