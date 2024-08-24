package hooks;

import aquality.selenium.browser.AqualityServices;
import io.cucumber.java.*;

public class Hooks {

    @BeforeAll
    public static void setUp() {
        AqualityServices.getBrowser().maximize();
    }

    @AfterAll
    public static void tearDown() {
        AqualityServices.getBrowser().quit();
    }
}
