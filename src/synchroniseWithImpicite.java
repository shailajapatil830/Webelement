import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class synchroniseWithImpicite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.setProperty("webdriver.chrome.driver",
		// "E:\\Downloads\\Selenium\\Chrome\\chromedriver.exe");
		// WebDriver driver = new ChromeDriver();

		System.setProperty("webdriver.gecko.driver", "E:\\Downloads\\Selenium\\gecko\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://alaskatrips.poweredbygps.com");
		
		//driver.findElement(By.xpath("//*[@id=\"tab-hotel-tab-hp\"]")).click();
		WebElement tab = driver.findElement(By.xpath("//*[@id=\"tab-hotel-tab-hp\"]"));
		tab.click();

		WebElement destination = driver.findElement(By.id("hotel-destination-hp-hotel"));
		destination.sendKeys("nyc");
		destination.sendKeys(Keys.TAB);
		destination.sendKeys(Keys.TAB);

		driver.findElement(By.id("hotel-checkin-hp-hotel")).sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//a[contains(@href,'New-York-Hotels')]")).click();
	}

}
