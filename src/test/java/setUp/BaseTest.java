package setUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by ahmetbaltaci on 21.09.2018.
 */
public class BaseTest {

    public static WebDriver driver;

    public void goToWebSite(){
        driver = new ChromeDriver();
        driver.get(String.valueOf(ReadJsonFile.readJsonFile("baseUrl")));
        driver.manage().timeouts().pageLoadTimeout(20000, TimeUnit.MILLISECONDS);
    }
}
