import models.User;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        if (app.user().isLogged()) {
            app.user().logUot();
        }
    }

    @Test
    public void loginSuccess() {

        app.user().initLogin();
        app.user().fillLoginForm("uevgeny1965@gmail.com", "UMarina1969S");
        app.user().submitLogin();
        Assert.assertTrue(app.user().isLogged());

    }

    @Test
    public void loginSuccessModel() {
        User user = new User().withEmail("uevgeny1965@gmail.com").withPassword("UMarina1969S");
        app.user().initLogin();
        app.user().fillLoginForm(user);
        app.user().submitLogin();
        //app.user().pause(1000);
        Assert.assertTrue(app.user().isLogged());

    }

    @Test
    public void loginNegativeWithWrongEmailModel() {
        User user = new User().withEmail("uevgeny1965gmail.com").withPassword("UMarina1969S");
        app.user().initLogin();
        app.user().fillLoginForm(user);
        app.user().submitLoginError();
        Assert.assertFalse(app.user().isLogged());
        Assert.assertTrue(app.user().getTextErrorEmail().contains("There isn't an account for this username"));

    }

    @Test
    public void loginNegativeWithWrongPassWordModel() {
        User user = new User().withEmail("uevgeny1965@gmail.com").withPassword("UMar");
        app.user().initLogin();
        app.user().fillLoginForm(user);
        app.user().submitLogin();
        Assert.assertFalse(app.user().isLogged());
        Assert.assertTrue(app.user().getTextErrorPassword().contains("Incorrect email address and / or password."));
        app.user().returnToHome();

    }

}
