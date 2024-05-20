package com.imdb.cucmbersteps;
import com.imdb.steps.Top250MoviesSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;
import java.util.List;

public class imdbTob250Steps {

    @Steps
    Top250MoviesSteps top250MoviesSteps;


    @Given("^the user is on the IMDb homepage$")
    public void theUserIsOnTheIMDbHomepage() {
        top250MoviesSteps.navigate();
    }

    @When("^the user clicks on the 'Menu' to view the Menu panel$")
    public void the_user_clicks_on_the_Menu_to_view_the_Menu_panel() {
        top250MoviesSteps.clickMenuButton();
    }

    @And("^the user selects the 'Top (\\d+) Movies' sub-link$")
    public void the_user_selects_the_Top_Movies_sub_link(int arg1) {
        top250MoviesSteps.selectTop250Movies();

    }

    @Then("^the user collects all movies with a (\\d+)\\+ rating into an ArrayList$")
    public void the_user_collects_all_movies_with_a_rating_into_an_ArrayList(int arg1) {
        top250MoviesSteps.clickFilterButton();
        top250MoviesSteps.sendUserRatingFilter();
        top250MoviesSteps.closeFilterButton();
        top250MoviesSteps.getMovieTitles();

    }


    @When("^the user writes an assertion to validate the number of movies in the ArrayList$")
    public void the_user_writes_an_assertion_to_validate_the_number_of_movies_in_the_ArrayList() {
        List<String> movieTitles = top250MoviesSteps.getMovieTitlesList();
        System.out.println("Movie Titles: " + movieTitles);

        // Assert that the number of movies with 9+ rating is 7
        Assert.assertEquals("Number of movies with 9+ rating should be 7", 7, movieTitles.size());

    }

    @Then("the user validates that the movie {string} is listed")
    public void the_user_validates_that_the_movie_is_listed(String string) {
        List<String> movieTitles = top250MoviesSteps.getMovieTitlesList();
        // Assert that 'The Shawshank Redemption' is in the list
        Assert.assertTrue("Movie 'The Shawshank Redemption' should be listed in the ArrayList", movieTitles.contains("The Shawshank Redemption"));
    }

}
