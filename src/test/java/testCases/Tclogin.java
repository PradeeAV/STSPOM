package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import commonFunctions.commonFunctions;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObject.CropHarvest;
import pageObject.DistributiontoMobileUser;
import pageObject.FarmFman;
import pageObject.FarmerFman;
import pageObject.InputDistribution;
//import pageObject.Fmanlogin;
import pageObject.LoginFman;
import pageObject.Procurement;
import pageObject.SowingFman;
import pageObject.Training;
import pageObject.Warehousestock;
import pageObject.commonComponents;

//	@Listeners(TestExecutionListener.class)

public class Tclogin {
	public commonFunctions Commonfunctions;
	public LoginFman loginFman;
	public FarmerFman farmerFman;
	public ExtentReports report = new ExtentReports();
	public ExtentSparkReporter spark_report = new ExtentSparkReporter("extent-report.html");
	public ExtentTest test;

	public static WebDriver driver;

	@BeforeTest
	public void startTest() {
		System.out.println("Inside startTest function...");
		spark_report.config().setReportName("FMAN Extent report");
		report.attachReporter(spark_report);
	}

	@Test(priority = 0, enabled = true)
	public void Fman_Login_Test() throws IOException, Exception {
		test = report.createTest("launchBrowser");
		System.out.println("In Test, start test initialised...");
		Commonfunctions = new commonFunctions();
		driver = Commonfunctions.launchBrowser();
		LoginFman login = PageFactory.initElements(driver, LoginFman.class);
		System.out.println("login Object initialised...");
		try {
			boolean logged_in = login.loginAct();
			if (logged_in) {
				test.log(Status.PASS, "Login Test passed...");
				test.pass("User login is successful.");
			} else {
				test.log(Status.FAIL, "Login Test failed...");
				test.fail("User login failed.");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Exception occurred: " + e.getMessage());
			System.out.println(e);
			test.fail("User login failed due to " + e.getCause() + " exception.");
		}
	}

	@Test(priority = 1, enabled = true)
	public void FarmerFmanTest() throws IOException, Exception {
		ExtentTest test = report.createTest("FarmerFmanTest");
		FarmerFman farmer = PageFactory.initElements(driver, FarmerFman.class);

		try {
			String FarmerFmanTest_Result = farmer.FarmerAct();
			if (FarmerFmanTest_Result=="\'Mobile Number1 should be 11 Digits\' Error message is displayed successfully." || FarmerFmanTest_Result=="Farmer registered successfully.") {
				test.log(Status.PASS, FarmerFmanTest_Result+" FarmerFmanTest passed...");
				test.pass("FarmerFmanTest verified");
			} else if(FarmerFmanTest_Result=="\'Mobile Number1 should be 11 Digits\' Error message is not displayed."){
				test.log(Status.FAIL, FarmerFmanTest_Result+" FarmerFmanTest failed...");
				test.fail("FarmerFmanTest failed.");
			} else {
				test.log(Status.FAIL, FarmerFmanTest_Result);
				test.fail(FarmerFmanTest_Result);
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Exception occurred: " + e.getMessage());
			System.out.println(e);
			test.fail("FarmerFmanTest failed due to " + e.getCause() + " exception.");
		}
		
	}
	
	@Test(priority = 2, enabled = false)
	public void FarmerFmanTest1() throws IOException, Exception {
		ExtentTest test = report.createTest("FarmerFmanTest");
		FarmerFman farmer = PageFactory.initElements(driver, FarmerFman.class);

		try {
			String FarmerFmanTest_Result = farmer.FarmerAct();
			if (FarmerFmanTest_Result=="\'Please Select Enrollment Place\' Error message is displayed successfully." || FarmerFmanTest_Result=="Farmer registered successfully.") {
				test.log(Status.PASS, FarmerFmanTest_Result+" FarmerFmanTest passed...");
				test.pass("FarmerFmanTest verified");
			} else if(FarmerFmanTest_Result=="\'Please Select Enrollment Place\' Error message is not displayed."){
				test.log(Status.FAIL, FarmerFmanTest_Result+" FarmerFmanTest failed...");
				test.fail("FarmerFmanTest failed.");
			} else {
				test.log(Status.FAIL, FarmerFmanTest_Result);
				test.fail(FarmerFmanTest_Result);
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Exception occurred: " + e.getMessage());
			System.out.println(e);
			test.fail("FarmerFmanTest failed due to " + e.getCause() + " exception.");
		}
		
	}


	@Test(priority = 3, enabled = false)
	public void FarmFmanTest() throws IOException, Exception {
		ExtentTest test = report.createTest("FarmFmanTest");

		FarmFman farm = PageFactory.initElements(driver, FarmFman.class);
		try {
			String FarmFmanTest_Result = farm.FarmAct();
			if (FarmFmanTest_Result=="\'Please Enter Plot Id\' Error message is displayed successfully." || FarmFmanTest_Result=="Farm registered successfully.") {
				test.log(Status.PASS, FarmFmanTest_Result+" FarmFmanTest passed...");
				test.pass("FarmFmanTest verified");
			} else if(FarmFmanTest_Result=="\'Please Enter Plot Id\' Error message is not displayed."){
				test.log(Status.FAIL, FarmFmanTest_Result+" FarmFmanTest failed...");
				test.fail("FarmerFmanTest failed.");

			} else {
				test.log(Status.FAIL, FarmFmanTest_Result);
				test.fail(FarmFmanTest_Result);
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Exception occurred: " + e.getMessage());
			System.out.println(e);
			test.fail("FarmFmanTest failed due to " + e.getCause() + " exception.");
		}
	}

	@Test(priority = 4, enabled = false)
	public void SowingFmanTest() throws IOException, Exception {
		
		ExtentTest test = report.createTest("SowingFmanTest");

		SowingFman sowing = PageFactory.initElements(driver, SowingFman.class);
		try {
			String SowingFmanTest_Result = sowing.SowingAct();
			if (SowingFmanTest_Result=="\'Please Select Season\' Error message is displayed successfully." || SowingFmanTest_Result=="Sowing registered successfully.") { 
				test.log(Status.PASS, SowingFmanTest_Result+" SowingFmanTest passed...");
				test.pass("SowingFmanTest verified");
			} else if(SowingFmanTest_Result=="\'Please Select Season\' Error message is not displayed."){
				test.log(Status.FAIL, SowingFmanTest_Result+" SowingFmanTest failed...");
				test.fail("SowingFmanTest failed.");
			} else {
				test.log(Status.FAIL, "SowingFmanTest failed...");
				test.fail("SowingFmanTest failed.");
			}
			} catch (Exception e) {
			test.log(Status.FAIL, "Exception occurred: " + e.getMessage());
			System.out.println(e);
			test.fail("SowingFmanTest failed due to " + e.getCause() + " exception.");
		}
		}
	

	//@Test(priority = 5, enabled = false)
	//public void WarehousestockFmanTest() throws IOException, Exception {
		
	//	ExtentTest test = report.createTest("WarehousestockFmanTest");

	//	Warehousestock warehouse = PageFactory.initElements(driver, Warehousestock.class);
	//	try {
	//		String WarehousestockTest_Result = warehouse.WarehousestockAct();
	//		boolean verifyDuplicates_result = warehouse.verifyDuplicates_ReceiptNo();
	//		if (WarehousestockTest_Result && verifyDuplicates_result) {
	//			test.log(Status.PASS, "Test passed...");
	//			test.pass("WarehousestockFmanTest verified");
	//		} else {
	//			test.log(Status.FAIL, "WarehousestockTest failed...");
	//			test.fail("WarehousestockTest failed.");
	//		}
	//	} catch (Exception e) {
	//		test.log(Status.FAIL, "Exception occurred: " + e.getMessage());
	//		System.out.println(e);
	//		test.fail("WarehousestockTest failed due to " + e.getCause() + " exception.");
	//	}
	//}
	
	@Test(priority=6,enabled = false)
	public void WarehousestockFmanTest1() throws IOException, Exception {

	    ExtentTest test = report.createTest("WarehousestockFmanTest1");

	    Warehousestock warehouse = PageFactory.initElements(driver, Warehousestock.class);
	    try {
	        String WarehousestockTest_Result = warehouse.WarehousestockAct();
	        warehouse.verifyDuplicates_ReceiptNo();
	        if (WarehousestockTest_Result != null && !WarehousestockTest_Result.isEmpty()) {
	            test.log(Status.PASS, "Test passed...");
	            test.pass("WarehousestockFmanTest1 verified");
                }else if( WarehousestockTest_Result=="\'Please Select Date\'Error message is not displayed"){
                       test.log(Status.FAIL,WarehousestockTest_Result+" WarehousestockTest failed...");
                       test.fail(" WarehousestockTest failed");
	        } else {
	            test.log(Status.FAIL, "WarehousestockTest failed...");
	            test.fail("WarehousestockTest failed.");
	        }
	    } catch (Exception e) {
	        test.log(Status.FAIL, "Exception occurred: " + e.getMessage());
	        System.out.println(e);
	        test.fail("WarehousestockTest failed due to " + e.getCause() + " exception.");
	    }
	}


	@Test(priority = 7, enabled = false)
	public void DistributiontoMobileUser() throws IOException, Exception {
		ExtentTest test = report.createTest("DistributiontoMobileUser");

		DistributiontoMobileUser distribution = PageFactory.initElements(driver, DistributiontoMobileUser.class);
		//System.out.println("distribution Object initialised...");
		try {
			String DistributionTest_Result = distribution.DistributionAct();
			if (DistributionTest_Result=="\'Please select Warehouse\' Error message is displayed successfully." || DistributionTest_Result=="DistributiontoMobileuser added successfully") {
				test.log(Status.PASS, DistributionTest_Result +"Distributiontomobileuserpassed...");
				test.pass("DistributiontoMobileUser verified");
			}  else if(DistributionTest_Result=="\'Please select Warehouse\' Error message is not displayed."){

				test.log(Status.FAIL, "Distributiontomobileuserfailed...");
				test.fail("DistributiontoMobileUser failed.");
			}else {
				test.log(Status.FAIL, DistributionTest_Result);
				test.fail(DistributionTest_Result);
			}
			}catch (Exception e) {
			test.log(Status.FAIL, "Exception occurred: " + e.getMessage());
			System.out.println(e);
			test.fail("DistributiontoMobileUser failed due to " + e.getCause() + " exception.");
		}
	}
	

	@Test(priority = 8, enabled = false)
	public void InputDistributionFman() throws IOException, Exception {
		ExtentTest test = report.createTest("InputDistributionFman");

		InputDistribution idistribution = PageFactory.initElements(driver, InputDistribution.class);
		try {
			String InputDistributionTest_Result = idistribution.InputDistributionAct();
			if (InputDistributionTest_Result=="\'Please Select Farmer\' Error message is displayed successfully." || InputDistributionTest_Result=="InputDistribution added successfully.") {
				test.log(Status.PASS, InputDistributionTest_Result+"InputDistributionTest passed...");
				test.pass("InputDistributionFman verified");
			} else if(InputDistributionTest_Result=="\'Please Select Farmer\' Error message is not displayed."){
				test.log(Status.FAIL, InputDistributionTest_Result+" InputDistributionTest failed...");
				test.fail("InputDistributionTest failed.");

			} else {
				test.log(Status.FAIL, "InputDistribution failed...");
				test.fail("InputDistribution failed.");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Exception occurred: " + e.getMessage());
			System.out.println(e);
			test.fail("InputDistribution failed due to " + e.getCause() + " exception.");
		}
	}

	@Test(priority = 9, enabled = false)
	public void TrainingFman() throws IOException, Exception {
		ExtentTest test = report.createTest("TrainingFman");

		Training training = PageFactory.initElements(driver, Training.class);
		try {
			String Training_Result = training.TrainingAct();
			if (Training_Result=="\'Please select Village\' Error message is displayed successfully." || Training_Result=="Training registered successfully.") {
				test.log(Status.PASS, Training_Result+" TriningFmanTest failed...");
				test.pass("TrainingFmanTest verified");
			} else if(Training_Result=="\'Please select Village\' Error message is not displayed."){
				test.log(Status.FAIL, Training_Result+" TrainingFmanTest failed...");
				test.fail("TrainingFmanTest failed.");

			} else {
				test.log(Status.FAIL, "TrainingFman failed...");
				test.fail("TrainingFman failed.");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Exception occurred: " + e.getMessage());
			System.out.println(e);
			test.fail("TrainingFman failed due to " + e.getCause() + " exception.");
		}
	}

	@Test(priority = 10, enabled = false)
	public void CropHarvestFman() throws IOException, Exception {
		ExtentTest test = report.createTest("CropHarvestFman");

		CropHarvest harvest = PageFactory.initElements(driver, CropHarvest.class);
		try {
			String CropHarvest_Result = harvest.CropHarvestAct();
			if (CropHarvest_Result=="\'Please select Date\' Error message is displayed successfully." || CropHarvest_Result=="Crop Harvest added successfully.") {
				test.log(Status.PASS, CropHarvest_Result+"CropHarvestTest passed...");
				test.pass("CropHarvestFman verified");
			} else if(CropHarvest_Result=="\'Please select Date\' Error message is not displayed."){
				test.log(Status.FAIL, CropHarvest_Result+" CropHarvestTest failed...");
				test.fail("CropHarvestTest failed.");

			} else {
				test.log(Status.FAIL, CropHarvest_Result);
				test.fail(CropHarvest_Result);
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Exception occurred: " + e.getMessage());
			System.out.println(e);
			test.fail("CropHarvestFman failed due to " + e.getCause() + " exception.");
		}
	}

	@Test(priority = 11, enabled = false)
	public void ProcurementFman() throws IOException, Exception {
		ExtentTest test = report.createTest("ProcurementFman");
		Procurement procure = PageFactory.initElements(driver, Procurement.class);
		try {
			boolean Procurement_Result = procure.ProcurementAct();
			if (Procurement_Result) {
		test.log(Status.PASS, "Test passed...");
		test.pass("ProcurementFman verified");
			} else {
				test.log(Status.FAIL, "ProcurementFman failed...");
				test.fail("ProcurementFman failed.");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Exception occurred: " + e.getMessage());
			System.out.println(e);
			test.fail("ProcurementFman failed due to " + e.getCause() + " exception.");
		}
	}

	// @Test
	@AfterSuite
	public void endSuite() {
		// report.removeTest(test);
		report.flush();
		// driver.close();
		// driver.quit();
	}

}
