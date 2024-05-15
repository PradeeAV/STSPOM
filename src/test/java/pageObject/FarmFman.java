package pageObject;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FarmFman extends commonComponents{

	public FarmFman(WebDriver driver) throws IOException {
		super();
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	private static final String CONFIG_FILE_PATH = "C:\\Users\\HP\\eclipse-workspace\\STSPOM\\config.properties";
	
	String outcome;
	//@FindBy(xpath = "//body/div[4]/ul[1]/li[4]/a[1]/i[1]")
   // public WebElement service;

   // @FindBy(xpath = "/html/body/div[4]/ul/li[4]/ul/li[2]/a")
   // public WebElement FarmerRegistration;
	
	@FindBy(xpath = "//a[contains(text(),'Manu')]")
	public WebElement FarmerDetail;
	
	@FindBy(linkText ="Plot")
	public WebElement Farm;
	
	@FindBy(xpath ="//*[@id=\"detail1Btn\"]/ul/li/a")
	public WebElement AddFarm;
	
	@FindBy(id="plotid")
	public WebElement Plotid;
	
	@FindBy(id="farmSize")
	public WebElement FarmSize;
	
	@FindBy(id="select2-landownerShip-container")
	public WebElement LandOwnership;
	
    @FindBy(xpath = "//li[@class='select2-results__option']")
    public WebElement LandOwnershipList;
    
    @FindBy(id="address")
    public WebElement FarmerAddress;
    
    @FindBy(id="files")
    public WebElement FarmPhoto;
    
    @FindBy(xpath ="/html[1]/body[1]/div[3]/div[1]/div[2]/form[2]/div[1]/div[2]/div[1]/div[6]/div[1]/span[1]/span[1]/span[1]/span[1]")
    public WebElement LandPreparationType;
    
    @FindBy(xpath = "//li[@class='select2-results__option']")
    public WebElement LandPreparationTypeList;
    
    @FindBy(id ="select2-soilType-container")
    public WebElement SoilType;
    
    @FindBy(xpath = "//li[@class='select2-results__option']")
    public WebElement SoilTypeList; 
    
    @FindBy(id="select2-soilTexture-container")
    public WebElement SoilTexture;
    
    @FindBy(xpath = "//li[@class='select2-results__option']")
    public WebElement SoilTextureList; 
    
    @FindBy(id="select2-irrigationSource-container")
    public WebElement IrrigationSource;
    
    @FindBy(xpath = "//li[@class='select2-results__option']")
    public WebElement IrrigationSourceList;
    
    @FindBy(id="target_farm_latitude")
    public WebElement Latitude;
    
    @FindBy(id="target_farm_longitude")
    public WebElement Longitude;
    
    @FindBy(id="target_farm_landmark")
    public WebElement Landmark;
    
    @FindBy(id="buttonAdd1")
    public WebElement Save;
    
    @FindBy(id="buttonAdd")
    public WebElement Ok;
    
    
    
	
	
	
	
	public String FarmAct() throws Exception
	{
		try
		{
		//mouseHoverAndClickOnElement(service);
		//Thread.sleep(2000);
		//clickingOnWebElement(FarmerRegistration,20);
		Thread.sleep(2000);
		 String parent = driver.getWindowHandle();
		 System.out.println("Farmer_list_window"+parent);
		 FarmerDetail.click();
		 Set<String>allWindows=driver.getWindowHandles();
			int count=allWindows.size();
			System.out.println("Total window"+count);
			for(String child:allWindows)
			{
				if(!parent.equalsIgnoreCase(child))
				{
					driver.switchTo().window(child);
				}
			}
			    
		        Farm.click();
		        Thread.sleep(2000);
		        AddFarm.click();
		        senKeysWebElement(Plotid,"566554157");
		        senKeysWebElement(FarmSize,"5.8");
		        Thread.sleep(2000);
		        selectDropdownValue1(LandOwnership,"Own_W");
		        senKeysWebElement(FarmerAddress,"No 10,Ashok Nagar,Sulur,CBE");
		        FarmPhoto.sendKeys("E:\\Farm Image.jpg");
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		    	js.executeScript("window.scrollBy(0,500)", "");
		    	selectDropdownValue2(LandPreparationType,"Double Harrowing W");
		    	Thread.sleep(2000);
		        selectDropdownValue1(SoilType,"LoamyW");
		        selectDropdownValue1(SoilTexture,"Mud_W");
		        selectDropdownValue1(IrrigationSource,"TubeWell");
		        senKeysWebElement(Latitude,"0.785456677");
		        senKeysWebElement(Longitude,"1.25566655");
		        senKeysWebElement(Landmark,"Near Bank Street");
		        Save.click();
		        acceptAlert(driver);
		        outcome = "Farm registered successfully.";
		        
		     // Condition for Validation Message and Negative cases
		        
		     // String actual_error =
				// driver.findElement(By.xpath("//*[@id=\"validateError\"]")).getText();
				// System.out.println("Error message: " + actual_error);
				// String expected_error = "Mobile Number1 should be 11 Digits";
				// Assert.assertEquals(actual_error, expected_error);
				// try {
				// if (actual_error.equalsIgnoreCase(expected_error)) {
				// return "\'Mobile Number1 should be 11 Digits\' Error message is displayed successfully";
				// } else {
				// return "\'Mobile Number1 should be 11 Digits\' Error message is not displayed";
				// }
				// }catch(Exception e) {
				// System.out.println(e);
				//  }  
		        
		         return outcome;
	} catch (Exception e) {
		return "Exception: " + e + " occurred in FarmFmanTest.";

	}

}
}