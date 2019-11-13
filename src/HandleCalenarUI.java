import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandleCalenarUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "E:\\Downloads\\Selenium\\gecko\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://travel.com/");
		//first target selecting the date//
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/form[1]/div[2]/div[2]/input")).click();
		
		List<WebElement> dates = driver.findElements(By.className("rs_cal_day"));
		
		int count = dates.size();
		
		for(int i=0;i<count;i++)
		{
          String text = driver.findElements(By.className("rs_cal_day")).get(i).getText();
           if(text.equalsIgnoreCase("30"))
           {
        	   driver.findElements(By.className("rs_cal_day")).get(i).click();
        	   break;
           }
	}

	}
}
