# IMDb-SerenityCucumber
This project uses Serenity BDD with Cucumber and Java to test the IMDb website.

There are two features in this project:
1. Check if Shawshank Redemption is in the Top 250 movies list.
2. Create new user account and login to IMDb website. 

Limitations:
Creating new user account takes user to captcha page.Unable to proceed automation due to that.
Also logging in with existing user account *sometimes* gives CAPTCHA page. Those cases are handled by runtime exception.