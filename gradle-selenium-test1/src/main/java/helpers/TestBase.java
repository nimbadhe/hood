package helpers;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestBase {
    private final Logger LOGGER = LoggerFactory.getLogger(TestBase.class);


    @BeforeSuite
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));

    }

    @BeforeTest
    public void beforeTest() {
        LOGGER.info("This happens before each test");
    }

    @AfterTest
    public void tearDown() {

    }


}
