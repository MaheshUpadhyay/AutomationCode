package simple.Log;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class LogTestSample {
	private WebDriver driver;
	private Logger logger;
  @Test
  public void Googlelaunch() {
      // Open browser
      driver = new FirefoxDriver();
      logger.info("Browser Opened");
   // Set implicit wait
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      logger.info("Implicit wait given");
      // Load application
      driver.get("https://www.google.co.in/");
      logger.info("Url opened");
  }
  @Test
  public void Yahoolaunch() {
      // Open browser
      driver = new FirefoxDriver();
      logger.info("Browser Opened");
   // Set implicit wait
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      logger.info("Implicit wait given");
      // Load application
      driver.get("https://www.yahoo.com");
      logger.info("Url opened");
  }
  @BeforeMethod
  public void beforeMethod(Method method) {
	  logger=Logger.getLogger(method.getName());
      // configure log4j properties file
      PropertyConfigurator.configure("Log4j.properties");
  }
  
  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }
}
