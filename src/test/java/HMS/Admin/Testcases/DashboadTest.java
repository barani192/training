package HMS.Admin.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import HMS.base.Testbase;
import HMS.pages.Dashboardpage;
import HMS.pages.LoginPage;

public class DashboadTest extends Testbase {

	LoginPage objlog;
	 Dashboardpage objdash;
	 
	 
	 public DashboadTest()
	 {
		 super();
	 }
	 
	 @BeforeClass
	 
	 public void setup()
	 {
		 initilization();
		 objlog=new LoginPage();
		 objdash=objlog.login(prop.getProperty("Username"), prop.getProperty("Password"));
	 }
	
	 @Test
	 public void dashtest()
	 {
		 String expectedtitle="Smart Hospital Management System";
		 Assert.assertEquals(expectedtitle, objdash.verifytitle());
		 objdash.clickonprofile();
		 String expectedtext="Super Admin";
		 Assert.assertEquals(expectedtext, objdash.verifyusername());
		 objdash.clickonlogout();
	 }
	 
	 @AfterClass
	 public void teardown()
	 {
		 driver.close();
	 }
}


