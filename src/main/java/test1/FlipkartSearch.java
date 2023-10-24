package test1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartSearch {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        
        //with get method use the url
        driver.get("https://www.flipkart.com/");
        driver.manage().deleteAllCookies();
   
        
        //adding the claasName of search 
        driver.findElement(By.className("_30XB9F")).click();
   
        driver.findElement(By.name("q")).sendKeys("shoes"+Keys.ENTER);
  
        driver.findElement(By.className("_2r_T1I _396QI4")).click();
     
        
   }

}
