package msa4.sba.uistore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageLocators
{

	public WebElement searchButton;
	public WebElement footerStylingLink;
	public WebElement products;
	public WebElement mach3;

	public HomePageLocators(WebDriver driver)
	{
		this.searchButton = driver.findElement(By.xpath("//button[@id='searchIcon']"));
		this.footerStylingLink = driver.findElement(By.xpath("(//a[@title='Styling'])[2]"));
		this.products = driver.findElement(By.xpath("//span[text()='Products']"));
		this.mach3 = driver.findElement(By.xpath("//a[text()='MACH3']"));
		
	}
}
