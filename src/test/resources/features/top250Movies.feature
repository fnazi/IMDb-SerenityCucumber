Feature: Top 250 Movies
  As a user, I should be able to view the Top 250 movies with 9+ Ratings

  Scenario: Navigate to IMDb homepage and validate movies with 9+ rating

  Given the user is on the IMDb homepage
  When the user clicks on the 'Menu' to view the Menu panel
  And the user selects the 'Top 250 Movies' sub-link
  Then the user collects all movies with a 9+ rating into an ArrayList

  When the user writes an assertion to validate the number of movies in the ArrayList
  Then the user validates that the movie "The Shawshank Redemption" is listed