package com.imdb.pages;

import com.imdb.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class memberPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"imdbHeader\"]/div[2]/div[5]/div/label[2]")
    WebElementFacade userNameButton;

    @FindBy(xpath = "//*[@id=\"navUserMenu-contents\"]/ul/a[6]/span")
    WebElementFacade signoutButton;

    public void clickUserNameButton() {
        waitForCondition().until(ExpectedConditions.elementToBeClickable(userNameButton));
        userNameButton.click();
    }

    public void clickLogoutButton() {
        signoutButton.click();
    }

    public boolean isDisplayed() {
        return userNameButton.isDisplayed();
    }

}
