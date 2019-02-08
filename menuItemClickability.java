package Pikap;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class menuItemClickability {
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
            Thread.sleep(10000);
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
        String tst5= driver.findElementById("com.pikapuser:id/navNoOfStars").getText();
        try {
            Assert.assertEquals(tst5, "5.0");
            test.log(LogStatus.PASS, "Rating is accurate..");
        }
        catch (AssertionError ex)
        {
            test.log(LogStatus.FAIL, "Rating is not accurate..");
        }
        driver.findElementById("com.pikapuser:id/paymentsLayout").click();

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String tst1= driver.findElementById("com.pikapuser:id/toolbar_title").getText();
        try {
            Assert.assertEquals(tst1, "Pagos");
            test.log(LogStatus.PASS, "Pagos  is clicked.");
            
        }
        catch (AssertionError ex)
        {
            test.log(LogStatus.FAIL, "Pagos is not clicked.");
        }
        driver.findElementById("com.pikapuser:id/backIcon").click();



        driver.findElement(MobileBy.xpath("//android.widget.ImageView[@content-desc='Atrás']")).click();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElementById("com.pikapuser:id/carsLayout").click();
        String tst2= driver.findElementById("com.pikapuser:id/toolbar_title").getText();
        try {
            Assert.assertEquals(tst2, "Vehículos");
            test.log(LogStatus.PASS, "Vehículos  is clicked & goes to proper view.");
        }
        catch (AssertionError ex)
        {
            test.log(LogStatus.FAIL, "Vehículos is not clicked.");
        }
        driver.findElementById("com.pikapuser:id/backIcon").click();

        driver.findElement(MobileBy.xpath("//android.widget.ImageView[@content-desc='Atrás']")).click();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElementById("com.pikapuser:id/settingLayout").click();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String tst3= driver.findElementById("com.pikapuser:id/toolbar_title").getText();
        try {
            Assert.assertEquals(tst2, "Configuración");
            test.log(LogStatus.PASS, "Configuración is clicked & goes to proper view.");
        }
        catch (AssertionError ex)
        {
            test.log(LogStatus.FAIL, "Configuración is not clicked.");
        }
        driver.findElementById("com.pikapuser:id/backIcon").click();

        driver.findElement(MobileBy.xpath("//android.widget.ImageView[@content-desc='Atrás']")).click();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElementById("com.pikapuser:id/work_with_us").click();

        extent.endTest(test);
        extent.flush();


    }

}
