Feature: Buy products
    As a customer
    I want to buy products

Background:
    Given สินค้า "Bread" with price 20.50 exists
    And สินค้า "Jam" with price 80.00 exists
    And สินค้า "Orange Juice" with price 60.00 exists

Scenario: Buy one product
    When ฉันซื้อ "Bread" with quantity 2
    Then total should be 41.00

Scenario: Buy multiple products
    When ฉันซื้อ "Bread" with quantity 2
    And ฉันซื้อ "Jam" with quantity 1
    Then total should be 121.00
    
Scenario: Buy three products
    When ฉันซื้อ "Bread" with quantity 3
    And ฉันซื้อ "Jam" with quantity 2
    And ฉันซื้อ "Orange Juice" with quantity 2
    Then total should be 341.5



