import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "E:\\Downloads\\Selenium\\gecko\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://jqueryui.com/droppable/");
		// count the frame//
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		
		//switch frame with the help of index//
		driver.switchTo().frame(0);
		
		//switch frame with the help of webelement//
		//driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class = 'demo-frame']")));
		//driver.findElement(By.id("draggable")).click();
		Actions a = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		a.dragAndDrop(source, target).build().perform();
		//if you want to do action outside of frames so let webdriver knows use following action method//
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[1]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[1]/ul/li[3]/a")).click();

	}

}
