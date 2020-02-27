package AssertionExample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TestAssertMethods {
    private final static String YOUTUBE_CAMEL_CASE = "YouTube";
    private final static String YOUTUBE_LOWER_CASE = "youtube";

    private WebDriver chromeDriver;
    @BeforeSuite
    public void setUpChromeDriver() throws Exception{
//        System.setProperty("webdriver.chrome.driver", "/Users/popcorn/Drivers/chromedriver");
        chromeDriver = new ChromeDriver();
        String url = "https://www.youtube.com/";
        chromeDriver.navigate().to(url);
    }


    @Test
    public void testCaseVerifyHomePageTitle() {
        Assert.assertEquals(YOUTUBE_CAMEL_CASE, chromeDriver.getTitle());
//        Assert.assertEquals("youTube", chromeDriver.getTitle());
    }


    @Test
    public void testCaseVerifyHomePageWithErrorMessageInAssertion() {
        Assert.assertEquals(YOUTUBE_CAMEL_CASE, chromeDriver.getTitle(), "is not equal");
    }

    @Test
    public void testVerifyTheBooleansArg() {

        // different assert for example
//       Assert.assertEquals(false, youtube.equals(YouTube));
//       Assert.assertNotEquals(youtube, YouTube, "not equals");
//       Assert.assertEquals(true, !(youtube.equals(YouTube)));
//
//       Assert.assertFalse(youtube.equals(YouTube));
        Assert.assertTrue(!(YOUTUBE_CAMEL_CASE.equals(YOUTUBE_LOWER_CASE)));
    }

    @Test
    public void testVerifyArgumentsInCollections(){
        ArrayList<String> arrayListActual = new ArrayList<String>();
        ArrayList<String> arrayListExpected = new ArrayList<String>();
        arrayListActual.add(chromeDriver.getCurrentUrl());
        arrayListActual.add(chromeDriver.getTitle());
        arrayListExpected.add("https://www.youtube.com/");
        arrayListExpected.add(YOUTUBE_CAMEL_CASE);
        Assert.assertEquals(arrayListExpected, arrayListActual);

    }

}

