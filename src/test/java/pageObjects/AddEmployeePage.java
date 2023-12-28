package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testCases.BaseClass;

public class AddEmployeePage extends BaseClass {
	

	//I added a comment from sanjay
	WebDriver ldriver;
	public AddEmployeePage(WebDriver rdriver)
	{
	ldriver = rdriver;
	PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//*[text()='PIM']/parent::a")
	WebElement linkPIM;
	
	@FindBy(xpath="//a[text()='Add Employee']")
	WebElement linkAddEmployee;

	
	@FindBy(xpath="//input[@name='firstName']")
	WebElement inputFirstName;

	@FindBy(xpath="//input[@name='lastName']")
	WebElement inputLastName;
	
	@FindBy(xpath="//input[@name='middleName']")
	WebElement inpuMiddletName;
	
	
	@FindBy(xpath="//button[text()=' Save ']")
	WebElement buttonSave;
	
	public void addEmployee(String firstName,String midddleName,String lastName)
	{
		linkPIM.click();
		linkAddEmployee.click();
		inputFirstName.sendKeys(firstName);
		inpuMiddletName.sendKeys(midddleName);
		inputLastName.sendKeys(lastName);
		buttonSave.click();
	}
}

