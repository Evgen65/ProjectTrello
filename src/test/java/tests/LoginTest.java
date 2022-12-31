package tests;

import models.User;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        if (TestBase.app.user().isLogged()) {
            TestBase.app.user().logout();
        }
    }

    @Test
    public void loginSuccess() {

        TestBase.app.user().initLogin();
        TestBase.app.user().fillLoginForm("uevgeny1965@gmail.com", "UMarina1969S");
        TestBase.app.user().submitLogin();
        Assert.assertTrue(TestBase.app.user().isLogged());
    }

    @Test
    public void loginSuccessModel() {
        User user = new User().withEmail("uevgeny1965@gmail.com").withPassword("UMarina1969S");
        TestBase.app.user().initLogin();
        TestBase.app.user().fillLoginForm(user);
        TestBase.app.user().submitLogin();
        //app.user().pause(1000);
        Assert.assertTrue(TestBase.app.user().isLogged());
    }

    @Test
    public void loginNegativeWithWrongEmailModel() {
        User user = new User().withEmail("uevgeny1965gmail.com").withPassword("UMarina1969S");
        TestBase.app.user().initLogin();
        TestBase.app.user().fillLoginForm(user);
        TestBase.app.user().submitLoginError();
        Assert.assertFalse(TestBase.app.user().isLogged());
        Assert.assertTrue(TestBase.app.user().getTextErrorEmail().contains("There isn't an account for this username"));
    }

    @Test
    public void loginNegativeWithWrongPassWordModel() {
        User user = new User().withEmail("uevgeny1965@gmail.com").withPassword("UMar");
        TestBase.app.user().initLogin();
        TestBase.app.user().fillLoginForm(user);
        TestBase.app.user().submitLogin();
        Assert.assertFalse(TestBase.app.user().isLogged());
        Assert.assertTrue(TestBase.app.user().getTextErrorPassword().contains("Incorrect email address and / or password."));
        TestBase.app.user().returnToHome();
    }

}
