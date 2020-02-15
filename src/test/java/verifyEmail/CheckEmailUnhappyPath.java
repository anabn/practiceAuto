package verifyEmail;
import org.testng.Assert;
import org.testng.annotations.Test;

import static autoPractice.Email.isEmailCorrect;

/**
 * @author popcorn
 * the negative test
 * verify the mail via pattern "^[a-zA-Z0-9_!]{3,20}@[a-zA-Z0-9]{2,5}\\.[a-z]{2,5}$"
 */
public class CheckEmailUnhappyPath extends AbstractClass {
//    @Test
//    public void result() {
//        Assert.assertFalse(isEmailCorrect(example.substring(0, 2)));
//    }

    @Test(dataProvider = "WrongEmail")
    public void result(Object ... arg){
        for (Object elem : arg){
            Assert.assertFalse(isEmailCorrect(elem.toString()));
        }
    }

}
