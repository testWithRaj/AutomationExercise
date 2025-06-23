package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	
	public static void setUp() //static keyword we use bcs we can call methods without object
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		 driver.get("https://automationexercise.com/");
		
	}
	
	public static void tearDown()
	{
		driver.quit();
	}

}
