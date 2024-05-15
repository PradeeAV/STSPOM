package pageObject;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SowingFman extends commonComponents
{

	public SowingFman(WebDriver driver) throws IOException {
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
	
	//@FindBy(xpath = "//a[contains(text(),'Xavier')]")
	//public WebElement FarmerDetail;
	
	@FindBy(linkText ="Sowing")
	public WebElement Sowing;
	
	@FindBy(xpath = "//*[@id=\"cropDetailBtn\"]/ul/li/a")
	public WebElement AddSowing;
	
	@FindBy(id ="select2-selectedFarmName-container")
	public WebElement PlotId;
	
	@FindBy(id="select2-harvestseason-container")
	public WebElement Season;
	
	@FindBy(id="select2-cropName-container")
	public WebElement Crop;
	
	@FindBy(id="select2-cultivar-container")
	public WebElement Variety;
	
	@FindBy(id="select2-sowingMethod-container")
	public WebElement SowingMethod;
	
	@FindBy(xpath="//*[@id=\"date\"]")
	public WebElement SowingDate;
	
	@FindBy(id="irrigationDate")
	public WebElement FirststIrrigationDate;
	
	@FindBy(id="cultivationArea")
	public WebElement CultivationArea;
	
	@FindBy(id="noOfSeedUsed")
	public WebElement NoofTrees;
	
	@FindBy(id="select2-seedSource-container")
	public WebElement Seedsource;
	
	@FindBy(id="estimatedyieldskg")
	public WebElement EstimateYield;
	
	@FindBy(id="select2-application-container")
	public WebElement Application;
	
	@FindBy(id="select2-product-container")
	public WebElement Product;
	
	@FindBy(id="applicationDate")
	public WebElement ApplicationDate;
	
	@FindBy(id="quantityApplied")
	public WebElement QuantityApplied;
	
	@FindBy(id="select2-unit-container")
	public WebElement Unit;
	
	@FindBy(id="add")
	public WebElement ProductAdd;
	
	@FindBy(id="buttonAdd1")
	public WebElement Save2;
	
	@FindBy(id="buttonAdd")
	public WebElement Ok;
	
	
	
	public String SowingAct() throws Exception
	{
		try
		{	
		//mouseHoverAndClickOnElement(service);
		//Thread.sleep(2000);
		//clickingOnWebElement(FarmerRegistration,20);
		//Thread.sleep(2000);
		// String parent = driver.getWindowHandle();
		// System.out.println("Farmer_list_window"+parent);
		// FarmerDetail.click();
		 //Set<String>allWindows=driver.getWindowHandles();
		//	int count=allWindows.size();
		//	System.out.println("Total window"+count);
		//	for(String child:allWindows)
		//	{
		//		if(!parent.equalsIgnoreCase(child))
		//		{
		//			driver.switchTo().window(child);
		//		}
		//	}
			    
		        Sowing.click();
		        Thread.sleep(2000);
		        AddSowing.click();
		        selectDropdownValue1(PlotId,"566554156");
		        selectDropdownValue1(Season,"2023-24 Wheat Planting Season");
		        selectDropdownValue1(Crop,"Wheat");
		        selectDropdownValue1(Variety,"Borlaug");
		        selectDropdownValue1(SowingMethod,"DibblingW");
		        String dateString1 = "02-05-2024";
		        setDatePickerValue(SowingDate, dateString1);
		        String dateString2 = "02-05-2024";
		        setDatePickerValue(FirststIrrigationDate, dateString2);
		        senKeysWebElement(CultivationArea,"5.8");
		        senKeysWebElement(NoofTrees,"10");
		        selectDropdownValue1(Seedsource,"Own");
		        senKeysWebElement(EstimateYield,"10.8");
		        selectDropdownValue1(Application,"2nd Application");
		        selectDropdownValue1(Product,"Herbicides");
		        Thread.sleep(2000);
		        String dateString3 = "05-05-2024";
		        setDatePickerValue(ApplicationDate, dateString3);
		        senKeysWebElement(QuantityApplied,"35");
		        selectDropdownValue1(Unit,"Grams");
		        ProductAdd.click();
		        Save2.click();
		        acceptAlert(driver);
		        outcome = "Sowing registered successfully.";
		        Thread.sleep(2000);
		        
// Condition for Validation Message and Negative cases
		        
		     // String actual_error =
				// driver.findElement(By.xpath("//*[@id=\"validateError\"]")).getText();
				// System.out.println("Error message: " + actual_error);
				// String expected_error = "Please Select Season";
				// Assert.assertEquals(actual_error, expected_error);
				// try {
				// if (actual_error.equalsIgnoreCase(expected_error)) {
				// return "\'Please Select Season\' Error message is displayed successfully";
				// } else {
				// return "\'Please Select Season\' Error message is not displayed";
				// }
				// }catch(Exception e) {
				// System.out.println(e);
				//  }

				return outcome; 	        
		        
	} catch (Exception e) {
		return "Exception: " + e + " occurred in SowingFmanTest.";

	}

}

	}
	
	
	

