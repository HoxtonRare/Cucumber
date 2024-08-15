@cart @purchase
Feature: Добавление в корзину
  Scenario: Добавление товара "iPhone 13" в корзину
    Given Пользователь открыл карточку товара "https://www.wildberries.ru/catalog/177899980/detail.aspx"
    When Пользователь добавляет товар в корзину
    Then В корзине пользователя находится добавленный товар "iPhone 13 128GB"