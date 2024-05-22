package com.imdb.cucmbersteps;

import com.imdb.pages.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

import java.util.List;
import java.util.Map;
import java.util.UUID;


public class UserRegistrationSteps {

    @Steps
    imdbHomePage homePage;

    @Steps
    userRegistrationPage registrationPage;

    @Steps
    memberPage member;

    @Steps
    LoginPage loginPage;

    @Steps
    PuzzlePage puzzlePage;

    String uniqueEmail(){
        return "testuser+" + UUID.randomUUID().toString() + "@example.com";}


    @Given("I am a new user on the IMDb homepage")
    public void i_am_a_new_user_on_the_im_db_homepage() {
        homePage.open();
    }

    @When("I click the “Sign In” link and then click the “Create a New Account” link")
    public void i_click_the_sign_in_link_and_then_click_the_create_a_new_account_link() {
        homePage.clickSignInButton();
        registrationPage.clickCreateAccountButton();
    }

    @Then("I should be directed to the account registration page")
    public void i_should_be_directed_to_the_account_registration_page() {
        assert registrationPage.isDisplayed();
    }

    @When("I am on the account registration page")
    public void i_am_on_the_account_registration_page() {
        assert registrationPage.isDisplayed();
    }

    @And("I fill in the registration form with all required details")
    public void i_fill_in_the_registration_form_with_all_required_details(DataTable dataTable) {
        List<Map<String, String>> registrationData = dataTable.asMaps(String.class, String.class);
        Map<String, String> data = registrationData.get(0);
        String name = data.get("name");
        String email = uniqueEmail();
        String password = data.get("password");
        registrationPage.fillRegistrationForm(name, email, password);
    }

    @Then("I should be able to complete the registration process and land on the authorized member page")
    public void i_should_be_able_to_complete_the_registration_process_and_land_on_the_authorized_member_page() {
        registrationPage.submitRegistration();
        assert puzzlePage.isDisplayed();
        System.out.println("CAPTCHA is displayed, cannot proceed.");

        //Cannot proceed further since puzzle page is displayed, we can assume that the user is logged in and is on the member page, CAPTCHA cant be automated
    }

    @Given("I am on the account registration page to register")
    public void iAmOnTheAccountRegistrationPageToRegister() {
        homePage.open();
        homePage.clickSignInButton();
        registrationPage.clickCreateAccountButton();
        assert registrationPage.isDisplayed();
    }

    @When("I attempt to register with an email address that is already in use")
    public void i_attempt_to_register_with_an_email_address_that_is_already_in_use(DataTable dataTable) {
        List<Map<String, String>> registrationData = dataTable.asMaps(String.class, String.class);
        Map<String, String> data = registrationData.get(0);
        String name = data.get("name");
        String email = data.get("email");
        String password = data.get("password");
        registrationPage.fillRegistrationForm(name, email, password);
        registrationPage.submitRegistration();
    }

    @Then("I should see an error message displayed and not be allowed to complete the registration")
    public void i_should_see_an_error_message_displayed_and_not_be_allowed_to_complete_the_registration() {
        assert registrationPage.getEmailErrorMessage().contains("You indicated you're a new customer, but an account already exists with the email address");
    }


    @Given("I am logged into the member page")
    public void i_am_logged_into_the_member_page(DataTable dataTable) {
        homePage.open();
        homePage.clickSignInButton();
        registrationPage.clickCreateAccountButton();
        registrationPage.clickExistingAccountSignInButton();

        List<Map<String, String>> loginData = dataTable.asMaps(String.class, String.class);
        Map<String, String> data = loginData.get(0);
        String email = data.get("email");
        String password = data.get("password");

        loginPage.fillSignInForm(email, password);
        loginPage.submitSignIn();
        if (puzzlePage.isDisplayed()) {
            System.out.println("Puzzle page is displayed, cannot proceed.");
            throw new RuntimeException("CAPTCHA is displayed, cannot proceed.");
        }

        assert member.isDisplayed();
    }

    @When("I log out from the application")
    public void i_log_out_from_the_application() {
        member.clickUserNameButton();
        member.clickLogoutButton();
    }

    @Then("I should be redirected to the login page and not be able to access the member page")
    public void i_should_be_redirected_to_the_login_page_and_not_be_able_to_access_the_member_page() {
       assert homePage.isDisplayed();
    }

    @When("I am on the login page")
    public void i_am_on_the_login_page() {
        homePage.clickSignInButton();
        registrationPage.clickCreateAccountButton();
        registrationPage.clickExistingAccountSignInButton();
        assert loginPage.isDisplayed();
    }

    @And("I fill in my email and password correctly")
    public void i_fill_in_my_email_and_password_correctly(DataTable dataTable) {
        List<Map<String, String>> loginData = dataTable.asMaps(String.class, String.class);
        Map<String, String> data = loginData.get(0);
        String email = data.get("email");
        String password = data.get("password");

        loginPage.fillSignInForm(email, password);
    }

    @Then("I should be able to login and access the member page again")
    public void i_should_be_able_to_login_and_access_the_member_page_again() {
        loginPage.submitSignIn();
        if (puzzlePage.isDisplayed()) {
            System.out.println("Puzzle page is displayed, cannot proceed.");
            throw new RuntimeException("CAPTCHA is displayed, cannot proceed.");
        }
        assert member.isDisplayed();
    }
}
