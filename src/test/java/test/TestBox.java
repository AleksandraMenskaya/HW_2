package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;


public class TestBox {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Aleksandra");
        $("#lastName").setValue("Menskaia");
        $("#userEmail").setValue("al.menskaya@gmail.com");
        $("#gender-radio-2 + label").click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("1988");
        $(".react-datepicker__day--002:not(.react-datepicker__day--outside-month)").click();
        $("#hobbies-checkbox-3 + label").click();
        $("#subjectsInput").setValue("Subject");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#uploadPicture").uploadFile(new File("src\\test\\java\\test\\imagesForTest.jfif"));
        $("#stateCity-label").scrollIntoView(true).click();
        $("#currentAddress").setValue("Belgrade");
        $("#state").click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-1").click();
        $("#submit").scrollIntoView(true).click();
    }
}