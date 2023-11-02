package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubSelenideTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com/";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void checkJUnit5Test() {
        open("selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("Softassertions").pressEnter();
        $("[href='/selenide/selenide/wiki/SoftAssertions']").click();
        $("#user-content-3-using-junit5-extend-test-class+div").$("pre").shouldHave(text("@ExtendWith({SoftAssertsExtension.class}"));
    }
}