package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	
	By userName = By.xpath("//input[@data-qa='login-email']");
	By Password= By.xpath("//input[@data-qa='login-password']");
	By loginButton = By.xpath("//button[@data-qa='signup-button']");
	By errorMessage = By.xpath("//p[text()='Your email or password is incorrect!']");
	
	//constructor 
	
	public LoginPage(WebDriver driver)
	{
		this.driver =driver;
	}
	
	//actions
	
	public void enterUserName(String email)
	{
		driver.findElement(userName).sendKeys("rajk116629@gmail.com");
	}
	
	public void enterPassword(String password)
	{
		driver.findElement(Password).sendKeys("password12345");
	}
	
	public void clickloginButton()
	{
		driver.findElement(loginButton).click();
	}
	
	
	

}
