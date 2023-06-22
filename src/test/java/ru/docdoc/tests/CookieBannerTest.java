package ru.docdoc.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.docdoc.TestBase;
import ru.docdoc.pages.MainPage;
import ru.docdoc.pages.components.CookieBanner;

@Feature("CookieBanner")
@DisplayName("Проверка баннера с предупреждением об использвании cookies")
public class CookieBannerTest extends TestBase {

  MainPage mainPage = new MainPage();
  CookieBanner cookieBanner = new CookieBanner();

  @Tag("smoke")
  @Story("Баннер с предупреждением об использвании cookies. Проверка отображения/закрытия, наличия ссылки о политике и перехода по ней.")
  @DisplayName("Баннер с предупреждением об использвании cookies. Проверка отображения/закрытия, наличия ссылки о политике и перехода по ней.")
  @Severity(SeverityLevel.CRITICAL)
  @Test
  void cookieBannerTest() {
    mainPage.openPage();
    cookieBanner.checkCookieBannerIsVisible();
    cookieBanner.ClickLinkCookieBanner();
    cookieBanner.closeCookieBanner();
  }


}
