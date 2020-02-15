package verifyEmail;

import org.testng.annotations.DataProvider;

abstract class AbstractClass {
//     String example = "example@gmail.com";

    //    @BeforeSuite
    @DataProvider(name = "RightEmail")
    protected static Object[][] credentials() {
        //Rows - Number of times your test has to be repeated.
        //Columns - Number of parameters in test data.
        Object[][] data = new Object[3][2];

        // 1st row
        data[0][0] ="sampleuser1@gmail.com";
        data[0][1] = "99999999@hh.aa";

        // 2nd row
        data[1][0] ="testuser2@gmail.com";
        data[1][1] = "zxcvb@ukr.net";

        // 3rd row
        data[2][0] ="guestuser3@aa.ddd";
        data[2][1] = "!!!!!!!@66.ff";

        return data;
    }

    @DataProvider(name = "WrongEmail")
    protected static Object[][] wrongArguments() {
        return new Object[][] {{"asedf@a.22", "aaaa..@11"}, {"      @11.aa", "a.@1.1"}, {"ioi", "tt.gmail.com"}};
    }
    abstract void result(Object ... arg);
}
