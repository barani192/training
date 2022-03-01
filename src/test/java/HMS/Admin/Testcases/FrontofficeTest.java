package HMS.Admin.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import HMS.base.Testbase;
import HMS.pages.Dashboardpage;
import HMS.pages.FrontofficePage;
import HMS.pages.LoginPage;

public class FrontofficeTest extends Testbase {

	LoginPage objlog;
	 Dashboardpage objdash;
	 FrontofficePage objff;
	 
	 public FrontofficeTest()
	 {
		 super();
	 }
	 
	@BeforeClass
	public void setup()
	{
		initilization();
		objlog=new LoginPage();
		objdash=objlog.login(prop.getProperty("Username"), prop.getProperty("Password"));
		objff=objdash.clickonfrontoffice();
	
		}
	 
	@Test
	public void ffvisitor()
	{
		Assert.assertTrue(objff.verifytabletitle());
		objff.clickonvistorbook();
	}
	
	@AfterClass
	public void teardown()
	{
		driver.close();
	}
}
