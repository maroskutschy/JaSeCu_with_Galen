package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookWellcomePage extends BasicActions {

  @FindBy (xpath = "//a[@data-testid='left_nav_item_News Feed']")
  private WebElement newsFeed;

  public FacebookWellcomePage(WebDriver driver) {
    super( driver );
  }

  public void validateWellcomePage () {
    checkElementPresent( newsFeed, "newsFeed" );
  }




}
