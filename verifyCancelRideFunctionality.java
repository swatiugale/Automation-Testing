package Pikap;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

public class verifyCancelRideFunctionality {
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
    public void verifyCancelerRideButtonFunctionality() {

        verifyTrip trip=new verifyTrip();
        trip.verifyTrip(driver);
        driver.findElementById("com.pikapuser:id/cancel_ride").click();
        test.log(LogStatus.PASS, "Test is Pass.");



    }
    @Test
    public void verifyTermsandConditionFunctionality() {
        verifyTrip trip=new verifyTrip();
        trip.verifyTrip(driver);
        driver.findElementById("com.pikapuser:id/thirdMessage").click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElementById("android:id/button1").click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.pressKeyCode(AndroidKeyCode.BACK);
        test.log(LogStatus.PASS, "Test is Pass.");

    }

    }
