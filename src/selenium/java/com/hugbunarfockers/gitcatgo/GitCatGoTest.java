package is.ru.arnlaugsson.chuck_joke;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

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

    @Test
    public void markOneSquare()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get(baseUrl);

        WebElement board = driver.findElement(By.id("board"));

        assertEquals(false, board.isDisplayed());

		String player1Name = "Player1Test2";
        String player1Key = "player1";

		String player2Name = "Player2Test2";
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

        WebElement cell1 = driver.findElement(By.id("cell1"));
        cell1.click();

        WebElement cell1paragraph = driver.findElement(By.cssSelector("#cell1 > p"));

        // Wait
        wait.until(ExpectedConditions.attributeContains(By.id("cell1"), "class", "unavailable"));

        assertEquals(true, cell1paragraph.getText().contains("X"));
    }

    @Test
    public void markTowSquares()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get(baseUrl);

        WebElement board = driver.findElement(By.id("board"));

        assertEquals(false, board.isDisplayed());

		String player1Name = "Player1Test3";
        String player1Key = "player1";

		String player2Name = "Player2Test3";
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

        WebElement cell5 = driver.findElement(By.id("cell5"));
        cell5.click();

        WebElement cell5paragraph = driver.findElement(By.cssSelector("#cell5 > p"));

        // Wait
        wait.until(ExpectedConditions.attributeContains(By.id("cell5"), "class", "unavailable"));

        assertEquals(true, cell5paragraph.getText().contains("X"));

        WebElement cell9 = driver.findElement(By.id("cell9"));
        cell9.click();

        WebElement cell9paragraph = driver.findElement(By.cssSelector("#cell9 > p"));

        // Wait
        wait.until(ExpectedConditions.attributeContains(By.id("cell9"), "class", "unavailable"));

        assertEquals(true, cell9paragraph.getText().contains("O"));
    }
}
