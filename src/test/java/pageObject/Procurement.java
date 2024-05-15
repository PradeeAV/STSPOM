package pageObject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Procurement  extends commonComponents
{

	public Procurement() throws IOException {
		super();
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	private static final String CONFIG_FILE_PATH = "C:\\Users\\HP\\eclipse-workspace\\STSPOM\\config.properties";
	
	@FindBy(xpath = "//body/div[4]/ul[1]/li[4]/a[1]/i[1]")
    public WebElement service;
	
	@FindBy(xpath ="/html/body/div[4]/ul/li[4]/ul/li[8]/a")
	public WebElement Procurement;
	
	@FindBy(id="addService")
	public WebElement Add_Procurement;
	
	@FindBy(name="Prodate")
	public WebElement Date;
	
	@FindBy(id="select2-season-container")
	public WebElement Season;
	
	@FindBy(id="select2-village-container")
	public WebElement Village;
	
	@FindBy(id="isRegisteredFarmerId0")
	public WebElement Registered_Farmer;
	
	@FindBy(id="select2-farmerId-container")
	public WebElement Farmer;
	
	@FindBy(id="select2-warehouseId-container")
	public WebElement Warehouse_Name;
	
	@FindBy(id="isRegisteredFarmerId1")
	public WebElement Unregistered_Farmer;
	
	@FindBy(id="farmerName")
	public WebElement Farmer_Name;
	
	@FindBy(id="mobileNoInput")
	public WebElement Mobile_Number;
	
	@FindBy(id="select2-productId-container")
	public WebElement Crop_Name;
	
	@FindBy(id="select2-varietyId-container")
	public WebElement Variety;
	
	@FindBy(id="select2-gradeId-container")
	public WebElement Grade;
	
	@FindBy(id="select2-productUnit-container")
	public WebElement Unit;
	
	@FindBy(id="quintalId")
	public WebElement No_of_Bags;
	
	@FindBy(id="grossWeightKgTxt")
	public WebElement Net_Weight;
	
	@FindBy(id="add")
	public WebElement Product_Add;
	
	@FindBy(xpath="//table[@id='procurementDetailTable']//thead/tr/th)[position()<8])")
	public List<WebElement> Details_Table_Header;
	
	@FindBy(xpath="(//table[@id='procurementDetailTable'])/tbody/tr")
	public List<WebElement> Details_Table_Rows;
	
	@FindBy(xpath="((//table[@id='procurementDetailTable'])/tbody/tr[1]/td)[position()<8]")
	public List<WebElement> Details_Table_Cell_In_Each_Row;
	
	@FindBy(id="paymentRupee")
	public WebElement Payment_Amount;
	
	
	
	
	
	
	
	
	
	
	
	
	public boolean ProcurementAct() throws Exception
	{
		mouseHoverAndClickOnElement(service);
		Thread.sleep(4000);
		clickingOnWebElement(Procurement,20);
		clickingOnWebElement(Add_Procurement,20);
		String dateString1 = "26-04-2024";
        setDatePickerValue(Date, dateString1);
        selectDropdownValue1(Season,"2023-24 Wheat Planting Season");
        selectDropdownValue1(Village,"Biyamusu - V00008");
        Registered_Farmer.click();
        selectDropdownValue1(Farmer,"kishore -D0009");
        selectDropdownValue1( Warehouse_Name,"Vino Warehouse");
       // Unregistered_Farmer.click();
      //  senKeysWebElement(Farmer_Name,"Ashok");
      //  senKeysWebElement(Mobile_Number,"9841032785");
      //  selectDropdownValue1( Warehouse_Name,"Vino Warehouse");
        
        selectDropdownValue1(Crop_Name,"Coffee");
        selectDropdownValue1(Variety,"Robusta");
        selectDropdownValue1(Grade,"A+");
        selectDropdownValue1(Unit,"KG");
        senKeysWebElement(No_of_Bags,"20");
        senKeysWebElement(Net_Weight,"100");
        Product_Add.click();
        
        //Printing the Info Table
        for(int i=0;i<Details_Table_Header.size();i++)
        {
        	System.out.print("|\t"+Details_Table_Header.get(i).getText()+"\t");
        }
        System.out.print("|\n");
		String cell_value;
		String cell_xpath;
		cell_xpath = "((//table[@id='procurementDetailTable'])/tbody/tr[{n}]/td)[position()<8]";
		List<WebElement> cell_data_list;
		for(int j=0;j<Details_Table_Rows.size();j++) 
		{
		cell_data_list = driver.findElements(By.xpath(cell_xpath.replace("{n}",Integer.toString(j+1))));
		for(int k=0;k<Details_Table_Cell_In_Each_Row.size();k++) {
			cell_value = cell_data_list.get(k).getText();
			System.out.print("|\t"+cell_value+"\t");
		}
		System.out.print("|\n");
	}
          
        senKeysWebElement(Payment_Amount,"500");
        
		return true;
	}
}
	
	
	

