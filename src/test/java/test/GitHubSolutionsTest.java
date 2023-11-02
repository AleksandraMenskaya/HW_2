package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.WebDriverConditions.*;
import static com.codeborne.selenide.Selenide.*;

public class GitHubSolutionsTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void checkEnterprise() {
        open("https://github.com");
        $x("//button[contains(text(),'Solutions')]").hover();
        $x("//a[contains(text(),'Enterprise')]").click();
        webdriver().shouldHave(url("https://github.com/enterprise"));
    }
}