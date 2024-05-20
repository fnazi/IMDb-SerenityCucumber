package com.imdb.pages;
import com.imdb.base.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Top250MoviesPage extends BasePage {


    @FindBy(xpath = "//button[@data-testid='filter-menu-button']")
    WebElementFacade filterButton;

    @FindBy(xpath = "//input[@data-testid='filter-user-rating-start']")
    WebElementFacade userRatingStart;

    @FindBy(xpath = "//button[@title='Close Prompt']")
    WebElementFacade closeFilter;


    String movieListLocator = "xpath=//ul[contains(@class, 'ipc-metadata-list')]//li";
    String movieTitleLocator = ".//h3[@class='ipc-title__text']//ancestor::li/div[2]/div[1]/div/div/a/h3";
 //   String movieRatingLocator = ".//span[@data-testid='ratingGroup--imdb-rating']";

    public void clickFilterButton() {
        filterButton.click();
    }

    public void sendUserRatingFilter() {
        userRatingStart.sendKeys(String.valueOf(9));
    }

    public void closeFilterButton() {
        closeFilter.click();
    }


    public List<String> getMovieTitles() {
        List<WebElementFacade> movieRows = getElements(movieListLocator);
        List<String> movieTitles = new ArrayList<>();

        System.out.println("Number of movie rows found: " + movieRows.size());

        for (WebElementFacade row : movieRows) {
            try {
                waitFor(row).withTimeoutOf(10, TimeUnit.SECONDS).isVisible();
                String movieTitle = row.find(By.xpath(movieTitleLocator)).getText();
                // Remove numeric prefix and any leading/trailing whitespace
                movieTitle = movieTitle.replaceFirst("^\\d+\\.\\s*", "").trim();
                System.out.println("Movie title found: " + movieTitle);
                movieTitles.add(movieTitle);
            } catch (Exception e) {
                System.out.println("Error while parsing movie row: " + e.getMessage());
            }
        }
        System.out.println("High Rated Movies: " + movieTitles);
        return movieTitles;
    }
}
