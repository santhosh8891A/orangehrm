package testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import pageObjects.LoginPage;
import utilities.ReadConfig;

public class BaseClass {
	public static ReadConfig readconfig = null;
	public static WebDriver driver = null;
	public String applictionURL = null;
	public String userName;
	public String password;
	public static LoginPage loginpage = null;
	public static Logger logger;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentHtmlReporter htmlReporter;
	public static SimpleDateFormat simpleDate;


	@Parameters("browser")
	@BeforeSuite
	public void setUp(String browser) throws InterruptedException {
		logger = Logger.getLogger("orangeHRM");
		PropertyConfigurator.configure("Log4j.properties");
		readconfig = new ReadConfig();
		applictionURL = readconfig.getPropertyFromConfingFile("ApplicationURL");
		userName = readconfig.getPropertyFromConfingFile("UserName");
		System.out.println(userName);
		password = readconfig.getPropertyFromConfingFile("Password");

		if (browser.contentEquals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
		} else if (browser.contentEquals("edge")) {
			driver = new EdgeDriver();
		}

		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy-HH-mm-ss");
		String strDate = formatter.format(date);
		htmlReporter = new ExtentHtmlReporter("test-output\\ExtentReportResults" + strDate + ".html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("Extent Report Demo");
		htmlReporter.config().setReportName("Test Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		
		driver.get(applictionURL);
		logger.info("Appliaction opened");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		loginpage = new LoginPage(driver);
		loginpage.applicationLogin(userName, password);
		Thread.sleep(3000);

	}

	@AfterSuite
	public void tearDown() {
		loginpage = new LoginPage(driver);
		loginpage.logout();
		driver.quit();
		System.out.println("after Suite");
	}
	
	
}
