import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TableTest {

    WebDriver wd;
    @BeforeMethod
    public void init(){

    }

    @Test
    public void tableTestCSS(){
        }

    @AfterMethod
    public void tearDown(){
        wd.quit();
    }

}
