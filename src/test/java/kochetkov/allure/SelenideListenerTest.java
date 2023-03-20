package kochetkov.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideListenerTest {

    @Test
    public void testGitHub() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com/");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("IlyaKoch/allure-reports");
        $(".header-search-input").submit();

        $(linkText("IlyaKoch/allure-reports")).click();
        $("#issues-tab").click();
        $("#issue_1_link").shouldHave(Condition.text("testIssue"));
    }
}