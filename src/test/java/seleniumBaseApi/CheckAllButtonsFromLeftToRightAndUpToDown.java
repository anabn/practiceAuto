package seleniumBaseApi;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

/*
     Перший клас буде в нас містити тести для перевірки різних батонів, на сторінці.
     Ваша задача написати послідовні тести що будуть клалацати батони з ліва на право, з верху вниз(перший буде
     Primary -> Success …. The last one will be Dropdown link1 -> link2)
      Кожна кнопка – це окремий тест, ваша задача придумати як зробити їх послідовними.
 */

public class CheckAllButtonsFromLeftToRightAndUpToDown {

    private final static String URL_TO_CHECKING_PAGE = "https://formy-project.herokuapp.com/buttons";

    private final static String PATH_TO_ALL_BUTTON_ON_PAGE = "//form//button";
    private final static String PATH_TO_FIRST_LEFT_BUTTON = "//div[@class = \"col-sm-8\"]/button[1]";
    private final static String PATH_TO_LAST_DROPDOWN_BUTTON =
            "//form/div[last()]//following::button[@id=\"btnGroupDrop1\"]";
    private final static String PATH_TO_LINK_FROM_DROPDOWN=
            "//*/form/div[last()]//following::div[@class=\"dropdown-menu\"]/a";
    private final static int INDEX_OF_RANDOM_BUTTON = 4;

    private WebDriver chromeWebDriver;
    private List<WebElement> theListOfAllButtons;


    @BeforeSuite
    public void setUpChromeDriver() throws Exception{
        chromeWebDriver = new ChromeDriver();
        chromeWebDriver.manage().window().maximize();
        chromeWebDriver.get(URL_TO_CHECKING_PAGE);
        theListOfAllButtons = chromeWebDriver.findElements(By.xpath(PATH_TO_ALL_BUTTON_ON_PAGE));
    }

    @Test
    public void verifyValueFromListWithXPath(){
        WebElement firstButtonFromList = theListOfAllButtons.get(0);
        WebElement firstButtonUsingXPath = chromeWebDriver.findElement(By.xpath(PATH_TO_FIRST_LEFT_BUTTON));
        System.out.println(" [ " + firstButtonFromList.getText() + " ] - the button for checking the equals with XPath and from list");
        Assert.assertEquals(firstButtonUsingXPath, firstButtonFromList);
    }

    // check out all buttons from left to right, up to down
    @Test
    public void clickOnButtonsFromList(){
        for (WebElement i: theListOfAllButtons) {
            i.click();
            System.out.println("The [ " + i.getText() + " ] button is clicked");
        }
    }

    @Test
    public void verifyOneRandomButtonFromList(){
        theListOfAllButtons.get(INDEX_OF_RANDOM_BUTTON).click();
        System.out.println("The [ " + theListOfAllButtons.get(INDEX_OF_RANDOM_BUTTON).getText() + " ] button is clicked");
    }


        /*
    ставлю click() на силку - отримую failed  -> попробую до пт розібраться, але поки так
    якщо не важко, то підскажіть / скиньте силку де почитать
    дякую

    + якщо запустить тільки цей тест - заходить в трай
    я так розумію це зв'язано з wait
        */

    @Test
    public void verifyDisplayedDropdown(){
        try {
            WebElement displayTheDropdown = chromeWebDriver.findElement(By.xpath(PATH_TO_LAST_DROPDOWN_BUTTON));
            List<WebElement> s = chromeWebDriver.findElements(By.xpath(PATH_TO_LINK_FROM_DROPDOWN));

            Thread.sleep(10*10);
            if (displayTheDropdown.isDisplayed()) {
                for (WebElement i : s) {
                    System.out.println(i.isSelected() + " -> " + i.getAttribute("href"));
                }
            } else {
                System.out.println("The dropdown wasn't displayed");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("from methods");

    }

    @AfterClass
    public void closeMethod(){
        chromeWebDriver.close();
    }

}
