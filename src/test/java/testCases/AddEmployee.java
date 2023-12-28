package testCases;

import org.testng.annotations.Test;

import pageObjects.AddEmployeePage;
import utilities.Dataprovider;

public class AddEmployee extends BaseClass {
	
	
	
	
	@Test(dataProviderClass = Dataprovider.class,dataProvider = "AddEmployee")
	public void addEmployee(String firsName,String MiddleName,String lastName)
	{
		test = extent.createTest("Add Employee");
		AddEmployeePage addemployee = new AddEmployeePage(driver);
		addemployee.addEmployee(firsName, MiddleName, lastName);
		test.pass("Add employee is successfull");
		logger.info("Add employee is successfull");	
		extent.flush();
	}
	
	

}
