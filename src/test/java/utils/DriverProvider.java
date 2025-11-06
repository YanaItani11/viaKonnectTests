package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverProvider {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static WebElement findElement(By by) {
        getCurrentWait().until(ExpectedConditions.visibilityOfElementLocated(by));
        return getCurrentDriver().findElement(by);
    }

    public static WebDriver getCurrentDriver() {
        if (driver == null) {
            init();
        }
        return driver;
    }

    public static void quitCurrentDriver() {
        driver.quit();
        driver = null;
        wait = null;
    }

    public static WebDriverWait getCurrentWait() {
        if (wait == null) {
            init();
        }
        return wait;
    }

    private static void init() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriverManager.chromedriver().clearResolutionCache().setup();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(12));
    }

//    private static void init() {
//        WebDriverManager.edgedriver().setup();
//        driver = new EdgeDriver();
//        driver.manage().window().maximize();
//        wait = new WebDriverWait(driver, Duration.ofSeconds(12));
//    }

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

    }

    public static void scrollToTop() {
        ((JavascriptExecutor) driver).executeScript("document.body.scrollTop = document.documentElement.scrollTop = 0;");
    }

    public static void scrollToBottom(){
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
    }
}
