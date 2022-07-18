
package msa4.sba.runner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import msa4.sba.pageobject.FooterResultPageObject;
import msa4.sba.pageobject.HomePageObject;
import msa4.sba.pageobject.ProductsPageObject;
import msa4.sba.pageobject.SearchResultPageObject;
import msa4.sba.utilities.BaseClass;
import msa4.sba.utilities.ExceltUtil;
import msa4.sba.utilities.PropertyUtil;
import msa4.sba.utilities.Reporting;

public class TestRunner
{
	public BaseClass baseObject = null;
	public WebDriver driver = null;
	public Reporting reportObject = null;
	public ExceltUtil getCell = null;
	public PropertyUtil getProp = null;
	public HomePageObject homeObject = null;
	public ProductsPageObject productsObject = null;
	public SearchResultPageObject searchObject = null;
	public FooterResultPageObject footerObject = null;

	@BeforeSuite
	public void extentReport()
	{
		BaseClass.ExecutionFlag = false;
		reportObject = new Reporting();
		reportObject.makeReport();
	}

	@BeforeMethod
	public void newObjects()
	{
		baseObject = new BaseClass();
		homeObject = new HomePageObject();
		getCell = new ExceltUtil();
		getProp = new PropertyUtil();
		productsObject = new ProductsPageObject();
		searchObject = new SearchResultPageObject();
		footerObject = new FooterResultPageObject();
	}

	@Test
	public void hoverClickAndCheck()
	{
		BaseClass.ts = BaseClass.ext.createTest("Click on Mach3 under Products and verify result product");
		driver = baseObject.initializeDriver(5, "Configure", "Chrome");
		baseObject.navigateToUrl(driver, "Configure", "Gillette");
		homeObject.hoverOnProducts(driver);
		homeObject.clickOnMach3(driver);
		productsObject.verifyProductResult(driver, getCell.fetchCellData(2, 'C'));
	}
	
	@Test
	public void footerClickAndCheck()
	{
		BaseClass.ts = BaseClass.ext.createTest("Search in search box and verify the result heading");
		driver = baseObject.initializeDriver(5, "Configure", "Chrome");
		baseObject.navigateToUrl(driver, "Configure", "Gillette");
		homeObject.clickOnSearchButton(driver);
		homeObject.enterIntoSearchBoxEnter(driver,getCell.fetchCellData(2, 'B'));
		searchObject.verifySearchResult(driver, getCell.fetchCellData(2, 'D'));
	}
	
	@Test
	public void stringSearchAndCheck()
	{
		BaseClass.ts = BaseClass.ext.createTest("Click Styling footer link and verify result style text");
		driver = baseObject.initializeDriver(5, "Configure", "Chrome");
		baseObject.navigateToUrl(driver, "Configure", "Gillette");
		homeObject.clickOnFooterStyling(driver);
		footerObject.verifyFooterResult(driver, getCell.fetchCellData(2, 'E'));
	}

	@AfterMethod
	public void flushReport()
	{
		BaseClass.ExecutionFlag = false;
		BaseClass.ext.flush();
	}

}
