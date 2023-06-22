package ru.docdoc.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import ru.docdoc.TestBase;
import ru.docdoc.pages.MainPage;
import ru.docdoc.pages.components.SearchForm;

@Feature("Форма поиска")
@DisplayName("Проверка формы поиска")
@TestMethodOrder(OrderAnnotation.class)
public class SearchFormTest extends TestBase {

  MainPage mainPage = new MainPage();
  SearchForm searchForm = new SearchForm();

  @Tag("smoke")
  @DisplayName("Форма поиска отображается на главной странице.")
  @Severity(SeverityLevel.CRITICAL)
  @Test
  @Order(1)
  void searchFormTest() {
    mainPage.openPage();
    searchForm.checkSearchForm();
  }

  @Tag("smoke")
  @DisplayName("Заполнить в форме поиска поле врач, клиника, болезнь, услуга.")
  @Severity(SeverityLevel.CRITICAL)
  @Test
  @Order(2)
  void setSearchFormTest() {
    searchForm.setValueSearchForm();
  }

  @Tag("smoke")
  @DisplayName("Заполнить в форме поиска поле метро, район, округ.")
  @Severity(SeverityLevel.CRITICAL)
  @Test
  @Order(3)
  void setGeoSearchFormTest() {
    searchForm.setGeoValueSearchForm();
  }

  @Tag("smoke")
  @DisplayName("Нажать кнопку Найти. Осуществляется переход к рез-ту поиска.")
  @Severity(SeverityLevel.CRITICAL)
  @Test
  @Order(4)
  void clickSearchButtonTest() {
    searchForm.clickSearchButton();
  }

}