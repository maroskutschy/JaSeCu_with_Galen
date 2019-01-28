package GlueCode;

import com.galenframework.testng.GalenTestNgTestBase;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static java.util.Arrays.asList;

//public class Galen extends GalenTestNgTestBase {
//
//  public WebDriver createDriver(Object[] args) {
//    return GeneralStepDefinitions.getDriver();
//  }
//
//  public void checkGalenLayout(String specFileName) throws IOException {
//    Object[] objects = new Object[2];
//    createDriver(objects );
//    checkLayout(specFileName, asList( "pc" ));
//  }
//
//}

public class GalenOld {

  @DataProvider(name = "devices")
  public Object [][] devices () {
    return new Object[][] {
        //                {new TestDevice("mobile", new Dimension(450, 800), asList("mobile"))},
        //                {new TestDevice("tablet", new Dimension(750, 800), asList("tablet"))},
        {new TestDevice( "desktop", new Dimension( 1024, 800), asList( "desktop"))}
    };
  }

  public static class TestDevice {
    private final String name;
    private final Dimension screenSize;
    private final List<String> tags;

    public TestDevice(String name, Dimension screenSize, List<String> tags) {
      this.name = name;
      this.screenSize = screenSize;
      this.tags = tags;
    }

    public String getName() {
      return name;
    }

    public Dimension getScreenSize() {
      return screenSize;
    }

    public List<String> getTags() {
      return tags;
    }

    @Override
    public String toString() {
      return String.format("%s %dx%d", name, screenSize.width, screenSize.height);
    }
  }


//  public void checkGalenLayout(String specFileName) throws IOException {
//    checkLayout(specFileName, asList( "pc" ));
//  }
    @Test(dataProvider = "devices")
    public void checkGalenLayout(String specFileName) throws IOException {
      //checkLayout(specFileName, asList( "desktop" ) );
    }

}
