package stepDefinations;

import org.openqa.selenium.WebDriver;
import Pages.HomePage;
import Pages.LoginPage;
import base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    WebDriver driver;
    HomePage homepage;
    LoginPage loginpage;

    @Given("user launches the browser")
    public void user_launches_the_browser() {
        BaseTest.setUp();
        driver = BaseTest.driver;
    }

    @When("user is on home page")
    public void user_is_on_home_page() {
        homepage = new HomePage(driver);
    }

    @When("user clicks on login link")
    public void user_clicks_on_login_link() {
        homepage.clickLoginLink();
    }

    @When("user enters email {string} and password {string}")
    public void user_enters_email_and_password(String email, String password) {
        loginpage = new LoginPage(driver);
        loginpage.enterUserName(email);
        loginpage.enterPassword(password);
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        loginpage.clickloginButton();
    }

    @Then("user should land on account page")
    public void user_should_land_on_account_page() {
        String title = driver.getTitle();
        if (title.equals("Automation Exercise")) {
            System.out.println("✅ Login Successful - on Account Page");
        } else {
            System.out.println("❌ Unexpected page title: " + title);
        }
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        boolean isErrorShown = driver.getPageSource().contains("Your email or password is incorrect!");
        if (isErrorShown) {
            System.out.println("❌ Error message displayed for invalid login");
        } else {
            System.out.println("✅ Login might be successful");
        }
    }
}
