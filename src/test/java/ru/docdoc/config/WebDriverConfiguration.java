package ru.docdoc.config;

import org.aeonbits.owner.Config;

@Config.Sources({
    "classpath:${environment}.properties"
})
public interface WebDriverConfiguration extends Config {

  @Key("baseUrl")
  @DefaultValue("https://docdoc.ru")
  String getBaseUrl();

  @Key("browser")
  @DefaultValue("chrome")
  String getBrowser();

  @Key("browserVersion")
  @DefaultValue("100.0")
  String getBrowserVersion();

  @Key("browserSize")
  @DefaultValue("1920x1080")
  String getBrowserSize();

  @Key("remoteUrl")
  String getRemoteURL();
}
