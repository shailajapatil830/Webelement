import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SynchroWithExplicit {
	public static void main(String[]arges) {
		
		System.setProperty("webdriver.gecko.driver", "E:\\Downloads\\Selenium\\gecko\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://alaskatrips.poweredbygps.com");
		driver.findElement(By.xpath("//*[@id=\"tab-hotel-tab-hp\"]")).click();

		WebElement destination = driver.findElement(By.id("hotel-destination-hp-hotel"));
		destination.sendKeys("nyc");
		destination.sendKeys(Keys.TAB);
		destination.sendKeys(Keys.TAB);

		driver.findElement(By.id("hotel-checkin-hp-hotel")).sendKeys(Keys.ENTER);
		
		WebDriverWait d = new WebDriverWait(driver,20);
		d.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'New-York-Hotels')]")));
		driver.findElement(By.xpath("//a[contains(@href,'New-York-Hotels')]")).click();
}
}