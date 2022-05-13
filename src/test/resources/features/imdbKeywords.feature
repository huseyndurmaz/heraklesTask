@wip
Feature: IMDB keywords on Bruce Willis page

  Background:
    Given the user searches "Bruce Willis" on Google

  Scenario: the keywords are not sorted by name in IMDB webpage
    Given the user clicks on result from "IMDB" webpage
    And the user clicks on the drop down element in the "Filmography" section
    And the user selects "Genre" from the drop down element
    And the user clicks on the "Keywords" tab from refine section
    Then the keywords are not sorted by name

  Scenario: "Incredible" does not exist in keyword list on Bruce Willis page
    Given the user clicks on result from "IMDB" webpage
    And the user clicks on the drop down element in the "Filmography" section
    And the user selects "Genre" from the drop down element
    And the user clicks on the "Keywords" tab from refine section
    Then "Incredible" is not a word in the keyword list
