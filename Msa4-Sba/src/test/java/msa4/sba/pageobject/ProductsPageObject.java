package msa4.sba.pageobject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;

import msa4.sba.reusablemethods.ReusableMethods;
import msa4.sba.uistore.ProductsPageLocator;
import msa4.sba.utilities.BaseClass;
import msa4.sba.utilities.LogUtil;
import msa4.sba.utilities.Reporting;


public class ProductsPageObject
{
	public void verifyProductResult(WebDriver driver,String s)
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
			ProductsPageLocator productObjectLoc = new ProductsPageLocator(driver);
			if(productObjectLoc.gillete.getText().contains(s))
			{
				tmp = tmp.substring(1, tmp.length() - 1);
				BaseClass.ts.pass("String found.  Expected [ " + s + " ]");
				l.info("TC Pass. String found");
				b = false;
			}	
		}
		finally
		{
			if (b)
			{
				BaseClass.ExecutionFlag = true;
				BaseClass.ts.fail("String NOT found. Expected [ " + s + " ]", MediaEntityBuilder.createScreenCaptureFromPath(reportObject.screenShot(driver)).build());
				l.error("TC Fail. String NOT found");
			}
			driver.quit();
		}
	}
}
