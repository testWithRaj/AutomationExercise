package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	WebDriver driver;
	
	private By loginLink= By.xpath("//a[text()=' Signup / Login']");
	
	
	//Constructor  : is used to initilize the object 
	public HomePage(WebDriver driver)
	{
		this.driver =driver;
	}
	
	
	//action
	public void clickLoginLink()
	{
		driver.findElement(loginLink).click();
	}
	
	
	

}
