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
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class verifyDiscount {
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
        driver.findElementById("com.pikapuser:id/phoneNumber").sendKeys("9130056860");
        driver.findElementById("com.pikapuser:id/passwordLogin").sendKeys("password");
        driver.navigate().back();
        driver.findElementById("com.pikapuser:id/sendOtp").click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElementById("com.pikapuser:id/otpEdit").sendKeys("4444");
        driver.navigate().back();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElementById("com.pikapuser:id/verifyOtp").click();
    }

    @Test
    public void verifyDiscountClickability() {
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(MobileBy.xpath("//android.widget.ImageView[@content-desc='Atrás']")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Descuentos']")).click();

    }

    @Test
    public void verifyDiscount() {
        verifyDiscountClickability();
        driver.findElementById("com.pikapuser:id/orgName").sendKeys("Swati");
        driver.findElementById("com.pikapuser:id/orgEmail").sendKeys("swati@sorigin.com");
        driver.navigate().back();
        driver.findElementById("com.pikapuser:id/sendPromoCode").click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String txt = driver.findElementById("com.pikapuser:id/toolbar_title").getText();
        try {
            Assert.assertEquals(txt, "Descuentos");
            test.log(LogStatus.PASS, "Promocode sent successfully");


        } catch (AssertionError ex) {
            test.log(LogStatus.FAIL, "Test is fail");
        }
        extent.endTest(test);
        extent.flush();


    }


    @Test
    public void verifyPromoCode() {
    verifyDiscount();
    driver.findElementById("com.pikapuser:id/promoCode").sendKeys("KYS5HSD52G");
    driver.navigate().back();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    driver.findElementById("com.pikapuser:id/validatePromoCode").click();
    extent.endTest(test);
    extent.flush();
    }
    @Test
    public void verifyDiscountCardClickability() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElementById("com.pikapuser:id/popup").click();
        String text= driver.findElementById("com.pikapuser:id/toolbar_title").getText();
        try {
            Assert.assertEquals(text, "Descuentos");
            test.log(LogStatus.PASS, "Successfully go to Promotion .");


        } catch (AssertionError ex) {
            test.log(LogStatus.FAIL, "Test is fail");
        }
        extent.endTest(test);
        extent.flush();

    }


    }
