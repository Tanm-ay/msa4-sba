package msa4.sba.pageobject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;

import msa4.sba.uistore.FooterResultPageLocator;
import msa4.sba.uistore.SearchResultPageLocator;
import msa4.sba.utilities.BaseClass;
import msa4.sba.utilities.LogUtil;
import msa4.sba.utilities.Reporting;

public class FooterResultPageObject
{
	public void verifyFooterResult(WebDriver driver, String s)
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
			FooterResultPageLocator footResLoc = new FooterResultPageLocator(driver);
			tmp = footResLoc.beard.getText();
			Assert.assertEquals(tmp, s);
			BaseClass.ts.pass("String found.  Expected [ " + s + " ] , Found [" + tmp + " ]");
			l.info("TC Pass. String found");
			b = false;	
		}
		finally
		{
			if (b)
			{
				BaseClass.ExecutionFlag = true;
				BaseClass.ts.fail("String NOT found. Expected [ " + s + " ] , Found [ " + tmp + " ]", MediaEntityBuilder.createScreenCaptureFromPath(reportObject.screenShot(driver)).build());
				l.error("TC Fail. String NOT found");
			}
			driver.quit();
		}
	}
}
