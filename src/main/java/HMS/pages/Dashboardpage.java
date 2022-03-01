package HMS.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import HMS.base.Testbase;

public class Dashboardpage extends Testbase{

	@FindBy(css="img.topuser-image")WebElement profile;
	@FindBy(xpath="//h5[text()='Super Admin']")WebElement usertxt;
	@FindBy(css="div.sspass>a:nth-child(3)")WebElement logout;
	@FindBy(css="ul.sidebar-menu>li")WebElement frontoffice;
	public Dashboardpage(){
		
		PageFactory.initElements(driver, this);
		
		 
	}
	
	public String verifytitle()
	{
		return driver.getTitle();
	}
	
	public void clickonprofile()
	{
		profile.click();
	}
	
	public String verifyusername() {
		//Explictwait(usertxt);
		return usertxt.getText();
	}
	
	public void clickonlogout()
	{
		logout.click();
	}
	
	public FrontofficePage clickonfrontoffice()
	{
		frontoffice.click();
		return new  FrontofficePage();
	}
	
}
