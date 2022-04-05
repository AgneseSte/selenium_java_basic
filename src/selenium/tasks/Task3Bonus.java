package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;
import static org.junit.Assert.*;

//import pages.FormPage;
//import pages.ListPage;

public class Task3Bonus {
    WebDriver driver;
//	ListPage listPage = PageFactory.initElements(driver, ListPage.class);
//     should contain what you see when you just open the page (the table with names/jobs)
//	FormPage formPage = PageFactory.initElements(driver, FormPage.class);
//     should be what you see if you click "Add" or "Edit" (2 input field and a button (Add/Edit) and (Cancel)

//    Bonus:
//    try storing people via an Object/separate class

    @Before
    public void openPage() {
        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/list_of_people");
    }

    @After
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void addPerson() {
        /* TODO:
         * implement adding new person using page object
         *
         * in order: store the list of people and jobs currently on page
         * add a person via "Add person button"
         * check the list again, that non of the people where changes, but an additional one with correct name/job was added
         */
//        List<WebElement> names = driver.findElements(By.className("name"));
//        List<WebElement> jobs = driver.findElements(By.className("job"));
//driver.findElement(By.id("addPersonBtn")).click();
//driver.findElement(By.id("name")).sendKeys("Arthur");
//        driver.findElement(By.id("surname")).sendKeys("Dent");
//        driver.findElement(By.id("job")).sendKeys("Hitchhiker");
//        driver.findElement(By.id("name")).sendKeys("Arthur");
//        driver.findElement(By.id("dob")).sendKeys("10/10/2010");
//        assertTrue(driver.findElement(By.id("english")).isSelected());
//        driver.findElement(By.id("french")).click();
//        driver.findElement(By.id("male")).click();
//        Select dropdown = new Select(driver.findElement(By.id("status")));
//        assertEquals("Employee", dropdown.getFirstSelectedOption().getText());
//        dropdown.selectByVisibleText("Intern");
//        driver.findElement(By.id("modal_button")).click();
//        List<WebElement> names2 = driver.findElements(By.className("name"));
//        List<WebElement> jobs2 = driver.findElements(By.className("job"));
    }

    @Test
    public void editPerson() {
        /* TODO:
         * implement editing a person using page object
         *
         * in order: store the list of people and jobs currently on page
         * edit one of existing persons via the edit link
         * check the list again and that 2 people stayed the same and the one used was changed
         */
    }

    @Test
    public void editPersonCancel() {
        /* TODO:
         * implement editing a person using page object
         *
         * in order: store the list of people and jobs currently on page
         * edit one of existing persons via the edit link then click "Cancel" on edit form instead of "Edit"
         * check the list again and that no changes where made
         */
    }


    @Test
    public void deletePerson() {
        /* TODO:
         * implement deleting a person using page object
         *
         * in order: store the list of people and jobs currently on page
         * delete 1 person see that there are now 2 people in the table with correct data
         */
    }


    @Test
    public void deletePersonAll() {
        /* TODO:
         * implement deleting a person using page object
         *
         * in order: store the list of people and jobs currently on page
         * delete all people and check that there is no no table on page, but the button Add is still present and working
         */
    }
}
