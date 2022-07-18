package msa4.sba.uistore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPageLocator
{
	public WebElement gillete;
	
	public ProductsPageLocator(WebDriver driver)
	{
		this.gillete = driver.findElement(By.xpath("//div[contains(@class,'leading-24 md:leading-26')]"));
	}
}
