# Manga App Functionality Testing

## Screen Recording

https://github.com/user-attachments/assets/25ec43c3-0c67-4b24-a56b-087035dccd7d

## Tools used: 
* Selenium
* TestNG
* Cucumber
* Ghrekin
* Allure
* Jenkins
  
This project contains automated tests for the Manga App functionality, focusing on the search and manga details features.

## Purpose

The goal of these tests is to ensure that the manga search feature works correctly and that the manga details modal displays accurate information. By automating these tests, we aim to improve reliability and efficiency in the testing process.

## Feature Description

### Feature: Manga App functionality testing
As a user,  
I want to search for manga and view details,  
So that I can easily find and read manga online.

## Scenarios Covered

### 1. Background
The background steps ensure that the user is properly logged in and redirected to the manga search page.

**Steps:**
- Open the application.
- Verify the login page is displayed.
- Enter valid login credentials.
- Click the "Login" button.
- Verify the user is redirected to the manga search page.

### 2. Scenario Template: Verify Manga Search and Display

This scenario template validates the search functionality by checking if the correct manga card is displayed or a "No manga found" message appears based on different search terms.

**Steps:**
- Enter `<search_term>` into the search box.
- Click the "Search" button.
- Verify that either a manga card with the name `<search_term>` is displayed, or a "No manga found" message is shown.

**Examples:**
- Naruto
- One Piece
- Seven Deadly Sins
- Berserk

### 3. Scenario: Verify Manga Details Modal

This scenario ensures that clicking the "Details" link on a manga card opens the modal with the correct information and allows the user to close the modal.

**Steps:**
- Click the "Details" link on a manga card.
- Verify the modal appears and displays the correct manga information.
- Click the "Close" button on the modal.
- Verify the modal is closed and no longer visible.

## Setup and Execution

1. **Environment Setup**: Ensure that all dependencies are installed, including *Selenium*, *TestNG*, *Cucumber*, *Ghrekin*, *Aquality Framework*, and *Allure* for reporting.
2. **Running Tests**: Use your test execution framework using *Maven* or directly from dedicated *Feature* file to run the Cucumber tests.
3. **Reporting**: After executing the tests, generate an *Allure report* to review the test results and search term outcomes.

### Contact Information
*For any questions or issues related to this project, feel free to contact:*

- ***Name:*** Jayed Bin Jahangir
- **Email:** jayedbinjahangir@gmail.com
- **Phone:** +8801756260844
- **LinkedIn:** https://www.linkedin.com/in/jayeed/
- **GitHub:** https://github.com/jayeeed/
  

