import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class StartSelenium {

    WebDriver wd;

    @BeforeMethod
    public void preCondition() {

        wd = new ChromeDriver();
        wd.get("https://telranedu.web.app/");

    }

    @Test
    public void testName(){
        System.out.println("test started");
        WebElement element = wd.findElement(By.tagName("a"));
        List<WebElement> elements = wd.findElements(By.tagName("div"));
        System.out.println(elements.size());
        wd.findElement(By.linkText("HOME"));
        wd.findElement(By.partialLinkText("HO"));
        wd.findElement(By.id("root"));

        wd.findElement(By.cssSelector("[href='/login']"));
        wd.findElement(By.cssSelector("[href^='/lo']"));
        wd.findElement(By.cssSelector("[href*='og']"));
        wd.findElement(By.cssSelector("[href$='gin']"));

        List<WebElement> buttons = wd.findElements(By.tagName("button"));




    }


    @Test
    public void testLogin(){
        System.out.println("test completed");
    }

    @AfterMethod
    public void postCondition(){
   // wd.close();
    wd.quit();
    }

}
