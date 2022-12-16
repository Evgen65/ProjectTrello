import manager.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class TestBase {

    WebDriver wd;
    public static ApplicationManager app = new ApplicationManager();

    @BeforeSuite
    public void setUp() {
        app.init();
    }

    @AfterSuite
    public void tearDown() {
        //app.stop();
    }


}
