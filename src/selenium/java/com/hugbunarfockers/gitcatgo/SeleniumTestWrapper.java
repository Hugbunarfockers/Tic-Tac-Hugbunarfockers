package is.ru.arnlaugsson.chuck_joke;

import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public abstract class SeleniumTestWrapper
{
    //static ChromeDriver driver;
    static PhantomJSDriver driver;
    static String baseUrl;
    static String port;

    @BeforeClass
    public static void openBrowser()
    {
        //driver = new ChromeDriver();
        driver = new PhantomJSDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		setBaseURL();

		if(baseUrl.contains("localhost"))
		{
			port = System.getenv("PORT");
	        if (port == null) {
	            port = "4567";
	        }

			baseUrl += port;
		}
    }

    @AfterClass
    public static void closeBrowser()
    {
        driver.quit();
    }

	private static void setBaseURL()
    {
		String serverFilePath = System.getProperty("user.dir") + "/servers/server.txt";
        try
		{
			BufferedReader reader;
			reader = new BufferedReader(new FileReader(serverFilePath));
			try
			{
				baseUrl = reader.readLine();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			finally
			{
				try
				{
					reader.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
    }
}
