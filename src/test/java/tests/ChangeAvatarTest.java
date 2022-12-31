package tests;

import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChangeAvatarTest extends TestBase {
    @BeforeMethod
    public void precondition() {
        if (!app.user().isLogged())
            app.user().login(new User().withEmail("uevgeny1965@gmail.com").withPassword("UMarina1969S"));
    }
    @Test
    public void changeAvatarTest(){
        app.user().clickAvatarImg();
        app.user().openProfileAndVicability();
        app.user().navigateToAtlassianProfile();

    }
}
