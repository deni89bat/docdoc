# Проект по автоматизации тестовых сценариев для сайта компании [СберЗдоровье](https://docdoc.ru/)
СберЗдоровье — сервис, предоставляющий услуги по поиску и подбору врачей частных медицинских учреждений, поиску диагностических медицинских центров, вызова врача на дом, записи пациентов к врачу и на диагностику по полису ДМС, телемедицины и ветеринарных услуг.

___

## Содержание:

- [Используемый стек](#computer-используемый-стек)
- [Список проверок](#spiral_notepad-список-проверок)
- [Локальный запуск автотестов](#arrow_forward-локальный-запуск-автотестов)
- [Запуск автотестов в Jenkins](#-запуск-автотестов-в-jenkins)
- [Пример Allure-отчета](#-пример-allure-отчета)
- [Интеграция с Allure TestOps](#-интеграция-с-allure-testOps)
- [Интеграция с Jira](#-интеграция-с-jira)
- [Уведомления в Telegram](#-уведомления-в-telegram)
- [Видео с запуском тестов](#-видео-с-запуском-тестов)

___

## :computer: Используемый стек технологий 

| <a href="https://www.jetbrains.com/idea/"><img src="media/logo/Intelij_IDEA.svg" width="40" height="40"  alt="IDEA"/></a> | <a href="https://www.jetbrains.com/idea/"><img src="media/logo/Java.svg" width="40" height="40"  alt="Java"/></a> | <a href="https://www.jetbrains.com/idea/"><img src="media/logo/JUnit5.svg" width="40" height="40"  alt="JUnit 5"/></a> |                      <a href="https://www.jetbrains.com/idea/"><img src="media/logo/Gradle.svg" width="40" height="40"  alt="Gradle"/></a>                      | <a href="https://www.jetbrains.com/idea/"><img src="media/logo/Selenide.svg" width="40" height="40"  alt="Selenide"/></a> |
|:-------------------------------------------------------------------------------------------------------------------------:|:-----------------------------------------------------------------------------------------------------------------:|:----------------------------------------------------------------------------------------------------------------------:|:----------------------------------------------------------------------------------------------------------------------------------------------------:|:---------------------------------------------------------------------------------------------------------------------------------------------------------:|
|                                                           IDEA                                                            |                                                       Java                                                        |                                                         Junit5                                                         |                                                                        Gradle                                                                        |                                                                         Selenide                                                                          |

| <a href="https://www.jetbrains.com/idea/"><img src="media/logo//Selenoid.svg" width="40" height="40"  alt="Selenoid"/></a> |                <a href="https://www.jetbrains.com/idea/"><img src="media/logo/Allure_Report.svg" width="40" height="40"  alt="Allure"/></a>                 | <a href="https://www.jetbrains.com/idea/"><img src="media/logo/AllureTestOps.svg" width="40" height="40"  alt="Allure TestOps"/></a> | <a href="https://www.jetbrains.com/idea/"><img src="media/logo/Jenkins.svg" width="40" height="40"  alt="Jenkins"/></a> | <a href="https://www.jetbrains.com/idea/"><img src="media/logo/GitHub.svg" width="40" height="40"  alt="Github"/></a> | <a href="https://www.jetbrains.com/idea/"><img src="media/logo/Jira.svg" width="40" height="40"  alt="Jira"/></a> |
|:---------------------------------------------------------------------------------------------------------------------------------------------------------:|:-----------------------------------------------------------------------------------------------------------------------------------------------------------:|:------------------------------------------------------------------------------------------------------------------------------------:|:-----------------------------------------------------------------------------------------------------------------------:|:---------------------------------------------------------------------------------------------------------------------:|:-------------------------------------------------------------------------------------------------------------------------------------------------:|
|                                                                         Selenoid                                                                          |                                                                           Allure                                                                            |                                                              Allure TO                                                               |                                                         Jenkins                                                         |                                                        Github                                                         |                                                                       Jira                                                                        |

- Тесты в данном проекте написаны на языке <code>Java</code> с использованием фреймворка для тестирования <code>Selenide</code> в среде разработки <code>IDEA</code>
- В качестве сборщика был использован - <code>Gradle</code>
- <code>JUnit 5</code> задействован в качестве фреймворка модульного тестирования
- При прогоне тестов браузер запускается в <code>Selenoid</code>
- Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием <code>Allure-отчета</code> и отправкой результатов в <code>Telegram</code> при помощи бота
- Осуществлена интеграция с <code>Allure TestOps</code> и <code>Jira</code>

___

## :spiral_notepad: Список проверок

### Web-тесты
:white_check_mark: Отображение баннера об использовании cookie<br />
:white_check_mark: Переход по ссылке с политикой<br />
:white_check_mark: Проверка выбора города (параметризованный тест)<br />
:white_check_mark: Проверка на соотвествие абревиатуры в url - городу<br />
:white_check_mark: Проверка формы поиска специалиста<br />

___

## :arrow_forward: Локальный запуск автотестов

### На локальном бразуере с параметрами сборки по умолчанию

```
gradle clean test
```

### На локальном браузере с параметрами сборки из local.properties

```
gradle clean test -Denvironment='local'
```

### На локальном/удаленном браузере с указанием необходимых параметров сборки

```
gradle clean
TASK
-DbaseUrl=BASE_URL
-Dbrowser=BROWSER
-DbrowserVersion=BROWSER_VERSION
-DbrowserSize=BROWSER_SIZE
-DremoteUrl=REMOTE_URL

```

где:
>- <code>TASK</code> - название задачи test или smoke
>- <code>BASE_URL</code> - адрес тестового стенда (по умолчанию https://docdoc.ru)
>- <code>BROWSER</code> - браузер, в котором будут выполняться тесты (по умолчанию chrome)
>- <code>BROWSER_VERSION</code> - версия браузера (по умолчанию 100.0)
>- <code>BROWSER_SIZE</code> - размер окна браузера (по умолчанию 1920x1080)
>- <code>REMOTE_URL</code> - адрес для удаленного запуска тестов


___

## <img width="4%" style="vertical-align:middle" title="Jenkins" src="media/logo/Jenkins.svg"> Запуск автотестов в Jenkins

### Для запуска автотестов в Jenkins необходимо
1. Открыть <a target="_blank" href="https://jenkins.autotests.cloud/job/Students/job/docdoc_ru_Pisyaev_DM/">проект</a>
2. Выбрать пункт **Собрать с параметрами**
3. При необходимости изменить параметры, выбрав значения
4. Нажать **Собрать**

![This is an image](/media/screens/jenkins_0.png)

После выполнения сборки, в блоке <code>История сборок</code> напротив номера сборки появятся
значок <img width="2%" title="Allure Report" src="media/logo/Allure_Report.svg"><code>Allure
Report</code>, кликнув по которому, откроется страница с сформированным html-отчетом,
и значок <img width="2%" title="Allure TestOps" src="media/logo/AllureTestOps.svg"><code>Allure TestOps</code>, кликнув по которому, откроется система управления тестами.

![This is an image](/media/screens/jenkins_1.png)

---

## <img width="4%" style="vertical-align:middle" title="Allure Report" src="media/logo/Allure_Report.svg"> Пример Allure-отчета

### Главная страница Allure-отчета

![This is an image](/media/screens/Allure_Report_1.png)

### Пример отчёта выполнения одного из автотестов

Содержит в себе:
- Шаги теста
- Скриншот страницы на последнем шаге
- Page Source
- Логи браузерной консоли
- Видео прогона автотестов

![This is an image](/media/screens/Allure_Report_2.png)

----

## <img width="4%" style="vertical-align:middle" title="Allure TestOps" src="media/logo/AllureTestOps.svg"> Интеграция с Allure TestOps

### Dashboard с общими результатами тестирования

![This is an image](/media/screens/Allure_TestOps_1.png)<br />

### Общий список всех кейсов

![This is an image](/media/screens/Allure_TestOps_2.png)<br />

### Тест-планы проекта

![This is an image](/media/screens/Allure_TestOps_3.png)<br />

### Пример отчёта выполнения одного из автотестов
Содержит в себе:
- Шаги теста
- Скриншот страницы на последнем шаге
- Page Source
- Логи браузерной консоли
- Видео прогона автотестов

![This is an image](/media/screens/Allure_TestOps_4.png)

___

## <img width="4%" style="vertical-align:middle" title="Jira" src="media/logo/Jira.svg"> Интеграция с Jira

### Реализована интеграция <code>Allure TestOps</code> с <code>Jira</code>. В задаче отображаются прикреплённые к ней тест-кейсы

![This is an image](/media/screens/Jira_1.png)

### Также прикреплены результаты запусков/прохождения тестов

![This is an image](/media/screens/Jira_2.png)

___

## <img width="4%" style="vertical-align:middle" title="Telegram" src="media/logo/Telegram.svg"> Уведомления в Telegram

### После завершения сборки, бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с результатом

![This is an image](/media/screens/Telegram.png)

___

## <img width="4%" style="vertical-align:middle" title="Selenoid" src="media/logo/Selenoid.svg"> Видео с запуском тестов

### Для всех тестов записано видео с прохождением тестов

![This is an gif](/media/screens/selenoid.gif)

---