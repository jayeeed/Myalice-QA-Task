Feature: Manga App functionality testing
  As a user,
  I want to search for manga and view details,
  So that I can easily find and read manga online.

  Background:
    Given the user opens the application
    Then the login page is displayed
    When the user enters valid login credentials
    And clicks the "Login" button
    Then the user is redirected to the manga search page

    Scenario Template: Verify Manga Search and Display
      When the user enters "<search_term>" into the search box
      And clicks the "Search" button on the manga search page
      Then manga card with the name "<search_term>" is displayed or "No manga found" message is shown

      Examples:
        | search_term         |
        | Naruto              |
        | One Piece           |
        | Seven Deadly Sins   |
        | Berserk             |

    Scenario: Verify Manga Details Modal
      When the user clicks the "Details" link on a manga card
      Then the modal appears and displays the correct manga information
      When the user clicks the "Close" button on the modal
      Then the modal is closed and no longer visible
