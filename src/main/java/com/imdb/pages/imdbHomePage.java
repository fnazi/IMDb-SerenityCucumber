package com.imdb.pages;

import com.imdb.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class imdbHomePage extends BasePage {

    @FindBy(xpath = "//*[@id='imdbHeader-navDrawerOpen']")
    WebElementFacade menuButton;

    @FindBy(xpath = "//span[@class='ipc-list-item__text' and text()='Top 250 Movies' and @role='presentation']")
    WebElementFacade top250MoviesLink;

    public void clickMenuButton() {
        menuButton.click();
    }

    public void selectTop250Movies() {
        top250MoviesLink.click();
    }

    @FindBy(xpath = "//*[@id=\"imdbHeader\"]/div[2]/div[5]/a/span")
    WebElementFacade signInButton;

    public void clickSignInButton() {
        waitForCondition().until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
    }

    public boolean isDisplayed() {
        return signInButton.isDisplayed();
    }

}
