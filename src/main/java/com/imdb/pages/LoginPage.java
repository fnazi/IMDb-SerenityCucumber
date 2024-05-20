package com.imdb.pages;
import com.imdb.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//*[@id=\"ap_email\"]")
    WebElementFacade inputExistingEmail;

    @FindBy(xpath = "//*[@id=\"ap_password\"]")
    WebElementFacade inputExistingPassword;

    @FindBy(xpath = " //*[@id=\"signInSubmit\"]")
    WebElementFacade signInButton;

    public void fillSignInForm( String email, String password) {
        inputExistingEmail.type(email);
        inputExistingPassword.type(password);
    }

    public void submitSignIn() {
        signInButton.click();
    }

    public boolean isDisplayed() {
        return signInButton.isDisplayed();
    }
}
