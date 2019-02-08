package Pikap;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class verifyTrip {
    AndroidDriver driver;

    ExtentReports extent = new ExtentReports("Extent-Report/report.html", true, NetworkMode.OFFLINE);
    ExtentTest test = extent.startTest("Login test", "Enter name");

    @Before
    public void Setup() throws MalformedURLException {


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi");
        capabilities.setCapability("appPackage", "com.pikapuser");
        capabilities.setCapability("appActivity", "com.pikapuser.SplashScreenActivity");

        //driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        TouchAction action = new TouchAction(driver);
        action.press(0, 300).waitAction().moveTo(0, 100).release().perform();
        driver.findElementById("com.pikapuser:id/loginText").click();
        driver.findElementById("com.pikapuser:id/phoneNumber").sendKeys("8600896491");
        driver.findElementById("com.pikapuser:id/passwordLogin").sendKeys("password");
        driver.navigate().back();
        driver.findElementById("com.pikapuser:id/sendOtp").click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElementById("com.pikapuser:id/otpEdit").sendKeys("4444");
        driver.navigate().back();
        try {
            Thread.sleep(1000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElementById("com.pikapuser:id/verifyOtp").click();
    }
  @Test
  public void verifyTrip(AndroidDriver driver)
  {


      verifyFindYourPikap verify=new verifyFindYourPikap();
      verify.verifyFindYourPikapFunctionality(driver);
      WebDriverWait wait = new WebDriverWait( driver, 1000);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[contains(@text,'Deccan Gymkhana, Pune, Maharas...')]")));
      try {
          Thread.sleep(1000 );
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
      driver.findElementById("com.pikapuser:id/dropOffLocation").click();
      WebDriverWait wait1 = new WebDriverWait( driver, 1000);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[contains(@text,'Shivajinagar, Pune, Maharashtr...')]")));
      driver.findElementById("com.pikapuser:id/hint").sendKeys("test");
      driver.navigate().back();
      try {
          Thread.sleep(5000 );
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
      driver.findElementById("com.pikapuser:id/confirmPikapLayout").click();
      try {
          Thread.sleep(5000 );
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
      driver.findElementById("com.pikapuser:id/doneButton").click();
      try {
          Thread.sleep(10000 );
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
     String text=driver.findElementById("com.pikapuser:id/firstMessage").getText();
      try {
          Assert.assertEquals(text, "Ten en cuenta: PIKAP no se hace responsable \n" +
                  "por daños y perjuicios durante el servicio");
          test.log(LogStatus.PASS, "Successfully created a ride .");

  } catch (AssertionError ex) {
        test.log(LogStatus.FAIL, "Test is fail");
    }
        extent.endTest(test);
        extent.flush();


}
}
