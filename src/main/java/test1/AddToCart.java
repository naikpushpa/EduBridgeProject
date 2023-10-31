package test1;



import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddToCart {

	WebDriver driver;

	@BeforeTest
	public void setup()
	{
		//WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Test
	public void addcart()
	{

		//would launch the Chrome browser 
		//by get method use the url
		driver.get("https://www.flipkart.com/");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6000));

		//findElement of class login
		driver.findElement(By.className("_30XB9F")).click();

		//findElement of class name search and enter
		driver.findElement(By.name("q")).sendKeys("iphone" + Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6000));

		//findElement of class name product 
		WebElement elink= driver.findElement(By.className("_396cs4"));
		elink.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6000));

		//opens in another browser so use chindWindow
		String mainwindow = driver.getWindowHandle();

		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();

		while (i1.hasNext()) {
			String ChildWindow = i1.next();
			if (!mainwindow.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				System.out.println("chilwindow" + ChildWindow);

				//add xpath of the product
				driver.navigate().refresh(); 
				WebElement addcart = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/button[1]"));
				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));

				addcart = wait.until(ExpectedConditions.elementToBeClickable(addcart));
				addcart.click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6000));

				System.out.println("Heading of child window is " + addcart.getText());
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6000));
			}
		}    


	}
	@AfterTest
	public void closeWindow()
	{
		driver.close();
	}
}
