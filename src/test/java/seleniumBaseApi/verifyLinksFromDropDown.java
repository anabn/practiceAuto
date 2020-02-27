package seleniumBaseApi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*
* Далі, у вас буде клас для перевірки ось цього функціоналу, що також буде дуже крисно освоїти.
* Вам треба написати один тест що буде в циклі проходитись по всім сторінкам що випадають в дропдауні,
* перейшов на першу сторінку перевірив в верефікації те що url дійсно відповідає тій сторінці,
* і повернувся на сторінку з дропдауном і так аж до останнього. Якщо ви застрягли на реалізації
* і немає ідей пишіть, допоможу, але тут вже треба заюзати те що ми вчили і в принципі тест буде лаконічний.
*
* */
public class verifyLinksFromDropDown {

    private final static String URL_TO_CHECKING_PAGE = "https://formy-project.herokuapp.com/dropdown";
    private final static String ROOT_URL = "https://formy-project.herokuapp.com/";
    private final static String LOCATOR_XPATH_DROPDOWN = "//div[@class=\"dropdown\"]";
    private WebDriver chromeWebDriver;

    @BeforeSuite
    public void setUpChromeDriver() throws Exception{
        chromeWebDriver = new ChromeDriver();
        chromeWebDriver.manage().window().maximize();
        chromeWebDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        chromeWebDriver.get(URL_TO_CHECKING_PAGE);
    }

//    @BeforeMethod
//    @DataProvider(name = "urlFromDropdown")
//    private static Object[][] urlThePagesFromDropdown() {
//        return new Object[][] {
//                {"Autocomplete"},
//                {"Buttons"},
//                {"Checkbox"},
//                {"Datepicker"},
//                {"Drag And Drop"},
//                {"Dropdown"},
//                {"Enabled and disabled elements"},
//                {"File Upload"},
//                {"File Download"},
//                {"Key And Mouse Press"},
//                {"Modal"},
//                {"Page Scroll"},
//                {"Radio Button"},
//                {"Switch Window"},
//                {"Complete Web Form"}
//        };
//    }

    @Test
    public void verifyIfLinkAndUrlAreEqual() {
        ArrayList<String> urlFromNewPageByAttr = new ArrayList<String>();
        ArrayList<String> urlFromNewPageByDriver = new ArrayList<String>();
        WebElement webElement = chromeWebDriver.findElement(By.xpath(LOCATOR_XPATH_DROPDOWN));
        List<WebElement> select = null;
        webElement.click();
        if (webElement.isDisplayed()) {
            select = chromeWebDriver.findElements(By.xpath("//div[@class=\"dropdown-menu\"]/a"));
            for (WebElement w : select) {
                urlFromNewPageByAttr.add(w.getAttribute("href"));
                for (int i = 1; i < select.size(); i++) {
                    try {
                        Thread.sleep(10 * 10);
                        chromeWebDriver.findElement(By.xpath("//div[@class=\"dropdown-menu\"]/a[" + i + "]")).click();
                        urlFromNewPageByDriver.add(chromeWebDriver.getCurrentUrl());
                        chromeWebDriver.navigate().to(URL_TO_CHECKING_PAGE);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }

        for (int i=0; i < urlFromNewPageByAttr.size(); i++) {
                Assert.assertEquals(urlFromNewPageByAttr.get(i), urlFromNewPageByDriver.get(i));
        }

    }

//    @Test
//    public void verifyIfLinkAndUrlAreEqual() {
//
//        ArrayList<String> urlFromNewPageByAttr = new ArrayList<String>();
//        ArrayList<String> urlFromNewPageByDriver = new ArrayList<String>();
//
//        WebElement webElement = chromeWebDriver.findElement(By.xpath(LOCATOR_XPATH_DROPDOWN));
//        List<WebElement> select = null;
//
////        if (webElement.isDisplayed()) {
////            select = chromeWebDriver.findElements(By.xpath("//div[@class=\"dropdown-menu\"]/a"));
////            for (WebElement w : select) {
////
////            }
////        }
//        webElement.click();
//        try {
//            Thread.sleep(100);
//            if (webElement.isDisplayed()) {
//                select = chromeWebDriver.findElements(By.xpath("//div[@class=\"dropdown-menu\"]/a"));
//                int size = select.size();
//                for (int i = 1; i < size; i++) {
//                        chromeWebDriver.findElement(By.xpath("//div[@class=\"dropdown-menu\"]/a["+i+"]")).click();
//
//                        urlFromNewPageByDriver.add(chromeWebDriver.getCurrentUrl());
//                        chromeWebDriver.navigate().to(URL_TO_CHECKING_PAGE);
//                }
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        for (int i=0; i < urlFromNewPageByDriver.size(); i++) {
//            System.out.println(urlFromNewPageByDriver.get(i));
//        }
//
//    }

    @AfterClass
    public void closeMethod(){
            chromeWebDriver.close();
    }
}
