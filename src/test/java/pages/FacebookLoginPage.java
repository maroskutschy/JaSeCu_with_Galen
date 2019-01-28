package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookLoginPage extends BasicActions {

  @FindBy (id = "email")
  private WebElement email;

  @FindBy (id = "pass")
  private WebElement password;

  @FindBy (xpath = "//input[@data-testid='royal_login_button']")
  private WebElement loginButton;

  public FacebookLoginPage(WebDriver driver) {
    super( driver );
  }

  public FacebookWellcomePage login (String email, String password) {
    clear(this.email, "email"  );
    sendKeys(this.email, email, "email"  );
    clear( this.password, "password" );
    sendKeys( this.password, password, "password" );
    click( loginButton, "loginButton" );
    return new FacebookWellcomePage( getDriver() );
  }

  public FacebookIncorrectLoginPage unsuccessfullLogin (String email, String password) {
    clear(this.email, "email"  );
    sendKeys(this.email, email, "email"  );
    clear( this.password, "password" );
    sendKeys( this.password, password, "password" );
    click( loginButton, "loginButton" );
    return new FacebookIncorrectLoginPage( getDriver() );
  }


}
