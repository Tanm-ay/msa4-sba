package msa4.sba.pageobject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;

import msa4.sba.reusablemethods.ReusableMethods;
import msa4.sba.uistore.ProductsPageLocator;
import msa4.sba.uistore.SearchResultPageLocator;
import msa4.sba.utilities.BaseClass;
import msa4.sba.utilities.LogUtil;
import msa4.sba.utilities.Reporting;

public class SearchResultPageObject
{
	public void verifySearchResult(WebDriver driver,String s)
	{
		Reporting reportObject = new Reporting();
		LogUtil l = new LogUtil();

		if (BaseClass.ExecutionFlag)
		{
			driver.quit();
			Assert.fail();
		}
		boolean b = true;
		String tmp = "";
		try
		{
			SearchResultPageLocator searchRestLoc = new SearchResultPageLocator(driver);
			tmp = searchRestLoc.resTop.getText();
			Assert.assertEquals(tmp, s);
			BaseClass.ts.pass("String macthed.  Expected [ " + s + " ] , Found [" + tmp + " ]");
			l.info("TC Pass. String matched");
			b = false;	
		}
		finally
		{
			if (b)
			{
				BaseClass.ExecutionFlag = true;
				BaseClass.ts.fail("String NOT macthed. Expected [ " + s + " ] , Found [ " + tmp + " ]", MediaEntityBuilder.createScreenCaptureFromPath(reportObject.screenShot(driver)).build());
				l.error("TC Fail. String NOT matched");
			}
			driver.quit();
		}
	}
}
