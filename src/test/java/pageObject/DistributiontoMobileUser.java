package pageObject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;

public class DistributiontoMobileUser extends commonComponents {

	public DistributiontoMobileUser() throws IOException {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	private static final String CONFIG_FILE_PATH = "C:\\Users\\HP\\eclipse-workspace\\STSPOM\\config.properties";
	
	String outcome;

	@FindBy(xpath = "//body/div[4]/ul[1]/li[4]/a[1]/i[1]")
	public WebElement service;

	@FindBy(xpath = "/html/body/div[4]/ul/li[4]/ul/li[4]/a")
	public WebElement Distribution_Mobileuser;

	@FindBy(id = "addService")
	public WebElement AddDistribution;

	@FindBy(id = "select2-season-container")
	public WebElement Season;

	@FindBy(id = "select2-warehouse-container")
	public WebElement Warehouse;

	@FindBy(id = "select2-agentId-container")
	public WebElement Mobile_User;

	@FindBy(id = "startDate")
	public WebElement Datepicker;

	@FindBy(id = "select2-category-container")
	public WebElement Product_Category;

	@FindBy(id = "select2-product1-container")
	public WebElement Product;

	@FindBy(id = "stock")
	public WebElement Available_Stock;

	@FindBy(xpath = "//*[@id=\"stock\"]")
	public WebElement Available_Stock1;

	@FindBy(id = "distributionStock")
	public WebElement Disctribution_Quantity;

	@FindBy(xpath = "//*[@id=\"target\"]/div[1]/div[2]/div/div/div/div/div[8]/table/tbody/tr/td/button[1]")
	public WebElement Product_Save;

	@FindBy(id = "sucessbtn")
	public WebElement Final_Save;

	@FindBy(xpath = "//*[@id=\"slideModal\"]/div/div/div[2]/button[2]")
	public WebElement Pop_up_Continue;

	@FindBy(xpath = "//*[@id=\"detail\"]/tbody/tr[1]/td[6]/button")
	public WebElement Detail_Info;

	@FindBy(id = "myTable1")
	public WebElement Details;

	@FindBy(xpath = "//table[@id='myTable1']/thead/tr/td")
	public List<WebElement> Details_Table_Header;

	@FindBy(xpath = "//table[@id='myTable1']/tbody/tr")
	public List<WebElement> Details_Table_Rows;

	@FindBy(xpath = "//table[@id='myTable1']/tbody/tr[1]/td")
	public List<WebElement> Details_Table_Cell_In_Each_Row;

	
	@Step("Verify the Distribution data.")
	public String DistributionAct() throws Exception
	{
		try {
		mouseHoverAndClickOnElement(service);
		Thread.sleep(2000);
		clickingOnWebElement(Distribution_Mobileuser,20);
		clickingOnWebElement(AddDistribution,20);
		selectDropdownValue1(Season,"2023-24 Wheat Planting Season");
		selectDropdownValue1(Warehouse,"Gombe Warehouse");
		selectDropdownValue1(Mobile_User,"Shahid  9999");
		String dateString1 = "03-04-2024";
        setDatePickerValue(Datepicker, dateString1);
        
        //Product1
        selectDropdownValue1(Product_Category,"Fertilizer");
        selectDropdownValue1(Product,"Zinc Sulphate");
        String actualValue=Available_Stock.getText();
        String expectedValue = "300";
        if (actualValue.equals(expectedValue)) {
            System.out.println("Value for Available Stock Correct!");
        } else {
            System.out.println("Value for Available Stock incorrect!");
        }
        
        senKeysWebElement(Disctribution_Quantity,"10");
        Product_Save.click();
        
        //Product 2
        selectDropdownValue1(Product_Category,"Fertilizer");
        selectDropdownValue1(Product,"Ammonium Sulphate");
        String actualValue1=Available_Stock1.getText();
        String expectedValue1 = "500";
        //To verify the Available Stock
        
        if (actualValue1.equals(expectedValue1)) {
            System.out.println("Value for Available Stock1 Correct!");
        } else {
            System.out.println("Value for Available Stock1 incorrect!");
        }
        senKeysWebElement(Disctribution_Quantity,"15");
        Product_Save.click();
        
        //Product 3
        selectDropdownValue1(Product_Category,"Herbicide");
        selectDropdownValue1(Product,"herb -123");
        String actualValue2=Available_Stock.getText();
        String expectedValue2 = "800";
        if (actualValue2.equals(expectedValue)) {
            System.out.println("Value for Available Stock Correct!");
        } else {
            System.out.println("Value for Available Stock incorrect!");
        }
        senKeysWebElement(Disctribution_Quantity,"20");
        
        Product_Save.click();
        Final_Save.click();
        Thread.sleep(2000);
        Pop_up_Continue.click();
        outcome = "Warehouse Stock has been Added Successfully";
        mouseHoverAndClickOnElement(service);
		Thread.sleep(2000);
		clickingOnWebElement(Distribution_Mobileuser, 20);
		
		// Printing the Info details
		Detail_Info.click();
		// Print header row in for loop...
		for(int i=0;i<Details_Table_Header.size();i++) {
			System.out.print("|\t"+Details_Table_Header.get(i).getText()+"\t");
		}
		System.out.print("|\n");
		String cell_value;
		String cell_xpath;
		//	Get the total number of rows
		for(int j=0;j<Details_Table_Rows.size();j++) {
			//	Print each row in for loop
			for(int k=0;k<Details_Table_Cell_In_Each_Row.size();k++) {
				cell_xpath = "//table[@id='myTable1']/tbody/tr[{n}]/td["+(k+1)+"]";
				cell_value = driver.findElement(By
						.xpath(cell_xpath.replace("{n}",
										Integer.toString(j+1)))).getText();
				System.out.print("|\t"
						+cell_value+"\t");
			}
			System.out.print("|\n");
		}
		Thread.sleep(3000);
	//	return true;
		
//		Comment next 15 for Negative Test Cases
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
		return outcome;
		
		} catch (Exception e) {
			return "Exception: " + e + " occurred in DistributiontoMobileUser";

	}
	}
}


