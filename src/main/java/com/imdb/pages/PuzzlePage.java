package com.imdb.pages;

import com.imdb.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class PuzzlePage extends BasePage {

    @FindBy(xpath = "//*[@id=\"a-page\"]/div/div/div")
    WebElementFacade solvePuzzleDialog;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/button")
    WebElementFacade solvePuzzleButton;


    public void clickSolvePuzzleButton() {
        solvePuzzleButton.click();
    }

    public boolean isDisplayed() {
        try {
            waitForCondition().withTimeout(Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(solvePuzzleDialog));
            return solvePuzzleDialog.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

}
