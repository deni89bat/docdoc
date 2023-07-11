package ru.docdoc.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import ru.docdoc.TestBase;
import ru.docdoc.pages.MainPage;
import ru.docdoc.pages.components.CookieBanner;

@Feature("CookieBanner")
@DisplayName("Проверка баннера с предупреждением об использвании cookies")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CookieBannerTest extends TestBase {

  MainPage mainPage = new MainPage();
  CookieBanner cookieBanner = new CookieBanner();

  @Tag("smoke")
  @Story("Баннер с предупреждением об использвании cookies. ")
  @DisplayName("Проверка отображения баннера с предупреждением об использвании cookies..")
  @Severity(SeverityLevel.CRITICAL)
  @Test
  @Order(1)
  void cookieBannerVisibleTest() {
    mainPage.openPage();
    cookieBanner.checkCookieBannerIsVisible();
  }


  @Tag("smoke")
  @Story("Баннер с предупреждением об использвании cookies.")
  @DisplayName("Проверка наличия ссылки о политике и переход по ней.")
  @Severity(SeverityLevel.CRITICAL)
  @Test
  @Order(2)
  void cookieBannerLinkTest() {
    mainPage.openPage();
    cookieBanner.clickLinkCookieBanner();
  }

  @Tag("smoke")
  @Story("Баннер с предупреждением об использвании cookies.")
  @DisplayName("Закрытие баннера.")
  @Severity(SeverityLevel.CRITICAL)
  @Test
  @Order(3)
  void cookieBannerCloseTest() {
    mainPage.openPage();
    cookieBanner.closeCookieBanner();
  }


}