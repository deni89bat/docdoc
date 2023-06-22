package ru.docdoc.pages;

import static com.codeborne.selenide.Selenide.open;

import io.qameta.allure.Step;

public class MainPage {

  @Step("Открыть главную страницу")

  public MainPage openPage() {
    open("");
    return this;

  }


}

