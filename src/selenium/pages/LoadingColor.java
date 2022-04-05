package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoadingColor extends GenericSamplePage {

    @FindBy(how = How.ID, using = "start_green")
    private WebElement startGreen;
    @FindBy(how = How.ID, using = "loading_green")
    private WebElement loadingGreen;
    @FindBy(how = How.ID, using = "finish_green")
    private WebElement finishGreen;

   public  void clickStartGreen() {
       startGreen.click();
   }
    public boolean startGreenDisplayed () {
        return startGreen.isDisplayed();
    }
    public boolean startGreenNotDisplayed () {
        startGreen.isDisplayed();
        return false;
    }

   public boolean loadGreenDisplayed () {
       return loadingGreen.isDisplayed();
   }

    public boolean finishGreenDisplayed () {
        return finishGreen.isDisplayed();
    }

}
