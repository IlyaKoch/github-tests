package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideSearch {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void shouldFindSelenideJUnit5Code() {
        open("https://github.com");
        $("[data-test-selector=nav-search-input]").setValue("Selenide").pressEnter();
        var listOfRepositories = $$(".repo-list li");
        listOfRepositories.first().$("a").click();
        $("h1").should(text("selenide/selenide"));
        $("#wiki-tab").click();
        $$(".markdown-body ul li").get(6).$("a").should(text("Soft assertions")).click();
        var listOfMechanisms = $$(".markdown-body ol li");
        listOfMechanisms.findBy(text("JUnit5 extension")).should(text("JUnit5"));
    }
}