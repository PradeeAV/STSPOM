package pageObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import commonFunctions.commonFunctions;

public class LoginFman extends commonComponents {
	public LoginFman(WebDriver driver) throws IOException {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	private static final String CONFIG_FILE_PATH = "C:\\Users\\HP\\eclipse-workspace\\STSPOM\\config.properties";

	@FindBy(id = "branch")
	public WebElement branchSelection;

	@FindBy(id = "userName")
	public WebElement username;

	@FindBy(id = "password")
	public WebElement password;

	@FindBy(id = "btnLogin")
	public WebElement loginButton;

	@FindBy(xpath = "//*[contains(text(),'Welcome to')]")
	public WebElement welcomeMessage;
	
	//@FindBy(xpath = "//button[@class='btn btn-primary btn-hi-sts-transparent btn-sm']/span")
//	public WebElement userProfileButton;
	
	//@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right dropdown-head']/li[5]/a[1]")
	
//	@FindBy(xpath="/html/body/div[3]/div[1]/div[1]/div/div[6]/ul/li/ul/li[4]/a")
//	public WebElement logoutButton;



	public boolean loginAct() throws IOException, InterruptedException {
		// System.out.println(pro.getProperty("User_name"));
		selectByVisibleText(branchSelection, pro.getProperty("Branch"));
		senKeysWebElement(username, pro.getProperty("User_name"));
		senKeysWebElement(password, pro.getProperty("Pass_word"));
		loginButton.click();
		Thread.sleep(6000);

		// This conditions checked for Negative cases

		/*
		 * String actual_msg = driver.switchTo().alert().getText();
		 * System.out.println("Alert msg is" + actual_msg); Thread.sleep(3000);
		 * driver.switchTo().alert().accept(); String expected_msg =
		 * "Please enter Username"; Assert.assertEquals(actual_msg, expected_msg);
		 */

		// String
		// actual_error=driver.findElement(By.xpath("//*[@id=\"login\"]/font/ul/li/span")).getText();
		// System.out.println("Username error is"+actual_error);
		// String expected_error="Wrong Password.";
		// Assert.assertEquals(actual_error, expected_error);
		if (welcomeMessage.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	
	//public void  logoutAct() throws IOException, InterruptedException {
	//	userProfileButton.click();
	//	Thread.sleep(2000);
	//	logoutButton.click();
	//	Thread.sleep(2000);
	//}

	public void closeDriver() {
		driver.quit();
	}
}
