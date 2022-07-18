package msa4.sba.pageobject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;

import msa4.sba.reusablemethods.ReusableMethods;
import msa4.sba.uistore.HomePageLocators;
import msa4.sba.utilities.BaseClass;
import msa4.sba.utilities.ExceltUtil;
import msa4.sba.utilities.LogUtil;
import msa4.sba.utilities.Reporting;

public class HomePageObject
{
	ReusableMethods rm = new ReusableMethods();
	Reporting reportObject = new Reporting();
	LogUtil l = new LogUtil();

	public void hoverOnProducts(WebDriver driver)
	{
		if (BaseClass.ExecutionFlag)
		{
			driver.quit();
			Assert.fail();
		}
		try
		{
			HomePageLocators homeObjectLoc = new HomePageLocators(driver);
			rm.hover(homeObjectLoc.products, driver);
			BaseClass.ts.pass("Hovered over "+homeObjectLoc.products.getText());
		}
		catch (Exception e)
		{
			BaseClass.ExecutionFlag = true;
			System.out.println(e.getMessage());
			l.error("Products tab not found");
			BaseClass.ts.fail("Products tab not found", MediaEntityBuilder.createScreenCaptureFromPath(reportObject.screenShot(driver)).build());
		}
	}
	public void clickOnSearchButton(WebDriver driver)
	{
		if (BaseClass.ExecutionFlag)
		{
			driver.quit();
			Assert.fail();
		}
		try
		{
			HomePageLocators homeObjectLoc = new HomePageLocators(driver);
			rm.clickSearch(homeObjectLoc.searchButton);
			BaseClass.ts.pass("Clicked search button");
		}
		catch (Exception e)
		{
			BaseClass.ExecutionFlag = true;
			e.getMessage();
			l.error("Search button not found");
			BaseClass.ts.fail("Search button not found", MediaEntityBuilder.createScreenCaptureFromPath(reportObject.screenShot(driver)).build());
		}
	}
	public void clickOnMach3(WebDriver driver)
	{
		if (BaseClass.ExecutionFlag)
		{
			driver.quit();
			Assert.fail();
		}
		try
		{
			HomePageLocators homeObjectLoc = new HomePageLocators(driver);
			rm.clickLink(homeObjectLoc.mach3);
			BaseClass.ts.pass("Clicked on Mach3");
		}
		catch (Exception e)
		{
			BaseClass.ExecutionFlag = true;
			System.out.println(e.getMessage());
			l.error("Mach3 not found");
			BaseClass.ts.fail("Mach3 not found", MediaEntityBuilder.createScreenCaptureFromPath(reportObject.screenShot(driver)).build());
		}
	}
	
	public void clickOnFooterStyling(WebDriver driver)
	{
		if (BaseClass.ExecutionFlag)
		{
			driver.quit();
			Assert.fail();
		}
		try
		{
			HomePageLocators homeObjectLoc = new HomePageLocators(driver);
			rm.clickLink(homeObjectLoc.footerStylingLink);
			BaseClass.ts.pass("Clicked Styling Link");
		}
		catch (Exception e)
		{
			BaseClass.ExecutionFlag = true;
			e.getMessage();
			l.error("Styling link not found");
			BaseClass.ts.fail("Styling link not found", MediaEntityBuilder.createScreenCaptureFromPath(reportObject.screenShot(driver)).build());
		}
	}
}
