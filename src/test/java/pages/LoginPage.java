package pages;

import aquality.selenium.browser.*;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import utils.SettingsTestData;
import models.UserData;

public class LoginPage extends Form {
    // Framework and Credentials
    private final IElementFactory elementFactory = AqualityServices.getElementFactory();
    private final Browser browser = AqualityServices.getBrowser();
    private final UserData userData = SettingsTestData.getSecretData();

    // Page Elements
    private final ITextBox UserNameField = elementFactory.getTextBox(By.id("username"), "User name");
    private final ITextBox PasswordField = elementFactory.getTextBox(By.id("password"), "Password button");
    private final IButton LoginBtn = elementFactory.getButton(By.id("login-btn"), "Login button");

    public LoginPage() {
        super(By.id("login-btn"), "Login Page");
    }

    public void openApplication() {
        browser.goTo(SettingsTestData.getEnvData().getHost());
    }

    public void fillUserPass() {
        UserNameField.type(userData.username());
        PasswordField.typeSecret(userData.password());
    }

    public void clickLogin() {
        LoginBtn.click();
    }
}
