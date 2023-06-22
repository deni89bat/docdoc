package ru.docdoc.pages.components;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class CitySelectModal {

  public SelenideElement citySelectButton = $("[data-test-id=city-select-button]"),
      inputCity = $(".TheInputNext__input_2v1P"),
      searchCityResult = $(".CitySelectModal__highlight_2YRu");
  String city = null;

  @Step("Вызов модального окна выбора города")
  public CitySelectModal clickCitySelectButton() {
    citySelectButton.click();
    return this;
  }

  @Step("Клик по найденому городу ")
  public CitySelectModal clickSearchResultCity() {
    searchCityResult.click();
    return this;
  }

}
