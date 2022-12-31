package manager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    Logger logger= LoggerFactory.getLogger(ApplicationManager.class);
    WebDriver wd;
    HelperUser user;
    String browser;

    public void init() {
        if(browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
            logger.info("Test on CHROME");
        }else if (browser.equals(BrowserType.FIREFOX)){
            wd=new FirefoxDriver();


        }
        wd.manage().window().maximize();
        wd.navigate().to("https://trello.com");
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        user = new HelperUser(wd);

    }
    public void stop() {
        wd.quit();
    }

    public HelperUser user() {
        return user;
    }

    public ApplicationManager(String browser) {
        this.browser = browser;
    }
}
