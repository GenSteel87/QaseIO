package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    final String EMAIL_CSS = "[name=email";
    final String PASS_CSS = "[name=password]";
    final String SUBMIT_CSS = "[type=submit]";

    public void openPage() {
        open("/login");
    }
    public void login(String user, String password) {
        $(EMAIL_CSS).sendKeys("yauhenitest.stalkoutest@gmail.com");
        $(PASS_CSS).sendKeys("123456Test_1G!");
        $(SUBMIT_CSS).click();
    }
}
