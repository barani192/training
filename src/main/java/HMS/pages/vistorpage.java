package HMS.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import HMS.base.Testbase;
import HMS.utility.Datepicker;
import HMS.utility.commonutil;

public class vistorpage extends Testbase {
	
	Datepicker dat=new Datepicker();

	@FindBy(xpath="//h3[text()='Visitor List']")WebElement vistortitle;
	@FindBy(css="div.box-tools>a")WebElement addvistor;
	@FindBy(xpath="//h4[text()=' Add Visitor']")WebElement visscreentitle;
	@FindBy(css="form#formadd select[name='purpose']")WebElement purpose;
	
	@FindBy(css="#formadd > div.box-body > div:nth-child(1) > div:nth-child(2) > div > input")WebElement nametext;
	@FindBy(css="#formadd > div.box-body > div:nth-child(2) > div:nth-child(1) > div > input")WebElement phonetxt;
	@FindBy(css="#formadd > div.box-body > div:nth-child(2) > div:nth-child(2) > div > input")WebElement idtext;
	@FindBy(css="#formadd > div.box-body > div:nth-child(3) > div:nth-child(1) > div > input")WebElement persontxt;
	@FindBy(css="textarea#description")WebElement notetxt;
	@FindBy(css="form#formadd input[name='date']")WebElement datepicker;
	@FindBy(css="form#formadd input[name='file']")WebElement upfile;
	@FindBy(css="button.close")WebElement btnclose;
	
	
	public vistorpage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyvistitle()
	{
		return vistortitle.isDisplayed();
		
	}
	
	public void clickonaddvistor()
	{
		 addvistor.click();
	}
	
	public boolean checkforscreentile()
	{
		return visscreentitle.isDisplayed();
	}
	
	public void addvistordetails(String data[]){
		{
			
			Select drp=new Select(purpose);
			drp.selectByVisibleText(data[0]);
			
			 nametext.sendKeys(data[1]);
			 phonetxt.sendKeys(data[2]);
			 idtext.sendKeys(data[3]);
			 persontxt.sendKeys(data[5]);
			 notetxt.sendKeys(data[6]);
			datepicker.click();
			dat.datpicker(data[4]);
			 commonutil.mouseclick(upfile);
			 commonutil.fileupload(data[7]);
			// btnclose.click();
			 
			 
			 
		}
		
		
		
			
		
	
	
	
	
	
	}
}
	
	
	

