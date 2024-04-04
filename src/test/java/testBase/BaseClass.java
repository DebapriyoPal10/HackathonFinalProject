package testBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

public class BaseClass {
	public static WebDriver driver;
	public static  Logger logger;
	public static Properties p;
	
	@BeforeTest
	@Parameters({"browser"})
	public void setUp(String browser) throws IOException {
		//Loading config.properties file
		FileReader file = new FileReader(".//src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
		
		//Loading the log4j2 file--
		logger = LogManager.getLogger(this.getClass());
		
		//Setting up the cross browser testing facility
		switch(browser.toLowerCase()) {
			case "chrome": driver = new ChromeDriver(); break;
			case "edge" : driver = new EdgeDriver(); break;
			default: System.out.println("No such browser found"); break;
		}

		//Deleting all the cookies(previously stored informations)
		driver.manage().deleteAllCookies();
		
		//Waiting for all the resources(HTML, CSS, JS) to load
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		
		//Getting the appUrl from the config.properties file.
		driver.get(p.getProperty("appUrl"));
		
		//Maximizing the window
		driver.manage().window().maximize();
	}
	
	
    /*  Declaring the tearDown method as the AfterTest method which will close the driver instance and will
	 *  run only once after running all the test cases
	*/
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	public String captureScreen(String name) throws IOException{
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\" + name + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;
	}
}
