package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups={"Sanity","Master"})
	public void verify_login()
	{
		logger.info("****starting TC002_LoginTest ");
		try
		{
		Homepage hp=new Homepage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		MyAccountPage map=new MyAccountPage(driver);
		boolean targetpage=map.isMyAccountPageExists();
		Assert.assertEquals(targetpage, true, "loginfailed"); //Assert.assertTrue(targetpage);
		}
		
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("***finished TC002_LoginTest");
		
		
	}

}
