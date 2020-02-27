package seleniumBaseApi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

/*
Наступний клас буде перевіряти ось цю сторінку. Задача примітивна, клацнути всі чекбокси,
але для того щоб попрактикуватись, не юзайте простий By.id() напишіть два дата провайдера
перший буде передавати данні для пошуку використовуючи CSS next one using xPath.
 */
public class CheckThePageWithCheckboxes {

    private final static String URL_TO_CHECKING_PAGE = "https://formy-project.herokuapp.com/checkbox";
    private WebDriver chromeWebDriver;

    @BeforeSuite
    public void setUpChromeDriver() throws Exception{
        chromeWebDriver = new ChromeDriver();
        chromeWebDriver.manage().window().maximize();
        chromeWebDriver.get(URL_TO_CHECKING_PAGE);
    }

    @BeforeMethod
    @DataProvider(name = "locatorsXPath")
    private static Object[][] foundTheElementByLocatorsXPath() {
        return new Object[][] {
                {"//input[@id=\"checkbox-1\"]"},
                {"//input[@id=\"checkbox-2\"]"},
                {"//input[@id=\"checkbox-3\"]"}
        };
    }

    @BeforeMethod
    @DataProvider(name = "locatorsCSS")
    private static Object[][] foundTheElementByLocatorsCSS() {
        return new Object[][] {
                {"input#checkbox-1"},
                {"input#checkbox-2"},
                {"input#checkbox-3"}
        };
    }

    @Test(dataProvider = "locatorsCSS")
    public void checkingCheckboxesWithCSSLocatorsInThisWebPage(Object ... dataProviderCSSLocators){
        for (Object path: dataProviderCSSLocators) {
            WebElement checkbox = chromeWebDriver.findElement(By.cssSelector(path.toString()));
            checkbox.click();
            System.out.println("the checkbox is selected [ " + checkbox.isSelected() + " ] ");
        }

    }

    @Test(dataProvider = "locatorsXPath")
    public void findOutIfCheckboxIsSelected(Object ... dataProviderXPath){
        for (Object path: dataProviderXPath) {
            WebElement checkbox = chromeWebDriver.findElement(By.xpath(path.toString()));
            checkbox.click();
            if(checkbox.isSelected()) {
                System.out.println("the checkbox is selected [ " + checkbox.isSelected() + " ] ");
            } else {
                try {
                    throw new ClassNotFoundException();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    @AfterClass
    public void closeMethod(){
        chromeWebDriver.close();
    }

}
