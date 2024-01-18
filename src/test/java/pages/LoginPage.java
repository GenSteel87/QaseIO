package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    final String EMAIL_CSS = "[name=email";
    final String PASS_CSS = "[name=password]";
    final String SUBMIT_CSS = "[type=submit]";

    private final SelenideElement emailField = $(EMAIL_CSS);
    private final SelenideElement passwordField = $(PASS_CSS);
    private final SelenideElement submitButton = $(SUBMIT_CSS);
    public LoginPage openLoginPage() {
        open("/login");
        return this;
    }

    @Step("Login")
    public ProjectsPage login(String user, String password) {
        emailField.sendKeys(user);
        passwordField.sendKeys(password);
        submitButton.click();
        return new ProjectsPage();
    }
}
