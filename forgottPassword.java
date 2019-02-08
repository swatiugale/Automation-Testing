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

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class forgottPassword {
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


    }
    @Test
    public void verifyForgottPasswordFunctionality()
    {
        ExtentTest test = extent.startTest("Login test", "Enter name");
        test.log(LogStatus.INFO, "To verify forgott password link clickability.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElementById("com.pikapuser:id/loginText").click();
        driver.findElementById("com.pikapuser:id/phoneNumber").sendKeys("8600896491");
        driver.findElementById("com.pikapuser:id/passwordLogin").sendKeys("password");
        driver.navigate().back();
        driver.findElementById("com.pikapuser:id/forgotPassword").click();
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String test1= driver.findElementById("android:id/message").getText();
        System.out.println("Message is "   +  test1);
        try {
            Assert.assertEquals(test1, "Las instrucciones para obtener una nueva contraseña fueron enviadas a: s***i@sorigin.com.");
            test.log(LogStatus.PASS, "Forgott password instruction is right & put in right place.");

        } catch (AssertionError ex) {
            test.log(LogStatus.FAIL, "Test is fail");
        }
        extent.endTest(test);
        extent.flush();

    }
    @Test
    public void backBtnClickability() {
        ExtentTest test = extent.startTest("Login test", "Enter name");
        test.log(LogStatus.INFO, "Login page is open.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElementById("com.pikapuser:id/loginText").click();
        driver.findElementById("com.pikapuser:id/backIcon").click();
        String text=driver.findElementById("com.pikapuser:id/loginText").getText();
        try {
            Assert.assertEquals(text, "Iniciar sesión");
            test.log(LogStatus.PASS, "Back button is working fine.");

        } catch (AssertionError ex) {
            test.log(LogStatus.FAIL, "Test is fail");
        }

        extent.endTest(test);
        extent.flush();




    }
}

