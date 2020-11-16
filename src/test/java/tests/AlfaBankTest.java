package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AlfaBankTest {

    @Test
    void testAlfa(){

        open("https://alfabank.ru/");

        $$(byText("Вклады")).find(visible).click();
        $$(byText("Депозиты")).find(visible).parent().click();
        $(byText("Архивные счета и депозиты")).click();





        $("body").shouldHave(text("Архивные счета и депозиты"));

    }
}
