@search
Feature: Поиск с помощью поисковой строки
  Scenario: Поиск товара "iPhone 13"
    Given Пользователь открыл сайт "https://www.wildberries.ru/"
    When Пользователь вводит "iPhone 13" в строку поиска
    Then Пользователь видит товар "iPhone 13" в результатах поиска