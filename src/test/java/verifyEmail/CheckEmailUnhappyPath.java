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

    private final static int MAX_SIZE_EMAIL = 20;
    private final static int INVALID_MAX_SIZE_EMAIL = MAX_SIZE_EMAIL + 1;

    private final static int MIN_SIZE_EMAIL = 3;
    private final static int INVALID_MIN_SIZE_EMAIL = MIN_SIZE_EMAIL - 1;

    private final static int MAX_SIZE_PROVIDER = 5;
    private final static int INVALID_MAX_SIZE_PROVIDER = MAX_SIZE_PROVIDER + 1;
    private final static int MIN_SIZE_PROVIDER = 2;
    private final static int INVALID_MIN_SIZE_PROVIDER = MIN_SIZE_PROVIDER - 1;

    private final static String ONLY_CHAR_IN_STRING = "qazxswedcvfrtgbnhyujmkiolp1234567890";
    private final static String ONLY_NUMBERS_IN_STRING= "123456789023456789456789456789";
    private final static String ONLY_SPEC_SYMBOLS_IN_STRING = "123456789023456789456789456789";

    @BeforeMethod
    @DataProvider(name = "IncorrectEmail")
    private final static Object[][] incorrectValuesInEmail() {
        return new Object[][] {

                {ONLY_CHAR_IN_STRING.substring(0, INVALID_MIN_SIZE_EMAIL)+
                        "@"+ ONLY_CHAR_IN_STRING.substring(0, INVALID_MIN_SIZE_PROVIDER)+
                        "."+ ONLY_CHAR_IN_STRING.substring(0, INVALID_MIN_SIZE_PROVIDER)},

                {ONLY_CHAR_IN_STRING.substring(0, INVALID_MIN_SIZE_EMAIL + 1)+
                        "@"+ ONLY_CHAR_IN_STRING.substring(0, INVALID_MIN_SIZE_PROVIDER)+
                        "."+ ONLY_CHAR_IN_STRING.substring(0, INVALID_MIN_SIZE_PROVIDER)},

                {ONLY_CHAR_IN_STRING.substring(0, INVALID_MIN_SIZE_EMAIL)+
                        "@"+ ONLY_CHAR_IN_STRING.substring(0, INVALID_MIN_SIZE_PROVIDER + 1)+
                        "."+ ONLY_CHAR_IN_STRING.substring(0, INVALID_MIN_SIZE_PROVIDER + 1)},

                {ONLY_CHAR_IN_STRING.substring(0, INVALID_MAX_SIZE_EMAIL)+
                        "@"+ ONLY_CHAR_IN_STRING.substring(0, INVALID_MAX_SIZE_PROVIDER)+
                        "."+ ONLY_CHAR_IN_STRING.substring(0, INVALID_MAX_SIZE_PROVIDER)},

                {ONLY_CHAR_IN_STRING.substring(0, INVALID_MAX_SIZE_EMAIL)+
                        "@"+ ONLY_CHAR_IN_STRING.substring(0, INVALID_MAX_SIZE_PROVIDER)+
                        "."+ ONLY_CHAR_IN_STRING.substring(0, INVALID_MAX_SIZE_PROVIDER)},

                {ONLY_CHAR_IN_STRING.substring(0, INVALID_MAX_SIZE_EMAIL)+
                        "@"+ ONLY_CHAR_IN_STRING.substring(0, INVALID_MAX_SIZE_PROVIDER + 1)+
                        "."+ ONLY_CHAR_IN_STRING.substring(0, INVALID_MAX_SIZE_PROVIDER)},

                {ONLY_CHAR_IN_STRING.substring(0, INVALID_MAX_SIZE_EMAIL)+
                        "@"+ ONLY_CHAR_IN_STRING.substring(0, INVALID_MAX_SIZE_PROVIDER)+
                        "."+ ONLY_CHAR_IN_STRING.substring(0, INVALID_MAX_SIZE_PROVIDER - 1)},

                {ONLY_NUMBERS_IN_STRING.substring(0, INVALID_MIN_SIZE_EMAIL)+
                        "@"+ ONLY_CHAR_IN_STRING.substring(0, INVALID_MIN_SIZE_PROVIDER)+
                        "."+ ONLY_CHAR_IN_STRING.substring(0, INVALID_MIN_SIZE_PROVIDER)},

                {ONLY_NUMBERS_IN_STRING.substring(0, INVALID_MIN_SIZE_EMAIL + 1)+
                        "@"+ ONLY_CHAR_IN_STRING.substring(0, INVALID_MIN_SIZE_PROVIDER)+
                        "."+ ONLY_CHAR_IN_STRING.substring(0, INVALID_MIN_SIZE_PROVIDER)},

                {ONLY_NUMBERS_IN_STRING.substring(0, INVALID_MIN_SIZE_EMAIL)+
                        "@"+ ONLY_CHAR_IN_STRING.substring(0, INVALID_MIN_SIZE_PROVIDER + 1)+
                        "."+ ONLY_CHAR_IN_STRING.substring(0, INVALID_MIN_SIZE_PROVIDER + 1)},

                {ONLY_NUMBERS_IN_STRING.substring(0, INVALID_MAX_SIZE_EMAIL)+
                        "@"+ ONLY_CHAR_IN_STRING.substring(0, INVALID_MAX_SIZE_PROVIDER)+
                        "."+ ONLY_CHAR_IN_STRING.substring(0, INVALID_MAX_SIZE_PROVIDER)},

                {ONLY_NUMBERS_IN_STRING.substring(0, INVALID_MAX_SIZE_EMAIL + 1)+
                        "@"+ ONLY_CHAR_IN_STRING.substring(0, INVALID_MAX_SIZE_PROVIDER + 1)+
                        "."+ ONLY_CHAR_IN_STRING.substring(0, INVALID_MAX_SIZE_PROVIDER + 1)},

                {ONLY_NUMBERS_IN_STRING.substring(0, INVALID_MAX_SIZE_EMAIL - 1)+
                        "@"+ ONLY_CHAR_IN_STRING.substring(0, INVALID_MAX_SIZE_PROVIDER)+
                        "."+ ONLY_CHAR_IN_STRING.substring(0, INVALID_MAX_SIZE_PROVIDER)},

                {ONLY_NUMBERS_IN_STRING.substring(0, INVALID_MAX_SIZE_EMAIL)+
                        "@"+ ONLY_CHAR_IN_STRING.substring(0, INVALID_MAX_SIZE_PROVIDER - 1)+
                        "."+ ONLY_CHAR_IN_STRING.substring(0, INVALID_MAX_SIZE_PROVIDER)},

                {ONLY_NUMBERS_IN_STRING.substring(0, INVALID_MAX_SIZE_EMAIL)+
                        "@"+ ONLY_CHAR_IN_STRING.substring(0, INVALID_MAX_SIZE_PROVIDER)+
                        "."+ ONLY_CHAR_IN_STRING.substring(0, INVALID_MAX_SIZE_PROVIDER - 1)},

                {ONLY_NUMBERS_IN_STRING.substring(0, INVALID_MIN_SIZE_EMAIL)+
                        "@"+ ONLY_NUMBERS_IN_STRING.substring(0, INVALID_MIN_SIZE_PROVIDER)+
                        "."+ ONLY_CHAR_IN_STRING.substring(0, INVALID_MIN_SIZE_PROVIDER)},

                {ONLY_NUMBERS_IN_STRING.substring(0, INVALID_MIN_SIZE_EMAIL + 1)+
                        "@"+ ONLY_NUMBERS_IN_STRING.substring(0, INVALID_MIN_SIZE_PROVIDER)+
                        "."+ ONLY_CHAR_IN_STRING.substring(0, INVALID_MIN_SIZE_PROVIDER)},

                {ONLY_NUMBERS_IN_STRING.substring(0, INVALID_MIN_SIZE_EMAIL)+
                        "@"+ ONLY_NUMBERS_IN_STRING.substring(0, INVALID_MIN_SIZE_PROVIDER + 1)+
                        "."+ ONLY_CHAR_IN_STRING.substring(0, INVALID_MIN_SIZE_PROVIDER + 1)},

                {ONLY_SPEC_SYMBOLS_IN_STRING.substring(0, INVALID_MIN_SIZE_EMAIL)+
                        "@"+ ONLY_CHAR_IN_STRING.substring(0,INVALID_MIN_SIZE_PROVIDER)+
                        "."+ ONLY_CHAR_IN_STRING.substring(0,INVALID_MIN_SIZE_PROVIDER)},

                {ONLY_SPEC_SYMBOLS_IN_STRING.substring(0, INVALID_MIN_SIZE_EMAIL + 1)+
                        "@"+ ONLY_CHAR_IN_STRING.substring(0, INVALID_MIN_SIZE_PROVIDER)+
                        "."+ ONLY_CHAR_IN_STRING.substring(0, INVALID_MIN_SIZE_PROVIDER)},

                {ONLY_SPEC_SYMBOLS_IN_STRING.substring(0, INVALID_MIN_SIZE_EMAIL)+
                        "@"+ ONLY_CHAR_IN_STRING.substring(0, INVALID_MIN_SIZE_PROVIDER + 1)+
                        "."+ ONLY_CHAR_IN_STRING.substring(0, INVALID_MIN_SIZE_PROVIDER + 1)},

                {ONLY_SPEC_SYMBOLS_IN_STRING.substring(0, INVALID_MAX_SIZE_EMAIL)+
                        "@"+ ONLY_NUMBERS_IN_STRING.substring(0, INVALID_MAX_SIZE_PROVIDER)+
                        "."+ ONLY_CHAR_IN_STRING.substring(0, INVALID_MAX_SIZE_PROVIDER)}
        };
    }

    @Test(dataProvider = "IncorrectEmail")
    public void usingIncorrectValuesToValidateTheEmail(Object ... arg){
        for (Object elem : arg){
            Assert.assertFalse(isEmailCorrect(elem.toString()), "using more [ " + MAX_SIZE_EMAIL
                    + " ] or less [ " + MIN_SIZE_EMAIL + "]  for email name and for provider's name - more [ " +
            + MAX_SIZE_PROVIDER +" ] or less [ " + MIN_SIZE_EMAIL + " ]");
        }
    }
}
