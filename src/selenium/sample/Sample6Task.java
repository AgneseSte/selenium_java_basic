package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import static org.junit.Assert.assertEquals;

public class Sample6Task {
    WebDriver driver;

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        // declaration above:
        driver = new ChromeDriver();
        //open page:
        driver.get("https://kristinek.github.io/site/examples/locators");
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test
    public void findElementByXPath() throws Exception {
//         TODO:
//        2 ways to find text: "Heading 2 text":
        String heading2 = "Heading 2 text";
        assertEquals(heading2, driver.findElement(By.xpath("//*[@id='heading_2']")).getText());
        assertEquals(heading2, driver.findElement(By.xpath("//h2[contains(text(),'" + heading2 + "')]")).getText());
//        1-2 ways to find text: "Test Text 1"
        String heading1 = "Test Text 1";
        System.out.println("By xPath: " + driver.findElement(By.xpath("//*[@class='test']")).getText());//check
        System.out.println("By css: " + driver.findElement(By.cssSelector(".test")).getText());//check
        assertEquals(heading1, driver.findElement(By.xpath("//*[@class='test']")).getText());
        assertEquals(heading1, driver.findElement(By.cssSelector(".test")).getText());

//        1-2 ways to find text: "Test Text 2"
        String testText2 = "Test Text 2";
        assertEquals(testText2, driver.findElement(By.cssSelector(".twoTest")).getText());

//        1-2 ways to find text: "Test Text 3"

//        1-2 ways to find text: "Test Text 4"
//        1-2 ways to find text: "Test Text 5"
//        1-2 ways to find text: "This is also a button"
        String button2 = "This is also a button";
        assertEquals(button2, driver.findElement(By.xpath("//input[@name='randomButton2']")).getAttribute("value"));

    }

    @Test
    public void findElementByCssName() throws Exception {
//         TODO:
//        1-2 ways to find text: "Heading 2 text"
        String heading2 = "Heading 2 text";
        assertEquals(heading2, driver.findElement(By.xpath("//*[@id='heading_2']")).getText());
        assertEquals(heading2, driver.findElement(By.xpath("//h2[contains(text(),'" + heading2 + "')]")).getText());

//        1-2 ways to find text: "Test Text 1"
//        1-2 ways to find text: "Test Text 2"
//        1-2 ways to find text: "Test Text 3"
//        1-2 ways to find text: "This is also a button"
    }
}
