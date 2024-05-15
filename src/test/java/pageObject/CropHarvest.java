package pageObject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CropHarvest extends commonComponents {

	public CropHarvest() throws IOException {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	private static final String CONFIG_FILE_PATH = "C:\\Users\\HP\\eclipse-workspace\\STSPOM\\config.properties";
	
	String outcome;

	@FindBy(xpath = "//body/div[4]/ul[1]/li[4]/a[1]/i[1]")
	public WebElement service;

	@FindBy(xpath = "/html/body/div[4]/ul/li[4]/ul/li[7]/a")
	public WebElement Crop_Harvest;

	@FindBy(id = "addService")
	public WebElement Add_Crop_Harvest;

	@FindBy(id = "cropHarvestdate")
	public WebElement Harvest_Date;

	@FindBy(id = "select2-village-container")
	public WebElement Village;

	@FindBy(id = "select2-farmerId-container")
	public WebElement Farmer_Name;

	@FindBy(id = "select2-farmId-container")
	public WebElement Plot_Name;

	@FindBy(id = "select2-cropName-container")
	public WebElement Crop;

	@FindBy(id = "select2-variety-container")
	public WebElement Variety;

	@FindBy(id = "select2-harvestType-container")
	public WebElement Harvest_Type;

	@FindBy(id = "select2-grade-container")
	public WebElement Grade;

	@FindBy(id = "quantityInBags")
	public WebElement Quantity_harvested_Bags;

	@FindBy(id = "quantityInKg")
	public WebElement Quantity_harvested_Kg;

	@FindBy(id = "add")
	public WebElement Product_Add;

	@FindBy(id = "select2-farmerId-container")
	public WebElement Farmer_Name2;

	@FindBy(xpath = "(//table[@id='packhouseIncomingContent']//thead/tr/th)[position()<9]")
	public List<WebElement> Details_Table_Header;

	@FindBy(xpath = "(//table[@id='packhouseIncomingContent'])/tbody/tr")
	public List<WebElement> Details_Table_Rows;

	@FindBy(xpath = "((//table[@id='packhouseIncomingContent'])/tbody/tr[1]/td)[position()<9]")
	public List<WebElement> Details_Table_Cell_In_Each_Row;

	@FindBy(id = "buttonAdd")
	public WebElement Save;

	@FindBy(xpath = "/html/body/div[3]/div[1]/div[1]/div/div[6]/ul/li")
	public WebElement Header_Home;

	@FindBy(xpath = "/html/body/div[3]/div[1]/div[1]/div/div[6]/ul/li/ul/li[4]/a")
	public WebElement Logout;

	public String CropHarvestAct() throws Exception 
	{
		try
		{
		mouseHoverAndClickOnElement(service);
		Thread.sleep(4000);
		clickingOnWebElement(Crop_Harvest, 20);
		clickingOnWebElement(Add_Crop_Harvest, 20);
		String dateString1 = "02-04-2024";
		setDatePickerValue(Harvest_Date, dateString1);
		selectDropdownValue1(Village, "Biyamusu - V00008");

		// Product 1
		selectDropdownValue1(Farmer_Name, "kishore -D0009");
		selectDropdownValue1(Plot_Name, "P0009");
		selectDropdownValue1(Crop, "Wheat");
		selectDropdownValue1(Variety, "Norman");
		selectDropdownValue1(Harvest_Type, "Manuals");
		selectDropdownValue1(Grade, "WGradeV3G01");
		senKeysWebElement(Quantity_harvested_Bags, "50");
		senKeysWebElement(Quantity_harvested_Kg, "15");
		Product_Add.click();

		// Product 2
		selectDropdownValue1(Farmer_Name, "Vinicius-TTS201");
		selectDropdownValue1(Plot_Name, "TTS201");
		selectDropdownValue1(Crop, "Wheat");
		selectDropdownValue1(Variety, "Norman");
		selectDropdownValue1(Harvest_Type, "Combine Harvester");
		selectDropdownValue1(Grade, "WGradeV3G01");
		senKeysWebElement(Quantity_harvested_Bags, "15");
		senKeysWebElement(Quantity_harvested_Kg, "10");
		Product_Add.click();
		

		// Printing the Info Table
		// System.out.println("Table headers...");
		for (int i = 0; i < Details_Table_Header.size(); i++) {
			System.out.print("|\t" + Details_Table_Header.get(i).getText() + "\t");
		}
		// System.out.println("Table rows...");
		System.out.print("|\n");
		String cell_value;
		String cell_xpath;
		cell_xpath = "((//table[@id='packhouseIncomingContent'])/tbody/tr[{n}]/td)[position()<9]";
		List<WebElement> cell_data_list;
		// System.out.println("Details_Table_Rows: "+Details_Table_Rows.size());

		// Get the total number of rows
		for (int j = 0; j < Details_Table_Rows.size(); j++) {
			cell_data_list = driver.findElements(By.xpath(cell_xpath.replace("{n}", Integer.toString(j + 1))));
			// Print each row in for loop
			for (int k = 0; k < Details_Table_Cell_In_Each_Row.size(); k++) {
				cell_value = cell_data_list.get(k).getText();
				System.out.print("|\t" + cell_value + "\t");
			}
			System.out.print("|\n");
		}

		Save.click();
		acceptAlert(driver);
		outcome = "Crop Harvest added successfully.";
		Thread.sleep(3000);
        //return true;

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
				// }catch(Exception e) {
				// System.out.println(e);
				//  }

				return outcome;
		} catch (Exception e) {
			return "Exception: " + e + " occurred in CropHarvest";

		}

	}
}
