package com.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.Table.Cell;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	public String getCellValue(String sheetName, int rownum, int cellnum) throws IOException {
		
		String res = "";

		File file = new File("C:\\Users\\sachin\\eclipse-workspace\\SeleniumFramework\\Excel\\Test hotels.xlsx");

		FileInputStream stream = new FileInputStream(file);

		Workbook workbook = new XSSFWorkbook(stream);

		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet(sheetName);

		Row row = sheet.getRow(rownum);

		org.apache.poi.ss.usermodel.Cell cell = row.getCell(cellnum);

		CellType type = cell.getCellType();

		switch (type) {
		case STRING:
			res = cell.getStringCellValue();

			break;

		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				res = dateFormat.format(dateCellValue);

			} else {
				
//				long d = (long) cell.getNumericCellValue();
//				BigDecimal b = BigDecimal.valueOf(d);
//				String num = b.toString();
//				System.out.println(num);
				
				double numericCellValue = cell.getNumericCellValue();
//
//				// 12.49 --> 12, 12.51 --> 13
				long check = Math.round(numericCellValue);
				if (check == numericCellValue) {
					res = String.valueOf(numericCellValue);

				} else {
					res = String.valueOf(check);
				}
			}
			break;

		default:
			break;
		}
		return res;
	}

	public void modifyCellData(String sheetName, int rownum, int cellnum, String oldData, String newData)
			throws IOException {

		File file = new File("C:\\Users\\sachin\\eclipse-workspace\\SeleniumFramework\\Excel\\Test hotels.xlsx");

		FileInputStream stream = new FileInputStream(file);

		Workbook workbook = new XSSFWorkbook(stream);

		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet(sheetName);

		Row row = sheet.getRow(rownum);

		org.apache.poi.ss.usermodel.Cell cell = row.getCell(cellnum);

		String value = cell.getStringCellValue();

		if (value.equals(oldData)) {
			cell.setCellValue(newData);
		}

		FileOutputStream out = new FileOutputStream(file);

		workbook.write(out);
	}

	public void writeCellData(String sheetName, int rownum, int cellnum, String data) throws IOException {

		File file = new File("C:\\Users\\sachin\\eclipse-workspace\\SeleniumFramework\\Excel\\Test hotels.xlsx");

		FileInputStream stream = new FileInputStream(file);

		Workbook workbook = new XSSFWorkbook(stream);

		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet(sheetName);

		Row row = sheet.getRow(rownum);

		org.apache.poi.ss.usermodel.Cell cell = row.createCell(cellnum);

		cell.setCellValue(data);
		
		FileOutputStream out = new FileOutputStream(file);
		
		workbook.write(out);
	}

	public static void getDriver() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public static void getApplnUrl(String url) {
		driver.get(url);
	}

	public WebElement locatorUsingName(String attributeName) {
		WebElement element = driver.findElement(By.name(attributeName));
		return element;
	}

	public WebElement locatorUsingId(String attributeName) {
		WebElement element = driver.findElement(By.id(attributeName));
		return element;
	}

	public WebElement locatorUsingClassName(String attributeValue) {
		WebElement element = driver.findElement(By.className(attributeValue));
		return element;
	}

	public WebElement locatorUsingXpath(String xpathExp) {
		WebElement element = driver.findElement(By.xpath(xpathExp));
		return element;
	}

	public WebElement locatorUsingTagName(String tagName) {
		WebElement element = driver.findElement(By.tagName(tagName));
		return element;
	}

	public String getApplnTitle() {
		String title = driver.getTitle();
		return title;
	}

	public String getEnteredUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public static void maxiWindow() {
		driver.manage().window().maximize();
	}

	public void elementSendKeys(WebElement element,String text) {
		element.sendKeys(text);
	}

	public void elementSendKeysJs(WebElement element, String text) {
		JavascriptExecutor e = (JavascriptExecutor) driver;
		e.executeScript("arguments[0].setAttribute('value', '" + text + "')", element);
	}

	public void elementClickJs(WebElement element) {
		JavascriptExecutor e = (JavascriptExecutor) driver;
		e.executeScript("arguments[0].click()", element);
	}

	public void elementGetTextBoxValueJs(WebElement element) {
		JavascriptExecutor e = (JavascriptExecutor) driver;
		e.executeScript("return arguments[0].getAtrribute('value')", element);
	}
	
	public void elementScrollDownJs(WebElement element) {
		JavascriptExecutor e = (JavascriptExecutor) driver;
		e.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
	public void elementScrollUpJs(WebElement element) {
		JavascriptExecutor e = (JavascriptExecutor) driver;
		e.executeScript("arguments[0].scrollIntoView(false)", element);
	}

	public void elementClick(WebElement element) {
		element.click();
	}

	public void clearTextBoxElement(WebElement element) {
		element.clear();
	}

	public void closeWindow() {
		driver.close();
	}

	public static void quitWindow() {
		driver.quit();
	}

	public String elementGetText(WebElement element) {
		String text = element.getText();
		return text;
	}

	// 99% --> value fixed
	public String elementGetAttribute(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}

	// 1% --> ?
	public String elementGetAttribute(WebElement element, String attributeName) {
		String attribute = element.getAttribute(attributeName);
		return attribute;
	}

	public void selectOptnByText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void selectOptnByAttribute(WebElement element, String atributeValue) {
		Select select = new Select(element);
		select.selectByValue(atributeValue);
	}

	public void selectOptnByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void deselectAll(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}

	public void deselectByText(WebElement element, String text) {
		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}

	public void deselectByAttribute(WebElement element, String attributeValue) {
		Select select = new Select(element);
		select.deselectByValue(attributeValue);
	}

	public void deselectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
	}

	public WebElement getFirstSelectOptn(WebElement element) {
		Select select = new Select(element);
		WebElement firstSelectedOption = select.getFirstSelectedOption();
		return firstSelectedOption;
	}

	public List<WebElement> getAllSelectOptn(WebElement element) {
		Select select = new Select(element);
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		return allSelectedOptions;
	}

	public boolean verifyMultiText(WebElement element) {
		Select select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;
	}

	public void launchChromeBrowser(String driverPath) {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
	}

	public String parentWindowId() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}

	public Set<String> allWindowID() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}

	public void switchToChildWindow(String windowId) {
		driver.switchTo().window(windowId);
	}

	public void switchToFrameIndex(int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrameName(String name) {
		driver.switchTo().frame(name);
	}

	public void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}

	public void implicityWait(long duration, TimeUnit unit) {
		driver.manage().timeouts().implicitlyWait(duration, unit);
	}

	public WebElement explicitWaitVisibilityOf(Duration timeout, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element2 = wait.until(ExpectedConditions.visibilityOf(element));
		return element2;
	}

	public WebElement explicitWaitVisibilityOfElementLocated(Duration timeout, String attributeValue) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(attributeValue)));
		return element;
	}

	public WebElement explicitWaitElementToBeClickable(Duration timeout, String xpathExpression) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
		return element;
	}

	public Boolean explicitWaitElementToBeSelected(Duration timeout, String attributeValue) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		Boolean boolean1 = wait.until(ExpectedConditions.elementToBeSelected(By.id(attributeValue)));
		return boolean1;
	}

	public Alert explicitWaitAlertPresent(Duration timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		return alert;
	}

	public void pageLoadTimeOut(Duration duration) {
		driver.manage().timeouts().pageLoadTimeout(duration);
	}

	public boolean verifyIsEnabled(WebElement element) {
		boolean enabled = element.isEnabled();
		return enabled;
	}

	public boolean verifyIsDisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;
	}

	public boolean verifyIsSelected(WebElement element) {
		boolean selected = element.isSelected();
		return selected;
	}

	public void ScreenShot(OutputType<Object> target) {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		screenshot.getScreenshotAs(target);
	}

	public void elementScreenShot(WebElement element, OutputType<Object> target) {
		element.getScreenshotAs(target);
	}

	public void moveToElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public void dragAndDrop(WebElement source, WebElement destination) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, destination).perform();
	}

	public void contextClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

	public void doubleClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	public void clickOkAlert() {
		driver.switchTo().alert().accept();
	}

	public void clickCancelAlert() {
		driver.switchTo().alert().dismiss();
	}

	public void navigateUsingUrl(String url) {
		driver.navigate().to(url);
	}

	public void toNavigateBackward() {
		driver.navigate().back();
	}

	public void toNavigateForward() {
		driver.navigate().forward();
	}

	public void toRefreshWebpage() {
		driver.navigate().refresh();
	}

	public void staticWait(long unit) throws InterruptedException  {
		Thread.sleep(unit);
	}

}
