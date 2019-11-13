import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class countLinks {

	private static Iterator<String> it;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "E:\\Downloads\\Selenium\\gecko\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

		// 1.Give me count of the links on the page - every link have a tag called <a //
		driver.get("http://www.qaclickacademy.com/practice.php");
		System.out.println(driver.findElements(By.tagName("a")).size());

		// 2. couunt footer section - requirement- get me the count of links in footer
		// section//
		// first create a mini/subsidery driver for only footer section//
		WebElement footerdriver = driver.findElement(By.id("gf-BIG")); // limited webdriver scope//
		System.out.println(footerdriver.findElements(By.tagName("a")).size());

		// 3.requirement- count links- only in first coloumn of footer section//
		WebElement coloumndriver = footerdriver.findElement(By.xpath("/html/body/div[6]/table/tbody/tr/td[1]/ul"));
		System.out.println(coloumndriver.findElements(By.tagName("a")).size());

		// 4- click on each link in the coloumn and check if the pages are open//
		for (int i = 1; i < coloumndriver.findElements(By.tagName("a")).size(); i++) {

			String clickonLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);

			coloumndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonLinkTab);
			Thread.sleep(5000L);
		}

		Set<String> abc = driver.getWindowHandles(); // 4
		Iterator<String> it = abc.iterator();
		// opens all the tabs

		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}

	}

}
