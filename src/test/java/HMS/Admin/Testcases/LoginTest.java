package HMS.Admin.Testcases;



import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import HMS.base.Testbase;
import HMS.pages.LoginPage;

public class LoginTest extends Testbase{

	LoginPage objlog;
	
	public LoginTest()
	{
		super();
	}
	
	@BeforeClass
	public void setup()
	
	{
		initilization();
	    objlog=new LoginPage();
}
	
	@Test
	public void loginpagetest()
	{
		Assert.assertTrue( objlog.logocheck());
		String expectedtitle="Admin Login";
		Assert.assertEquals(expectedtitle, objlog.admintxt());
		objlog.login(prop.getProperty("Username"), prop.getProperty("Password"));
		 
		
	}
	
	@AfterClass
	public void teardown()
	{
		driver.close();
	}
	
	
	
	
	
	
	
}

