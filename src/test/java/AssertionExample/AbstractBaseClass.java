package AssertionExample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

abstract class AbstractBaseClass {
    protected WebDriver chromeDriver;

    @BeforeSuite
    public void setUpChromeDriver() throws Exception{
        System.setProperty("webdriver.chrome.driver", "/Users/popcorn/Drivers/chromedriver");
        chromeDriver = new ChromeDriver();
        String url = "https://www.youtube.com/";
        chromeDriver.navigate().to(url);
    }

}
