package Pikap;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Verifyotp {
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
    public void verifyResendOtp() {
        ExtentTest test = extent.startTest("Login test", "Enter name");
        test.log(LogStatus.INFO, "Login page is open.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElementById("com.pikapuser:id/loginText").click();
        driver.findElementById("com.pikapuser:id/phoneNumber").sendKeys("9130056860");
        driver.findElementById("com.pikapuser:id/passwordLogin").sendKeys("password");
        driver.navigate().back();
        driver.findElementById("com.pikapuser:id/sendOtp").click();
        try {
            Thread.sleep(40000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElementById("com.pikapuser:id/resendCode").click();

        extent.endTest(test);
        extent.flush();
    }
    @Test
    public void verifyPhoneNumberChange() {
        ExtentTest test = extent.startTest("Login test", "Enter name");
        test.log(LogStatus.INFO, "Login page is open.");
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElementById("com.pikapuser:id/loginText").click();
        driver.findElementById("com.pikapuser:id/phoneNumber").sendKeys("9130056860");
        driver.findElementById("com.pikapuser:id/passwordLogin").sendKeys("password");
        driver.navigate().back();
        driver.findElementById("com.pikapuser:id/sendOtp").click();
        try {
            Thread.sleep(40000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElementById("com.pikapuser:id/phoneNumChanged").click();
        try {
            Thread.sleep(40000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElementById("com.pikapuser:id/phoneNumber").sendKeys("8600896491");
        driver.navigate().back();
        driver.findElementById("com.pikapuser:id/updatePhoneNumber").click();


        extent.endTest(test);
        extent.flush();
    }
}
