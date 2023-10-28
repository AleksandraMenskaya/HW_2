package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;

public class TestBox {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        //  Configuration.holdBrowserOpen = true;
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
        $("#hobbies-checkbox-1 + label").click();
        $("#hobbies-checkbox-3 + label").click();
        $("#subjectsInput").setValue("History").pressEnter();
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#uploadPicture").uploadFromClasspath("imagesForTest.jfif");
        $("#stateCity-label").scrollIntoView(true).click();
        $("#currentAddress").setValue("Belgrade");
        $("#state").click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-1").click();
        $("#submit").scrollIntoView(true).click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $("tbody tr:nth-child(1) td:last-child").shouldHave(text("Aleksandra Menskaia"));
        $("tbody tr:nth-child(2) td:last-child").shouldHave(text("al.menskaya@gmail.com"));
        $("tbody tr:nth-child(3) td:last-child").shouldHave(text("Female"));
        $("tbody tr:nth-child(4) td:last-child").shouldHave(text("1234567890"));
        $("tbody tr:nth-child(5) td:last-child").shouldHave(text("02 August,1988"));
        $("tbody tr:nth-child(6) td:last-child").shouldHave(text("History"));
        $("tbody tr:nth-child(7) td:last-child").shouldHave(text("Sports, Music"));
        $("tbody tr:nth-child(8) td:last-child").shouldHave(text("imagesForTest.jfif"));
        $("tbody tr:nth-child(9) td:last-child").shouldHave(text("Belgrade"));
        $("tbody tr:nth-child(10) td:last-child").shouldHave(text("NCR Gurgaon"));

    }

}