package tests;

import org.testng.annotations.Test;


public class CleanUpTest extends BaseTest{
    @Test(description = "Delete all projects")
    public void deleteAllProjects() {

        loginPage.
                openLoginPage().
                login(user, password).
                waitTillPaginationAppears().
                deleteAllProjects();
    }
}
