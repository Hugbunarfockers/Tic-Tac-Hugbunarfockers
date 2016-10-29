package is.ru.arnlaugsson.chuck_joke;

import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public abstract class SeleniumTestWrapper {
    static ChromeDriver driver;
    static String baseUrl;
    static String port;

    @BeforeClass
    public static void openBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		port = System.getenv("PORT");
        if (port == null) {
            port = "4567";
        }

		baseUrl = "http://localhost:" + port;
    }

    @AfterClass
    public static void closeBrowser(){
        driver.quit();
    }
}
