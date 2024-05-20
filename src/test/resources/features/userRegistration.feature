Feature: user Registration

  Scenario: Navigate to Account Registration Page and Complete Registration

  Given I am a new user on the IMDb homepage
  When I click the “Sign In” link and then click the “Create a New Account” link
  Then I should be directed to the account registration page
  When I am on the account registration page
  And I fill in the registration form with all required details
  Then I should be able to complete the registration process and land on the authorized member page

  Scenario: Prevent Registration with Existing Email

  Given I am on the account registration page to register
  When I attempt to register with an email address that is already in use
  Then I should see an error message displayed and not be allowed to complete the registration

  Scenario: Logout and Login Functionality

  Given I am logged into the member page
  When I log out from the application
  Then I should be redirected to the login page and not be able to access the member page
  When I am on the login page
  And I fill in my email and password correctly
  Then I should be able to login and access the member page again
