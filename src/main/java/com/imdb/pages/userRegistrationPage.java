package com.imdb.pages;

import com.imdb.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class userRegistrationPage extends BasePage {


    @FindBy(xpath = "//*[@id=\"signin-options\"]/div/div[2]/a")
    WebElementFacade createAccountButton;

    @FindBy(xpath = "//*[@id=\"ap_customer_name\"]")
    WebElementFacade inputName;

    @FindBy(xpath = "//*[@id=\"ap_email\"]")
    WebElementFacade inputEmail;

    @FindBy(xpath = "//*[@id=\"ap_password\"]")
    WebElementFacade inputPassword;

    @FindBy(xpath = "//*[@id=\"ap_password_check\"]")
    WebElementFacade inputRePassword;

    @FindBy(xpath = "//*[@id=\"continue\"]")
    WebElementFacade createAccountSubmitButton;

    @FindBy(xpath = "//*[@class='a-list-item']")
    WebElementFacade emailError;

    @FindBy(xpath = "//*[@id=\"ap_register_form\"]/div/div/div[6]/a")
    WebElementFacade existingAccountSignInButton;


    public void clickCreateAccountButton() {
        createAccountButton.click();
    }

    public void fillRegistrationForm(String name, String email, String password) {
        inputName.type(name);
        inputEmail.type(email);
        inputPassword.type(password);
        inputRePassword.type(password);
    }

    public void submitRegistration() {
        waitForCondition().until(ExpectedConditions.elementToBeClickable(createAccountSubmitButton));
        createAccountSubmitButton.click();

    }

    public String getEmailErrorMessage() {
        return emailError.getText();
    }

    public void clickExistingAccountSignInButton() {
        try {
            waitForCondition().withTimeout(Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(existingAccountSignInButton));
            existingAccountSignInButton.click();
            System.out.println("Existing account sign in button clicked successfully.");
        } catch (Exception e) {
            System.out.println("Failed to click the existing account sign in button: " + e.getMessage());
            throw e;
        }
    }

    public boolean isDisplayed() {
        waitForCondition().until(ExpectedConditions.elementToBeClickable(createAccountSubmitButton));
        return createAccountSubmitButton.isDisplayed();
    }

}
