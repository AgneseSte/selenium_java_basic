package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class Task2 {
    WebDriver driver;

    @Before
    public void openPage() {
        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
    }

    @After
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void initialFeedbackPage() throws Exception {
//         TODO:
//        check that all field are empty and no tick are clicked
//        "Don't know" is selected in "Genre"
        assertEquals("", driver.findElement(By.id("fb_name")).getText());
        assertEquals("", driver.findElement(By.id("fb_age")).getText());
        assertFalse(driver.findElement(By.xpath("//*[@id='lang_check']/input[1]")).isSelected());
        assertFalse(driver.findElement(By.xpath("//*[@id='lang_check']/input[2]")).isSelected());
        assertFalse(driver.findElement(By.xpath("//*[@id='lang_check']/input[3]")).isSelected());
        assertFalse(driver.findElement(By.xpath("//*[@id='lang_check']/input[4]")).isSelected());
        assertFalse(driver.findElement(By.xpath("//*[@id='fb_form']/form/div[4]/input[1]")).isSelected());
        assertFalse(driver.findElement(By.xpath("//*[@id='fb_form']/form/div[4]/input[2]")).isSelected());
        assertTrue(driver.findElement(By.xpath("//*[@id='fb_form']/form/div[4]/input[3]")).isSelected());
        assertFalse(driver.findElement(By.id("like_us")).isSelected());
        assertEquals("", driver.findElement(By.name("comment")).getText());
//         "Choose your option" in "How do you like us?"
        Select dropdown = new Select(driver.findElement(By.id("like_us")));
        dropdown.selectByVisibleText("Why me?");
//         check that the button send is blue with white letters
        assertEquals("rgba(255, 255, 255, 1)", driver.findElement(By.tagName("button")).getCssValue("color"));
        assertEquals("rgba(33, 150, 243, 1)",
                driver.findElement(By.tagName("button")).getCssValue("background-color"));
    }

    @Test
    public void emptyFeedbackPage() throws Exception {
//         TODO:
//         click "Send" without entering any data
        driver.findElement(By.tagName("button")).click();
//         check fields are empty or null
        assertEquals("", driver.findElement(By.id("name")).getText());
        assertEquals("", driver.findElement(By.id("language")).getText());
        assertEquals("null", driver.findElement(By.id("gender")).getText());
        assertEquals("null", driver.findElement(By.id("option")).getText());
        assertEquals("", driver.findElement(By.id("comment")).getText());
//         check button colors
//         (green with white letter and red with white letters)
        assertEquals("rgba(255, 255, 255, 1)", driver.findElement(By.className("w3-green")).getCssValue("color"));
        assertEquals("rgba(76, 175, 80, 1)",
                driver.findElement(By.className("w3-green")).getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", driver.findElement(By.className("w3-red")).getCssValue("color"));
        assertEquals("rgba(244, 67, 54, 1)",
                driver.findElement(By.className("w3-red")).getCssValue("background-color"));
    }

    @Test
    public void notEmptyFeedbackPage() throws Exception {
//         TODO:
        String name = "Jane";
        String age = "65";
        String comment = "This is a comment";
//         fill the whole form, click "Send"
        driver.findElement(By.id("fb_name")).sendKeys(name);
        driver.findElement(By.id("fb_age")).sendKeys(age);
        driver.findElement(By.xpath("//*[@id='lang_check']/input[1]")).click();
        driver.findElement(By.xpath("//*[@id='lang_check']/input[4]")).click();
        driver.findElement(By.xpath("//*[@id='fb_form']/form/div[4]/input[2]")).click();
        Select dropdown = new Select(driver.findElement(By.id("like_us")));
        dropdown.selectByVisibleText("Why me?");
        driver.findElement(By.name("comment")).sendKeys(comment);
        driver.findElement(By.tagName("button")).click();

//         check fields are filled correctly
        assertEquals(name, driver.findElement(By.id("name")).getText());
        assertEquals(age, driver.findElement(By.id("age")).getText());
        assertEquals("English,Chinese", driver.findElement(By.id("language")).getText());
        assertEquals("female", driver.findElement(By.id("gender")).getText());
        assertEquals("Why me?", driver.findElement(By.id("option")).getText());
        assertEquals(comment, driver.findElement(By.id("comment")).getText());


//         check button colors
//         (green with white letter and red with white letters)
        assertEquals("rgba(255, 255, 255, 1)", driver.findElement(By.className("w3-green")).getCssValue("color"));
        assertEquals("rgba(76, 175, 80, 1)",
                driver.findElement(By.className("w3-green")).getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", driver.findElement(By.className("w3-red")).getCssValue("color"));
        assertEquals("rgba(244, 67, 54, 1)",
                driver.findElement(By.className("w3-red")).getCssValue("background-color"));
    }

    @Test
    public void yesOnWithNameFeedbackPage() throws Exception {
//         TODO:
//         enter only name
        String name = "Jane";
        driver.findElement(By.id("fb_name")).sendKeys(name);
//         click "Send"
        driver.findElement(By.tagName("button")).click();
//         click "Yes"
        driver.findElement(By.className("w3-green")).click();
//         check message text: "Thank you, NAME, for your feedback!"
        assertEquals("Thank you, " + name + ", for your feedback!", driver.findElement(By.id("message")).getText());
//         color of text is white with green on the background
        assertEquals("rgba(255, 255, 255, 1)", driver.findElement(By.id("message")).getCssValue("color"));
        assertEquals("rgba(76, 175, 80, 1)",
                driver.findElement(By.className("w3-green")).getCssValue("background-color"));

    }

    @Test
    public void yesOnWithoutNameFeedbackPage() throws Exception {
//         TODO:
//         click "Send" (without entering anything
        driver.findElement(By.tagName("button")).click();
//         click "Yes"
        driver.findElement(By.className("w3-green")).click();
//         check message text: "Thank you for your feedback!"
        assertEquals("Thank you for your feedback!", driver.findElement(By.id("message")).getText());
//         color of text is white with green on the background
        assertEquals("rgba(255, 255, 255, 1)", driver.findElement(By.id("message")).getCssValue("color"));
        assertEquals("rgba(76, 175, 80, 1)",
                driver.findElement(By.className("w3-green")).getCssValue("background-color"));

    }

    @Test
    public void noOnFeedbackPage() throws Exception {
//         TODO:
//         fill the whole form
        String name = "Jane";
        String age = "65";
        String comment = "This is a comment";
        driver.findElement(By.id("fb_name")).sendKeys(name);
        driver.findElement(By.id("fb_age")).sendKeys(age);
        driver.findElement(By.xpath("//*[@id='lang_check']/input[1]")).click();
        driver.findElement(By.xpath("//*[@id='lang_check']/input[4]")).click();
        driver.findElement(By.xpath("//*[@id='fb_form']/form/div[4]/input[2]")).click();
        Select dropdown = new Select(driver.findElement(By.id("like_us")));
        dropdown.selectByVisibleText("Why me?");
        driver.findElement(By.name("comment")).sendKeys(comment);
//         click "Send"
        driver.findElement(By.tagName("button")).click();
//         click "No"
        driver.findElement(By.className("w3-red")).click();
//         check fields are filled correctly
        assertEquals(name, driver.findElement(By.name("name")).getAttribute("value"));
        assertEquals(age, driver.findElement(By.id("fb_age")).getAttribute("value"));

        assertTrue(driver.findElement(By.xpath("//*[@id='lang_check']/input[1]")).isSelected());
        assertFalse(driver.findElement(By.xpath("//*[@id='lang_check']/input[2]")).isSelected());
        assertFalse(driver.findElement(By.xpath("//*[@id='lang_check']/input[3]")).isSelected());
        assertTrue(driver.findElement(By.xpath("//*[@id='lang_check']/input[4]")).isSelected());
        assertFalse(driver.findElement(By.xpath("//*[@id='fb_form']/form/div[4]/input[1]")).isSelected());
        assertTrue(driver.findElement(By.xpath("//*[@id='fb_form']/form/div[4]/input[2]")).isSelected());
        assertFalse(driver.findElement(By.xpath("//*[@id='fb_form']/form/div[4]/input[3]")).isSelected());
        assertEquals("Why me?", driver.findElement(By.id("like_us")).getAttribute("value"));
        assertEquals(comment, driver.findElement(By.name("comment")).getAttribute("value"));

    }
}
