package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChangeAvatarTest extends TestBase {
    @BeforeMethod
    public void precondition() {
        if (!app.user().isLogged())
            app.user().login(new User().withEmail(app.getEmail()).withPassword(app.getPassword()));
    }

   @Test(groups = {"smoke"},enabled = false)
    public void changeAvatarTest() {
        app.user().clickAvatarImg();
        app.user().openProfileAndVicability();
        app.user().navigateToAtlassianProfile();
        app.user().initChangeAvatar();
        app.user().uploadPhoto("C:\\repositoris\\ProjectTrelloVebinar\\src\\test\\resources\\avatar.jpg");
        Assert.assertTrue(app.user().isAvatarAdded());
        app.user().returnToTrelloHome();
}


    @Test
    public void changeAvatarTest2() {
        app.user().clickAvatarImg();
        app.user().openProfileAndVisability();
        app.user().navigateToAtlassianPtofile();
        app.user().initChangeAvatar();
        app.user().uploadPhoto("C:\\repositoris\\ProjectTrelloVebinar\\src\\test\\resources\\avatarAnon.jpg");
        Assert.assertTrue(app.user().isAvatarAdded());
        app.user().returnToTrelloHome();
    }
}