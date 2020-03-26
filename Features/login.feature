Feature: Login

  Scenario: Successful login with valid credentials
    Given the user navigates to login page "https://admin-demo.nopcommerce.com/login"
    When the user enters username as "admin@yourstore.com" and password as "admin"
    And the user click on login button
    Then the page title should be "Dashboard / nopCommerce administration"
    When the user clicks on log out link
    Then the page title should be "Your store. Login"

  Scenario Outline: Login data driven
    Given the user navigates to login page "https://admin-demo.nopcommerce.com/login"
    When the user enters username as "admin@yourstore.com" and password as "admin"
    And the user click on login button
    Then the page title should be "Dashboard / nopCommerce administration"
    When the user clicks on log out link
    Then the page title should be "Your store. Login"
    Examples:
      | email                | password |
      | admin@yourstore.com  | admin    |
      | admin1@yourstore.com | admin123 |