package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AlfaBankTest {

    String url = "https://alfabank.ru/";

    @Test
    void testAlfa(){

        open(url);

        $$(byText("Вклады")).find(visible).click();
        $$(byText("Депозиты")).find(visible).parent().click();
        $(byText("Архивные счета и депозиты")).click();
        $$(byText("Депозиты")).find(visible).click();

 //       $("#filter").findAll("[data-widget-name=\"CatalogCard\"]").shouldHaveSize(5);

        $("[data-widget-name=\"CatalogCard\"]").$(byText("Победа+")).click();

    }

    @Test
    void alfaElementSibling(){
        // Обращаемся к первому элементу на странице в блоке tabs-list и через sibling(0) смещаемся на следующий элемент на 1 позицию.

        open(url);

        $$(byText("Вклады")).find(visible).click();
        $("#good-to-know [data-test-id=\"tabs-list-tabTitle-0\"]").sibling(0).click();

        $("[data-test-id=\"accordion-header-3\"]").shouldHave(text("Как происходит возмещение средств?"));
    }

    @Test
    void alfaElementClosest(){
        // Обращаемся к самому "глубокому" элементу у "Страхование вкладов" (span) и через closest("button") поднимаемся до ближайшего родителя с тегом button.

        open(url);

        $$(byText("Вклады")).find(visible).click();
        $("#good-to-know [data-test-id=\"tabs-list-tabTitle-1\"] span").closest("button").click();

        $("[data-test-id=\"accordion-header-3\"]").shouldHave(text("Как происходит возмещение средств?"));
    }

    @Test
    void alfaElementPreceding(){
        // Обращаемся к третьему элементу на странице в блоке tabs-list и через preceding(0) смещаемся на предыдущий элемент на 1 позицию.

        open(url);

        $$(byText("Вклады")).find(visible).click();
        $("#good-to-know [data-test-id=\"tabs-list-tabTitle-2\"]").preceding(0).click();

        $("[data-test-id=\"accordion-header-3\"]").shouldHave(text("Как происходит возмещение средств?"));
    }

    @Test
    void localTest() {

        open("file://c:\\Users\\Сода\\IdeaProjects\\QA_lesson_3\\src\\test\\resources\\Elements.html");

        $("h1 div").shouldHave(text("Hello"));

    //    $("h1").$("div").shouldHave(text("Hello"));

    }
}
