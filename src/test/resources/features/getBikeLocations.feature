Feature: Get City Bikes Locations
  Scenario: Get the  Location of the City Bikes across Globe
    Given I want to get the city bikes location
    When  I send request with "/networks"
    Then I get the successful response 200


  Scenario: Get the Bike Locations of the City Bike for the City Frankfurt
    Given I want to get the city bikes location
    When  I send request with "/networks/visa-frankfurt"
    Then I get the successful response 200


  Scenario: Get the Bike Longitude and Latitude for the City Frankfurt in Germany
    Given I want to get the city bikes location
    When  I send request with "/networks/visa-frankfurt" with queryParam "fields" as "\"id\",\"location\",\"city\""
    Then I get the successful response 200
    And I am looking for the "frankfurt"


