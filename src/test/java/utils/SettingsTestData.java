package utils;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.utilities.*;
import com.google.gson.Gson;
import lombok.experimental.UtilityClass;
import models.*;
import java.io.*;

@UtilityClass
public class SettingsTestData {
    public final String RESOURCES_PATH = "src/test/resources/";
    private final String ENVIRONMENT_PATH = RESOURCES_PATH + "environment/";
    private final String TESTDATA_PATH = RESOURCES_PATH + "testdata/";
    private final ISettingsFile ENVIRONMENT_CONFIG = new JsonSettingsFile("env.json");
    private final Gson GSON = new Gson();

    public EnvData getEnvData() {
        String envConfigPath = "%s%s.json".formatted(ENVIRONMENT_PATH, getCurrentEnvironment());
        return deserializeJson(envConfigPath, EnvData.class);
    }

    private String getCurrentEnvironment() {
        return ENVIRONMENT_CONFIG.getValue("/env").toString();
    }

    public UserData getSecretData() {
        return deserializeJson(TESTDATA_PATH + "userSecret.json", UserData.class);
    }

    private <T> T deserializeJson(String filePath, Class<T> tClass) {
        try {
            return GSON.fromJson(new FileReader(filePath), tClass);
        }
        catch (FileNotFoundException e) {
            AqualityServices.getLogger().error("Settings file %s not found or incorrect. Error msg: %s".formatted(filePath, e));
            throw new RuntimeException(e);
        }
    }
}
