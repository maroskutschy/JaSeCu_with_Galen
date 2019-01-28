package pages;

import GlueCode.GeneralStepDefinitions;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static com.galenframework.api.Galen.checkLayout;

public class Galen {

  WebDriver driver = GeneralStepDefinitions.getDriver();
  String scenarioName = GeneralStepDefinitions.getScenarioName();

  public void validatePageUsingGalenSpecFile(String fileName) throws Throwable {
    //Galen galen = new Galen();
    //galen.checkGalenLayout(fileName);
    //load("http://example.com", 1024, 768);
    //////////////////checkLayout(driver, fileName, asList("mobile"));
    //Create a layoutReport object
    //checkLayout function checks the layout and returns a LayoutReport object
    LayoutReport layoutReport = checkLayout( driver, fileName, Arrays.asList( "desktop"));

    //Create a tests list
    List<GalenTestInfo> tests = new LinkedList<GalenTestInfo>();

    //Create a GalenTestInfo object
    GalenTestInfo test = GalenTestInfo.fromString(scenarioName + " layout");

    //Get layoutReport and assign to test object
    test.getReport().layout(layoutReport, "check " + scenarioName +  " layout");

    //Add test object to the tests list
    tests.add(test);

    //Create a htmlReportBuilder object
    HtmlReportBuilder htmlReportBuilder = new HtmlReportBuilder();

    //Create a report under /target folder based on tests list
    htmlReportBuilder.build(tests, "target//" + scenarioName + "//galen_report");

    //If layoutReport has errors Assert Fail
    if (layoutReport.errors() > 0)
    {
      Assert.fail( "Galen Layout test of scenario: " + scenarioName + " failed, see report here: " + "file:///" + System.getProperty( "user.dir") + "\\target\\" + scenarioName + "\\galen_report\\report.html");
      //Assert.fail( "Galen Layout test of scenario: " + scenarioName + " failed, see report here: " + "<a href=\"file:///" + System.getProperty("user.dir") + "\\target\\" + scenarioName + "\\galen_report\\report.html\">Galen report</a>");

    }

  }

}
