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

    private final static int MAX_SIZE_EMAIL = 20;
    private final static int MIN_SIZE_EMAIL = 3;

    private final static int MAX_SIZE_PROVIDER = 5;
    private final static int MIN_SIZE_PROVIDER = 2;

    private final static String ONLY_CHAR_IN_STRING = "qazxswedcvfrtgbnhyujmkiolp1234567890";
    private final static String ONLY_NUMBERS_IN_STRING= "123456789023456789456789456789";
    private final static String ONLY_SPEC_SYMBOLS_IN_STRING = "__!!!_____!!!!____!__!!!!!!!!____!";

    @BeforeMethod
    @DataProvider(name = "CorrectEmail")
    private final static Object[][] properValuesInEmail() {
        return new Object[][] {

                {ONLY_CHAR_IN_STRING.substring(0, MIN_SIZE_EMAIL)+
                        "@"+ ONLY_CHAR_IN_STRING.substring(0,MIN_SIZE_PROVIDER)+
                        "."+ ONLY_CHAR_IN_STRING.substring(0,MIN_SIZE_PROVIDER)},

                {ONLY_CHAR_IN_STRING.substring(0, MIN_SIZE_EMAIL + 1)+
                        "@"+ ONLY_CHAR_IN_STRING.substring(0,MIN_SIZE_PROVIDER)+
                        "."+ ONLY_CHAR_IN_STRING.substring(0,MIN_SIZE_PROVIDER)},

                {ONLY_CHAR_IN_STRING.substring(0, MIN_SIZE_EMAIL)+
                        "@"+ ONLY_CHAR_IN_STRING.substring(0,MIN_SIZE_PROVIDER + 1)+
                        "."+ ONLY_CHAR_IN_STRING.substring(0,MIN_SIZE_PROVIDER + 1)},

                {ONLY_CHAR_IN_STRING.substring(0, MAX_SIZE_EMAIL)+
                        "@"+ ONLY_CHAR_IN_STRING.substring(0,MAX_SIZE_PROVIDER)+
                        "."+ ONLY_CHAR_IN_STRING.substring(0,MAX_SIZE_PROVIDER)},

                {ONLY_CHAR_IN_STRING.substring(0, MAX_SIZE_EMAIL - 1)+
                        "@"+ ONLY_CHAR_IN_STRING.substring(0,MAX_SIZE_PROVIDER - 1)+
                        "."+ ONLY_CHAR_IN_STRING.substring(0,MAX_SIZE_PROVIDER - 1)},

                {ONLY_CHAR_IN_STRING.substring(0, MAX_SIZE_EMAIL - 1)+
                        "@"+ ONLY_CHAR_IN_STRING.substring(0,MAX_SIZE_PROVIDER)+
                        "."+ ONLY_CHAR_IN_STRING.substring(0,MAX_SIZE_PROVIDER)},

                {ONLY_CHAR_IN_STRING.substring(0, MAX_SIZE_EMAIL)+
                        "@"+ ONLY_CHAR_IN_STRING.substring(0,MAX_SIZE_PROVIDER - 1)+
                        "."+ ONLY_CHAR_IN_STRING.substring(0,MAX_SIZE_PROVIDER)},

                {ONLY_CHAR_IN_STRING.substring(0, MAX_SIZE_EMAIL)+
                        "@"+ ONLY_CHAR_IN_STRING.substring(0,MAX_SIZE_PROVIDER)+
                        "."+ ONLY_CHAR_IN_STRING.substring(0,MAX_SIZE_PROVIDER - 1)},

                {ONLY_NUMBERS_IN_STRING.substring(0, MIN_SIZE_EMAIL)+
                        "@"+ ONLY_CHAR_IN_STRING.substring(0,MIN_SIZE_PROVIDER)+
                        "."+ ONLY_CHAR_IN_STRING.substring(0,MIN_SIZE_PROVIDER)},

                {ONLY_NUMBERS_IN_STRING.substring(0, MIN_SIZE_EMAIL + 1)+
                        "@"+ ONLY_CHAR_IN_STRING.substring(0,MIN_SIZE_PROVIDER)+
                        "."+ ONLY_CHAR_IN_STRING.substring(0,MIN_SIZE_PROVIDER)},

                {ONLY_NUMBERS_IN_STRING.substring(0, MIN_SIZE_EMAIL)+
                        "@"+ ONLY_CHAR_IN_STRING.substring(0,MIN_SIZE_PROVIDER + 1)+
                        "."+ ONLY_CHAR_IN_STRING.substring(0,MIN_SIZE_PROVIDER + 1)},

                {ONLY_NUMBERS_IN_STRING.substring(0, MAX_SIZE_EMAIL)+
                        "@"+ ONLY_CHAR_IN_STRING.substring(0,MAX_SIZE_PROVIDER)+
                        "."+ ONLY_CHAR_IN_STRING.substring(0,MAX_SIZE_PROVIDER)},

                {ONLY_NUMBERS_IN_STRING.substring(0, MAX_SIZE_EMAIL - 1)+
                        "@"+ ONLY_CHAR_IN_STRING.substring(0,MAX_SIZE_PROVIDER - 1)+
                        "."+ ONLY_CHAR_IN_STRING.substring(0,MAX_SIZE_PROVIDER - 1)},

                {ONLY_NUMBERS_IN_STRING.substring(0, MAX_SIZE_EMAIL - 1)+
                        "@"+ ONLY_CHAR_IN_STRING.substring(0,MAX_SIZE_PROVIDER)+
                        "."+ ONLY_CHAR_IN_STRING.substring(0,MAX_SIZE_PROVIDER)},

                {ONLY_NUMBERS_IN_STRING.substring(0, MAX_SIZE_EMAIL)+
                        "@"+ ONLY_CHAR_IN_STRING.substring(0,MAX_SIZE_PROVIDER - 1)+
                        "."+ ONLY_CHAR_IN_STRING.substring(0,MAX_SIZE_PROVIDER)},

                {ONLY_NUMBERS_IN_STRING.substring(0, MAX_SIZE_EMAIL)+
                        "@"+ ONLY_CHAR_IN_STRING.substring(0,MAX_SIZE_PROVIDER)+
                        "."+ ONLY_CHAR_IN_STRING.substring(0,MAX_SIZE_PROVIDER - 1)},

                {ONLY_NUMBERS_IN_STRING.substring(0, MIN_SIZE_EMAIL)+
                        "@"+ ONLY_NUMBERS_IN_STRING.substring(0,MIN_SIZE_PROVIDER)+
                        "."+ ONLY_CHAR_IN_STRING.substring(0,MIN_SIZE_PROVIDER)},

                {ONLY_NUMBERS_IN_STRING.substring(0, MIN_SIZE_EMAIL + 1)+
                        "@"+ ONLY_NUMBERS_IN_STRING.substring(0,MIN_SIZE_PROVIDER)+
                        "."+ ONLY_CHAR_IN_STRING.substring(0,MIN_SIZE_PROVIDER)},

                {ONLY_NUMBERS_IN_STRING.substring(0, MIN_SIZE_EMAIL)+
                        "@"+ ONLY_NUMBERS_IN_STRING.substring(0,MIN_SIZE_PROVIDER + 1)+
                        "."+ ONLY_CHAR_IN_STRING.substring(0,MIN_SIZE_PROVIDER + 1)},

                {ONLY_NUMBERS_IN_STRING.substring(MIN_SIZE_EMAIL, MAX_SIZE_EMAIL)+
                        "@"+ ONLY_NUMBERS_IN_STRING.substring(MIN_SIZE_PROVIDER, MAX_SIZE_PROVIDER)+
                        "."+ ONLY_CHAR_IN_STRING.substring(MIN_SIZE_PROVIDER, MAX_SIZE_PROVIDER)},

                {ONLY_SPEC_SYMBOLS_IN_STRING.substring(0, MIN_SIZE_EMAIL)+
                        "@"+ ONLY_CHAR_IN_STRING.substring(0,MIN_SIZE_PROVIDER)+
                        "."+ ONLY_CHAR_IN_STRING.substring(0,MIN_SIZE_PROVIDER)},

                {ONLY_SPEC_SYMBOLS_IN_STRING.substring(0, MIN_SIZE_EMAIL + 1)+
                        "@"+ ONLY_CHAR_IN_STRING.substring(0,MIN_SIZE_PROVIDER)+
                        "."+ ONLY_CHAR_IN_STRING.substring(0,MIN_SIZE_PROVIDER)},

                {ONLY_SPEC_SYMBOLS_IN_STRING.substring(0, MIN_SIZE_EMAIL)+
                        "@"+ ONLY_CHAR_IN_STRING.substring(0,MIN_SIZE_PROVIDER + 1)+
                        "."+ ONLY_CHAR_IN_STRING.substring(0,MIN_SIZE_PROVIDER + 1)},

                {ONLY_SPEC_SYMBOLS_IN_STRING.substring(0, MAX_SIZE_EMAIL)+
                        "@"+ ONLY_NUMBERS_IN_STRING.substring(0,MAX_SIZE_PROVIDER)+
                        "."+ ONLY_CHAR_IN_STRING.substring(0,MAX_SIZE_PROVIDER)}
        };
    }

    @Test(dataProvider = "CorrectEmail")
    public void verifyEmailWithCorrectData(Object ... email){
        for (Object elem : email){
            Assert.assertTrue(isEmailCorrect(elem.toString()));
        }
    }


}
