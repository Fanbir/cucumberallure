package stepdef;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.selenide.AllureSelenide;


public class Hooks {

    @Before
    public static void setUp(Scenario scenario) {
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver89.exe");
        Configuration.startMaximized = true;
        Configuration.timeout=10000;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    /**
     * Закрывающий метод, выполняющийся после каждого сценария. Расширен сохранением скриншотов в случае ошибок.
     *
     * @param scenario сценарий, после которого выполняется закрывающий метод
     */
    @After
    public static void tearDown(Scenario scenario) {
        Selenide.closeWebDriver(); // закрываем браузер
    }

}
