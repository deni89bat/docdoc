package ru.docdoc.pages.components;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

public class CookieBanner {

  private final SelenideElement cookieBanner = $("[data-test-id=cookies-banner]");
  private final SelenideElement closeCookieButton = $("[data-test-id=cookies-banner-button]");
  private final SelenideElement cookieBannerLink = cookieBanner.find("a");

  @Step("Проверить отображение баннера")
  public CookieBanner checkCookieBannerIsVisible() {
    cookieBanner.shouldBe(Condition.visible);
    cookieBanner.shouldHave(Condition.text(
        "Мы используем файлы cookies, чтобы делать сайт удобнее. Оставаясь на сайте, вы соглашаетесь с политикой их использования."));
    cookieBannerLink.shouldHave(Condition.attribute("href", "https://docdoc.ru/cookies"));
    return this;

  }

  @Step("Переход по ссылке с политикой ")
  public CookieBanner clickLinkCookieBanner() {
    String currentWindowHandle = WebDriverRunner.getWebDriver()
        .getWindowHandle();
    cookieBannerLink.click();
    switchTo().window(1);
    webdriver().shouldHave(url("https://docdoc.ru/cookies"));
    closeWindow();
    switchTo().window(currentWindowHandle);
    return this;
  }

  @Step("Закрыть баннер")
  public CookieBanner closeCookieBanner() {
    closeCookieButton.click();
    cookieBanner.shouldNotBe(Condition.visible);
    return this;
  }


}
