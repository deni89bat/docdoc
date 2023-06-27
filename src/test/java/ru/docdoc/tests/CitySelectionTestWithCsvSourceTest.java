package ru.docdoc.tests;


import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.docdoc.TestBase;
import ru.docdoc.pages.MainPage;
import ru.docdoc.pages.components.CitySelectModal;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
@DisplayName("Проверка выбора города")
@Tag("smoke")
public class CitySelectionTestWithCsvSourceTest extends TestBase {
    MainPage mainPage = new MainPage();
    CitySelectModal citySelectModal = new CitySelectModal();
    @CsvSource({"Альметьевск, alm",
            "Анапа, anp",
            "Ангарск, angr",
            "Армавир, arm",
            "Архангельск, arh",
            "Астрахань, astr"})
    @ParameterizedTest(name = "Для города {0} осуществляется переход на страницу https://{1}.docdoc.ru/")
    @DisplayName("Тест на соотвествие абревиатуры в url - городу.")
    @Tags({
            @Tag("CRITICAL"),
            @Tag("CITY")
    })
    void selectionCityTest(String city, String abbreviation) {
       mainPage.openPage();
       citySelectModal.clickCitySelectButton();
       citySelectModal.inputCity.setValue(city);
       citySelectModal.clickSearchResultCity();
        webdriver().shouldHave(url("https://" + abbreviation + ".docdoc.ru/"));
    }
}
