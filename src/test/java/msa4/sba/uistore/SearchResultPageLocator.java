package msa4.sba.uistore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPageLocator
{
	public WebElement resTop;
	
	public SearchResultPageLocator(WebDriver driver)
	{
		this.resTop = driver.findElement(By.xpath("//h1[contains(@class,'search-heading')]"));
	}
}
