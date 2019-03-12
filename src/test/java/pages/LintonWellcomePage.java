package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LintonWellcomePage extends BasicActions {

  @FindBy (xpath = "//span[@data-automation-id='header-viewTitle']")
  private WebElement dashboard;

  public LintonWellcomePage(WebDriver driver) {
    super( driver );
  }

  public void validateWellcomePage () {
    checkElementPresent( dashboard, "dashboard" );
  }




}
