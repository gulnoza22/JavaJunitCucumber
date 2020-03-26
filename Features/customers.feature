Feature: Customers

  Scenario: Add new customer
    Given User launch Chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters email as "admin@yourstore.com" and password as "admin"
    And Click on login
    Then User can view Dashboard
    When User clicks on customers menu
    And Click on customers menu item
    And Click on add new button
    Then User can view add new customer page
    When User enter customer info
    And Click on save button
    Then User can view confirmation message "The new customer has been added successfully."
    And Close browser