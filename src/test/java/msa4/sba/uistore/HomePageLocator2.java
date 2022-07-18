package msa4.sba.uistore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageLocator2 {
	public WebElement searchBox;
	
	public HomePageLocator2(WebDriver driver)
	{
		this.searchBox = driver.findElement(By.xpath("//input[@id='search-box-input']"));
	}
}
