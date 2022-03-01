package HMS.Admin.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import HMS.base.Testbase;
import HMS.pages.Dashboardpage;
import HMS.pages.FrontofficePage;
import HMS.pages.LoginPage;
import HMS.pages.vistorpage;
import HMS.utility.ReadExcel;

public class VistorTest extends Testbase {

	LoginPage objlog;
	 Dashboardpage objdash;
	 FrontofficePage objff;
	 vistorpage objvis;
	 
	 public VistorTest()
	 {
		 super();
		 
	 }
	
	 @BeforeMethod
		public void setup()
		{
			initilization();
			objlog=new LoginPage();
			objdash=objlog.login(prop.getProperty("Username"), prop.getProperty("Password"));
			objff=objdash.clickonfrontoffice();
			objvis=objff.clickonvistorbook();
			
			
		}
	 
	 @DataProvider
		public Object[][] visdata()
		{
			Object[][] data=ReadExcel.getTestData("testdata");
			return data;
			
		}
	 
	 @Test(dataProvider="visdata")
	 
	 public void addvistordetails(String vis[]) {
		 
		 Assert.assertTrue(objvis.verifyvistitle());
		 objvis.clickonaddvistor();
		// Assert.assertTrue(objvis.checkforscreentile());
		 objvis.addvistordetails(vis);

	 }
	 
	 @AfterMethod
		public void teardown()
		{
			driver.close();
		}
	
	
	
	
	
	
	
	
	
	
	
}
