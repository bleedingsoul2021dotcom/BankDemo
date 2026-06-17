package BaseTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Browser {
	
    public ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public WebDriver getDriver() {
		return driver.get();
	}
	
	public WebDriver intializeDriver() throws IOException {
		String path = System.getProperty("user.dir")+"\\src\\main\\java\\Utilities\\DataProvider.properties";
		FileInputStream fis = new FileInputStream(path);
		Properties prop = new Properties();
		prop.load(fis);
		
		String Browser = prop.getProperty("browser");
		
		if(Browser.contains("chrome")) {
		   driver.set(new ChromeDriver());
		}
		else if(Browser.contains("edge")) {
			 driver.set(new EdgeDriver());
		}
		
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		getDriver().manage().window().maximize();
		
		String appName = System.getProperty("app");
		String URL = prop.getProperty(appName);
		getDriver().get(URL);
		
		
		return getDriver();
	}
	
@BeforeMethod
public void goTo() throws IOException {
	intializeDriver();
}
     
@AfterMethod
public void tearDown() throws IOException {
	getDriver().close();
}
	
	
	
	

}
