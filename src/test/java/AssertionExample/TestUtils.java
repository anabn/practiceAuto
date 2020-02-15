package AssertionExample;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TestUtils extends AbstractBaseClass{
    private String youtube = "youtube";
    private String YouTube = "YouTube";

    private ArrayList<String> arrayListActual = new ArrayList<String>();
    private ArrayList<String> arrayListExpected = new ArrayList<String>();

//    @Test
//    public void verifyString() {
//
//        chromeDriver.get("https://www.youtube.com/");
//    }

    @Test
    public void testCaseVerifyHomePage() {
        Assert.assertEquals(YouTube, chromeDriver.getTitle());
//        Assert.assertEquals("youTube", chromeDriver.getTitle());
    }


    @Test
    public void testCaseVerifyHomePageWithMessage() {
        Assert.assertEquals(youtube, chromeDriver.getTitle(), "is not equal");
    }

    @Test
    public void testBooleanArg() {
//       Assert.assertEquals(false, youtube.equals(YouTube));
//       Assert.assertNotEquals(youtube, YouTube, "not equals");
//       Assert.assertEquals(true, !(youtube.equals(YouTube)));
//
//       Assert.assertFalse(youtube.equals(YouTube));
        Assert.assertTrue(!(youtube.equals(YouTube)));
    }

    @Test
    public void testCollections(){
        arrayListActual.add(chromeDriver.getCurrentUrl());
        arrayListActual.add(chromeDriver.getTitle());
        arrayListExpected.add("https://www.youtube.com/");
        arrayListExpected.add(YouTube);
        Assert.assertEquals(arrayListExpected, arrayListActual);

    }

}

