package selenium.sample.extra;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class extra1Task {
    WebDriver driver;
    String base_url = "https://kristinek.github.io/site/examples/act";
    String new_url = "https://kristinek.github.io/site/examples/link1";
    String task_url = "https://kristinek.github.io/site/examples/po";
    String task_url2 = "https://kristinek.github.io/site/examples/po1";

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        // declaration above:
        driver = new ChromeDriver();

        //open page:
        driver.get(base_url);
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test
    public void navigateBack() throws Exception {
//        TODO
        driver.get(task_url);
        driver.findElement(By.xpath("//*[contains(@class, 'w3-pale-red')] //a[contains(text(), 'More >> ')]")).click();
        assertEquals(task_url2, driver.getCurrentUrl());
driver.navigate().back();
assertEquals(task_url, driver.getCurrentUrl());
//        open page with url "https://kristinek.github.io/site/examples/po"
//        click "More > " for the top left element
//        check that the url now "https://kristinek.github.io/site/examples/po1"
//        using driver navigation go back to "https://kristinek.github.io/site/examples/po"
//        check that the page now is "https://kristinek.github.io/site/examples/po"
    }

    @Test
    public void navigateForward() throws Exception {
//        TODO
        driver.get(task_url);
        driver.findElement(By.xpath("//*[contains(@class, 'w3-pale-red')] //a[contains(text(), 'More >> ')]")).click();
        driver.navigate().back();
        driver.navigate().forward();
        assertEquals(task_url2, driver.getCurrentUrl());
//        open page with url "https://kristinek.github.io/site/examples/po"
//        click "More > " for the top left element
//        using driver navigation go back to "https://kristinek.github.io/site/examples/po"
//        using driver navigation go forward to "https://kristinek.github.io/site/examples/po1"
//        check that the page now is "https://kristinek.github.io/site/examples/po1"
    }

    @Test
    public void refresh() throws Exception {
//        TODO
//        open page "https://kristinek.github.io/site/examples/act" // no such page
        driver.get("https://kristinek.github.io/site/examples/actions");
//        click on "Show" button in 'Button' section

        driver.findElement(By.id("show_text")).click();
//        check that text "I am here!" is seen
        assertTrue(driver.findElement(By.id("show_me")).isDisplayed());
        assertEquals("I am here!", driver.findElement(By.id("show_me")).getText());

//        refresh page
        driver.navigate().refresh();
//        check that text "I am here!" is not seen

    }
}
