//package amazon;

//import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AppiumStartApp {

	private static WebDriver driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		// File classpathRoot = new File(System.getProperty("user.dir"));
		// File appDir = new File(classpathRoot, "/Apps/Amazon/");
		// File app = new File(appDir, "com.amazon.mShop.android.shopping.apk");

		AppiumStartApp app1 = new AppiumStartApp();
		 //app1.facebookLogin();
		app1.whatsAppChat();

	}

	public void facebookLogin() throws MalformedURLException, InterruptedException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
		capabilities.setCapability("deviceName", "OPPO F1f");
		capabilities.setCapability("platformVersion", "5.1.1");
		capabilities.setCapability("platformName", "Android");
		// capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("autoDismissAlerts", true);
		capabilities.setCapability("appPackage", "com.android.chrome");
		capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");

		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		Thread.sleep(5000);
		driver.get("http://facebook.com");
		Thread.sleep(10000);

		driver.findElement(By.name("email")).sendKeys("omarcareem@yahoo.com");
		driver.findElement(By.name("pass")).sendKeys("Razmi@860094037");
		driver.findElement(By.name("login")).click();
		Thread.sleep(15000);
		driver.findElement(By.xpath("//div[@id='header']/div/div[6]/div")).click();
		driver.findElement(By.xpath("//div/a[@data-sigil='logout']")).click();
		Thread.sleep(5000);
		driver.quit();
	}

	public void whatsAppChat() throws MalformedURLException, InterruptedException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
		capabilities.setCapability("deviceName", "OPPO F1f");
		capabilities.setCapability("platformVersion", "5.1.1");
		capabilities.setCapability("platformName", "Android");
		// capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.whatsapp");
		capabilities.setCapability("appActivity", "com.whatsapp.Main");

		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

		Thread.sleep(10000);
		//driver.findElement(By.name("Search")).click();
		//driver.findElement(By.id("com.whatsapp:id/search_src_text")).sendKeys("Jaan");
		WebElement element = driver.findElement(By.name("Jaan"));
		element.click();
		driver.findElement(By.id("com.whatsapp:id/message_btn")).click();
		driver.findElement(By.id("com.whatsapp:id/entry")).sendKeys(
				" Zindagi ab tum hi ho, This is also I am sending through automation :) ");
		driver.findElement(By.id("com.whatsapp:id/send")).click();
		driver.quit();
	}

}
