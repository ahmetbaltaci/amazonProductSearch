package setUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by ahmetbaltaci on 21.09.2018.
 */
public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement getElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElement(locator);
    }

    public boolean isDisplayed(By locator){
        boolean isDisplayedStatus = false;
        try {
             getElement(locator).isDisplayed();
             isDisplayedStatus = true;
        }catch (Exception e){
            System.out.println("Element is not enable");
        }
        return isDisplayedStatus;
    }



}
