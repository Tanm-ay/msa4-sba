package msa4.sba.uistore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FooterResultPageLocator
{
	public WebElement beard;
	
	public FooterResultPageLocator(WebDriver driver)
	{
		this.beard = driver.findElement(By.xpath("//h3[text()='Facial Hair Styles: The Anchor Beard']"));
	}
}
