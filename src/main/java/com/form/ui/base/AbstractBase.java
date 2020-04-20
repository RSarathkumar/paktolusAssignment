package com.form.ui.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.form.ui.util.AbstractUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AbstractBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public AbstractBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/form"
					+ "/ui/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization() throws InterruptedException {
		String browserName = prop.getProperty("browser");

		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "/Users/Sarathkumar R/drchrome/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();

			options.setPageLoadStrategy(PageLoadStrategy.NONE);
			options.addArguments("start-maximized");
			options.addArguments("enable-automation");
						options.addArguments("--no-sandbox");
			options.addArguments("--disable-infobars");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--disable-browser-side-navigation");
			options.addArguments("--disable-gpu");
			driver = new ChromeDriver(options);

		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(AbstractUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(AbstractUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		Thread.sleep(100);
		driver.getTitle().equalsIgnoreCase("Labyrinth eLab: Create Learner");
		new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//nav[@class='header-nav']/a")));
		
	}

	public void closeBrowser(){

		driver.close();
	}
	
	
	
	
	
	
	
	

}
