package verifyEmail;

import org.testng.Assert;
import org.testng.annotations.Test;

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
public class CheckEmailHappyPath extends AbstractClass{

//    @Test
//    public void result() {
//        Assert.assertTrue(isEmailCorrect(example));
//    }

    @Test(dataProvider = "RightEmail")
    public void result(Object ... email){
        for (Object elem : email){
            Assert.assertTrue(isEmailCorrect(elem.toString()));
        }
    }

}
