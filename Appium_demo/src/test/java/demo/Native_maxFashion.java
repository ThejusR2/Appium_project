package demo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class Native_maxFashion {
	AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void BT() throws MalformedURLException {
		
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.applications.max");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.landmarkgroup.landmarkshops.module.splash.activity.SplashActivityV2");
		driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
	}
	
	@Test
	public void tc1() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(MobileBy.id("com.applications.max:id/ivSearch")).click();
		Thread.sleep(5000);
		driver.findElement(MobileBy.id("com.applications.max:id/editSearch")).sendKeys("Shoes");
		Thread.sleep(2000);
		Actions a1=new Actions(driver);
		a1.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		Actions a2=new Actions(driver);
		a2.sendKeys(Keys.ARROW_DOWN).build().perform();
		a2.sendKeys(Keys.ARROW_DOWN).build().perform();
		a2.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(2000);
		Actions a3=new Actions(driver);
		a3.sendKeys(Keys.ENTER).build().perform();
	}
	
	@Test
	public void tc2() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget"
				+ ".LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android"
				+ ".widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android"
				+ ".widget.RelativeLayout/android.view.ViewGroup/androidx.recyclerview.widget"
				+ ".RecyclerView/android.view.ViewGroup[2]/android.widget.ImageView[1]")).click();
		Thread.sleep(3000);
		driver.findElement(MobileBy.id("com.applications.max:id/button")).click();
		Thread.sleep(2000);
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"41\")")).click();
		Thread.sleep(2000);
		driver.findElement(MobileBy.id("com.applications.max:id/btnAddToBasket")).click();
	}
	
	@Test
	public void tc3() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(MobileBy.id("com.applications.max:id/txt_remove")).click();
		Thread.sleep(2000);
		driver.findElement(MobileBy.id("com.applications.max:id/btnRemove")).click();
		
	}

}
