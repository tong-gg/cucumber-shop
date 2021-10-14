Feature: Checking Stock
  As a merchandise
  I want to check stocks

Background:
  Given product "Bread" with price 20.50, and quantity 5
  And product "Jam" with price 80.00, and quantity 7
  And product "Orange Juice" with price 60.00, and quantity 8

Scenario: Buy each item with exceed quantity
  When a customer buy "Bread" with 8 quantity
  And a customer buy "Jam" with 10 quantity
  And a customer buy "Orange Juice" with 11 quantity
  Then "Bread" should have 5 left
  Then "Jam" should have 7 left
  Then "Orange Juice" should have 8 left