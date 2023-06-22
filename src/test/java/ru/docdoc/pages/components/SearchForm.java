package ru.docdoc.pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class SearchForm {

  private SelenideElement searchForm = $("[data-test-id=search_form]"),
      searchInput = $("[data-test-id=search_input]"),
      searchInputActive = $("input[placeholder='Врач, клиника, болезнь, услуга']"),
      searchSuggestions = $(".SearchSuggestion__text_2_9_"),
      searchGeoInput = $("[data-test-id=search_geo_input"),
      searchGeoInputActive = $("input[placeholder='Метро, район, округ, город МО']"),
      searchSuggestionsGeo = $(".SearchLocationSuggestion__text_2vgG"),
      searchButton = $("[data-test-id='search_button']");


  @Step("Отображается форма поиска")
  public SearchForm checkSearchForm() {
    searchForm.shouldBe(Condition.visible);
    return this;
  }

  @Step("Заполнить поле врач, клиника, болезнь, услуга. В результатах отображаются запрошенные данные. ")
  public SearchForm setValueSearchForm() {
    searchInput.click();
    searchInputActive.sendKeys("эпилептолог детский");
    searchSuggestions.shouldHave(text("Эпилептолог детский")).click();
    return this;
  }

  @Step("Заполнить поле метро,район,округ. В результатах отображаются запрошенные данные. ")
  public SearchForm setGeoValueSearchForm() {
    searchGeoInput.click();
    searchGeoInputActive.sendKeys("Электроу");
    searchSuggestionsGeo.shouldHave(text("Электроугли")).click();
    return this;
  }

  @Step("Нажать кнопку Найти.")
  public SearchForm clickSearchButton() {
    searchButton.click();
    webdriver().shouldHave(url("https://docdoc.ru/doctor/epileptolog/city/elektrougli/deti"));
    return this;
  }
}

