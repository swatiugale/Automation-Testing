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

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Menu {
    AndroidDriver driver;

    ExtentReports extent = new ExtentReports("Extent-Report/report.html", true, NetworkMode.OFFLINE);
    ExtentTest test = extent.startTest("Login test", "Enter name");
    Register reg=new Register();

    @Before
    public void Setup() throws MalformedURLException {


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi");
        capabilities.setCapability("appPackage", "com.pikapuser");
        capabilities.setCapability("appActivity", "com.pikapuser.SplashScreenActivity");

        //driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }
   @Test
    public void menuClickability()
   {
       ExtentTest test = extent.startTest("Login test", "Enter name");
       test.log(LogStatus.INFO, "Verify Login functionality");
       try {
           Thread.sleep(7000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }

       reg.RegisterLogin(driver);
       try {
           Thread.sleep(7000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }

       driver.findElement(MobileBy.xpath("//android.widget.ImageView[@content-desc='Atrás']")).click();
       String tst= driver.findElementById("com.pikapuser:id/navFullName").getText();
       try {
           Assert.assertEquals(tst, "SwatiUgale Ugale shelke");
           test.log(LogStatus.PASS, "Menu is clicked.");
       }
       catch (AssertionError ex)
       {
           test.log(LogStatus.FAIL, "Menu is not clicked.");
       }

       extent.endTest(test);
       extent.flush();


   }


}
