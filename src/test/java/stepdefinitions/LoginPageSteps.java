package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.LoginPage;

import static io.qameta.allure.Allure.step;

public class LoginPageSteps {
    private final LoginPage loginPage = new LoginPage();

    @Given("the user opens the application")
    public void theUserOpensTheApplication() {
        step("The user opens the application", () -> {
            loginPage.openApplication();
        });
    }

    @And("the login page is displayed")
    public void theLoginPageIsDisplayed() {
        step("The login page is displayed", () -> {
            Assert.assertTrue(loginPage.state().isDisplayed(), "Login page is not displayed");
        });
    }

    @When("the user enters valid login credentials")
    public void theUserEntersValidLoginCredentials() {
        step("The user enters valid login credentials", () -> {
            loginPage.fillUserPass();
        });
    }

    @And("clicks the {string} button")
    public void clicksTheLoginButton(String buttonName) {
        step("Clicks the " + buttonName + " button", () -> {
            if (buttonName.equals("Login")) {
                loginPage.clickLogin();
            }
        });
    }
}
