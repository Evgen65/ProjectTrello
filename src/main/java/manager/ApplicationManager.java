package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    EventFiringWebDriver wd;
    HelperUser user;
    HelperBoard board;
    String browser;
    Properties properties;


    public ApplicationManager(String browser) {
        properties = new Properties();
        this.browser = browser;
    }

    public void init() throws IOException {
        String target = System.getProperty("target", "config1");
        logger.info(("Config file is ----->"+target));
        properties.load(new FileReader(new File(String.format("src/test/resources/config1.properties", target))));

        if (browser.equals(BrowserType.CHROME)) {
            wd = new EventFiringWebDriver(new ChromeDriver());
            logger.info("Test on CHROME");
        } else if (browser.equals(BrowserType.FIREFOX)) {
            wd = new EventFiringWebDriver(new FirefoxDriver());
            logger.info("Test on FIREFOX");
        }
        wd.register(new MyListener());

        wd.manage().window().maximize();
//        wd.navigate().to("https://trello.com");
        wd.navigate().to(properties.getProperty("web.baseUrl"));
        logger.info("Base Url is ---->" + properties.getProperty(("web.baseUrl")));
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        user = new HelperUser(wd);
        board = new HelperBoard(wd);
    }

    public String getEmail() {
        logger.info("I used email--->"+properties.getProperty("web.email"));
        return properties.getProperty("web.email");
    }
    public String getPassword(){
        logger.info("I used password--->"+properties.getProperty("web.password"));
        return properties.getProperty("web.password");
    }

    public void stop() {
        wd.quit();
    }

    public HelperUser user() {
        return user;
    }

    public HelperBoard board() {
        return board;
    }
}

