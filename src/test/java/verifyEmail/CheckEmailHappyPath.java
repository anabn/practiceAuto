package verifyEmail;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.regex.Pattern;

import static autoPractice.Email.isEmailCorrect;

/**
 * @author popcorn
 * the positive test
 * verify the mail via pattern "^[a-zA-Z0-9_!]{3,20}@[a-zA-Z0-9]{2,5}\\.[a-z]{2,5}$";
 *
 * 1. email with  valid numbers and chars (size from 3 to 20)
 * 2. email with  only numbers (size from 3 to 20)
 * 3. email with  chars (size from 3 to 20)
 * 4. email with spec Symbols (size from 3 to 20)
 *
 */
public class CheckEmailHappyPath{

    final static int MAX_SIZE_EMAIL = 20;
    final static int MIN_SIZE_EMAIL = 3;

    final static int MAX_SIZE_PROVIDER = 5;
    final static int MIN_SIZE_PROVIDER = 3;


    @BeforeMethod
    @DataProvider(name = "CorrectEmail")
    private final static Object[][] credentials() {
        return new Object[][] {
                {"9999999@hh.aa"},
                {"99999999@hh.aa"},
                {"testuser2@gmail.com"},
                {"zxcvb@ukr.net"},
                {"guestuser3@aa.ddd"},
                {"!!!!!!!@66.ff"}
        };
    }

    @Test(dataProvider = "CorrectEmail")
    public void verifyEmailWithIncorrectData(Object ... email){
        for (Object elem : email){
            Assert.assertTrue(isEmailCorrect(elem.toString()));
        }
    }


}
