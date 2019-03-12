package GlueCode;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.*;

public class LintonStepDefinitions {


  private WebDriver driver = (new GeneralStepDefinitions()).getDriver();
  private LintonLoginPage lintonLoginPage;
  private LintonWellcomePage lintonWellcomePage;


  @Then("^Linton Welcome Page is successfully displayed$")
  public void linton_Welcome_Page_is_successfully_displayed() throws Throwable {
    lintonWellcomePage.validateWellcomePage();
  }

  @When("^I populate values: username \"([^\"]*)\" , password \"([^\"]*)\"$")
  public void populateUsernameAndPassword(String username, String password) throws Throwable {
    lintonLoginPage = new LintonLoginPage(driver  );
    lintonLoginPage.populateEmailAndPassword(username, password  );
  }

  @When("^I click on signIn Button$")
  public void clickOnSignInButton() throws Throwable {
    lintonWellcomePage = lintonLoginPage.clickOnSignInButton();
  }

}
