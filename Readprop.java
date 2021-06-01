package selenium_training;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Readprop {
	static WebDriver driver;

	public static void main(String[] args) throws IOException {
		
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("D:\\Eclipse  Workplace\\Selenium Testing\\config.properties");
		prop.load(ip);
		System.out.println(prop.getProperty("browser"));	
		String browserName = prop.getProperty("browser");
		
		
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","D:\\QA Softwares\\Drivers\\chromedriver.exe")	;
			driver=new ChromeDriver();
		}
		else if(browserName.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver","D:\\QA Softwares\\Drivers\\geckodriver.exe")	;
			driver=new FirefoxDriver();
		}
		
		else
		{
			System.out.println("No Such Driver Exist");
		}
		
	    driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	
	}
	

}
