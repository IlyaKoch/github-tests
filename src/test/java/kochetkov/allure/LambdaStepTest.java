package kochetkov.allure;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class LambdaStepTest extends TestBase {

    public final static String REPOSITORY = "IlyaKoch/allure-reports";

    @Test
    public void testGitHub() {
        step("Open start page", () -> {
            open("https://github.com/");
        });

        step("Search repository " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Moving to repository " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Open Issues ", () -> {
            $("#issues-tab").click();
        });
        step("Checking for availability Issue", () -> {
            $("#issue_1_link").shouldHave(Condition.text("testIssue"));
        });
    }
}