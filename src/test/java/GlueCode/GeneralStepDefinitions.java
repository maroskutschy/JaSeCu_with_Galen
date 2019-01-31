package GlueCode;

import TestRunners.TestDefaultValues;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import gherkin.formatter.model.Step;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.Galen;

import static com.galenframework.api.Galen.checkLayout;

//public class GeneralStepDefinitions extends GalenTestNgTestBase{
  public class GeneralStepDefinitions {

  public static WebDriver driver;
  private String browser = TestDefaultValues.getBrowser();
  public String link = TestDefaultValues.getLink();



  private static String scenarioName;


  @Before
  public void openBrowser(Scenario scenario) {
    scenarioName = scenario.getName().replaceAll( " ", "_" );
    if (!scenario.getName().contains("Galen")) {
      switch( browser ) {
        case "Chrome" :
          System.setProperty( "webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe" );
          driver = new ChromeDriver( );
          //Set the browser size for desktop
          driver.manage().window().setSize(new Dimension( 1200, 800));
          break;
        case "Firefox" :
          System.setProperty( "webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe" );
          driver = new FirefoxDriver( );
      }
      driver.get( link );
    }
  }

  //@Override
  @Given("^I open browser for Galen Framework \"([^\"]*)\"$")
  public WebDriver createDriver(Object[] args) {
    switch( browser ) {
      case "Chrome" :
        System.setProperty( "webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe" );
        driver = new ChromeDriver( );
        break;
      case "Firefox" :
        System.setProperty( "webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe" );
        driver = new FirefoxDriver( );
    }
    //driver.get( link );
    //load(link, 1024, 768);
    return driver;
  }

  //@Test
  @And("^I validate page using Galen Framework \"([^\"]*)\" file$")
  public void validatePageUsingGalenSpecFile(String fileName) throws Throwable {
    //Galen galen = new Galen();
    //galen.checkGalenLayout(fileName);
    //load("http://example.com", 1024, 768);
    //////////////////checkLayout(driver, fileName, asList("mobile"));
    //Create a layoutReport object

    Galen galen = new Galen();
    galen.validatePageUsingGalenSpecFile(fileName  );

//    //checkLayout function checks the layout and returns a LayoutReport object
//    LayoutReport layoutReport = checkLayout( driver, fileName, Arrays.asList( "desktop"));
//
//    //Create a tests list
//    List<GalenTestInfo> tests = new LinkedList<GalenTestInfo>();
//
//    //Create a GalenTestInfo object
//    GalenTestInfo test = GalenTestInfo.fromString(scenarioName + " layout");
//
//    //Get layoutReport and assign to test object
//    test.getReport().layout(layoutReport, "check " + scenarioName +  " layout");
//
//    //Add test object to the tests list
//    tests.add(test);
//
//    //Create a htmlReportBuilder object
//    HtmlReportBuilder htmlReportBuilder = new HtmlReportBuilder();
//
//    //Create a report under /target folder based on tests list
//    htmlReportBuilder.build(tests, "target//" + scenarioName + "//galen_report");
//
//    //If layoutReport has errors Assert Fail
//    if (layoutReport.errors() > 0)
//    {
//      Assert.fail( "Galen Layout test of scenario: " + scenarioName + " failed, see report here: " + "file:///" + System.getProperty("user.dir") + "\\target\\" + scenarioName + "\\galen_report\\report.html");
//      //Assert.fail( "Galen Layout test of scenario: " + scenarioName + " failed, see report here: " + "<a href=\"file:///" + System.getProperty("user.dir") + "\\target\\" + scenarioName + "\\galen_report\\report.html\">Galen report</a>");
//
//    }

  }

  @After
  public void closeBrowser() {
    driver.quit();
  }

  public static WebDriver getDriver() {
    return  driver;
  }

  public static String getScenarioName() {
    return scenarioName;
  }

}
