package pageObject;

import java.io.IOException;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Warehousestock extends commonComponents {

	public Warehousestock() throws IOException {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	private static final String CONFIG_FILE_PATH = "C:\\Users\\HP\\eclipse-workspace\\STSPOM\\config.properties";
	String outcome;

	@FindBy(xpath = "//body/div[4]/ul[1]/li[4]/a[1]/i[1]")
	public WebElement service;

	@FindBy(xpath = "/html/body/div[4]/ul/li[4]/ul/li[3]/a")
	public WebElement Warehousestock;

	@FindBy(id = "addService")
	public WebElement AddWarehousestock;

	@FindBy(id = "select2-seasonId-container")
	public WebElement Season;

	@FindBy(id = "select2-warehouseId-container")
	public WebElement WarehouseName;

	@FindBy(id = "select2-vendorId-container")
	public WebElement Vendor;

	@FindBy(id = "dateId")
	public WebElement Date;

	@FindBy(id = "select2-productId-container")
	public WebElement Product;

	@FindBy(id = "goodStockId")
	public WebElement GoodQuantity;

	@FindBy(id = "damageStockId")
	public WebElement DamagedQuantity;

	@FindBy(id = "add")
	public WebElement AddProduct;

	@FindBy(xpath = "//*[@id=\"row0\"]/td[7]/button[1]")
	public WebElement ProductEdit;

	@FindBy(id = "add")
	public WebElement After_Edit_AddProduct1;

	@FindBy(id = "sucessbtn")
	public WebElement Save;

	@FindBy(xpath = "//*[@id=\"detail\"]/tbody/tr[1]/td[6]/a")
	public WebElement EditDetail_Grid;

	@FindBy(xpath = "//tbody[@id='warehouseTblBody']//tr[1]/td[7]//*[@class='fa fa-edit']")
	public WebElement EditDetail_EditPage;

	@FindBy(xpath = "//*[@id=\"row1\"]/td[7]/button[1]")
	public WebElement ListpageEdit;

	@FindBy(id = "editstock")
	public WebElement GoodQuantityEdit;

	@FindBy(id = "editdamagQty")
	public WebElement DamagedQuantityEdit;

	@FindBy(xpath = "//*[@id=\"productTblBody\"]/tbody/tr/td[9]/button[1]")
	public WebElement ProductSaveEdit;

	@FindBy(id = "buttonAdd")
	public WebElement Save1;

	@FindBy(xpath = "//*[@id=\"slideModal\"]/div/div/div[2]/button[2]")
	public WebElement Confirmation;

	@FindBy(xpath = "//*[@id=\"slideModal\"]/div/div/div[2]/button")
	public WebElement Edit_Confirmation;

	@FindBy(xpath = "//*[@id=\"detail_info\" and contains(text(),'Showing')]")
	public WebElement Pagination_Results;

	@FindBy(xpath = "//table[@id='detail']/tbody/tr/td[2]")
	public List<WebElement> ReceiptNO_List_Each_page;

	@FindBy(xpath = "//a[@id='detail_next']")
	public WebElement Pagination_Next_Button;

	public String WarehousestockAct() throws Exception 
	{
		try
		{
		mouseHoverAndClickOnElement(service);
		Thread.sleep(2000);
		clickingOnWebElement(Warehousestock, 20);
		clickingOnWebElement(AddWarehousestock, 20);
		selectDropdownValue1(Season, "2023-24 Wheat Planting Season");
		selectDropdownValue1(WarehouseName, "Gombe Warehouse");
		selectDropdownValue1(Vendor, "Wheat Vender A");
		String dateString1 = "";
		setDatePickerValue(Date, dateString1);
		selectDropdownValue1(Product, "Ammonium Sulphate");
		senKeysWebElement(GoodQuantity, "500");
		senKeysWebElement(DamagedQuantity, "10");
		AddProduct.click();
		ProductEdit.click();
		After_Edit_AddProduct1.click();
		Save.click();
		Confirmation.click();
		outcome = "Warehouse stock added successfully";
		mouseHoverAndClickOnElement(service);
		Thread.sleep(2000);
		clickingOnWebElement(Warehousestock, 20);

		// Edit Condition
		
		//Thread.sleep(3000);
		//EditDetail_Grid.click();
		//ListpageEdit.click();
		//GoodQuantityEdit.clear();
		//DamagedQuantityEdit.clear();
		//ProductSaveEdit.click();
		//String actual_error = driver.findElement(By.xpath("//*[@id=\"validateError\"]")).getText();
		//System.out.println("Good Quantity is" + actual_error);
		//String expected_error = "Please Enter Good Quantity";
		//Assert.assertEquals(actual_error, expected_error);
		//Save1.click();
	//	Edit_Confirmation.click();

		}
		catch(Exception e) {
			System.out.println("Exception "+e+" occurred...");
		}
		return outcome;

	}
		 //return true;
	
	


		

	
	//Finding the Duplicate Receipts

	public String verifyDuplicates_ReceiptNo() throws InterruptedException {
		try
		{
	
		// Fetch the total results number.
		// Divide by 10. We get the number of pages.
		// For loop for number of pages.
		// Fetch all Receipt numbers.
		// Compare all receipt numbers.
		//

		mouseHoverAndClickOnElement(service);
		Thread.sleep(2000);
		clickingOnWebElement(Warehousestock, 20);

		String pagination = Pagination_Results.getText().toString();
		String[] split_list = pagination.split(" ");
		int total_results = Integer.parseInt(split_list[5]);
		int total_pages;
		int count = 0;

		System.out.println("Total results: " + total_results);
		// total_results mod 10 gives the remainder for last page results...
		if (total_results % 10 == 0) {
			total_pages = total_results / 10;
		} else {
			total_pages = (total_results / 10) + 1;
		}
		System.out.println("Total pages: " + total_pages);
		Set<String> duplicateValues = new HashSet<>();
		Set<String> uniqueValues = new HashSet<>();
		String[] Receipt_No = new String[total_results];
		WebDriverWait grid_wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> grid_receipt_no;

		for (int i = 0; i < total_pages; i++) {
			for (int j = 0; j < ReceiptNO_List_Each_page.size(); j++) {
          grid_receipt_no = driver.findElements(By.xpath("//table[@id='detail']/tbody/tr/td[2]"));
				Receipt_No[count] = grid_receipt_no.get(j).getText();
				if (!uniqueValues.add(Receipt_No[count])) {
					duplicateValues.add(Receipt_No[count]);
				}
				count++;

			}
			Pagination_Next_Button.click();
			Thread.sleep(4000);
			grid_wait.until(
					ExpectedConditions.presenceOfElementLocated(By.xpath("(//table[@id='detail']/tbody/tr/td[2])[1]")));
		}

		System.out.println("Duplicate values: ");
		for (String duplicate : duplicateValues) {
			System.out.println(duplicate);
		}
		Assert.assertTrue(duplicateValues.isEmpty());
		Thread.sleep(3000);
		//return true;
	
	



//Comment next 15 for Negative Test Cases
		 String actual_error =
		 driver.findElement(By.xpath("//*[@id=\"validateError\"]")).getText();
		 System.out.println("Error message: " + actual_error);
		 String expected_error = "Please Select Date";
		 Assert.assertEquals(actual_error, expected_error);
		 try {
		 if (actual_error.equalsIgnoreCase(expected_error)) {
		 return "\'Please Select Date\' Error message is displayed successfully";
   } else {
		 return "\'Please Select Date\' Error message is not displayed";
		 }
		 }catch(Exception e) {
		 System.out.println(e);
		  }


	} catch (Exception e) {
		System.out.println("Exception: " +e+ " occurred in Warehousestock.");

	}
		return outcome;
	}
	}
	


