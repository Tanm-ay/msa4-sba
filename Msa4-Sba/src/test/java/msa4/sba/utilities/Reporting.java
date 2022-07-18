package msa4.sba.utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reporting
{
	LogUtil l = new LogUtil();

	
	public void makeReport()
	{
		BaseClass objTime = new BaseClass();
		String Stamp = objTime.getDateTime();
		String reportPath = "/Reports/Report_" + Stamp + ".html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(new File("." + reportPath));
		BaseClass.ext = new ExtentReports();
		BaseClass.ext.attachReporter(reporter);

	}

	public String screenShot(WebDriver d)
	{
		BaseClass objTime = new BaseClass();
		String path = "";
		try
		{
			String Stamp = objTime.getDateTime();
			path = System.getProperty("user.dir") + "/ScreenShots/FailShot_" + Stamp + ".png";
			File capture = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(capture, new File(path));
		}
		catch (IOException i)
		{
			l.error("Failed to add screenshot to report");
		}
		return path;
	}
}
