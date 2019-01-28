package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookIncorrectLoginPage extends BasicActions {

  @FindBy (xpath = "//div[@class='uiContextualLayer uiContextualLayerRight']//div//div")
  private WebElement incorrectLoginMessage;

  public FacebookIncorrectLoginPage(WebDriver driver) {
    super( driver );
  }

  public void checkIncorrectMessage (String message) {
    checkElementPresent(incorrectLoginMessage,"incorrectLoginMessage"  );
    String actualMessage = incorrectLoginMessage.getText();
    LOGGER.info( "Checking actual message: '" + actualMessage + "', expected message is : '" + message + "'." );
    Assert.assertTrue("Actual message: '" + actualMessage + "' is not same as expected message :'" + message + "'.", actualMessage.contentEquals( message )  );

  }




}
