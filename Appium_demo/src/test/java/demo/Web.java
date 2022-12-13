package demo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import antlr.collections.List;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Web {
AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void BT() throws MalformedURLException
	{
    DesiredCapabilities dc = new DesiredCapabilities();
		
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		dc.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "E://chromedriver.exe");
		driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
	
	}
	
	@Test
	public void tc1() throws InterruptedException
	{
		
		driver.get("https://www.google.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("OrangeHRM");
		Actions a1=new Actions(driver);
		a1.sendKeys(Keys.ENTER).build().perform();
	
//		List<AndroidElement> link = driver.findElements(By.tagName("a"));
//     	System.out.println(link.size());
//     	for(int i=0;i<=link.size();i++) {
//     		System.out.println(link.get(i).getText());
//  		System.out.println(link.get(i).getAttribute("href"));
  		
	}
	
	@Test
	public void tc2() throws InterruptedException {
		Thread.sleep(2000);
		WebElement element=driver.findElement(By.xpath("//*[@class='Z26q7c UK95Uc jGGQ5e']"));
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		element.click();
//		System.out.println(driver.getTitle());
//		js.executeScript("document.getElementsByClassName('oewGkc LeUQr MUxGbd v0nnCb')[1].scrollIntoView();");
//		js.executeScript("document.getElementsByClassName('oewGkc LeUQr MUxGbd v0nnCb')[1].click();");
		
	}
	
	@Test
	public void tc3() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("admin123");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@type='submit']")).click();
	}
	
	@Test
	public void tc4() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='oxd-icon bi-list oxd-topbar-header-hamburger']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='oxd-main-menu']/li")).click();
		System.out.println(driver.getTitle());
	}
	
	@Test
	public void tc5() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='oxd-dropdown-menu']/li[4]")).click();
	}
}
