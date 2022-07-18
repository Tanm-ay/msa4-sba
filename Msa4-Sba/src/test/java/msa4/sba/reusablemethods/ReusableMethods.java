package msa4.sba.reusablemethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import msa4.sba.utilities.LogUtil;

public class ReusableMethods
{
	LogUtil l = new LogUtil();

	public void stringKeys(WebElement el, String keys)
	{
		el.sendKeys(keys);
		l.debug("Entered the string");
	}

	public void hover(WebElement el,WebDriver driver)
	{
		Actions ac = new Actions(driver);
		ac.moveToElement(el).build().perform();
		l.debug("Hovered over the element");
	}
	public void clickSearch(WebElement button)
	{
		button.click();
		l.debug("Clicked search button");
	}

	public void clickLink(WebElement link)
	{
		link.click();
		l.debug("Clicked the link");
	}

	public void implicitWaitSeconds(WebDriver driver, int waitTime)
	{
		driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
	}

	public void maximize(WebDriver driver)
	{
		driver.manage().window().maximize();
		l.debug("Maximized the browser window");
	}

}
