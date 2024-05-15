package pageObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Properties;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonFunctions.commonFunctions;

public class commonComponents extends commonFunctions

{
	public static WebDriver driver;
	Properties pro;

// This is for Click Action	
	public void clickingOnWebElement(WebElement element, long waitTimeInSeconds) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeInSeconds));
		WebElement elements = null;
		elements = wait.until(ExpectedConditions.elementToBeClickable(element));
		elements.click();
	}

// This is for sendKeys Action :: on the Text field

	public void senKeysWebElement(WebElement element, String text) {
		clickingOnWebElement(element, 20);
		element.click();
		element.clear();
		element.sendKeys(text);

	}

// This is for Drop down list Action
	public static WebElement getElement(By locator) {
		try {
			return driver.findElement(locator);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void selectByVisibleText(WebElement element, String text) {

		Select select = new Select((element));
		select.selectByVisibleText(text);
	}

	public static void selectByIndex(WebElement element, int Index) {
		Select select = new Select(element);
		select.selectByIndex(Index);
	}

	public static void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

// Bootstarp Dropdown

	public static void selectDropdownValue1(WebElement element, String valuetobeselected) {
		element.click();

		List<WebElement> fieldname = driver.findElements(By.xpath("//li[@class='select2-results__option']"));

		for (WebElement value : fieldname) {
			// System.out.println(value.getText());
			String innerhtml = value.getAttribute("innerHTML");
			// System.out.println("Values from dropdown is =======" +innerhtml);
			if (innerhtml.equals(valuetobeselected)) {
				value.click();
				System.out.println("Selected dropdown value is =======" + valuetobeselected);
				break;
			}
		}
	}

	public static void selectDropdownValue2(WebElement element, String valuetobeselected) {
		element.click();
		List<WebElement> fieldname = driver.findElements(By.xpath("//li[@class='select2-results__option']"));
		for (WebElement value : fieldname) {
			// System.out.println(value.getText());
			String innerhtml = value.getAttribute("innerHTML");
			// System.out.println("Values from dropdown is =======" +innerhtml);
			if (innerhtml.equals(valuetobeselected)) {
				value.click();
				System.out.println("Selected dropdown value is =======" + valuetobeselected);
				break;
			}
		}
	}

	public static void selectDropdownValue3(String classname, String valuetobeselected) {
		WebElement fieldname = driver.findElement(By.className(classname));
		List<WebElement> values = fieldname.findElements(By.className("option"));
		for (WebElement value : values) {
			System.out.println(value.getText());
			if (value.getText().equals(valuetobeselected)) {
				value.click();
				break;
			}
		}
	}

	public static void selectDropdownValue4(String name, String valuetobeselected) {
		WebElement fieldname = driver.findElement(By.name(name));
		List<WebElement> values = fieldname.findElements(By.name("option"));
		for (WebElement value : values) {
			System.out.println(value.getText());
			if (value.getText().equals(valuetobeselected)) {
				value.click();
				break;
			}
		}
	}

	public static void selectDropdownValue5(WebElement element, String valuetobeselected) {
		element.click();
		List<WebElement> fieldname = driver.findElements(By.xpath("//li[@class='select2-results__option']"));
		for (WebElement value : fieldname) {
			// System.out.println(value.getText());
			String innerhtml = value.getAttribute("innerHTML");
			// h System.out.println("Values from dropdown is =======" +innerhtml);
			if (innerhtml.equals(valuetobeselected)) {
				value.click();
				System.out.println("Selected dropdown value is =======" + valuetobeselected);
				break;
			}
		}
	}

// Accepting an Alert

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

//getWindowHandle :::

	public String getCurrentWindowID() {
		return driver.getWindowHandle();
	}

// Date Picker

	public void setDatePickerValue(WebElement element, String dateString) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			js.executeScript("arguments[0].setAttribute('value', '" + dateString + "')", element);
		} catch (Exception e) {
			// Handle potential errors
			e.printStackTrace();
		}
	}

// MouseHoverandClick

	public void mouseHoverAndClickOnElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();
	}

//Radio Button

	public static void selectRadioButton(WebElement element, String value) {
		element.click();
		List<WebElement> radioButtons = driver.findElements(By.id("option"));
		for (WebElement radioButton : radioButtons) {
			if (radioButton.getAttribute("value").equals(value)) {
				radioButton.click();
				return;
			}
		}
	
	}

// Multi Select Dropdown

	public static void selectMultiDropdownValues(WebElement dropdown, ArrayList<String> valuesToBeSelected) {
		dropdown.click();
		System.out.println("Dropdown clicked...");
		List<WebElement> options = driver.findElements(By.xpath("//*[@class='select2-results__options']/li"));
		System.out.println("Options in catalogue: "+options.size()+" items...");
		System.out.println("Passed values to Select in the dropdown: "+valuesToBeSelected.size()+" items...");
		System.out.println("Passed values: "+valuesToBeSelected);
        for(int k=0;k<valuesToBeSelected.size();k++) {
			 System.out.println("Iteration: "+k);
			if(k>0) {
			options = driver.findElements(By.xpath("//*[@class='select2-results__options']/li"));
			}
			String text = options.get(k).getText();
			if (text.equalsIgnoreCase(valuesToBeSelected.get(k))) {
				if (!options.get(k).isSelected()) {
					options.get(k).click();
					System.out.println("Selected dropdown value is: " + valuesToBeSelected.get(k));
				if(k<valuesToBeSelected.size()-1) {
					//if (j < valuesToBeSelected.length - 1) {
					dropdown.click();
					}
				}
				else {
					System.out.println("Dropdown value is already selected: " + valuesToBeSelected.get(k));
				}
			}
			else {
				System.out.println("Value not found...");
			}

			}
		 }
	
	// Scroll Up and Down
	
	public static void scrollDownByPixel(WebDriver driver, int pixels) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0, " + pixels + ")");
	  }
	
	public static void scrollUpByPixel(WebDriver driver, int pixels) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0, -" + pixels + ")"); // Negative value for up
	  }

	public commonComponents() throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\STSPOM\\config.properties");
		pro = new Properties();
		pro.load(fis);

	}

	public String getkey(String key) {
		return this.pro.getProperty(key);
	}
}