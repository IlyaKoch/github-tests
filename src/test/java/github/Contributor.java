package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class Contributor {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    public void andreiSolntsevTest() {
        open("https://github.com/selenide/selenide");
        $(".BorderGrid").$(byText("Contributors")).closest("div").$("ul li").hover();
        sleep(5000);
        $$(".Popover-message").findBy(visible).shouldHave(text("Andrei Solntsev"));
    }
}
