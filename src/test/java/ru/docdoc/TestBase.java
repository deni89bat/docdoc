package ru.docdoc;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.docdoc.config.WebDriverConfiguration;
import ru.docdoc.helpers.Attach;


import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    private static WebDriverConfiguration config = ConfigFactory.create(WebDriverConfiguration.class, System.getProperties());

    @BeforeAll
    static void beforeAll() {
        //Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = config.getBaseUrl();
        Configuration.browser = config.getBrowser();
        Configuration.browserVersion = config.getBrowserVersion();
        Configuration.browserSize = config.getBrowserSize();

        if (config.getRemoteURL() != null) {
            Configuration.remote = config.getRemoteURL();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            Map<String, Object> value = new java.util.HashMap<>();
            value.put("enableVNC", true);
            value.put("enableVideo", true);
            capabilities.setCapability("selenoid:options",
                value);
            Configuration.browserCapabilities = capabilities;
        }
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
