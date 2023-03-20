package kochetkov.allure;

import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.*;

public class DynamicLabelsTest extends TestBase {

    @Test
    @DisplayName("Проверка того, что мы можем поискать конкретную Issue")
    public void testGitHub() {
        feature("Issue");
        story("Поиск по Issue");
        label("owner", "IlyaKoch");
        label("severity", SeverityLevel.BLOCKER.toString());
        link("Главная страница", "https://github.com");
        step("Open start page", () -> {
            open("https://github.com/");
        });
    }
}