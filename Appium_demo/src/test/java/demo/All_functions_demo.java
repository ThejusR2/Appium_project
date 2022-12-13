package demo;

import static java.time.Duration.ofSeconds;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class All_functions_demo {
	AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void BT() throws MalformedURLException {
		
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.appium.android.apis.ApiDemos");
		driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
	}
	
	@Test(enabled = true)
	public void tc1() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(MobileBy.AccessibilityId("Animation")).click();
		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath("//android.widget.TextView[@content-desc=\"Cloning\"]")).click();
		Thread.sleep(2000);
		driver.findElement(MobileBy.id("io.appium.android.apis:id/startButton")).click();
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(2000);
		driver.findElements(MobileBy.className("android.widget.TextView")).get(12).click();
		Thread.sleep(2000);
		driver.findElementByAndroidUIAutomator("text(\"FLIP\")").click();
		Thread.sleep(2000);
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"FLIP\")")).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
	
	@Test(enabled = true)
	public void tc2() throws InterruptedException {
		driver.findElement(MobileBy.AccessibilityId("Preference")).click();
		Thread.sleep(2000);
		driver.findElements(MobileBy.className("android.widget.TextView")).get(9).click();
		Thread.sleep(2000);
		driver.findElement(MobileBy.className("android.widget.CheckBox")).click();
		Thread.sleep(2000);
		driver.findElements(MobileBy.className("android.widget.Switch")).get(0).click();
		Thread.sleep(2000);
		driver.findElements(MobileBy.className("android.widget.Switch")).get(1).click();
	}
	
	@Test
	public void tc3() throws InterruptedException {
		driver.openNotifications();
		Thread.sleep(3000);
		driver.findElement(MobileBy.AccessibilityId("Open quick settings.")).click();
		Thread.sleep(2000);
		AndroidElement a1= driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Auto-rotate\")"));
		TouchAction lp=new TouchAction(driver);
		lp.longPress(longPressOptions().withElement(element(a1)).withDuration(ofSeconds(5))).release().perform();
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
	
	@Test
	public void tc4() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath("//android.widget.TextView[@content-desc=\"Graphics\"]")).click();
		Thread.sleep(2000);
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Touch Paint\"))").click();
		Thread.sleep(2000);
		driver.findElement(MobileBy.className("android.view.View")).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(2000);
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		Thread.sleep(2000);
		driver.findElement(MobileBy.AccessibilityId("Drag and Drop")).click();
		Thread.sleep(2000);
		AndroidElement d1= driver.findElement(MobileBy.id("io.appium.android.apis:id/drag_dot_1"));
		Thread.sleep(2000);
		AndroidElement d2= driver.findElement(MobileBy.id("io.appium.android.apis:id/drag_dot_2"));
		
		TouchAction s1=new TouchAction(driver);
		s1.longPress(longPressOptions().withElement(element(d1)).withDuration(ofSeconds(5))).moveTo(element(d2)).release().perform();
		
	}
	
	@Test
	public void tc5() throws InterruptedException {
		driver.activateApp("com.applications.max");
		Thread.sleep(15000);
		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
	}
	
	

}
