package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static utils.DriverProvider.getCurrentDriver;
import static utils.DriverProvider.quitCurrentDriver;

public class BaseTest {
    @BeforeMethod
    public void setUp() {
        getCurrentDriver().get("https://prelive.coursy.io/#/coursydemo/login");
    }

    @AfterMethod
    public void tearDown() {
        quitCurrentDriver();
    }
}

