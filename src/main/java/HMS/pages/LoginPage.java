package HMS.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import HMS.base.Testbase;

public class LoginPage extends Testbase{
	
	@FindBy(tagName="img")WebElement logo;
	@FindBy(css="h3.font-white")WebElement formtxt;
	@FindBy(css="input#email")WebElement usernametxt;
	@FindBy(css="input#password")WebElement passwordtxt;
	@FindBy(css="button.btn")WebElement signinbtn;

	public LoginPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public boolean logocheck()
	{
		
		
		return logo.isDisplayed();
	}	
		 
	public String admintxt()
	{
		
		return formtxt.getText();
	}
	public  Dashboardpage login(String user,String pass) 
	{
		usernametxt.sendKeys(user);
		passwordtxt.sendKeys(pass);
		signinbtn.click();
		return new  Dashboardpage();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
