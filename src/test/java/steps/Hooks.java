package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Hooks {   // like a TestBase
    WebDriver driver = Driver.getDriver();

    @Before
    public  void  setup(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        System.out.println("Before Scenario Method");
    }
    @After
    public void  teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
        System.out.println("After Scenario Method");
    }
}
