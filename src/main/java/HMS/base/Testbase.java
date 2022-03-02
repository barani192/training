package HMS.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import HMS.utility.Activitycapture;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;

public class Testbase {
 
	public static WebDriver driver;
	public static Properties prop;
	public static  EventFiringWebDriver event;
	public static  Activitycapture  actcap;
	
	public Testbase()
	{
		try {
			FileInputStream ipf=new FileInputStream("./src/main/java/HMS/config/Appconfig.properties");
            prop=new Properties();
            prop.load(ipf);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initilization()
	{
		String runbrowser=prop.getProperty("browser");
		if(runbrowser.equals("chrome"))
		{
			String headless=prop.getProperty("Headless") ;
			if(headless.endsWith("true")) 
			{
				WebDriverManager.chromedriver().setup();
				ChromeOptions options=new ChromeOptions();
				
				options.addArguments("--headless");
				
				driver=new ChromeDriver(options);
			}else
			{
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				
			}
		}else if (runbrowser.equals("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if (runbrowser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		
		//basic methods
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));

		   event=new EventFiringWebDriver(driver);
		    actcap=new Activitycapture();
		    event.register(actcap);
		    driver=event;
		
	}
	
	public void Explictwait(WebElement el)
	{
		WebDriverWait wt=new WebDriverWait(driver, Duration.ofSeconds(30));
		wt.until(ExpectedConditions.invisibilityOf(el));
	}
	
	
	
	
	
	
}
