package com.imdb.steps;

import com.imdb.pages.Top250MoviesPage;
import com.imdb.pages.imdbHomePage;
import net.serenitybdd.annotations.Step;


import java.util.List;

public class Top250MoviesSteps {
    imdbHomePage home;
    Top250MoviesPage top250Movies;


    private List<String> movieTitles;

    @Step
    public void navigate(){
        home.open();
    }

    @Step
    public void clickMenuButton(){
        home.clickMenuButton();
    }

    @Step
    public void selectTop250Movies(){
        home.selectTop250Movies();
    }

    @Step
    public void clickFilterButton(){
        top250Movies.clickFilterButton();
    }

    @Step
    public void sendUserRatingFilter(){
        top250Movies.sendUserRatingFilter();
    }

    @Step
    public void closeFilterButton(){
        top250Movies.closeFilterButton();
    }

    @Step
    public void getMovieTitles(){
        movieTitles = top250Movies.getMovieTitles();
    }
    public List<String> getMovieTitlesList() {
        return movieTitles;
    }

}
