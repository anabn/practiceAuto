package verifyEmail;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static autoPractice.Email.isEmailCorrect;

/**
 * @author popcorn
 * the negative test
 * verify the mail via pattern "^[a-zA-Z0-9_!]{3,20}@[a-zA-Z0-9]{2,5}\\.[a-z]{2,5}$"
 */
public class CheckEmailUnhappyPath{

    final static int MAX_SIZE_EMAIL = 20;
    final static int MIN_SIZE_EMAIL = 3;

    final static int MAX_SIZE_PROVIDER = 5;
    final static int MIN_SIZE_PROVIDER = 3;


    @BeforeMethod
    @DataProvider(name = "IncorrectEmail")
    private final static Object[][] incorrectArguments() {
        return new Object[][] {
                {"asedf@a.22"},
                {"aaaa..@11"},
                {"      @11.aa"},
                {"a.@1.1"},
                {"ioi"},
                {"tt.gmail.com"}
        };
    }

    @Test(dataProvider = "IncorrectEmail")
    public void result(Object ... arg){
        for (Object elem : arg){
            Assert.assertFalse(isEmailCorrect(elem.toString()));
        }
    }

}
