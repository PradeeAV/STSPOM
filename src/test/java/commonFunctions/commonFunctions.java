package commonFunctions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


//import org.testng.annotations.BeforeTest;
//import org.testng.log4testng.Logger;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import testCases.Tclogin;

public class commonFunctions 
{
	
    public static WebDriver driver;
	  //private static WebDriver driver;
	  
	public static Properties prop=null;
	
	public Properties loadPropertyFile() throws IOException
	{
	FileInputStream fileInputStream =new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\STSPOM\\config.properties");
	prop=new Properties();
	prop.load(fileInputStream);
	System.out.println(prop.getProperty("browser"));
	System.out.println(prop.getProperty("url"));
     return prop;
	
}


	@Step("Launch the application")
	@BeforeSuite
	public  WebDriver launchBrowser() throws IOException
	{
		prop =loadPropertyFile();
		String browser=prop.getProperty("browser");
		String url=prop.getProperty("url");
		String Driverlocation=prop.getProperty("Driverlocation");
		
		
		
		if(browser.equalsIgnoreCase("chrome"))
		{
		//	System.setProperty("webdriver.chrome.driver", Driverlocation);
			WebDriverManager.chromedriver().setup();
		//	WebDriverManager.chromedriver().driverVersion(Driverlocation).setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
		   // options.setBinary("C:\\Users\\HP\\Downloads\\chromedriver-win64 (1).zip\\chromedriver-win64\\chromedriver.exe");

		driver=new ChromeDriver(options);
			driver.manage().window().maximize();
			//driver.get(browser);
			driver.navigate().to(url);
			//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.manage().timeouts().
			implicitlyWait(java.time.Duration.ofSeconds(30));
			 // driver.findElement(By.id("userName")).sendKeys("123");;
			  
			return driver;
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			//System.setProperty("Webdriver.gecko.driver", Driverlocation);
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			//driver.get(browser);
			driver.navigate().to(url);
			//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.manage().timeouts().
			implicitlyWait(java.time.Duration.ofSeconds(30));
			return driver;
		}
		
		return driver;
			
	}
	
	

	//@AfterSuite
	//public void tearDown()

	{
	//	driver.quit();
	}
}
	