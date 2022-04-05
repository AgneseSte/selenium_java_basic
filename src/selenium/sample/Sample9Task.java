package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.pages.LoadingColor;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Sample9Task {
    WebDriver driver;
    static LoadingColor loadingColor;

    @Before
    public void openPage() {
        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/loading_color");
    }

    @After
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void loadGreenSleep() throws Exception {
//        THIS TASK IS EDITED FOR SAMPLE 10 NEEDS
        loadingColor = PageFactory.initElements(driver, LoadingColor.class);
//         TODO:
//         * 1) click on start loading green button
        loadingColor.clickStartGreen();
//         * 2) check that button does not appear,
        loadingColor.startGreenNotDisplayed();
//         * but loading text is seen instead   "Loading green..."
        loadingColor.loadGreenDisplayed();
//         * 3) check that both button
        Thread.sleep(5000);
        loadingColor.startGreenNotDisplayed();
//         * and loading text is not seen,
        assertFalse(loadingColor.loadGreenDisplayed());
//         * success is seen instead "Green Loaded"
        loadingColor.finishGreenDisplayed();
    }

    @Test
    public void loadGreenImplicit() throws Exception {
//         TODO:
//         * 1) click on start loading green button

//        WebElement startGreen = driver.findElement(By.id("start_green"));
//        WebElement loadingGreen = driver.findElement(By.id("loading_green"));
//        WebElement finishGreen = driver.findElement(By.id("finish_green"));
        driver.findElement(By.id("start_green")).click();
//         * 2) check that button does not appear,
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());
//         * but loading text is seen instead   "Loading green..."
        assertTrue(driver.findElement(By.id("loading_green")).isDisplayed());
//         * 3) check that both button
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);// wait until finish green is displayed!!!
        driver.findElement(By.id("finish_green"));
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());
//         * and loading text is not seen,
        assertFalse(driver.findElement(By.id("loading_green")).isDisplayed());
//         * success is seen instead "Green Loaded"
        assertTrue(driver.findElement(By.id("finish_green")).isDisplayed());
    }

    @Test
    public void loadGreenExplicitWait() throws Exception {
//         TODO:
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 5).ignoring(StaleElementReferenceException.class);
        //         * 1) click on start loading green button
        driver.findElement(By.id("start_green")).click();
//         * 2) check that button does not appear,
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());
//         * but loading text is seen instead   "Loading green..."
        assertTrue(driver.findElement(By.id("loading_green")).isDisplayed());
//         * 3) check that both button
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish_green")));
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());
//         * and loading text is not seen,
        assertFalse(driver.findElement(By.id("loading_green")).isDisplayed());
//         * success is seen instead "Green Loaded"
        assertTrue(driver.findElement(By.id("finish_green")).isDisplayed());
    }

    @Test
    public void loadGreenAndBlueBonus() throws Exception{
        Thread.sleep(3000);
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 5).ignoring(StaleElementReferenceException.class);
//        * TODO:
//         * 0) wait until button to load green and blue appears
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("start_green_and_blue"))).isDisplayed();
//         * 1) click on start loading green and blue button
        driver.findElement(By.id("start_green_and_blue")).click();
//         * 2) check that button does not appear, but loading text is seen instead for green
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("loading_green_without_blue"))).isDisplayed();
//        driver.findElement(By.id("loading_green_without_blue")).isDisplayed();
        assertFalse(driver.findElement(By.id("start_green_and_blue")).isDisplayed());
//        assertTrue(driver.findElement(By.id("loading_green_without_blue")).isDisplayed());
//         * 3) check that button does not appear, but loading text is seen instead for green and blue
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("loading_green_with_blue"))).isDisplayed();
//        driver.findElement(By.id("loading_green_with_blue")).isDisplayed();
        assertFalse(driver.findElement(By.id("start_green_and_blue")).isDisplayed());
        assertTrue(driver.findElement(By.id("loading_green_with_blue")).isDisplayed());
//         * 4) check that button and loading green does not appear,
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("loading_blue_without_green"))).isDisplayed();
        assertFalse(driver.findElement(By.id("start_green_and_blue")).isDisplayed());
        assertFalse(driver.findElement(By.id("loading_green_without_blue")).isDisplayed());
//         * 		but loading text is seen instead for blue and success for green is seen
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("loading_blue_without_green"))).isDisplayed();
        assertTrue(driver.findElement(By.id("loading_green_with_blue")).isDisplayed());
        assertTrue(driver.findElement(By.id("loading_blue_without_green")).isDisplayed());
//         * 5) check that both button and loading text is not seen, success is seen instead
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish_green_and_blue"))).isDisplayed();
        assertFalse(driver.findElement(By.id("loading_green_without_blue")).isDisplayed());
        assertFalse(driver.findElement(By.id("loading_green_with_blue")).isDisplayed());
        assertFalse(driver.findElement(By.id("loading_blue_without_green")).isDisplayed());

        assertTrue(driver.findElement(By.id("finish_green_and_blue")).isDisplayed());
//         *
    }

}