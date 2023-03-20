package kochetkov.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Open main page")
    public void openMainPage() {
        open("https://github.com/");
        takeScreenshot();
        takePageSource();
    }

    @Step("Search repository {repository}")
    public void searchForRepository(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
        takeScreenshot();
        takePageSource();
    }

    @Step("Moving to repository {repository}")
    public void goToRepository(String repository) {
        $(linkText(repository)).click();
        takeScreenshot();
        takePageSource();
    }

    @Step("Open Issues")
    public void openIssueTab() {
        $("#issues-tab").click();
        takeScreenshot();
        takePageSource();
    }

    @Step("Checking for availability Issue")
    public void checkForAvailableIssueWithNumber() {
        $("#issue_1_link").shouldHave(Condition.text("testIssue"));
        takeScreenshot();
        takePageSource();
    }

    @Attachment(value = "Page Source", type = "text/html")
    public byte[] takePageSource() {
        return WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        return Selenide.screenshot(OutputType.BYTES);
    }
}