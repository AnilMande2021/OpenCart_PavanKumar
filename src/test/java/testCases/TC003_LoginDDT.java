package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass  {
	
	@Test(dataProvider="LoginData" , dataProviderClass=DataProviders.class,groups="DataDriven" )
	public void verify_loginDDT(String email, String pwd, String exp)
	
	{
		logger.info("****starting TC003_LoginDDT ");
		try
		{
		Homepage hp=new Homepage(driver);
		hp.clickMyAccount();
		hp.clickLogin(); 
	
	LoginPage lp=new LoginPage(driver);
	lp.setEmail(email);
	lp.setPassword(pwd);
	lp.clickLogin();
	
	MyAccountPage map=new MyAccountPage(driver);
	boolean targetPage=map.isMyAccountPageExists();
	
	if(exp.equalsIgnoreCase("valid"))
	{
		if(targetPage==true)
		{
			map.clickLogout();
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	
	if(exp.equalsIgnoreCase("invalid"))
	{
		if(targetPage==true)
		{
			map.clickLogout();
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
		}
	}
	
	}		
	
	catch(Exception e)
	{
		Assert.fail();
	}
		logger.info("****finished TC003_LoginDDT ");
	}
}
