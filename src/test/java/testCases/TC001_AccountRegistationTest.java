package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.Homepage;
import testBase.BaseClass;

public class TC001_AccountRegistationTest extends BaseClass{
	
	@Test(groups={"Regression","Master"})
	public void verify_Account_Registration()
	{
		logger.info("****Starting TC001_AccountRegistationTest *** ");
		try
		{
		Homepage hp=new Homepage(driver);
		logger.info("Clicked on my account link ");
		hp.clickMyAccount();
		logger.info("Clicked on my register link ");
		hp.clickRegister();
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		logger.info("providing customer info ");
		
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setTelephone(randomNumber());
		
		String password=randomAlphaNumeric();

		regpage.setpassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("Validating expected message ");
		
		String msg=regpage.getConfirmationMsg();
		
		if(msg.equals("Your Account Has Been Created!"))
			
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("test failed");
			logger.debug("debug logs");
			Assert.assertTrue(false);
		}
		//Assert.assertEquals(msg, "Your Account Has Been Created!");
	
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("***Finished TC001_AccountRegistationTest*** ");
	}

}
