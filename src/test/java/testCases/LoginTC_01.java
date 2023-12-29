package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LoginPage;
import utilities.WeBDriverUtils;

public class LoginTC_01 extends BaseClass {

	public static LoginPage loginpage = null;
	public static WeBDriverUtils webdriverutils = null;

	@Test()
	public void verifyLogin() throws IOException, InterruptedException {
		test = extent.createTest("Login Application");
		loginpage = new LoginPage(driver);
		loginpage.applicationLogin(userName, password);
		test.pass("Login is successfull");
		Thread.sleep(3000);

		String expectedTitle = "OrangeHR";
		String actualTitle = driver.getTitle();

		if (actualTitle.contentEquals(expectedTitle)) {
			test.pass("Title is matched");
			logger.info("Title is matched");			
		} else {
			logger.error("Title is not matched");
			String path = WeBDriverUtils.captureScreen(driver, "VerifyLogin");
			test.fail("Title is not matching" + test.addScreenCaptureFromPath(path));
		}

		//testt
		
		extent.flush();
		Assert.assertEquals(expectedTitle, actualTitle);
	}

}
