package Pikap;

import com.example.admin.myapplication.Action1;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class LoginBtnClickability {
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
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElementById("com.pikapuser:id/verifyOtp").click();
    }

    @Test
    public void loginBtnClickability() {
        ExtentTest test = extent.startTest("Login test", "Enter name");
        test.log(LogStatus.INFO, "Browser is open");


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElementById("com.pikapuser:id/loginText").click();
        test.log(LogStatus.PASS, "Login button is working.");
        String toolbarTitle = driver.findElementById("com.pikapuser:id/toolbar_title").getText();
        try {
            Assert.assertEquals(toolbarTitle, "Iniciar sesión");
            test.log(LogStatus.PASS, "Title is matching as per the screen.");

        } catch (AssertionError ex) {
            test.log(LogStatus.FAIL, "Test is fail");
        }
        driver.findElementById("com.pikapuser:id/backIcon").click();
        String reg = driver.findElementById("com.pikapuser:id/signupButton").getText();
        try {
            Assert.assertEquals(reg, "Regístrate");
            test.log(LogStatus.PASS, "Test is PASS-Back button is working fine.");

        } catch (AssertionError ex) {
            test.log(LogStatus.FAIL, "Test is fail");
        }


        extent.endTest(test);
        extent.flush();
    }
    @Test
    public void verifyLoginFunctionality(AndroidDriver driver)
    {
        ExtentTest test = extent.startTest("Login test", "Enter name");
        test.log(LogStatus.INFO, "Verify Login functionality");
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
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElementById("com.pikapuser:id/verifyOtp").click();
        extent.endTest(test);
        extent.flush();

    }
    @Test
    public void verifyResendOtpFunctionality()
    {
        ExtentTest test = extent.startTest("Login test", "Enter name");
        test.log(LogStatus.INFO, "Verify Login functionality");
        driver.findElementById("com.pikapuser:id/resendCode").click();
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    String text=driver.findElementById("android:id/message").getText();
        try {
            Assert.assertEquals(text, "El código  de seguridad fue reenviado  con éxito");
            test.log(LogStatus.PASS, "Password resend successfully");
            driver.findElementById("android:id/button1").click();


        } catch (AssertionError ex) {
            test.log(LogStatus.FAIL, "Test is fail");
        }
        extent.endTest(test);
        extent.flush();
    }
    @Test
    public void verifyPhoneNumberChangeFunctionality()
    {
       String text1=driver.findElementById("com.pikapuser:id/phoneNumChanged").getText();
        try {
            Assert.assertEquals(text1, "El número celular ha cambiado?");
            test.log(LogStatus.PASS, "Phone number changed link is available.");



        } catch (AssertionError ex) {
            test.log(LogStatus.FAIL, "Test is fail");
        }
        extent.endTest(test);
        extent.flush();

    }
    @Test
    public void verifyPhoneNumberChangeLinkClickability() {

        driver.findElementById("com.pikapuser:id/phoneNumChanged").click();






    }
}
