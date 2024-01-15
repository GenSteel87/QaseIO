package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    final String EMAIL_CSS = "[name=email";
    final String PASS_CSS = "[name=password]";
    final String SUBMIT_CSS = "[type=submit]";

    public void openPage() {
        open("/login");
    }

    @Step("Login")
    public void login(String user, String password) {
        $(EMAIL_CSS).sendKeys(user);
        $(PASS_CSS).sendKeys(password);
        $(SUBMIT_CSS).click();
    }
}
