package GlueCode;

import TestRunners.TestDefaultValues;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import pages.FacebookIncorrectLoginPage;
import pages.FacebookLoginPage;
import pages.FacebookWellcomePage;

public class FacebookStepDefinitions {


  private WebDriver driver = (new GeneralStepDefinitions()).getDriver();
  private FacebookLoginPage facebookLoginPage;
  private FacebookWellcomePage facebookWellcomePage;
  private String email = TestDefaultValues.getUser();
  private String password = TestDefaultValues.getPassword();
  private FacebookIncorrectLoginPage facebookIncorrectLoginPage;


  @And("^I successfully login to facebook with email \"([^\"]*)\" and password \"([^\"]*)\"$")
  public void loginToFacebookWithCredentials(String email, String password) throws Throwable {
    facebookLoginPage = new FacebookLoginPage(driver  );
    facebookWellcomePage = facebookLoginPage.login(email, password  );
  }

  @When("^I successfully login to facebook with default credentials$")
  public void i_successfully_login_to_facebook_with_default_credentials() throws Throwable {
    facebookLoginPage = new FacebookLoginPage(driver  );
    facebookWellcomePage = facebookLoginPage.login(email, password  );
  }

  @Then("^Facebook Welcome Page is successfully displayed$")
  public void facebook_Welcome_Page_is_successfully_displayed() throws Throwable {
    facebookWellcomePage.validateWellcomePage();
  }

  @And("^I unsuccessfully login to facebook with email \"([^\"]*)\" and password \"([^\"]*)\"$")
  public void unsuccessfullLoginToFacebookWithCredentials(String email, String password) throws Throwable {
    facebookLoginPage = new FacebookLoginPage(driver  );
    facebookIncorrectLoginPage = facebookLoginPage.unsuccessfullLogin(email, password  );
  }

  @And("^Because of \"([^\"]*)\" Incorrect Login Page is displayed with following message \"([^\"]*)\"$")
  public void validateIncorrectFacebookLoginMessage(String reason, String message) throws Throwable {
    facebookIncorrectLoginPage.checkIncorrectMessage(message);
  }

  @When("^I populate values: email \"([^\"]*)\" , password \"([^\"]*)\"$")
  public void populateEmailAndPassword(String email, String password) throws Throwable {
    facebookLoginPage = new FacebookLoginPage(driver  );
    facebookLoginPage.populateEmailAndPassword(email, password  );
  }




}
