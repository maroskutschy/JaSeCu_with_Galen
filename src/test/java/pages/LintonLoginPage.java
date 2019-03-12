package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LintonLoginPage extends BasicActions {

  @FindBy (xpath = "//input[@data-automation-id='loginUsername']")
  private WebElement username;

  @FindBy (xpath = "//input[@data-automation-id='loginPassword']")
  private WebElement password;

  @FindBy (xpath = "//span[@data-automation-id='loginButton']")
  private WebElement signInButton;

  public LintonLoginPage(WebDriver driver) {
    super( driver );
  }

  public LintonWellcomePage login (String username, String password) {
    clear(this.username, "email"  );
    sendKeys(this.username, username, "email"  );
    clear( this.password, "password" );
    sendKeys( this.password, password, "password" );
    click( signInButton, "loginButton" );
    return new LintonWellcomePage( getDriver() );
  }

  public void populateEmailAndPassword (String email, String password) {
    clear(this.username, "email"  );
    sendKeys(this.username, email, "email"  );
    clear( this.password, "password" );
    sendKeys( this.password, password, "password" );
  }

  public LintonWellcomePage clickOnSignInButton () {
    click( signInButton, "loginButton" );
    return new LintonWellcomePage(getDriver());
  }

}
