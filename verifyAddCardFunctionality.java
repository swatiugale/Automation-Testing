package Pikap;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class verifyAddCardFunctionality {
    AndroidDriver driver;

    ExtentReports extent = new ExtentReports("Extent-Report/report.html", true, NetworkMode.OFFLINE);
    ExtentTest test = extent.startTest("Verify Add Card", "Enter card details");
    Register reg=new Register();

    @Before
    public void Setup() throws MalformedURLException {


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "mi");
        capabilities.setCapability("appPackage", "com.pikapuser");
        capabilities.setCapability("appActivity", "com.pikapuser.SplashScreenActivity");

        //driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
    @Test
    public void verifyAddCard() {
        ExtentTest test = extent.startTest("Add Card", "To verify Add Card functionality.");
        test.log(LogStatus.INFO, "Add Card.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        reg.RegisterLogin(driver);
        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(MobileBy.xpath("//android.widget.ImageView[@content-desc='Atrás']")).click();
       /* driver.findElementById("com.pikapuser:id/paymentsLayout").click();
        driver.findElementById("com.pikapuser:id/backIcon").click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String tst2= driver.findElementById("com.pikapuser:id/navFullName").getText();
        try {
            Assert.assertEquals(tst2, "SwatiUgale Ugale shelke");
            test.log(LogStatus.PASS, "Back button is working & it back to menu.");
        }
        catch (AssertionError ex)
        {
            test.log(LogStatus.FAIL, "Back button is not working");
        }*/
        driver.findElementById("com.pikapuser:id/paymentsLayout").click();
        driver.findElementById("com.pikapuser:id/addCreditCard").click();
        String card=driver.findElementById("com.pikapuser:id/toolbar_title").getText();
        try {
            Assert.assertEquals(card, "Agregar tarjeta");
            test.log(LogStatus.PASS, "Add card heading is displayed in proper place.");
        }
        catch (AssertionError ex)
        {
            test.log(LogStatus.FAIL, "Add card heading is not displayed in proper place.");
        }
        driver.findElementById("com.pikapuser:id/nameOnTheCard").sendKeys("swati");
        driver.findElementById("com.pikapuser:id/lastNameEdit").sendKeys("ugale");
        driver.findElementById("com.pikapuser:id/emailContact").sendKeys("swati@gmail.com");
        driver.navigate().back();
        driver.findElementById("com.pikapuser:id/cardNumber").sendKeys("4400666454713666");
        driver.navigate().back();
        driver.findElementById("com.pikapuser:id/cvv").sendKeys("645");
        driver.findElementById("com.pikapuser:id/monthSpinner").click();
        driver.navigate().back();
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       // driver.findElementById("android:id/text7").click();
        driver.findElementById("com.pikapuser:id/addCardButton").click();



        extent.endTest(test);
        extent.flush();
    }

}
