package is.ru.arnlaugsson.chuck_joke;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GitCatGoTest extends SeleniumTestWrapper
{
    @Test
    public void titleMatches()
    {
        driver.get(baseUrl);
        assertEquals("Git-Cat-Go", driver.getTitle());
    }

	@Test
    public void showBoardAfterLogin()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get(baseUrl);

        WebElement board = driver.findElement(By.id("board"));

        assertEquals(false, board.isDisplayed());

		String player1Name = "Player1Test";
        String player1Key = "player1";

		String player2Name = "Player2Test";
        String player2Key = "player2";

        // Login

        WebElement player1NameInput = driver.findElement(By.id("player1name"));
        player1NameInput.sendKeys(player1Name);

        WebElement player1KeyInput = driver.findElement(By.id("player1key"));
        player1KeyInput.sendKeys(player1Key);

        WebElement player2NameInput = driver.findElement(By.id("player2name"));
        player2NameInput.sendKeys(player2Name);

        WebElement player2KeyInput = driver.findElement(By.id("player2key"));
        player2KeyInput.sendKeys(player2Key);

        // Submit
        player2KeyInput.sendKeys(Keys.ENTER);

        // Wait
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("board")));

        assertEquals(true, board.isDisplayed());
    }
}
