package pageObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Training extends commonComponents
{

	public Training() throws IOException {
		super();
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	private static final String CONFIG_FILE_PATH = "C:\\Users\\HP\\eclipse-workspace\\STSPOM\\config.properties";
	
	String outcome;
	
	
	@FindBy(xpath = "//body/div[4]/ul[1]/li[4]/a[1]/i[1]")
    public WebElement service;

    @FindBy(xpath = "/html/body/div[4]/ul/li[4]/ul/li[6]/a")
    public WebElement Training;
    
    @FindBy(id="add")
    public WebElement TrainingAdd;
    
    @FindBy(id="insDate")
    public WebElement Date;
    
    @FindBy(id="select2-village-container")
    public WebElement Village;
    
    @FindBy(xpath="//*[text()='Training Attended Farmer List']/..//input[@class='select2-search__field']")
    public WebElement Training_Attended_Farmer_List;
    
    @FindBy(id="select2-97-container")
    public WebElement Training_Type;
    
    @FindBy(id="98")
    public WebElement Training_Assistant_Name;
    
    @FindBy(id="96")
    public WebElement No_of_Farmers;
    
    @FindBy(xpath="//*[@id='99']")
    public WebElement TimeTakenforTraining;
    
    @FindBy(id="100")
    public WebElement Remarks;
    
    @FindBy(id="select2-101-container")
    public WebElement Training_Topic_Name;
    
    @FindBy(id="102")
    public WebElement Proposal_Principle;
    
    @FindBy(xpath="//*[text()='Training Materials']/..//input[@class='select2-search__field']")
    public WebElement TrainingMaterials;
    
    @FindBy(xpath="//*[text()='Training Methods']/..//input[@class='select2-search__field']")
    public WebElement TrainingMethods;
    
    @FindBy(xpath="//*[@class='select2-results__options']/li")
    public List<WebElement> TrainingMaterialsAddlist;
    
    @FindBy(id="105")
    public WebElement Training_Observations;
    
    @FindBy(name="C0128")
    public WebElement Training_photo1;
    
    @FindBy(name="C0129")
    public WebElement Training_photo2;
    
    @FindBy(id="sucessbtn")
    public WebElement Save;
    
 
    
    
    public String TrainingAct() throws Exception
	{
    	try
    	{
      
    	mouseHoverAndClickOnElement(service);
    	Thread.sleep(2000);
    	clickingOnWebElement(Training,20);
    	clickingOnWebElement(TrainingAdd,20);
    	String dateString1 = "02-05-2024";
        setDatePickerValue(Date,dateString1);
        selectDropdownValue1(Village,"Biyamusu - V00008");
        
        ArrayList<String> Training_Attended = new ArrayList<String>();
        Training_Attended.add("Select");
        Training_Attended.add("KN045-Habib");
        Training_Attended.add("D0009-kishore ");
        Training_Attended.add("S0002-kannan");
    	
    	//Training Informations
    	
    	selectDropdownValue1(Training_Type,"Own Warehouse_W");
    	Thread.sleep(2000);
    	senKeysWebElement(Training_Assistant_Name,"Jerwin");
    	Thread.sleep(2000);
    	senKeysWebElement(No_of_Farmers,"20");
    	Thread.sleep(2000);
    	senKeysWebElement(TimeTakenforTraining,"2000");
    	Thread.sleep(2000);
    	senKeysWebElement(Remarks,"Good Training");
    	Thread.sleep(2000);
    	selectDropdownValue1(Training_Topic_Name,"demo");
    	Thread.sleep(2000);
    	senKeysWebElement(Proposal_Principle,"Avoid Mobile Phones");
    	
    	
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,600)", "");
    	Thread.sleep(2000);
    	
    	ArrayList<String> materials_valuesToSelect = new ArrayList<String>();
    	materials_valuesToSelect.add("paper");
    	materials_valuesToSelect.add("demo");
    	materials_valuesToSelect.add("Charts");
    	
    	ArrayList<String> methods_valuesToSelect = new ArrayList<String>();
    	methods_valuesToSelect.add("group discussion");
    	
    	 selectMultiDropdownValues(Training_Attended_Farmer_List, Training_Attended);
    	 selectMultiDropdownValues(TrainingMaterials, materials_valuesToSelect);
    	 selectMultiDropdownValues(TrainingMethods, methods_valuesToSelect);
    	 
    	 senKeysWebElement(Training_Observations,"Notes");
    	 Training_photo1.sendKeys("D:\\Seed-Village-visit-scaled.jpg");
    	 Training_photo2.sendKeys("D:\\Farmer Training.jpeg");
    	 Save.click();
    	 Thread.sleep(3000);
    	// return true;
    	 
//    		Comment next 15 for Negative Test Cases
    				// String actual_error =
    				// driver.findElement(By.xpath("//*[@id=\"validateError\"]")).getText();
    				// System.out.println("Error message: " + actual_error);
    				// String expected_error = "Please select Village";
    				// Assert.assertEquals(actual_error, expected_error);
    				// try {
    				// if (actual_error.equalsIgnoreCase(expected_error)) {
    				// return "\'Please select Village\' Error message is displayed successfully";
    				// } else {
    				// return "\'Please select Village\' Error message is not displayed";
    				// }
    				// }catch(Exception e) {
    				// System.out.println(e);
    				//  }

    				return outcome;
    				
	} catch (Exception e) {
		return "Exception: " + e + " occurred in Training";
    	}
}
}