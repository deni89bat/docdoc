package ru.docdoc.pages.components;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class CitySelectModal {

  public SelenideElement citySelectButton = $("[data-test-id=city-select-button]"),
      inputCity = $(".TheInputNext__input_2v1P"),
      searchCityResult = $(".CitySelectModal__highlight_2YRu");


  @Step("Вызов модального окна выбора города")
  public CitySelectModal clickCitySelectButton() {
    citySelectButton.click();
    return this;
  }

  @Step("Ввод города")
  public CitySelectModal setCity(String city) {
    inputCity.setValue(city);
    return this;
  }

  @Step("Клик по найденому городу ")
  public CitySelectModal clickSearchResultCity() {
    searchCityResult.click();
    return this;
  }

  @Step("Проверка соотвествия URL аббревиатуре города")
  public CitySelectModal verifyUrl(String abbreviation) {
    webdriver().shouldHave(url("https://" + abbreviation + ".docdoc.ru/"));
    return this;
  }

}
