package demo;

import java.net.MalformedURLException;
import java.net.URL;
import static java.time.Duration.ofSeconds;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
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
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

public class Native_apps {
	AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void BT() throws MalformedURLException {
		
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.appium.android.apis.ApiDemos");
		driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
	}
	
	@Test(enabled = false)
	public void tc1() throws InterruptedException {
		driver.findElement(MobileBy.AccessibilityId("Preference")).click();
		Thread.sleep(2000);
		driver.findElements(MobileBy.className("android.widget.TextView")).get(3).click();
		Thread.sleep(2000);
		driver.findElement(MobileBy.id("android:id/checkbox")).click();
		
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"WiFi settings\")")).click();
		Thread.sleep(5000);
		driver.findElement(MobileBy.className("android.widget.EditText")).sendKeys("Thejus");
		
		driver.hideKeyboard();      //to hide the keyboard in emulator
//		Thread.sleep(3000);
//		driver.findElement(MobileBy.id("android:id/button1")).click();
//		Thread.sleep(3000);
//		driver.navigate().back();
//		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Reversing\")")).click();
	}
	
	@Test(enabled = true)
	public void tc2() throws InterruptedException {
		driver.openNotifications();
		Thread.sleep(3000);
		driver.findElement(MobileBy.AccessibilityId("Open quick settings.")).click();
		Thread.sleep(3000);
		TouchAction s=new TouchAction(driver);
		s.longPress(PointOption.point(976,577)).moveTo(PointOption.point(94,577)).release().perform();
//		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Auto-rotate\")")).click();
//		Thread.sleep(2000);
	}
	
	@Test(enabled = false)
	public void tap_and_longPress() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		Thread.sleep(2000);
		driver.findElement(MobileBy.AccessibilityId("Expandable Lists")).click();
		Thread.sleep(2000);
		AndroidElement tp = driver.findElement(MobileBy.AccessibilityId("1. Custom Adapter"));
		TouchAction TA=new TouchAction(driver);
		TA.tap(tapOptions().withElement(element(tp))).perform();
		
		AndroidElement lp = driver.findElementByAndroidUIAutomator("text(\"Dog Names\")");
		TA.longPress(longPressOptions().withElement(element(lp)).withDuration(ofSeconds(3))).release().perform();
		
	}
	
	@Test(enabled = false)
	public void scroll() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		AndroidElement size=driver.findElementByAndroidUIAutomator("new UiSelector().clickable(true)");
		System.out.println(size.getSize());
		Thread.sleep(2000);
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Tabs\"))").click();
		// Emulator presskeys 
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
	}
	
	@Test(enabled = false)
	public void swipe() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		Thread.sleep(2000);
		driver.findElement(MobileBy.AccessibilityId("Date Widgets")).click();
		Thread.sleep(2000);
		driver.findElement(MobileBy.AccessibilityId("2. Inline")).click();
		Thread.sleep(2000);
		driver.findElement(MobileBy.AccessibilityId("12")).click();
		
		AndroidElement e1=driver.findElement(MobileBy.AccessibilityId("15"));
		AndroidElement e2=driver.findElement(MobileBy.AccessibilityId("40"));
		
		TouchAction s=new TouchAction(driver);
		s.longPress(longPressOptions().withElement(element(e1)).withDuration(ofSeconds(5))).moveTo(element(e2)).release().perform();
		
		driver.findElementByAndroidUIAutomator("text(\"AM\")").click();
		
		//Drag and Drop
		
		Thread.sleep(4000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(2000);
		driver.findElement(MobileBy.AccessibilityId("Drag and Drop")).click();
		Thread.sleep(2000);
		AndroidElement d1= driver.findElement(MobileBy.id("io.appium.android.apis:id/drag_dot_1"));
		AndroidElement d2= driver.findElement(MobileBy.id("io.appium.android.apis:id/drag_dot_2"));
		
		TouchAction s1=new TouchAction(driver);
		s1.longPress(longPressOptions().withElement(element(d1)).withDuration(ofSeconds(5))).moveTo(element(d2)).release().perform();
	}
	
	@Test(enabled = false)
	public void switching_apps() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(MobileBy.AccessibilityId("OS")).click();
		Thread.sleep(2000);
		driver.findElement(MobileBy.AccessibilityId("SMS Messaging")).click();
		Thread.sleep(2000);
		driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_recipient")).sendKeys("(555) 521-5554");
		Thread.sleep(2000);
		driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_content")).sendKeys("Welcome to Moolya");
		Thread.sleep(2000);
		driver.findElement(MobileBy.AccessibilityId("Send"));
		
		driver.activateApp("com.google.android.apps.messaging");
		
		String s1= driver.findElement(MobileBy.id("com.google.android.apps.messaging:id/conversation_snippet")).getText();
		System.out.println(s1);
		
		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
		Thread.sleep(2000);
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}
}
