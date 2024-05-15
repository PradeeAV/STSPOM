package pageObject;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;

public class FarmerFman extends commonComponents {
	public FarmerFman(WebDriver driver) throws IOException {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	private static final String CONFIG_FILE_PATH = "C:\\Users\\HP\\eclipse-workspace\\STSPOM\\config.properties";

	String outcome;

	// Farmer Detail

	@FindBy(xpath = "//body/div[4]/ul[1]/li[4]/a[1]/i[1]")
	public WebElement service;

	@FindBy(xpath = "/html/body/div[4]/ul/li[4]/ul/li[2]/a")
	public WebElement FarmerRegistration;

	@FindBy(id = "addService")
	public WebElement Add;

	@FindBy(id = "select2-placeOfReg-container")
	WebElement EnrollmentPlaceDropdown;

	@FindBy(xpath = "//li[@class='select2-results__option']")
	public List<WebElement> EnrollmentplaceList;

	@FindBy(id = "select2-season-container")
	public WebElement Season;

	@FindBy(xpath = "//li[@class='select2-results__option']")
	public List<WebElement> SeasonList;

	@FindBy(id = "select2-IsCertificationFarmer-container")
	public WebElement IstheFarmerCertified;

	@FindBy(xpath = "//li[@class='select2-results__option']")
	public List<WebElement> IstheFarmerCertifiedList;

	@FindBy(name = "farmer.icsname")
	public WebElement ICSName;

	@FindBy(name = "farmer.icscode")
	public WebElement ICSCode;

	@FindBy(id = "select2-Certificationtype-container")
	public WebElement CertificationType;

	@FindBy(xpath = "//input[@id='enrollmentDate']")
	public WebElement EnrollmentDate;

	@FindBy(id = "farmerOldNew1")
	public WebElement FarmerNew;

	// @FindBy(id="farmerOldNew0")
	// public WebElement FarmerOld;

	@FindBy(name = "farmerCodeNew")
	public WebElement NewFarmerCode;

	@FindBy(id = "govScheme")
	public WebElement BeneficiaryInGovernmentScheme;

	@FindBy(id = "SchemeName")
	public WebElement NameoftheScheme;

	@FindBy(id = "Goverdepartment")
	public WebElement GovernmentDepartment;

	// Personal Information
	@FindBy(id = "farmerName")
	public WebElement FarmersFirstName;

	@FindBy(id = "fatherName")
	public WebElement FarmersSurname;

	@FindBy(id = "select2-gender-container")
	public WebElement Gender;

	@FindBy(xpath = "//li[@class='select2-results__option']")
	public List<WebElement> GenderList;

	@FindBy(id = "select2-education-container")
	public WebElement Education;

	@FindBy(id = "calendar")
	public WebElement DOB;

	@FindBy(id = "files")
	public WebElement FarmerPhoto;

	@FindBy(id = "select2-ageRange-container")
	public WebElement AgeRange;

	@FindBy(xpath = "//li[@class='select2-results__option']")
	public List<WebElement> Age;

	@FindBy(id = "select2-MaritalStatus-container")
	public WebElement MartialStatus;

	@FindBy(xpath = "//li[@class='select2-results__option']")
	public List<WebElement> Martial;

	@FindBy(id = "idProofNumber")
	public WebElement BVN;

	@FindBy(id = "file")
	public WebElement FarmerIdProofPhoto;

	@FindBy(id = "select2-category-container")
	public WebElement Category;

	@FindBy(xpath = "//li[@class='select2-results__option']")
	public List<WebElement> Category1;

	@FindBy(id = "select2-religion-container")
	public WebElement Religion;

	@FindBy(xpath = "//li[@class='select2-results__option']")
	public List<WebElement> Religion1;

	// Contact Information

	@FindBy(id = "address")
	public WebElement FarmerAddress;

	@FindBy(id = "mobileNumber1")
	public WebElement MobileNumber1;

	@FindBy(id = "mobileNumber2")
	public WebElement MobileNumber2;

	@FindBy(id = "email")
	public WebElement Email;

	@FindBy(id = "select2-country-container")
	public WebElement Country;

	@FindBy(xpath = "//li[@class='select2-results__option']")
	public List<WebElement> Country1;

	@FindBy(id = "select2-state-container")
	public WebElement State;

	@FindBy(xpath = "//li[@class='select2-results__option']")
	public List<WebElement> State1;

	@FindBy(id = "select2-localities-container")
	public WebElement LGA;

	@FindBy(xpath = "//li[@class='select2-results__option']")
	public List<WebElement> LGA1;

	@FindBy(id = "select2-village-container")
	public WebElement Village;

	@FindBy(xpath = "//li[@class='select2-results__option']")
	public List<WebElement> Village1;

	@FindBy(id = "select2-cluster-container")
	public WebElement Group;

	@FindBy(xpath = "//li[@class='select2-results__option']")
	public List<WebElement> Group1;

	// Loan Details

	@FindBy(id = "select2-loanTakenThisSeason-container")
	public WebElement LoanTakenthisSeason;

	@FindBy(xpath = "//li[@class='select2-results__option']")
	public List<WebElement> LoanTakenthisSeason1;

	@FindBy(id = "loanRepayDate")
	public WebElement LoanRepaymentDate;

	// Bank Information

	@FindBy(id = "addBankDetail")
	public WebElement AddBank;

	@FindBy(name = "accType")
	public WebElement AccountType;

	@FindBy(id = "accHolder")
	public WebElement AccountNumber;

	@FindBy(id = "accName")
	public WebElement AccountName;

	@FindBy(id = "accNo")
	public WebElement BankName;

	@FindBy(id = "ifsc")
	public WebElement BranchDetails;

	@FindBy(id = "saveBankDetail")
	public WebElement Save;

	@FindBy(id = "agree")
	public WebElement Agree;

	@FindBy(id = "buttonAdd")
	public WebElement Save1;

	@FindBy(id = "buttonAdd")
	public WebElement Ok;

	public String FarmerAct() throws Exception {
		try {
			// Farmer Detail
			mouseHoverAndClickOnElement(service);
			Thread.sleep(2000);
			clickingOnWebElement(FarmerRegistration, 20);
			clickingOnWebElement(Add, 20);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//selectDropdownValue1(EnrollmentPlaceDropdown, "On the field");
			String dateString = "19-01-2024";
			setDatePickerValue(EnrollmentDate, dateString);
			selectDropdownValue2(Season, "2023-24 Wheat Planting Season");
			selectDropdownValue2(IstheFarmerCertified, "Yes");
			senKeysWebElement(ICSName, "44555");
			senKeysWebElement(ICSCode, "IC19877");
			selectDropdownValue2(CertificationType, "Type2_W");
			// clickingOnWebElement(FarmerNew,20);
			selectRadioButton(FarmerNew, "Farmer");
			Thread.sleep(1000);
			senKeysWebElement(NewFarmerCode, "1245929");
			senKeysWebElement(BeneficiaryInGovernmentScheme, "Ujwal scheme");
			senKeysWebElement(NameoftheScheme, "DOC scheme");
			senKeysWebElement(GovernmentDepartment, "Agri Department");

			// Personal Information
			senKeysWebElement(FarmersFirstName, "Manu");
			senKeysWebElement(FarmersSurname, "Antony");
			selectDropdownValue2(Gender, "Male");
			selectDropdownValue2(Education, "Secondary");
			String dateString1 = "11-01-2014";
			setDatePickerValue(DOB, dateString1);
			// Thread.sleep(1000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,600)", "");
			FarmerPhoto.sendKeys("E:\\Farmer image.jpg");
			selectDropdownValue2(AgeRange, "30-45");
			selectDropdownValue2(MartialStatus, "Married");
			senKeysWebElement(BVN, "02365897456");
			FarmerIdProofPhoto.sendKeys("E:\\id photo.jpg");
			selectDropdownValue2(Category, "Seed production");
			selectDropdownValue2(Religion, "Hindu");

			// Contact Information
			senKeysWebElement(FarmerAddress, "10-iob street,RS Puram,CBE-10");
			senKeysWebElement(MobileNumber1, "09942456789");
			senKeysWebElement(MobileNumber2, "08967888885");
			senKeysWebElement(Email, "pradesh@sourcetrace.com");
			selectDropdownValue2(Country, "C006-Kenya");
			selectDropdownValue2(State, "S00022-Kwale");
			selectDropdownValue2(LGA, "D00045-Nairobia county");
			selectDropdownValue2(Village, "V00080-Nairobi");
			selectDropdownValue2(Group, "FA00018-Ikara LGA Farmers");

			// Loan Details
			selectDropdownValue2(LoanTakenthisSeason, "1.5");
			String dateString2 = "17-01-2024";
			setDatePickerValue(LoanRepaymentDate, dateString2);

			// Bank Information
			AddBank.click();
			Thread.sleep(1000);
			selectByIndex(AccountType, 2);
			senKeysWebElement(AccountNumber, "0098778877788777");
			senKeysWebElement(AccountName, "Raja");
			senKeysWebElement(BankName, "SBI");
			senKeysWebElement(BranchDetails, "10-RS PURAM BRANCH,CBE");
			Save.click();
			Agree.click();
			Save1.click();
			Thread.sleep(2000);
			acceptAlert(driver);
			outcome = "Farmer registered successfully.";

			
//	Comment next 15 for Negative Test Cases
			 String actual_error =driver.findElement(By.xpath("//*[@id=\"validateError\"]")).getText();
			 System.out.println("Error message: " + actual_error);
			 String expected_error = "Mobile Number1 should be 11 Digits";
			 Assert.assertEquals(actual_error, expected_error);
			 try {
			 if (actual_error.equalsIgnoreCase(expected_error)) {
			 return "\'Mobile Number1 should be 11 Digits\' Error message is displayed successfully";
			 } else {
			 return "\'Mobile Number1 should be 11 Digits\' Error message is not displayed";
			 }
			 }catch(Exception e) {
			 System.out.println(e);
			  }
					
			return outcome;

		} catch (Exception e) {
			return "Exception: " + e + " occurred in FarmerFmanTest.";

		}

	}
}
