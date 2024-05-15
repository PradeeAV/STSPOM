package pageObject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class InputDistribution extends commonComponents
{

	public InputDistribution() throws IOException {
		super();
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	private static final String CONFIG_FILE_PATH = "C:\\Users\\HP\\eclipse-workspace\\STSPOM\\config.properties";
	
	String outcome;
	
	@FindBy(xpath = "//body/div[4]/ul[1]/li[4]/a[1]/i[1]")
    public WebElement service;
	
	@FindBy(xpath ="/html/body/div[4]/ul/li[4]/ul/li[5]/a")
	public WebElement Input_Distribution;
	
	@FindBy(id="addService")
	public WebElement Add_Input_Distribution;
	
	@FindBy(xpath="//*[@id=\"select2-seasonId-container\"]")
	public WebElement Season;
	
	@FindBy(name="distributionDate")
	public WebElement Datepicker;
	
	@FindBy(id="select2-packhouseid-container")
	public WebElement Warehouse;
	
	@FindBy(id="select2-village-container")
	public WebElement Village;
	
	@FindBy(id="select2-farmerId-container")
	public WebElement Farmer;
	
	@FindBy(id="select2-farmId-container")
	public WebElement Plot;
	
	@FindBy(id="mobileNumber")
	public WebElement MobileNumber;
	
	@FindBy(id="select2-category-container")
	public WebElement Product_Category;
	
	@FindBy(id="select2-crops-container")
	public WebElement Product;
	
	@FindBy(id="salep")
	public WebElement Selling_Price;
	
	@FindBy(id="disQ")
	public WebElement Distribution_Qty;
	
	@FindBy(id="add")
	public WebElement Add_Product;
	
	@FindBy(xpath = "(//*[@id='productInfoTbl'])[2]")
	public WebElement Product_Table_Detail;
	
	@FindBy(xpath="((//*[@id='productInfoTbl'])[2]/thead/tr/th)[position()<7 or position()=8]")
	public List<WebElement> Details_Table_Header;
	
	@FindBy(xpath="(//table[@id='productInfoTbl'])[2]/tbody/tr")
	public List<WebElement> Details_Table_Rows;
	
	@FindBy(xpath="((//table[@id='productInfoTbl'])[2]/tbody/tr[1]/td)[position()<7 or position()=8]")
	public List<WebElement> Details_Table_Cell_In_Each_Row;
	
	@FindBy(id="paymentRupee")
	public WebElement Payment_Information;
	
	@FindBy(xpath="//*[@id='buttonAdd']")
	public WebElement Save;
	
	@FindBy(id="buttonAdd")
	 public WebElement Ok;
	
	  
	
	
	public String InputDistributionAct() throws Exception
	{
		try
		{
		mouseHoverAndClickOnElement(service);
		Thread.sleep(4000);
		clickingOnWebElement(Input_Distribution,20);
		clickingOnWebElement(Add_Input_Distribution,20);
		selectDropdownValue1(Season,"2023-24 Wheat Planting Season");
		String dateString1 = "08-04-2024";
        setDatePickerValue(Datepicker, dateString1);
        selectDropdownValue1(Warehouse,"Vino Warehouse");
        selectDropdownValue1(Village,"Biyamusu - V00008");
        selectDropdownValue1(Farmer,"kannan-S0002");
        selectDropdownValue1(Plot,"S000p");
        String actualValue=MobileNumber.getText();
        String expectedValue = "08946494649";
        if (actualValue.equals(expectedValue)) {
            System.out.println("Mobile Number for kannan-S0002 Matched !");
        } else {
            System.out.println("Mobile Number for kannan-S0002 Not_Matched!");
        }
        selectDropdownValue1(Product_Category,"FP00003-Fertilizer");
        selectDropdownValue1(Product,"Ammonium Sulphate");
        senKeysWebElement(Selling_Price,"200");
        senKeysWebElement(Distribution_Qty,"50");
        Add_Product.click();
        Thread.sleep(3000);

        selectDropdownValue1(Product_Category,"FP00003-Fertilizer");
        selectDropdownValue1(Product,"Zinc Sulphate");
        senKeysWebElement(Selling_Price,"100");
        senKeysWebElement(Distribution_Qty,"85");
        Thread.sleep(3000);
        Add_Product.click();
        
        selectDropdownValue1(Product_Category,"FP00001-CategoryW1");
        selectDropdownValue1(Product,"ItemC1W1");
        senKeysWebElement(Selling_Price,"50");
        senKeysWebElement(Distribution_Qty,"20");
        Thread.sleep(3000);
        Add_Product.click();
        
        
        //Finding Validation Error
     //   String actual_error=driver.findElement(By.xpath("//*[@id=\"validateError\"]")).getText();
    //	System.out.println("Distribution Qty"+actual_error);
    //	String expected_error=" Distribution Quantity should be less then Available Stock";
    //	Assert.assertEquals(actual_error, expected_error);
    	
    	// Printing the Info details
    	for(int i=0;i<Details_Table_Header.size();i++) {
			System.out.print("|\t"+Details_Table_Header.get(i).getText()+"\t");
		}
    	System.out.print("|\n");
		String cell_value;
		String cell_xpath;
		cell_xpath = "((//table[@id='productInfoTbl'])[2]/tbody/tr[{n}]/td)[position()<7 or position()=8]";
		List<WebElement> cell_data_list;
		System.out.println("Details_Table_Rows: "+Details_Table_Rows.size());

		//	Get the total number of rows
		for(int j=0;j<Details_Table_Rows.size();j++) 
		{
			cell_data_list = driver.findElements(By
					.xpath(cell_xpath.replace("{n}",
							Integer.toString(j+1))));
			//	Print each row in for loop
			for(int k=0;k<Details_Table_Cell_In_Each_Row.size();k++) {
				cell_value = cell_data_list.get(k).getText();
				System.out.print("|\t"+cell_value+"\t");
			}
			System.out.print("|\n");
		}
		
    	
    	//Payment Information
    	
    	//String actualValue1=Payment_Information.getText();
    	//String expectedValue1 = "20000";
       // if (actualValue1.equals(expectedValue1)) {
       //     System.out.println("Payment Information for kannan-S0002 matched - 20000 !");
       // } else {
       //     System.out.println("Payment Information for kannan-S0002 Not_Matched!");
       // }

        
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)", "");
		Thread.sleep(3000);
        Save.click();
        acceptAlert(driver);
        outcome = "InputDistribution added successfully.";
        Thread.sleep(3000);
       // return true;
        
//    	Comment next 15 for Negative Test Cases
    			// String actual_error =
    			// driver.findElement(By.xpath("//*[@id=\"validateError\"]")).getText();
    			// System.out.println("Error message: " + actual_error);
    			// String expected_error = "Please Select Farmer";
    			// Assert.assertEquals(actual_error, expected_error);
    			// try {
    			// if (actual_error.equalsIgnoreCase(expected_error)) {
    			// return "\'Please Select Farmer\' Error message is displayed successfully";
    			// } else {
    			// return "\'Please Select Farmer\' Error message is not displayed";
    			// }
    			// }catch(Exception e) {
    			// System.out.println(e);
    			//  }

    			return outcome;
		} catch (Exception e) {
			return "Exception: " + e + " occurred in InputDistributionTest";
        
	}
	
}
}


