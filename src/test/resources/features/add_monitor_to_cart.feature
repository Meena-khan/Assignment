Feature: Add a differnt products to Cart and verify sub total

Scenario: Adding a "Monitor" Item in Cart and verifying sub total
    Given I open Amazon website for the first
    When I search for "Monitor" first
    And I select the first item in the list first
    And I add the item to the cart first
    And I open the cart first
    Then the product price should match the cart price first
    And the sub total should match the product price first
    
 Scenario: Adding a Laptop Item in Cart and verifying sub total
    Given I open Amazon website second
    When I search for "Laptop" second
    And I select the second item in the list second
    And I add the item to the cart second
    And I open the cart second
    Then the product price should match the cart price second
    And the sub total should match the product price second
    
 Scenario: Adding two items in Cart and verifying sub total
    Given I open Amazon website third
    When I search for "Headphones" third
    And I select the first item in the list third
    And I add the first item to the cart third
    And I search again for "Keyboard" third
    And I select the first item in the list third
    And I add the second item to the cart third
    And I open the cart third
    Then each item price should match the product page price third
    And the sub total should be the sum of both item prices third

 