package HMS.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import HMS.base.Testbase;


public class FrontofficePage extends Testbase {
	
	@FindBy(xpath="//h3[text()='Appointment Details']")WebElement fftitle;
	@FindBy(css="div.box-tools>a:nth-child(2)")WebElement vistorbook;
	
	public FrontofficePage () {
		
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifytabletitle()
	{
		return fftitle.isDisplayed();
		
	}
	
	public vistorpage clickonvistorbook()
	{
		vistorbook.click();
		return new vistorpage();
	}
	
	
	
	
	
	
	
	
	
	

}
