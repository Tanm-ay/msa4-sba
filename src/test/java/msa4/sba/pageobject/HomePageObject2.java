package msa4.sba.pageobject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;

import msa4.sba.reusablemethods.ReusableMethods;
import msa4.sba.uistore.HomePageLocator2;
import msa4.sba.uistore.HomePageLocators;
import msa4.sba.utilities.BaseClass;
import msa4.sba.utilities.LogUtil;
import msa4.sba.utilities.Reporting;

public class HomePageObject2 {
	LogUtil l = new LogUtil();
	Reporting reportObject = new Reporting();
	ReusableMethods rm = new ReusableMethods();
	
	public void enterIntoSearchBoxEnter(WebDriver driver,String s)
	{
		if (BaseClass.ExecutionFlag)
		{
			driver.quit();
			Assert.fail();
		}
		try
		{
			HomePageLocator2 homeObjectLoc = new HomePageLocator2(driver);
			rm.stringKeys(homeObjectLoc.searchBox,s+Keys.ENTER);
			BaseClass.ts.pass("Entered into search box");
		}
		catch (Exception e)
		{
			BaseClass.ExecutionFlag = true;
			e.getMessage();
			l.error("Search box not found");
			BaseClass.ts.fail("Search box not found", MediaEntityBuilder.createScreenCaptureFromPath(reportObject.screenShot(driver)).build());
		}
	}
}
