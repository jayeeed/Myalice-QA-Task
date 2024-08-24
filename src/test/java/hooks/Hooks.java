package hooks;

import aquality.selenium.browser.AqualityServices;
import io.cucumber.java.*;

public class Hooks {

    @Before
    public static void setUp() {
        AqualityServices.getBrowser().maximize();
    }

    @After
    public static void tearDown() {
        AqualityServices.getBrowser().quit();
    }
}
