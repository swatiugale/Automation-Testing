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

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Register {
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
    public void backBtnFunctionality() {
        ExtentTest test = extent.startTest("Login test", "Enter name");
        test.log(LogStatus.INFO, "Login page is open.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElementById("com.pikapuser:id/signupButton").click();
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
    @Test
    public void RegisterLogin(AndroidDriver driver) {
       ExtentTest test = extent.startTest("Login test", "Enter name");
        test.log(LogStatus.INFO, "Browser is open");
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //driver.findElementById("android:id/button1").click();
        //driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
        //driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
        driver.findElementById("com.pikapuser:id/signupButton").click();
        driver.findElementById("com.pikapuser:id/firstName").sendKeys("swati");
        driver.findElementById("com.pikapuser:id/lastName").sendKeys("Ugale");
        driver.findElementById("com.pikapuser:id/email").sendKeys("swati@gmail.com");
        //Select s=new Select(driver.findElementById("com.pikap:id/countryCodeSpinner"));
        driver.navigate().back();
        driver.findElementById("com.pikapuser:id/countryCodeSpinner").click();
      //  driver.findElementById("android:id/text1").click();
        driver.navigate().back();
        driver.findElementById("com.pikapuser:id/phoneNumber").sendKeys("8600896491");
        TouchAction action = new TouchAction(driver);

        //JavascriptExecutor jse=(JavascriptExecutor)driver;
        //jse.executeScript("window.scrollBy(0,580)","");

        action.press(0, 300).waitAction().moveTo(0, 100).release().perform();
        driver.findElementById("com.pikapuser:id/password").sendKeys("password");
        driver.findElementById("com.pikapuser:id/confirmPassword").sendKeys("password");


        //JavascriptExecutor jse=(JavascriptExecutor)driver;
        //jse.executeScript("window.scrollBy(0,580)","");

        action.press(0, 300).waitAction().moveTo(0, 100).release().perform();
        driver.findElementById("com.pikapuser:id/termsOfUse").click();
        driver.findElementById("com.pikapuser:id/privacyPolicy").click();
        driver.navigate().back();
        driver.findElementById("com.pikapuser:id/signUpStep1").click();
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElementById("com.pikapuser:id/verifyOtp").click();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean d=driver.findElementById("com.pikapuser:id/hamburgerHome").isDisplayed();
        if(d==true)
        {
            test.log(LogStatus.PASS,"Registration Successful.");
        }
        else {
            test.log(LogStatus.FAIL,"Registration Successful.");
        }
        extent.endTest(test);
        extent.flush();
    }
    @Test
    public void verifyHeading() {
        ExtentTest test = extent.startTest("Login test", "Enter name");
        test.log(LogStatus.INFO, "Browser is open");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElementById("com.pikapuser:id/signupButton").click();
        String text1=driver.findElementById("com.pikapuser:id/toolbar_title").getText();
        try {
            Assert.assertEquals(text1, "Regístrate");
            test.log(LogStatus.PASS, "Heading is proper.");

        } catch (AssertionError ex) {
            test.log(LogStatus.FAIL, "Test is fail");
        }

        extent.endTest(test);
        extent.flush();


    }
    @Test
    public void registrateBtnClickability()
    {
        ExtentTest test = extent.startTest("Login test", "Enter name");
        test.log(LogStatus.INFO, "Login page is open.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElementById("com.pikapuser:id/signupButton").click();
        String text1=driver.findElementById("com.pikapuser:id/toolbar_title").getText();
        try {
            Assert.assertEquals(text1, "Regístrate");
            test.log(LogStatus.PASS, "Registration button is working proper");

        } catch (AssertionError ex) {
            test.log(LogStatus.FAIL, "Test is fail");
        }


        extent.endTest(test);
        extent.flush();

    }

}



