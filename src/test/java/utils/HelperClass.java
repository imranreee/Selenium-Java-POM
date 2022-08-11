package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class HelperClass {
    protected static WebDriver driver;

    public HelperClass(WebDriver driver) {
        this.driver = driver;
    }

    // waiting for element until visible for maximum 30 seconds (time configurable)
    protected void waitForVisibilityOf(WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(locator));
    }

    // waiting for element until clickable for maximum 30 seconds (time configurable)
    protected void waitForClickAbilityOf(WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
